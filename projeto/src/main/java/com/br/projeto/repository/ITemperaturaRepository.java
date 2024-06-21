package com.br.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.projeto.model.Temperatura;
import java.util.Optional;


public interface ITemperaturaRepository extends CrudRepository<Temperatura, Integer> {
    
    Optional<Temperatura> findById(Integer id);
}
