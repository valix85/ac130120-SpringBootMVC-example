package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.dto.ContrattoDTO;
import it.nextre.academy.firstexample.model.Contratto;
import it.nextre.academy.firstexample.service.ContrattoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/contratto")
@Slf4j
public class ContrattoRestController {
    @Autowired
    ContrattoService contrattoService;
    @GetMapping("/")
    public List<Contratto> getContratto(){
        log.debug("GET: /api/contratto/");
        return contrattoService.findAll();
    }
    @PostMapping("/")
    public Contratto addContratto(
            @RequestBody ContrattoDTO contrattoDto
    ){
        log.debug("POST: /api/contratto/");

        return contrattoService.inserisci( contrattoDto );
    }
    @PutMapping("/{id}")
    public Contratto aggiorna(@PathVariable("id") Integer id,
                              @RequestBody Contratto tipoContratto){
        //controllo
        log.debug("PUT: /api/contartto/"+id);
        return contrattoService.update(id, tipoContratto);
    }
    @DeleteMapping("/{id}")
    public Boolean cancella(@PathVariable("id") Integer id) {
        log.debug(("DELETE: /api/contratto"+id));
        contrattoService.cancella(id);
        return true;
    }
}//end class
