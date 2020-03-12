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
    AssistenzaService assistenza;
    @GetMapping("/")
    public List<Assistenza> findAll() {
        log.debug("GET: /api/assistenza/");
        return assistenza.findAll();
    }
    @GetMapping("/{id}")
    public Assistenza getAssistenzaById(@PathVariable("id") Integer id) {
        log.debug("GET: /api/assistenza/" + id);
        return assistenza.findById(id);
    }
    @PostMapping("/")
    public Assistenza insert(@RequestBody AssistenzaDTO assistenzaDto) {
        log.debug("GET: /api/assistenza/");
        Assistenza tmp = new Assistenza();
        // todo URGENTE fix con i vari repository
        tmp.getIdProdotto().setId(assistenzaDto.getIdProdotto());
        tmp.getIdAssegnatario().setId(assistenzaDto.getIdAssegnatario());
        tmp.setData_inizio(assistenzaDto.getData_inizio());
        tmp.setData_fine(assistenzaDto.getData_fine());
        tmp.setCosto_riparazione(assistenzaDto.getCosto_riparazione());
        tmp.setNote(assistenzaDto.getNote());
        tmp.getTipoGuasto().setId(assistenzaDto.getId());
        tmp.setIn_garanzia(assistenzaDto.getIn_garanzia());
        tmp.getEsito().setId(assistenzaDto.getEsito());
        tmp.setFattura_cliente(assistenzaDto.getFattura_cliente());
        return assistenza.insert(tmp);
    }
    @PutMapping("/{id}")
    public Assistenza update(@PathVariable("id") Integer id,
                             @RequestBody AssistenzaDTO assistenzaDto) {
        log.debug("PUT: /api/assistenza/" + id);
        Assistenza tmp = new Assistenza();
        tmp.setData_fine(assistenzaDto.getData_fine());
        tmp.setCosto_riparazione(assistenzaDto.getCosto_riparazione());
        tmp.setNote(assistenzaDto.getNote());
        tmp.getTipoGuasto().setId(assistenzaDto.getTipoGuasto());
        tmp.getEsito().setId(assistenzaDto.getEsito());
        tmp.setFattura_cliente(assistenzaDto.getFattura_cliente());
        return assistenza.update(tmp);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        log.debug("DELETE: /api/assistenza/" + id);
        assistenza.delete(id);
        return true;
    }
}//end class
