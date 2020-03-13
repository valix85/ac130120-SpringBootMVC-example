package it.nextre.academy.firstexample.controller.api;
import it.nextre.academy.firstexample.dto.NoleggioDTO;
import it.nextre.academy.firstexample.model.Noleggio;
import it.nextre.academy.firstexample.service.NoleggioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/noleggio/")
@Slf4j
public class NoleggioRestController {
    @Autowired
    NoleggioService noleggioService;
    @GetMapping("/")
    public List<Noleggio> findAll(){
        log.debug("GET:  /api/tipo-prodotto");
        return noleggioService.findAll();
    }
    @GetMapping("/{id}")
    public Noleggio getById(@PathVariable("id") Integer id){
        log.debug("GET: /api/noleggio/");
        return noleggioService.getById(id);
    }
    @PostMapping("/")
    public Noleggio inserisci(@RequestBody Map<Integer, Object> dati){
        log.debug("POST: /api/noleggio/");
        log.info("dati ricevuti: "+ dati);
        return noleggioService.inserisci((Integer) dati.get("value"));
    }
    @DeleteMapping("/{id}")
    public Boolean cancella(@PathVariable("id")Integer id){
        log.debug("DELETE: /api/tipo-prodotto"+id);
        noleggioService.rimuovi(id);
        return true;
    }

    @PutMapping("/{id}")
    public Noleggio aggiorna(@PathVariable("id") Integer id, @RequestBody NoleggioDTO noleggioDTO){
        log.debug("PUT: /api/noleggio/"+id);
        Noleggio noleggio= new Noleggio();
        noleggio.setDataFine(noleggioDTO.getDataFine());
        noleggio.setCostoGiorno(noleggioDTO.getCostoGiorno());
        return noleggioService.aggiorna(id, noleggio);
    }
}//end class
