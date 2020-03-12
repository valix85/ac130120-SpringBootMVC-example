package it.nextre.academy.firstexample.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="catalogo")
@Data
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String marca;

    @Column(length = 45)
    private String nome_prodotto;

    @Column(length = 45)
    private String modello;

    @Column(length = 255)
    private String descrizione;

    @ManyToOne
    @JoinColumn(name="tipo")
    @JsonManagedReference
    private TipoProdotto tipoProdotto;


}//end class
