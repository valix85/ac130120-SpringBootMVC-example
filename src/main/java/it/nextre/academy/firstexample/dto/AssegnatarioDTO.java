package it.nextre.academy.firstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssegnatarioDTO {
    private Integer id;
    private String nome;
    private String cognome;
    private Boolean is_dipendente;
    private Boolean is_azienda;
    private String ragione_sociale;
    private String codice_fiscale;
    private String partita_iva;
    private String indirizzo;
    private String recapito_telefonico;
    private String recapito_email;
}// end class
