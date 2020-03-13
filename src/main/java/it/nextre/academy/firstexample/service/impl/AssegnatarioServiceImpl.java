package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.dto.AssegnatarioDTO;
import it.nextre.academy.firstexample.model.Assegnatario;
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
    public Assegnatario add(AssegnatarioDTO assegnatarioDTO) {
        if (assegnatarioDTO != null) {
            Assegnatario tmp = new Assegnatario();
            tmp.setNome(assegnatarioDTO.getNome());
            tmp.setCognome(assegnatarioDTO.getCognome());
            tmp.set_dipendente(assegnatarioDTO.getIs_dipendente());
            tmp.set_azienda(assegnatarioDTO.getIs_azienda());
            tmp.setRagione_sociale(assegnatarioDTO.getRagione_sociale());
            tmp.setCodice_fiscale(assegnatarioDTO.getCodice_fiscale());
            tmp.setPartita_iva(assegnatarioDTO.getPartita_iva());
            tmp.setIndirizzo(assegnatarioDTO.getIndirizzo());
            tmp.setRecapito_telefonico(assegnatarioDTO.getRecapito_telefonico());
            tmp.setRecapito_email(assegnatarioDTO.getRecapito_email());
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

    @Override
    public Assegnatario findOneById(int id) {
        return assegnatarioRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}// end class