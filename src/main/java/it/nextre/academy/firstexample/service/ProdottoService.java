package it.nextre.academy.firstexample.service;
//Service = azioni concesse su un certo tipo di dato
import it.nextre.academy.firstexample.model.Prodotto;
import it.nextre.academy.firstexample.model.Prodotto;
import java.util.List;
public interface ProdottoService {
    List<Prodotto> findAll();
    Prodotto inserisci(String nomeProdotto);
    Prodotto aggiorna(Integer id, Prodotto prodotto);
    void cancella(Integer id);


    Prodotto findOneById(Integer id);
}