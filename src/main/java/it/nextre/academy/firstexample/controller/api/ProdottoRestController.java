package it.nextre.academy.firstexample.controller.api;
import it.nextre.academy.firstexample.dto.ProdottoDTO;
import it.nextre.academy.firstexample.model.Prodotto;
import it.nextre.academy.firstexample.service.ProdottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/prodotto")
@Slf4j
public class ProdottoRestController {
    @Autowired
    ProdottoService prodottoService;
    @GetMapping("/")
    public List<Prodotto> getProdotti(){
        log.debug("GET: /api/prodotto/");
        return prodottoService.findAll();
    }
    //todo sistemare eventualmente il RequestBody
    @PostMapping("/")
    public Prodotto addProdotto(@RequestBody Map<String, Object> dati){
        log.debug("POST: /api/prodotto/");
        log.info("dati ricevuti: " + dati);
        return prodottoService.inserisci((String)dati.get("value"));
    }
    //con DTO
    @PutMapping("/{id}")
    public Prodotto aggiorna (@PathVariable("id") Integer id, @RequestBody ProdottoDTO prodottoDTO){
        log.debug("PUT: /api/prodotto/" + id);
        Prodotto prodotto = new Prodotto();
        prodotto.setId(prodottoDTO.getId());
        prodotto.setIdCatalogo(prodottoDTO.getIdCatalogo());
        prodotto.setSeriale(prodottoDTO.getSeriale());
        prodotto.setNote(prodottoDTO.getNote());
        prodotto.setPrezzo(prodottoDTO.getPrezzo());
        prodotto.setDismesso(prodottoDTO.getDismesso());
        prodotto.setData_acquisto(prodottoDTO.getData_acquisto());
        return prodottoService.aggiorna(id, prodotto);
    }
    @DeleteMapping("/{id}")
    public Boolean cancella (@PathVariable("id") Integer id){
        log.debug("DELETE: /api/prodotto/" + id);
        prodottoService.cancella(id);
        return true;
    }
}//end class