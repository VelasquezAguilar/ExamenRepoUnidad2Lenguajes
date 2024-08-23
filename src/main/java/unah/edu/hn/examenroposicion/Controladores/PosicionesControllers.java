package unah.edu.hn.examenroposicion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.edu.hn.examenroposicion.Modelos.Posiciones;
import unah.edu.hn.examenroposicion.Servicios.PosicionesServices;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionesControllers {

    @Autowired
    private PosicionesServices posicionesServices;

    // dovolver todos los registro de la tabla posicion
    @GetMapping("/tablaPosiciones")
    public List<Posiciones> obtenerPosiciones() {
        return this.posicionesServices.obtenerTodasPosiciones();
    }
}
