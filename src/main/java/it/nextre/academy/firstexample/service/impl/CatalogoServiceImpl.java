package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.repository.CatalogoRepository;
import it.nextre.academy.firstexample.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    CatalogoRepository catalogoRepository;

    @Override
    public List<Catalogo> findAll() {
        return catalogoRepository.findAll();
    }
}//end class
