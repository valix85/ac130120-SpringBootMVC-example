package it.nextre.academy.firstexample.controller;


import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.service.TipoGuastoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test/")
@Slf4j
public class TestController {

    @Autowired
    TipoGuastoService tipoGuastoService;

    @GetMapping(path="guasti", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoGuasto>> getGuasti(){
        log.debug("/test/guasti");
        return new ResponseEntity<List<TipoGuasto>>(tipoGuastoService.findAll(), HttpStatus.OK);
    }

}//end class
