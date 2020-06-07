package com.example.demo.Controllers;

import com.example.exparcialg4.entity.Usuarios;
import com.example.exparcialg4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SendMailController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/enviarMail")
    public String enviarCorreo(@RequestParam("correo") String correoDestino){

        Optional<Usuarios> optional = usuarioRepository.findByEmail(correoDestino);


        if (optional.isPresent()) {
            model.addAttribute("employee", optional.get());
            model.addAttribute("listaJefes", getListaJefes());
            return "employee/editFrm";
        } else {
            return "redirect:/employee";
        }



    }

}
