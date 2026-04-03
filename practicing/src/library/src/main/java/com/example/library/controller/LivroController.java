package com.example.library.controller;

import com.example.library.model.Livro;
import com.example.library.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<Livro> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody Livro livro){
        Livro livroSalvo = repository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livroNovo) {
        return repository.findById(id)
            .map(livroExistente ->{
                livroExistente.setTitulo(livroNovo.getTitulo());
                livroExistente.setPrice(livroNovo.getPrice());

                Livro livroAtualizado = repository.save(livroExistente);
                return ResponseEntity.ok(livroAtualizado);
            })
                .orElse(ResponseEntity.notFound().build());
    }
}
