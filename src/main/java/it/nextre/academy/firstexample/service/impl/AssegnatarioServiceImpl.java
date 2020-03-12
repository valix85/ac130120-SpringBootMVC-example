package it.nextre.academy.firstexample.service.impl;
import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.model.Assegnatario;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.repository.AssegnatarioRepository;
import it.nextre.academy.firstexample.service.AssegnatarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class AssegnatarioServiceImpl implements AssegnatarioService {
    @Autowired
    AssegnatarioRepository assegnatarioRepository;
    @Override
    public List<Assegnatario> findAll() {
        return assegnatarioRepository.findAll();
    }
    public Assegnatario add(String nomeAssegnatario) {
        if (nomeAssegnatario != null && nomeAssegnatario.length() > 0) {
            Assegnatario tmp = new Assegnatario();
            tmp.setNome(nomeAssegnatario);
            return  assegnatarioRepository.save(tmp);
        }
        throw new BadDataException("Nome assegnatario non valido");
    }
    @Override
    public Assegnatario update(Integer id, Assegnatario assegnatario) {
        if (!assegnatarioRepository.findById(id).isPresent()){
            throw new BadDataException("ID assegnatario non valido");
        }
        if(id!= null && assegnatario!= null && id.equals(assegnatario.getId())){
            return assegnatarioRepository.save(assegnatario);
        }
        throw new BadDataException("Dati assegnatario non valido");
    }
    @Override
    public void  delete(Integer id) {
        if (!assegnatarioRepository.findById(id).isPresent()){
            throw new BadDataException("ID assegnatario non valido");
        }
        assegnatarioRepository.deleteById(id);
    }
}// end class