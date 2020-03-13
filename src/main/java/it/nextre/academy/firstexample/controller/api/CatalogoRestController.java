package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.dto.CatalogoDTO;
import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.service.CatalogoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
@Slf4j
public class CatalogoRestController {
    @Autowired
    CatalogoService catalogoService;

    @GetMapping("/")
    public List<Catalogo> findAll() {
        log.debug("GET: /api/catalogo/");
        return catalogoService.findAll();
    }

    @GetMapping("/{id}")
    public Catalogo getCatalogoById(@PathVariable("id") Integer id) {
        log.debug("GET: /api/catalogo/" + id);
        return catalogoService.findById(id);
    }

    @PostMapping("/")
    public Catalogo insert(@RequestBody CatalogoDTO catalogoDto) {
        log.debug("GET: /api/catalogo/");
        Catalogo tmp = catalogoService.toCatalogo(catalogoDto);
        return catalogoService.insert(tmp);
    }

    @PutMapping("/{id}")
    public Catalogo update(@PathVariable("id") Integer id,
                           @RequestBody CatalogoDTO catalogoDto) {
        log.debug("PUT: /api/catalogo/" + id);
        Catalogo tmp = catalogoService.toCatalogo(catalogoDto);
        return catalogoService.update(id, tmp);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        log.debug("DELETE: /api/catalogo/" + id);
        catalogoService.delete(id);
        return true;
    }
}//end class