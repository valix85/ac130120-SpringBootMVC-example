package it.nextre.academy.firstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {
    private Integer id;
    private String marca;
    private String nome_prodotto;
    private String modello;
    private String descrizione;
    private Integer tipoProdotto;
}//end class
