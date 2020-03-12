package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.model.Contratto;
import java.util.List;
public interface ContrattoService {
    List<Contratto> findAll();

    Contratto inserisci(Contratto contratto);
    Contratto update(Integer id, Contratto contratto);

    Boolean cancella(Integer id);
}
