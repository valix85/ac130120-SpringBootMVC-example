package it.nextre.academy.firstexample.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tipo_prodotto")
@Data
public class TipoProdotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String nome;

    @OneToMany(mappedBy = "tipoProdotto")
    private List<Catalogo> catalogoItems;
}//end class