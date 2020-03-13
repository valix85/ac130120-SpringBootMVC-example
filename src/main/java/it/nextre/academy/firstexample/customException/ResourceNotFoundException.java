package it.nextre.academy.firstexample.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   public ResourceNotFoundException(){
      this("La risorsa richiesta non è dipsonibile");
   }
   public ResourceNotFoundException(String msg){super(msg);}

}//end class
