package it.nextre.academy.firstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssistenzaDTO {
    private Integer id;
    private Integer idProdotto;
    private Integer idAssegnatario;
    private LocalDateTime data_inizio;
    private LocalDateTime data_fine;
    private Double costo_riparazione;
    private String note;
    private Integer tipoGuasto;
    private Boolean in_garanzia;
    private Integer esito;
    private Boolean fattura_cliente;
}//end class
