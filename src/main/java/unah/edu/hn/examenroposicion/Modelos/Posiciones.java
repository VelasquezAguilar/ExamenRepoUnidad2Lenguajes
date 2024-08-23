package unah.edu.hn.examenroposicion.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "posiciones")
@Data
public class Posiciones {

    // no me corria si no le daba un id a posiciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer empates;

    private Integer ganados;

    private Integer perdidos;

    @Column(name = "golesfavor")
    private Integer golesFavor;

    @Column(name = "golescontra")
    private Integer golesContra;

    private Integer puntos;

    // relacion de uno a uno con la tabla de equios
    @OneToOne
    @JoinColumn(name = "codigoequipo", referencedColumnName = "codigoequipo")
    private Equipos equipo;

}
