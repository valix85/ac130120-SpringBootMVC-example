package it.nextre.academy.firstexample.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="prodotto")
@Data
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_catalogo")
    @JsonManagedReference
    private Prodotto idCatalogo;
    @Column(length = 255)
    private String seriale;
    @Column
    private String note;
    @Column(scale = 10, precision = 2)
    private Double prezzo;
    @Column
    private Boolean dismesso;
    @Column(columnDefinition = "TIMESTAMP")  //todo verificare
    private LocalDateTime data_acquisto;
}//end class