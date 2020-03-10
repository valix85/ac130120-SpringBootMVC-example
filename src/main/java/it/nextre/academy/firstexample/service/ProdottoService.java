package it.nextre.academy.firstexample.service;

//Service = azioni concesse su un certo tipo di dato

import it.nextre.academy.firstexample.dto.ProdottoDto;
import it.nextre.academy.firstexample.model.Prodotto;

import java.util.List;

public interface ProdottoService {
    List<Prodotto> getLastProduct(int max);
    ProdottoDto toDto(Prodotto prodotto);

    Prodotto getOneById(Integer id);
}
