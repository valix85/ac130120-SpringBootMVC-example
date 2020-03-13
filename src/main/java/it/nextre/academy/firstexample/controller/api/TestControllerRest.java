package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.customResponse.MyCustomResponse;
import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.model.TipoContratto;
import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.service.CatalogoService;
import it.nextre.academy.firstexample.service.TipoContrattoService;
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

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/test/")
@Slf4j
public class TestControllerRest {

    @Autowired
    TipoGuastoService tipoGuastoService;

    @Autowired
    CatalogoService catalogoService;

    @Autowired
    TipoContrattoService tipoContrattoService;


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


    @GetMapping("prova-risp-1")
    public ResponseEntity getTest1(){
        log.debug("/api/test/prova-risp-1");

        List<TipoGuasto> guasti = tipoGuastoService.findAll();
        List<TipoContratto> contratti = tipoContrattoService.findAll();


        return new MyCustomResponse(HttpStatus.OK,null)
                .addData("tipoGuasti",guasti)
                .addData("tipoContratti",contratti)
                .addHeader("secToken","r78werwrgg34783434")
                .addHeaders("props", Arrays.asList("A","B","C"))
                .getPage();
    }



    @GetMapping("prova-risp-ex")
    public ResponseEntity getTestEx() {
        log.debug("/api/test/prova-risp-ex");
        throw new ResourceNotFoundException("Ok questo controller deve lanciare una 404 custom!");
    }

}//end class
