package it.nextre.academy.firstexample.repository;

import it.nextre.academy.firstexample.model.Prodotto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProdottoRepositoryFake {

    List<Prodotto> db = new ArrayList<>();
    {
        db.add(new Prodotto(1,"Mouse GM1","Big mouse 102 tasti", 49.98, LocalDateTime.now(),"/data/copertina/1.png","lorem ipsum",4));

        db.add(new Prodotto(2,"Monitor 24\" LED ASUS MK3","Monitor 4K 5ms LED", 249.98, LocalDateTime.now(),"/data/copertina/2.png","lorem ipsum",2));

        db.add(new Prodotto(3,"Tastiera AURUS AR886","tastiera retroilluminata RGB", 79.98, LocalDateTime.now(),"/data/copertina/3.png","lorem ipsum",1));

        db.add(new Prodotto(4,"Tastiera MARKUS MKK4","tastiera meccanica retroilluminata RGB gaming", 109.49, LocalDateTime.now(),"/data/copertina/4.png","lorem ipsum",5));

        db.add(new Prodotto(5,"Casse SoundBlaster 5.1  PRO","Set 5 casse full-range più subwoofer 6\" 60W RMS", 139.49, LocalDateTime.now(),"/data/copertina/5.png","lorem ipsum",4));


    }


    public Prodotto getById(int id){
        return  db.stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElseGet(Prodotto::new);
    }

    public List<Prodotto> getAll(){return db;}

    public List<Prodotto> getLasts(int n){
        return db.stream()
                .sorted(Comparator.comparing(Prodotto::getId).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }


}//end class
