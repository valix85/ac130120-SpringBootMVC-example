package it.nextre.academy.firstexample.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "noleggio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noleggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("id_prodotto")
    @JoinColumn(name = "id_prodotto")
    @JsonManagedReference
    private Prodotto prodotto;

    @ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("id_contratto")
    @JoinColumn(name = "id_contratto")
    @JsonManagedReference
    private Contratto contratto;

    @Column(name = "costo_giorno", scale = 10, precision = 2)
    private Double costoGiorno;

    @Column(name = "data_inizio", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataInizio;

    @Column(name = "data_fine", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataFine;

}//end class
