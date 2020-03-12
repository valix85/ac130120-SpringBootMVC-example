package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.model.TipoProdotto;

import java.util.List;

public interface TipoProdottoService {
    List<TipoProdotto> findAll();
    TipoProdotto inserisci(String nomeProdotto);

    TipoProdotto aggiorna(Integer id, TipoProdotto tipoProdotto);

    void cancella(Integer id);
}
