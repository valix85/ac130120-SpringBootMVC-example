package it.nextre.academy.firstexample.service;

//Service = azioni concesse su un certo tipo di dato

import it.nextre.academy.firstexample.dto.ProdottoDemoDto;
import it.nextre.academy.firstexample.model.ProdottoDemo;

import java.util.List;

public interface ProdottoDemoService {
    List<ProdottoDemo> getLastProduct(int max);
    ProdottoDemoDto toDto(ProdottoDemo prodotto);

    ProdottoDemo getOneById(Integer id);
}
