package com.example.exparcialg4.service;

import com.example.exparcialg4.entity.Usuarios;
import com.example.exparcialg4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SendMailService;

import java.util.Random;

@Controller
public class SendMailController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SendMailService sendMailService;

    @PostMapping("/enviarMail")
    public String enviarCorreo(@RequestParam("correo") String correoDestino) {

        Usuarios optional = usuarioRepository.findByEmail(correoDestino);

        String subject;
        String mensaje;
        if (optional.getEmail() != "") {
            String caracteres1 = "abcdefghijklmnopqrtsuvwxyz1234567890";
            String caracteres2 = "1234567890";
            Random random = new Random();
            StringBuilder aux = new StringBuilder();
            StringBuilder aux2 = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                aux.append(caracteres1.charAt(random.nextInt(caracteres1.length())));
            }
            for (int i = 0; i < 2; i++) {
                aux2.append(caracteres2.charAt(random.nextInt(caracteres2.length())));
            }
            String contraGenerada = aux.toString() + aux2.toString();
            subject = "Recuperacion de contraseña";
            mensaje = "Está intentando recuperar su contraseña, se le generó la contraseña" + contraGenerada;
        } else {
            subject = "Invitacion de registro";
            mensaje = "No está registrado";
        }
        sendMailService.sendMail(correoDestino, "saritaatanacioarenas@gmail.com", subject, mensaje);
    }
}
