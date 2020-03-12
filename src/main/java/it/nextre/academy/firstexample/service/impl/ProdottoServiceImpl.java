package it.nextre.academy.firstexample.service.impl;
import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.model.Prodotto;
import it.nextre.academy.firstexample.repository.ProdottoRepository;
import it.nextre.academy.firstexample.service.ProdottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class ProdottoServiceImpl implements ProdottoService {
    @Autowired
    ProdottoRepository prodottoRepository;
    @Override
    public List<Prodotto> findAll() {
        return prodottoRepository.findAll();
    }
    @Override
    public Prodotto inserisci(String serialeProdotto) {
        if (serialeProdotto != null && serialeProdotto.length() > 0){
            Prodotto tmp = new Prodotto();
            tmp.setSeriale(serialeProdotto);
            return prodottoRepository.save(tmp);
        }
        throw new BadDataException("Nome prodotto non valido");
    }
    @Override
    public Prodotto aggiorna(Integer id, Prodotto prodotto) {
        // cerco se l'id richiesto è presente
        if (!prodottoRepository.findById(id).isPresent()) {
            throw new BadDataException("ID prodotto non valido");
        }
        if (id != null && prodotto != null && id.equals(prodotto.getId())){
            //posso aggiornare
            return prodottoRepository.save(prodotto);
        }
        throw new BadDataException("Dati prodotto non validi");
    }
    @Override
    public void cancella(Integer id) {
        // cerco se l'id richiesto è presente
        if (!prodottoRepository.findById(id).isPresent()) {
            throw new BadDataException("ID prodotto non valido");
        }
        prodottoRepository.deleteById(id);
    }

    @Override
    public Prodotto findOneById(Integer id) {
        return prodottoRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}//end class