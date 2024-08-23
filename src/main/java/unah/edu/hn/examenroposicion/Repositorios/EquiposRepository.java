package unah.edu.hn.examenroposicion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.edu.hn.examenroposicion.Modelos.Equipos;

@Repository
public interface EquiposRepository extends JpaRepository<Equipos, Long> {

    public boolean existsByNombre(String nombre);
}
