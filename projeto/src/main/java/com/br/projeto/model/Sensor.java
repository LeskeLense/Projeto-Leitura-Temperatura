package com.br.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome",length = 100, nullable = true)
	private String nome;

    @Column(name = "latitude",length = 255, nullable = true)
	private String latitude;
	
	@Column(name = "longitude",length = 255, nullable = true)
	private String longitude;
	
}
