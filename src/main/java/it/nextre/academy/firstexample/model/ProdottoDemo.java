package it.nextre.academy.firstexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdottoDemo {
    private Integer id;
    private String nome;
    private String descrizione;
    private Double prezzo;
    private LocalDateTime create;
    private String immagine;
    private String istruzioni;
    private Integer stelle;
}//end class
