package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.model.Esito;
import java.util.List;
public interface EsitoService
{
    List<Esito> findAll();
    Esito addNew(String tipoesito);
    Esito update(Integer id, Esito esito);
    Boolean delete(Integer id);
    Esito findOneById(Integer id);
}