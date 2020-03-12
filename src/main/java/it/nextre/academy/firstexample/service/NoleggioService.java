package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.model.Noleggio;
import java.time.LocalDateTime;
import java.util.List;
public interface NoleggioService {
    List<Noleggio> findAll();
    Noleggio inserisci(Integer id);
    Noleggio getById(Integer id);
    Noleggio aggiorna(Integer id, Noleggio noleggio);
    void rimuovi (Integer id);
}//end class
