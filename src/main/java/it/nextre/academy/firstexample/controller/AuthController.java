package it.nextre.academy.firstexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AuthController {
    @PostMapping("/autentica")
    public String autentica(
            @RequestParam("user") String username,
            @RequestParam("pwd") String password,
            Model m
    ){
        log.debug("POST /autentica");
        // !!! mai loggare dati sensibili !!! !!! !!!
        //log.debug("POST user "+username);
        //log.debug("POST pwd  "+password);

        if (username != null &&
            username.equals("valix85@gmail.com") &&
            password != null && password.equals("12345")
        ){
            // dati corretti
            m.addAttribute("PIN","7894561230");
        }else{
            return "redirect:index?err=1";
        }

        return "hello.html";
    }
}//end class
