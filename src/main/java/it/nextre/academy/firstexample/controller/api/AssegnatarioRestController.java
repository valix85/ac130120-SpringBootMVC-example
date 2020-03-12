package it.nextre.academy.firstexample.controller.api;
import it.nextre.academy.firstexample.model.Assegnatario;
import it.nextre.academy.firstexample.model.TipoProdotto;
import it.nextre.academy.firstexample.service.AssegnatarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/assegnatario")
@Slf4j
public class AssegnatarioRestController {
    @Autowired
    AssegnatarioService assegnatarioService;
    @GetMapping("/")
    public List<Assegnatario> getAssegnatario() {
        log.debug("GET:  /api/assegnatario/");
        return assegnatarioService.findAll();
    }
    @PostMapping("/")
    public Assegnatario addAssegnatario(
            @RequestBody Map<String, Object> dati
    ) {
        log.debug("POST: /api/assegnatario/");
        log.info("dati ricevuti: " + dati);
        return assegnatarioService.add((String) dati.get("value"));
    }
    @PutMapping("/{id}")
    public Assegnatario update(@PathVariable("id") Integer id, @RequestBody Assegnatario assegnatario){
        log.debug("PUT:  /api/assegnatario/"+id);
        return assegnatarioService.update(id, assegnatario);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        log.debug("DELETE: /api/assegnatario/" + id);
        assegnatarioService.delete(id);
        return true;
    }
}// end class