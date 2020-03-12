package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.model.Esito;
import it.nextre.academy.firstexample.service.EsitoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/esito")
@Slf4j
public class EsitoRestController
{
    @Autowired
    EsitoService esitoService;
    @GetMapping("/")
    public List<Esito> getEsito() {
        log.debug("GET : /api/esito/");
        return esitoService.findAll();
    }
    //todo sistemmare
    @PostMapping("/")
    public Esito addEsito(@RequestBody Map<String, Object> dati)
    {
        log.debug(" POST : /api/esito/");
        return esitoService.addNew((String) dati.get("tipo"));
    }
    @PutMapping("/{id}")
    public Esito updatea(@PathVariable("id") Integer id, @RequestBody Esito esito)
    {
        log.debug("PUT : /api/esito/"+id);
        Esito esitonew = new Esito();
        esitonew.setId(esito.getId());
        esitonew.setTipo(esito.getTipo());
        return esitoService.update(id,esitonew);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") Integer id)
    {
        log.debug(("DELETE : /api/esito/"+id));
        esitoService.delete(id);
        return true;
    }
}//end class
