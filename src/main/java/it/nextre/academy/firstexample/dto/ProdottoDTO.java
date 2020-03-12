package it.nextre.academy.firstexample.dto;
import it.nextre.academy.firstexample.model.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdottoDTO {
    private Integer id;
    private Integer idCatalogo;
    private String seriale;
    private String note;
    private Double prezzo;
    private Boolean dismesso;
    private LocalDateTime data_acquisto;
}//end class