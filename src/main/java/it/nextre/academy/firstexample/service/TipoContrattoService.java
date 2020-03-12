package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.model.TipoContratto;

import java.util.List;

public interface TipoContrattoService {
    List<TipoContratto> findAll();

    TipoContratto insert(String nome);

    void delete(Integer id);

    TipoContratto update(Integer id, TipoContratto tipoContratto);
}