package it.nextre.academy.firstexample.service;

//Service = azioni concesse su un certo tipo di dato

import it.nextre.academy.firstexample.dto.ProdottoDto;
import it.nextre.academy.firstexample.model.ProdottoDemo;

import java.util.List;

public interface ProdottoService {
    List<ProdottoDemo> getLastProduct(int max);
    ProdottoDto toDto(ProdottoDemo prodotto);

    ProdottoDemo getOneById(Integer id);
}
