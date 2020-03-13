package it.nextre.academy.firstexample.service.impl;
import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.model.TipoContratto;
import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.repository.TipoContrattoRepository;
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
    public List<TipoGuasto> findAll() {
        log.debug("TipoContrattoRepositoryImpl find all");
        return tipoGuastoRepository.findAll();
    }
    @Override
    public TipoGuasto insert(String tipo) {
        if(tipo!=null && tipo.length()>0){
            TipoGuasto tmp=new TipoGuasto();
            tmp.setTipo((tipo));
            return tipoGuastoRepository.save(tmp);
        }else {
            throw new BadDataException("Nome Prodotto non valido.");
        }
    }
    @Override
    public void delete(Integer id) {
        if(!tipoGuastoRepository.findById(id).isPresent()){
            throw new BadDataException("Id Prodotto non valido");
        }
        tipoGuastoRepository.deleteById(id);
    }
    @Override
    public TipoGuasto update(Integer id, TipoGuasto tipoGuasto) {
        if(!tipoGuastoRepository.findById(id).isPresent()){
            throw new BadDataException("Id Prodotto non valido");
        }
        if(id!=null && tipoGuasto!=null&& id.equals(tipoGuasto.getId())){
            return tipoGuastoRepository.save(tipoGuasto);
        };
        throw new BadDataException("Id Prodotto non valido");
    }

    @Override
    public TipoGuasto findOneById(int id) {
        return tipoGuastoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}//end class