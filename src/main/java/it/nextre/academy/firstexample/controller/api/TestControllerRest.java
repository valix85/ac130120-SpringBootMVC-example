package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.service.CatalogoService;
import it.nextre.academy.firstexample.service.TipoGuastoService;
import it.nextre.academy.firstexample.service.TipoProdottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test/")
@Slf4j
public class TestControllerRest {

    @Autowired
    TipoGuastoService tipoGuastoService;

    @Autowired
    CatalogoService catalogoService;

    @GetMapping("tipo-guasti")
    public List<TipoGuasto> getTipoGuasti(){
        log.debug("/api/test/tipo-guasti");
        return tipoGuastoService.findAll();
    }

    @GetMapping("catalogo")
    public List<Catalogo> getCatalogo(){
        log.debug("/api/test/catalogo");
        return catalogoService.findAll();
    }

}//end class
