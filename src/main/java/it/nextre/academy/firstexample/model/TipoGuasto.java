package it.nextre.academy.firstexample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tipo_guasto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoGuasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String tipo;

    // esempio di ovveride di lombok
    @Override
    public String toString() {
        return "TipoGuasto{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}//end class
