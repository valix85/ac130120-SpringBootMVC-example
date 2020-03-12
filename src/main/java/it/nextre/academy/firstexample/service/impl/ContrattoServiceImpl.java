package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.model.Contratto;
import it.nextre.academy.firstexample.service.ContrattoService;

import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.model.Contratto;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.ContrattoRepository;
import it.nextre.academy.firstexample.service.ContrattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContrattoServiceImpl implements ContrattoService {
    @Autowired
    ContrattoRepository contrattoRepository;

    @Override
    public List<Contratto> findAll() {
        return contrattoRepository.findAll();
    }

    @Override
    public Contratto inserisci(Contratto contratto) {
        if (contratto != null &&
                contratto.getId() != null &&
                contratto.getId_assegnatario() != null &&
                contratto.getId_tipo_contratto() != null) {
            return contrattoRepository.save(contratto);
        }
        throw new BadDataException("Nome contartto non valido");
    }

    @Override
    public Contratto update(Integer id, Contratto contratto) {
        //cerco se l'id richiesto è presente
        if (!contrattoRepository.findById(id).isPresent())
            throw new BadDataException("ID contratto non valido");
        if (id != null && contratto != null && id.equals(contratto.getId())) {
            //posso aggiornare
            return contrattoRepository.save(contratto);
        }
        throw new BadDataException("Dato non valido");
    }

    @Override
    public Boolean cancella(Integer id) {
        //cerco se l'id richiesto è presente
        if (!contrattoRepository.findById(id).isPresent())
            throw new BadDataException("Dato non valido");
        contrattoRepository.deleteById(id);
        return true;
    }
}//end class
