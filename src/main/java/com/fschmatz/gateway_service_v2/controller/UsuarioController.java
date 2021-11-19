package com.fschmatz.gateway_service_v2.controller;



import com.fschmatz.gateway_service_v2.entity.Usuario;
import com.fschmatz.gateway_service_v2.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Transactional
//@RequestMapping("/loginservice")
public class UsuarioController {

    UsuarioRepository repository;

    /*//LOGIN
    @GetMapping("/login")
    public String login() {
        return "login";
    }*/

    //PAGINA PRINCIPAL
    @GetMapping("/login")
    public String homePage() {
        return "login";
    }


    //http://localhost:9093/login/1/2             !!! tem 2 "eu" não usar
    //checar usuario e retornar true or false
    @RequestMapping ("/{login}/{senha}")
    public Boolean login(@PathVariable("login") String login, @PathVariable("senha") String senha, Model model){

        Optional<Usuario> existingUsuarioLogin = repository.findByLogin(login);
        if(existingUsuarioLogin.get().getSenha().equals(senha)){
            System.out.println("ok");
            return true;
        }
        System.out.println("nope");
        return false;

        /* if (existingUsuarioLogin.get().getSenha().isEmpty()) {
            return "OK achou";
        }

        return "redirect:https://g1.globo.com/";*/

        /*System.out.println("NOME --> "+existingUsuarioLogin.get().getNome());
        System.out.println("LOGIN --> "+existingUsuarioLogin.get().getLogin());
        System.out.println("SENHA --> "+existingUsuarioLogin.get().getSenha());*/
    }

    @RequestMapping ("/oi")
    public String oi(){
        return "oi";
    }


}