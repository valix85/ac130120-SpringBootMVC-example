package it.nextre.academy.firstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdottoDemoDto {
    private Integer id;
    private String nome;
    private String descrizione;
    private Double prezzo;
}//end class
