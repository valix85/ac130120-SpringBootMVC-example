package it.nextre.academy.firstexample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="tipo_prodotto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoProdotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String nome;

    @JsonIgnore
    //@JsonBackReference // lasciarlo attivo ma usare un DTO specifico (non avrà questo campo)
    @OneToMany(mappedBy = "tipoProdotto")
    private List<Catalogo> catalogoItems;
}//end class