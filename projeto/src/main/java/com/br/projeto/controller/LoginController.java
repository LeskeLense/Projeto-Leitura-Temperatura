package com.br.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.projeto.model.Usuario;
import com.br.projeto.repository.IUsuarioRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final IUsuarioRepository usuarioRepository;

    public LoginController(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginForm", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") Usuario loginForm, Model model, HttpSession session) {

        String email = loginForm.getEmail();
        String senha = loginForm.getSenha();

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            session.setAttribute("loggedUser", usuario);
            return "redirect:/temperatura"; 
        } else {
            model.addAttribute("error", "Email ou senha incorretos");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; 
    }
}
