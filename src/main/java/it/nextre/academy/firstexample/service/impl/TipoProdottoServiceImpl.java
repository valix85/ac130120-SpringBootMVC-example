package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.TipoProdottoRepository;
import it.nextre.academy.firstexample.service.TipoProdottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    @Override
    public TipoProdotto inserisci(String nomeProdotto) {
        if (nomeProdotto != null && nomeProdotto.length()>0){
            TipoProdotto tmp = new TipoProdotto();
            tmp.setNome(nomeProdotto);
            return tipoProdottoRepository.save(tmp);
        }
        throw new BadDataException("Nome prodotto non valido");
    }

    @Override
    public TipoProdotto aggiorna(Integer id, TipoProdotto tipoProdotto) {
        // cerco se l'id richiesto è presente
        if (!tipoProdottoRepository.findById(id).isPresent())
            throw new BadDataException("ID prodotto non valido");

        if (id!=null && tipoProdotto != null && id.equals(tipoProdotto.getId())){
            // posso aggiornare
            return tipoProdottoRepository.save(tipoProdotto);
        }
        throw new BadDataException("Dati prodotto non validi");
    }

    @Override
    public void cancella(Integer id) {
        // cerco se l'id richiesto è presente
        if (!tipoProdottoRepository.findById(id).isPresent())
            throw new BadDataException("ID prodotto non valido");
        tipoProdottoRepository.deleteById(id);
    }
}//end class
