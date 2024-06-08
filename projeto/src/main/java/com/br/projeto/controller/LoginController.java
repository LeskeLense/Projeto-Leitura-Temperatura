package com.br.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.projeto.model.IUsuarioRepository;
import com.br.projeto.model.Usuario;

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

		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("Usuario") Usuario usuario, Model model) {

		String email = usuario.getEmail();
		String senha = usuario.getSenha();

		usuario = usuarioRepository.findByEmail(email);

		if (usuario != null && usuario.getSenha().equals(senha)) {
			return "redirect:/temperatura";
		} else {
			model.addAttribute("error", "Email ou senha Incorretos");
			return "login";
		}

	}
}
