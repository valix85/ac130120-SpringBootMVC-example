package it.nextre.academy.firstexample.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="assistenza")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assistenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    @JsonManagedReference
    private Prodotto idProdotto;
    @ManyToOne
    @JoinColumn(name = "id_assegnatario")
    @JsonManagedReference
    private Assegnatario idAssegnatario;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime data_inizio;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime data_fine;
    @Column(scale = 10, precision = 2, nullable = false)
    private Double costo_riparazione;
    @Column
    private String note;
    @ManyToOne
    @JoinColumn(name = "tipo_guasto")
    @JsonManagedReference
    private TipoGuasto tipoGuasto;
    private Boolean in_garanzia;
    @ManyToOne
    @JoinColumn(name = "esito")
    @JsonManagedReference
    private Esito esito;
    @Column
    private Boolean fattura_cliente;
}//end class
