package com.example.library.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "livros")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private double price;

    public Livro() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}
}
