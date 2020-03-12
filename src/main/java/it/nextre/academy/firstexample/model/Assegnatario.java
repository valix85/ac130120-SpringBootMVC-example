package it.nextre.academy.firstexample.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Table(name="assegnatario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assegnatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 255)
    private String nome;
    @Column(length = 255)
    private String cognome;
    @Column()
    private boolean is_dipendente;
    @Column()
    private boolean is_azienda;
    @Column(length = 255)
    private String ragione_sociale;
    @Column(length = 255)
    private String codice_fiscale;
    @Column(length = 255)
    private String partita_iva;
    @Column(length = 255)
    private String indirizzo;
    @Column(length = 255)
    private String recapito_telefonico;
    @Column(length = 255)
    private String recapito_email;
}// end class