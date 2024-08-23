package unah.edu.hn.examenroposicion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.examenroposicion.Modelos.Equipos;
import unah.edu.hn.examenroposicion.Servicios.EquiposServices;
import unah.edu.hn.examenroposicion.Servicios.PosicionesServices;

@RestController
@RequestMapping("/api/equipos")
public class EquiposControllers {

    @Autowired
    private EquiposServices equiposServices;

    @Autowired
    private PosicionesServices posicionesServices;

    @PostMapping("/crear")
    public Equipos crearEquipo(@RequestBody Equipos nvoEquipo) {
        // validar que no exista por nombre
        if (!this.equiposServices.VerficcarExistencia(nvoEquipo.getNombre())) {
            return this.equiposServices.nuevoEquipo(nvoEquipo);
        }

        return null;
    }

    // eliminar equipo con condiciones
    @DeleteMapping("/eliminar/{codigoEquipo}")
    public String eliminarEquipo(@PathVariable(name = "codigoEquipo") long codigoEquipo) {
        // validar que exista
        if (!this.posicionesServices.VerificarExistenciaDeEquipoRegistrado(codigoEquipo)) {
            return this.equiposServices.eliminarEquipo(codigoEquipo);
        }

        return "el equipo no puede ser eliminado, tiene un registro asociado";

    }

    // buscar equipo
    @GetMapping("/buscar/{codigoEquipo}")
    public Equipos buscarEquipo(@PathVariable(name = "codigoEquipo") long codigoEquipo) {
        return this.equiposServices.buscarEquipo(codigoEquipo);
    }

}
