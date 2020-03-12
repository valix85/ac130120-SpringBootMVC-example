package it.nextre.academy.firstexample.service;
import it.nextre.academy.firstexample.model.Assegnatario;
import java.util.List;
public interface AssegnatarioService {
    List<Assegnatario> findAll();
    Assegnatario add(String nomeAssegnatario);
    Assegnatario update(Integer id, Assegnatario assegnatario);
    void  delete(Integer id);
}