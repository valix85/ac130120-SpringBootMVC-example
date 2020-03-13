package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.dto.AssegnatarioDTO;
import it.nextre.academy.firstexample.model.Assegnatario;
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
        return assegnatarioService.add((AssegnatarioDTO) dati.get("value"));
    }
    @PutMapping("/{id}")
    public Assegnatario update(@PathVariable("id") Integer id, @RequestBody AssegnatarioDTO assegnatarioDTO){
        log.debug("PUT:  /api/assegnatario/"+id);
        Assegnatario assegnatario = new Assegnatario();
        assegnatario.setId(assegnatarioDTO.getId());
        assegnatario.setNome(assegnatarioDTO.getNome());
        assegnatario.setCognome(assegnatarioDTO.getCognome());
        assegnatario.set_dipendente(assegnatarioDTO.getIs_dipendente());
        assegnatario.set_azienda(assegnatarioDTO.getIs_azienda());
        assegnatario.setRagione_sociale(assegnatarioDTO.getRagione_sociale());
        assegnatario.setCodice_fiscale(assegnatarioDTO.getCodice_fiscale());
        assegnatario.setPartita_iva(assegnatarioDTO.getPartita_iva());
        assegnatario.setIndirizzo(assegnatarioDTO.getIndirizzo());
        assegnatario.setRecapito_telefonico(assegnatarioDTO.getRecapito_telefonico());
        assegnatario.setRecapito_email(assegnatarioDTO.getRecapito_email());
        return assegnatarioService.update(id, assegnatario);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        log.debug("DELETE: /api/assegnatario/" + id);
        assegnatarioService.delete(id);
        return true;
    }
}// end class