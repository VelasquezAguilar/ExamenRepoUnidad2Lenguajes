package unah.edu.hn.examenroposicion.Servicios;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.examenroposicion.Modelos.Equipos;
import unah.edu.hn.examenroposicion.Modelos.Posiciones;
import unah.edu.hn.examenroposicion.Repositorios.EquiposRepository;
import unah.edu.hn.examenroposicion.Repositorios.PosicionesRepository;

@Service
public class PosicionesServices {

    @Autowired
    private PosicionesRepository posicionesRepository;

    @Autowired
    private EquiposRepository equiposRepository;

    public boolean VerificarExistenciaDeEquipoRegistrado(long codigoEquipo) {
        // verificar si tiene registros de ese equipo
        if (this.posicionesRepository.existsByEquipos_codigoEquipo(codigoEquipo)) {
            return true;
        }

        return false;
    }

    // obtener tabal posicino
    public List<Posiciones> obtenerTodasPosiciones() {
        return this.posicionesRepository.findAll();
    }

    // metodo para si¿imular partidos
    public Posiciones generarPartido() {
        List<Equipos> listartodsEquipos = this.equiposRepository.findAll();

        // son mas de 6 , si no crearlos
        if (listartodsEquipos.size() < 6) {
            int existen = listartodsEquipos.size();
            for (int i = existen; i < 6; i++) {

                Equipos nuvoEquipo = new Equipos();
                nuvoEquipo.setCodigoEquipo(i + 1);
                nuvoEquipo.setNombre("nombreEquipo" + (i + 1));

            }

        }
        return null;
        // Posiciones nuevaPosicion = new Posiciones();
        // nuevaPosicion.setEmpates(0);
        // nuevaPosicion.setGanados(0);
        // nuevaPosicion.setPerdidos(0);
    }

    public Posiciones GenerarPartidosRandom(long codigoEquipoA, long codigoEquipoB) {
        
             Random aleatorio = new Random();
             int equipoA = aleatorio.nextInt(4);
             int equipoB  = aleatorio.nextInt(4);
             
             Posiciones registrarResultadosA = new Posiciones();
             Posiciones registrarResultadosB = new Posiciones();


             if(equipoA>equipoB){

                 registrarResultadosA.setGanados(equipoA);
                 registrarResultadosB.setPerdidos(1);

             }else if(equipoA < equipoB) {
                 registrarResultadosA.setPerdidos(1);
                 registrarResultadosB.setGanados(equipoB);

             }else (equipoA == equipoB)
             { 
                 registrarResultadosA.setEmpates(1);
                 registrarResultadosB.setEmpates(1);
             }

    }

}
