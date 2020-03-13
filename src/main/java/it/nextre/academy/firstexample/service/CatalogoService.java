package it.nextre.academy.firstexample.service;

import it.nextre.academy.firstexample.dto.CatalogoDTO;
import it.nextre.academy.firstexample.model.Catalogo;

import java.util.List;
public interface CatalogoService {
    List<Catalogo> findAll();
    Catalogo findById(Integer idCatalogo);
    Catalogo insert(Catalogo catalogo);
    Catalogo update(Integer id, Catalogo catalogo);
    Boolean delete(Integer id);
    Catalogo toCatalogo(CatalogoDTO catalogoDTO);
}//end class
