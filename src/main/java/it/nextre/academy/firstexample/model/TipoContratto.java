package it.nextre.academy.firstexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Table(name = "tipo_contratto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoContratto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128)
    private String nome;
}//end class