package com.br.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.projeto.model.Sensor;

public interface ISensorRepository extends CrudRepository<Sensor, Integer>{
    
        Sensor findByNome(String nome);
}
