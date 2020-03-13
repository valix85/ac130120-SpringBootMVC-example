package it.nextre.academy.firstexample.service;
import it.nextre.academy.firstexample.dto.AssegnatarioDTO;
import it.nextre.academy.firstexample.model.Assegnatario;
import java.util.List;
public interface AssegnatarioService {
    Assegnatario findOneById(int id);
    List<Assegnatario> findAll();
    Assegnatario add(AssegnatarioDTO nomeAssegnatario);
    Assegnatario update(Integer id, Assegnatario assegnatario);
    void  delete(Integer id);
}