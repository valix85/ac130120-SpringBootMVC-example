package it.nextre.academy.firstexample.controller.api;
import it.nextre.academy.firstexample.dto.TipoGuastoDTO;
import it.nextre.academy.firstexample.model.TipoGuasto;
import it.nextre.academy.firstexample.service.TipoGuastoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@Slf4j
@RequestMapping("/api/tipo-guasto/")
public class TipoGuastoRestController {
    @Autowired
    TipoGuastoService tipoGuastoService;
    @GetMapping
    public List<TipoGuasto> getTipoGuasto(){
        log.debug("GET:     /api/tipo-guasto/");
        return tipoGuastoService.findAll();
    }
    @PostMapping
    public TipoGuasto addTipoGuasto(@RequestBody Map<String, Object> dati){
        log.debug("POST:    /api/tipo-guasto/");
        log.info("Dati ricevuti: "+dati);
        return tipoGuastoService.insert((String)dati.get("tipo"));
    };
    @PutMapping("/{id}")
    public TipoGuasto aggiorna(@PathVariable("id") Integer id, @RequestBody TipoGuastoDTO tipoGuastoDTO){
        log.debug("PUT:     /api/tipo-guasto/"+id);
        TipoGuasto tipoGuasto=new TipoGuasto();
        tipoGuasto.setId(tipoGuastoDTO.getId());
        tipoGuasto.setTipo(tipoGuastoDTO.getTipo());
        return  tipoGuastoService.update(id, tipoGuasto);
    };
    @DeleteMapping("/{id}")
    public Boolean cancella(@PathVariable("id") Integer id){
        log.debug("DELETE:     /api/tipo-guasto/"+id);
        tipoGuastoService.delete(id);
        return true;
    };
}