package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.TipoProdottoRepository;
import it.nextre.academy.firstexample.service.TipoProdottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TipoProdottoServiceImpl implements TipoProdottoService {

    @Autowired
    TipoProdottoRepository tipoProdottoRepository;

    @Override
    public List<TipoProdotto> findAll() {
        return tipoProdottoRepository.findAll();
    }
}//end class
