package it.nextre.academy.firstexample.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDataException extends RuntimeException {
    public BadDataException(){
        // todo valutare stringa di default
    }
    public BadDataException(String msg){super(msg);}
}//end class
