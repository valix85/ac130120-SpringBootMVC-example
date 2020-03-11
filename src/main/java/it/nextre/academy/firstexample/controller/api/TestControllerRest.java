package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.service.TipoGuastoService;
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

    @GetMapping("guasti")
    public List<TipoGuasto> getGuasti(){
        log.debug("/api/test/guasti");
        return tipoGuastoService.findAll();
    }
}//end class
