package com.example.library.controller;

import com.example.library.model.Autor;
import com.example.library.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        Autor autorSalvo = autorRepository.save(autor);
        return ResponseEntity.ok().body(autorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id) {
        return autorRepository.findById(id)
                .map(autor -> ResponseEntity.ok(autor))
                .orElse(ResponseEntity.notFound().build());
    }
}
