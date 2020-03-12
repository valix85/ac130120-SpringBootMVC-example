package it.nextre.academy.firstexample.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contratto")
@Data
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_assegnatario")
    private Assegnatario id_assegnatario;
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoContratto id_tipo_contratto;
    @Column
    private LocalDateTime dataInizio;
    @Column
    private LocalDateTime dataFine;
    @Column(name = "recesso", nullable = false)
    private boolean recesso = true;
    @Column(length = 10, precision = 2)
    private Double penale;
    @Column(length = 10, precision = 2)
    private Double costo;
    @Column
    private String note;
}