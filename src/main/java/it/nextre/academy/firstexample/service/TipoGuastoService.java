package it.nextre.academy.firstexample.service;
import it.nextre.academy.firstexample.model.TipoContratto;
import it.nextre.academy.firstexample.model.TipoGuasto;
import java.util.List;
public interface TipoGuastoService {
    List<TipoGuasto> findAll();
    TipoGuasto insert(String tipo);
    void delete(Integer id);
    TipoGuasto update(Integer id, TipoGuasto tipoGuasto);
}