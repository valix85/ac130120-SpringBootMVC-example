package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.repository.TipoGuastoRepository;
import it.nextre.academy.firstexample.service.TipoGuastoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TipoGuastoServiceImpl implements TipoGuastoService {

    @Autowired
    TipoGuastoRepository tipoGuastoRepository;

    @Override
    public List<TipoGuasto> findAll() {
        log.debug("TipoGuastoServiceImpl findAll method");
        return tipoGuastoRepository.findAll();
    }
}//end class
