package it.nextre.academy.firstexample.service.impl;
import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.model.Noleggio;
import it.nextre.academy.firstexample.repository.NoleggioRepository;
import it.nextre.academy.firstexample.service.NoleggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoleggioServiceImpl implements NoleggioService {
    @Autowired
    NoleggioRepository noleggioRepository;


    @Override
    public List<Noleggio> findAll() {
        return noleggioRepository.findAll();
    }

    @Override
    public Noleggio inserisci(Integer id) {
        if(id!=null){
            Noleggio tmp=new Noleggio();
            tmp.setId(id);
            return noleggioRepository.save(tmp);
        }
        throw new BadDataException("Id non valido!");
    }

    @Override
    public Noleggio getById(Integer id) {
        return noleggioRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Noleggio aggiorna(Integer id, Noleggio noleggio) {

        Optional<Noleggio> orginale = noleggioRepository.findById(id);
        if(!orginale.isPresent())
            throw new BadDataException("Id non valido");
        if(id!=null && noleggio!= null && noleggio.getId()!=null){
            Noleggio tmp = orginale.get();
            //todo fare controlli su cosa assegno
            tmp.setDataFine(noleggio.getDataFine());
            tmp.setCostoGiorno(noleggio.getCostoGiorno());
            return noleggioRepository.save(tmp);
        }
        throw new BadDataException("Dati noleggio non validi");
    }
    @Override
    public void rimuovi(Integer id) {
        if(!noleggioRepository.findById(id).isPresent())
            throw new BadDataException("Id non valido");
        noleggioRepository.deleteById(id);
    }
}//end class
