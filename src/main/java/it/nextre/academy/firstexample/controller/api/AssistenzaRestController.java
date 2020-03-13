package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.dto.AssistenzaDTO;
import it.nextre.academy.firstexample.model.Assistenza;
import it.nextre.academy.firstexample.service.AssistenzaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/assistenza/")
@Slf4j
public class AssistenzaRestController {
    @Autowired
    AssistenzaService assistenzaService;
    @GetMapping("/")
    public List<Assistenza> findAll() {
        log.debug("GET: /api/assistenza/");
        return assistenzaService.findAll();
    }
    @GetMapping("/{id}")
    public Assistenza getAssistenzaById(@PathVariable("id") Integer id) {
        log.debug("GET: /api/assistenza/" + id);
        return assistenzaService.findById(id);
    }
    @PostMapping("/")
    public Assistenza insert(@RequestBody AssistenzaDTO assistenzaDto) {
        log.debug("GET: /api/assistenza/");
        return assistenzaService.insert(assistenzaService.toAssistenza(assistenzaDto));
    }
    @PutMapping("/{id}")
    public Assistenza update(@PathVariable("id") Integer id,
                             @RequestBody AssistenzaDTO assistenzaDto) {
        log.debug("PUT: /api/assistenza/" + id);
        return assistenzaService.update(id, assistenzaService.toAssistenza(assistenzaDto));
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        log.debug("DELETE: /api/assistenza/" + id);
        assistenzaService.delete(id);
        return true;
    }
}//end class
