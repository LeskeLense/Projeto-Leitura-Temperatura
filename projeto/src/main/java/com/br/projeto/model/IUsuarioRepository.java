package com.br.projeto.model;

import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	Usuario findByEmail(String email);
}
