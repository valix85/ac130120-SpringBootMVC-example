package it.nextre.academy.firstexample.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tipo_guasto")
@Data
public class TipoGuasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String tipo;

    @Override
    public String toString() {
        return "TipoGuasto{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}//end class
