package it.nextre.academy.firstexample.controller.api;

import it.nextre.academy.firstexample.customException.ResourceNotFoundException;
import it.nextre.academy.firstexample.customResponse.MyCustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// https://www.baeldung.com/exception-handling-for-rest-with-spring
// https://en.wikipedia.org/wiki/List_of_HTTP_status_codes

// limito alle sole api
@RestControllerAdvice("it.nextre.academy.firstexample.controller.api")
@Slf4j
public class ExceptionHandlerRestController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity do404(ResourceNotFoundException ex){
        log.debug("handle 404");
        return new MyCustomResponse(HttpStatus.NOT_FOUND, ex.getMessage())
                .addData("localizedMessage", ex.getLocalizedMessage())
                .getPage();
    }

}//end class
