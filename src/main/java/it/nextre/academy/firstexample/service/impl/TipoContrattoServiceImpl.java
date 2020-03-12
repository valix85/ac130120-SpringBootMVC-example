package it.nextre.academy.firstexample.service.impl;


import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.model.TipoContratto;
import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.TipoContrattoRepository;
import it.nextre.academy.firstexample.repository.TipoGuastoRepository;
import it.nextre.academy.firstexample.service.TipoContrattoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TipoContrattoServiceImpl implements TipoContrattoService {
    @Autowired
    TipoContrattoRepository tipoContrattoRepository;

    public List<TipoContratto> findAll() {
        log.debug("TipoContrattoRepositoryImpl find all");
        return tipoContrattoRepository.findAll();
    }

    @Override
    public TipoContratto insert(String nome) {
        if (nome != null && nome.length() > 0) {
            TipoContratto tmp = new TipoContratto();
            tmp.setNome((nome));
            return tipoContrattoRepository.save(tmp);
        } else {
            throw new BadDataException("Nome Prodotto non valido.");
        }
    }

    @Override
    public void delete(Integer id) {
        if (!tipoContrattoRepository.findById(id).isPresent()) {
            throw new BadDataException("Id Prodotto non valido");
        }
        tipoContrattoRepository.deleteById(id);
    }

    @Override
    public TipoContratto update(Integer id, TipoContratto tipoContratto) {
        if (!tipoContrattoRepository.findById(id).isPresent()) {
            throw new BadDataException("Id Prodotto non valido");
        }
        if (id != null && tipoContratto != null && id.equals(tipoContratto.getId())) {
            return tipoContrattoRepository.save(tipoContratto);
        }
        ;
        throw new BadDataException("Id Prodotto non valido");
    }
}