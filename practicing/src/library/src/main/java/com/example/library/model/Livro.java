package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull; // <- O import correto é este!
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "livros")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O títuulo não pode estar em branco")
    private String titulo;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private double price;

    public Livro() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}
}
