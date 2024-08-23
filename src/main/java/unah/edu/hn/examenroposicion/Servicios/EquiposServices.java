package unah.edu.hn.examenroposicion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.hn.examenroposicion.Modelos.Equipos;
import unah.edu.hn.examenroposicion.Repositorios.EquiposRepository;

@Service
public class EquiposServices {

    @Autowired
    private EquiposRepository equiposRepository;

    // metodo para crear equipo
    public Equipos nuevoEquipo(Equipos nvoEquipo) {
        if (nvoEquipo != null) {

            return equiposRepository.save(nvoEquipo);

        }

        return null;
    }

    // validar que no exista un equipo con el mismo nombre
    public boolean VerficcarExistencia(String nombre) {

        if (this.equiposRepository.existsByNombre(nombre)) {
            return true;
        }

        return false;
    }

    // eliminar equipo por id
    public String eliminarEquipo(long codigoEquipo) {
        // validar que exista
        if (this.equiposRepository.existsById(codigoEquipo)) {

            this.equiposRepository.deleteById(codigoEquipo);
            return "El equipo se ha eliminado ";

        }

        return "el equipo no existe registrado";

    }

    // bucar equipo
    public Equipos buscarEquipo(long codigoEquipo) {
        return this.equiposRepository.findById(codigoEquipo).get();
    }

}
