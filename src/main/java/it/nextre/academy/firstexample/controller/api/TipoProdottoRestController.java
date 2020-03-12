package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.dto.TipoProdottoDTO;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.service.TipoProdottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tipo-prodotto")
@Slf4j
public class TipoProdottoRestController {

    @Autowired
    TipoProdottoService tipoProdottoService;

    @GetMapping("/")
    public List<TipoProdotto> getTipoProdotto(){
        log.debug("GET:  /api/tipo-prodotto/");
        return tipoProdottoService.findAll();
    }

    // todo sistemare eventualmente il RequestBody
    @PostMapping("/")
    public TipoProdotto addTipoProdotto(
            @RequestBody Map<String, Object> dati
            ){
        log.debug("POST: /api/tipo-prodotto/");
        log.info("dati ricevuti: "+dati);
        return tipoProdottoService.inserisci((String)dati.get("value"));
    }


    // todo sistemare eventualmente il RequestBody
    /*
    @PutMapping("/{id}")
    public TipoProdotto aggiorna(@PathVariable("id") Integer id, @RequestBody TipoProdotto tipoProdotto){
     log.debug("PUT:  /api/tipo-prodotto/"+id);
     return tipoProdottoService.aggiorna(id, tipoProdotto);
    }
    */

    // Con DTO
    @PutMapping("/{id}")
    public TipoProdotto aggiorna(@PathVariable("id") Integer id, @RequestBody TipoProdottoDTO tipoProdottoDTO){
        log.debug("PUT:  /api/tipo-prodotto/"+id);
        TipoProdotto tipoProdotto = new TipoProdotto();
        tipoProdotto.setId(tipoProdottoDTO.getId());
        tipoProdotto.setNome(tipoProdottoDTO.getNome());
        return tipoProdottoService.aggiorna(id, tipoProdotto);
    }

    @DeleteMapping("/{id}")
    public Boolean cancella(@PathVariable("id") Integer id){
        log.debug("DELETE: /api/tipo-prodotto/"+id);
        tipoProdottoService.cancella(id);
        return true;
    }

}//end class
