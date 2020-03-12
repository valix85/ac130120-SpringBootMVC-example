package it.nextre.academy.firstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoleggioDTO {
    private Integer id;
    private Double costoGiorno;
    private LocalDateTime dataInizio;
    private LocalDateTime dataFine;
}//end class
