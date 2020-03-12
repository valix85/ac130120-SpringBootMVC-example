package it.nextre.academy.firstexample.service.impl;
import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.model.Esito;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.EsitoRepository;
import it.nextre.academy.firstexample.repository.TipoProdottoRepository;
import it.nextre.academy.firstexample.service.EsitoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class EsitoServiceImpl implements EsitoService
{
    @Autowired
    EsitoRepository esitoRepository;
    @Override
    public List<Esito> findAll()
    {
        return esitoRepository.findAll();
    }
    @Override
    public Esito addNew(String tipoesito)
    {
        if (tipoesito !=null && tipoesito.length()>0)
        {    Esito tmp = new Esito();
            tmp.setTipo(tipoesito);
            return esitoRepository.save(tmp);
        }
        throw  new BadDataException("dati esito non valido");
    }
    @Override
    public Esito update(Integer id, Esito esito)
    {
        if(!esitoRepository.findById(id).isPresent())
            throw new BadDataException("Id esito non valido");
        if(id !=null && esito !=null && id.equals(esito.getId()))
        {
            return esitoRepository.save(esito);
        }
        throw new BadDataException("Dati esito non valido");
    }
    @Override
    public Boolean delete(Integer id)
    {
        if(esitoRepository.findById(id).isPresent())
        {
            try {
                esitoRepository.deleteById(id);
                return true;
            }catch (Exception ex){
                throw new BadDataException("Dati non validi o esito non trovato");
            }
        }
        throw new BadDataException("Dati non validi o esito non trovato");
    }
}//end class