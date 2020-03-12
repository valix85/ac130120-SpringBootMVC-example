package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.dto.TipoContrattoDTO;
import it.nextre.academy.firstexample.model.TipoContratto;
import it.nextre.academy.firstexample.service.TipoContrattoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/tipo-contratto/")
public class TipoContrattoRestController {
    @Autowired
    TipoContrattoService tipoContrattoService;

    @GetMapping
    public List<TipoContratto> getTipoContratto() {
        log.debug("GET:     /api/tipo-contratto/");
        return tipoContrattoService.findAll();
    }

    @PostMapping
    public TipoContratto addTipoProdotto(@RequestBody Map<String, Object> dati) {
        log.debug("POST:    /api/tipo-contratto/");
        log.info("Dati ricevuti: " + dati);
        return tipoContrattoService.insert((String) dati.get("nome"));
    }

    ;

    @PutMapping("/{id}")
    public TipoContratto aggiorna(@PathVariable("id") Integer id, @RequestBody TipoContrattoDTO tipoContrattoDTO) {
        log.debug("PUT:     /api/tipo-contratto/" + id);
        TipoContratto tipoContratto = new TipoContratto();
        tipoContratto.setId(tipoContrattoDTO.getId());
        tipoContratto.setNome(tipoContrattoDTO.getNome());
        return tipoContrattoService.update(id, tipoContratto);
    }

    ;

    @DeleteMapping("/{id}")
    public Boolean cancella(@PathVariable("id") Integer id) {
        log.debug("DELETE:     /api/tipo-contratto/" + id);
        tipoContrattoService.delete(id);
        return true;
    }

    ;
}//end class
