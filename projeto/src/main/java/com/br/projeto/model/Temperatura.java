package com.br.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "temperatura")
public class Temperatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temperatura")
    private Integer id;

    @Column(name = "id_cliente")
    private Integer id_cliente;

    @Column(name = "graus", length = 100, nullable = true)
    private Double graus;

    @Column(name = "data_hora", nullable = true)
    private String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Double getGraus() {
        return graus;
    }

    public void setGraus(Double graus) {
        this.graus = graus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
