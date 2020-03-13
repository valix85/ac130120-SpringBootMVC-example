package it.nextre.academy.firstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContrattoDTO {
    private Integer id;
    private Integer id_assegnatario;
    private Integer id_tipo_contratto;
    private LocalDateTime data_inizio;
    private LocalDateTime data_fine;
    private Boolean recesso;
    private Double penale;
    private Double costo;
    private String note;
}//end class
