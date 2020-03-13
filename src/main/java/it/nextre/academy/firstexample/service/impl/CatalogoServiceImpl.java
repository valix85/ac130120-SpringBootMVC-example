package it.nextre.academy.firstexample.service.impl;

import it.nextre.academy.firstexample.customException.BadDataException;
import it.nextre.academy.firstexample.dto.CatalogoDTO;
import it.nextre.academy.firstexample.model.Catalogo;
import it.nextre.academy.firstexample.repository.CatalogoRepository;
import it.nextre.academy.firstexample.service.CatalogoService;
import it.nextre.academy.firstexample.service.TipoProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CatalogoServiceImpl implements CatalogoService {
    @Autowired
    CatalogoRepository catalogoRepository;
    @Autowired
    TipoProdottoService tipoProdottoService;
    @Override
    public List<Catalogo> findAll() {
        return catalogoRepository.findAll();
    }
    @Override
    public Catalogo findById(Integer idCatalogo) {
        return catalogoRepository.findById(idCatalogo).orElseThrow(BadDataException::new);
    }
    @Override
    public Catalogo insert(Catalogo catalogo) {
        if (catalogo != null && catalogo.getId() != null && catalogo.getTipoProdotto() != null) {
            return catalogoRepository.save(catalogo);
        }
        throw new BadDataException("Dati catalogo non validi");
    }
    @Override
    public Catalogo update(Integer id, Catalogo catalogo) {
        if(!catalogoRepository.findById(id).isPresent())
            throw new BadDataException("Id assistenza non presente");
        if(id !=null && catalogo !=null && id.equals(catalogo.getId()))
            return catalogoRepository.save(catalogo);
        throw new BadDataException("Dati assistenza non validi");
    }
    @Override
    public Boolean delete(Integer id) {
        catalogoRepository.deleteById(id);
        return true;
    }
    @Override
    public Catalogo toCatalogo(CatalogoDTO catalogoDto) {
        Catalogo tmp = new Catalogo();
        tmp.setId(catalogoDto.getId());
        tmp.setMarca(catalogoDto.getMarca());
        tmp.setNome_prodotto(catalogoDto.getNome_prodotto());
        tmp.setModello(catalogoDto.getModello());
        tmp.setDescrizione(catalogoDto.getDescrizione());
        tmp.setTipoProdotto(tipoProdottoService.findOneById(catalogoDto.getId()));
        return tmp;
    }
}//end class
