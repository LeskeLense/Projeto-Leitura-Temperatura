package com.br.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.projeto.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	Usuario findByEmail(String email);
}
