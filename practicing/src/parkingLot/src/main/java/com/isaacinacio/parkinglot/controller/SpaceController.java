package com.isaacinacio.parkinglot.controller;

import com.isaacinacio.parkinglot.model.Space;
import com.isaacinacio.parkinglot.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaces")
public class SpaceController {

    @Autowired
    private SpaceRepository repository;

    @GetMapping
    public List<Space> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Space> save(@RequestBody Space space) {
        Space savedSpace = repository.save(space);
        return ResponseEntity.ok(savedSpace);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Space> update(@PathVariable @RequestBody Space space) {
        Space updatedSpace = repository.save(space);
        return ResponseEntity.ok(updatedSpace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Space> delete(@PathVariable Long id) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
