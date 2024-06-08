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
public class CadastroController {

    private final IUsuarioRepository usuarioRepository;

	public CadastroController(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        
        Usuario existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if(existingUser != null){
            model.addAttribute("error", "Este email já está em uso.");
            System.out.println("Deu Errado");
            return "cadastro";
        }
        
        usuarioRepository.save(usuario);
        System.out.println("Cadastrado");
        return "redirect:/login";
    }
    
	@RequestMapping(path="/cadastro", method=RequestMethod.GET)
    public String index(Model model) {
		
        return "cadastro";
    }
}
