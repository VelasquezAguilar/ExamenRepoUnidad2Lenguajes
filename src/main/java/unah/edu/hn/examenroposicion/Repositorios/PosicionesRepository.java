package unah.edu.hn.examenroposicion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.examenroposicion.Modelos.Posiciones;

@Repository
public interface PosicionesRepository extends JpaRepository<Posiciones, Long> {

    public boolean existsByEquipos_codigoEquipo(long codigoEquipo);
}
