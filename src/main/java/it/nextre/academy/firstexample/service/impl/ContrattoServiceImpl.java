package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.dto.ContrattoDTO;
import it.nextre.academy.firstexample.model.Contratto;
import it.nextre.academy.firstexample.service.AssegnatarioService;
import it.nextre.academy.firstexample.service.ContrattoService;

import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.model.Contratto;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.ContrattoRepository;
import it.nextre.academy.firstexample.service.ContrattoService;
import it.nextre.academy.firstexample.service.TipoContrattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContrattoServiceImpl implements ContrattoService {
    @Autowired
    ContrattoRepository contrattoRepository;

    @Autowired
    AssegnatarioService assegnatarioService;

    @Autowired
    TipoContrattoService tipoContrattoService;

    @Override
    public List<Contratto> findAll() {
        return contrattoRepository.findAll();
    }

    @Override
    public Contratto inserisci(ContrattoDTO contrattoDto) {
        Contratto tmp = toContratto(contrattoDto);
        if (tmp != null &&
                tmp.getId() == null &&
                tmp.getId_assegnatario() != null &&
                tmp.getId_tipo_contratto() != null) {
            return contrattoRepository.save(tmp);
        }
        throw new BadDataException("Nome contartto non valido");
    }

    @Override
    public Contratto toContratto(ContrattoDTO contrattoDto){
        Contratto tmp = new Contratto();
        tmp.setId(contrattoDto.getId());
        tmp.setId_assegnatario(assegnatarioService.findOneById(contrattoDto.getId_assegnatario()));
        tmp.setId_tipo_contratto(tipoContrattoService.findOneById(contrattoDto.getId_tipo_contratto()));
        tmp.setDataInizio(contrattoDto.getData_inizio());
        tmp.setDataFine(contrattoDto.getData_fine());
        tmp.setRecesso(contrattoDto.getRecesso());
        tmp.setPenale(contrattoDto.getPenale());
        tmp.setCosto(contrattoDto.getCosto());
        tmp.setNote(contrattoDto.getNote());
        return tmp;
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
