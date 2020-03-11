package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.model.TipoProdotto;
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
    TipoProdottoService tipoProdottoService;

    @GetMapping("tipo-guasti")
    public List<TipoGuasto> getTipoGuasti(){
        log.debug("/api/test/tipo-guasti");
        return tipoGuastoService.findAll();
    }

    @GetMapping("tipo-prodotti")
    public List<TipoProdotto> getTipoProdotti(){
        log.debug("/api/test/tipo-prodotti");
        return tipoProdottoService.findAll();
    }
}//end class
