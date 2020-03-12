package it.nextre.academy.firstexample.controller;


import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.dto.ProdottoDemoDto;
import it.nextre.academy.firstexample.model.ProdottoDemo;
import it.nextre.academy.firstexample.service.ProdottoDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Slf4j
public class GenericController {

    @Autowired
    ProdottoDemoService prodottoService;



    @GetMapping({"","home","index"})
    public String getHome(Model model){
        log.info("sono nel metodo getHome");
        System.out.println("getHome");

        model.addAttribute("nickname","pippo");

        //return "hello.html";
        return "index.html";
    }

    @GetMapping("contatti")
    public String getContatti(){
        log.debug("metodo getContatti");
        return "contatti.html";
    }


    @GetMapping("pagina2/livello3/opzione1")
    public String getHome3(Model model){
        return "hello.html";
    }



    @GetMapping("prodotti")
    public String getProdotti(Model m){
        log.debug("metodo getProdotti");
        List<ProdottoDemo> prods = prodottoService.getLastProduct(3);
        //convertire i prodotti in una lista di prodottoDto
        m.addAttribute("items",prods.stream().map(prodottoService::toDto).collect(Collectors.toList()));
        return "prodotti.html";
    }








    @GetMapping(path="json/prodotti", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdottoDemoDto>> getProdottiJson(){
        log.debug("metodo getProdottiJson");
        List<ProdottoDemo> prods = prodottoService.getLastProduct(3);
        //convertire i prodotti in una lista di prodottoDto
       List<ProdottoDemoDto> items = prods.stream().map(prodottoService::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }





    @GetMapping("prodotti/{itemId}")
    public String getProdottoById(@PathVariable("itemId") Integer id, Model m){
        log.debug("metodo getProdottoById "+id);
        ProdottoDemo tmp = prodottoService.getOneById(id);
        if (tmp.getId()!=null) {
            ProdottoDemoDto res = prodottoService.toDto(tmp);
            m.addAttribute("item", res);
            return "prodotto.html";
        }
        throw new ResourceNotFoundException();
    }





}//end class
