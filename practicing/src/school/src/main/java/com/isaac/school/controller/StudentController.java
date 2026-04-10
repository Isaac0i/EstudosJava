package com.isaac.school.controller;

import com.isaac.school.dto.StudentRequest;
import com.isaac.school.model.Student;
import com.isaac.school.repository.StudentRepository;
import com.isaac.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @PostMapping("/cad")
    public ResponseEntity<Student> cadastrar(@RequestBody @Valid StudentRequest dto) {
        // Convertendo DTO para Entidade
        Student student = new Student();
        student.setName(dto.name());
        student.setRegistration(dto.registration());

        // Os campos stats e averageGrade começarão como null/0.0 no banco,
        // o que é o correto, já que ele ainda não tem notas.

        Student salvo = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> atualizar(@PathVariable Long id, @RequestBody @Valid StudentRequest dto) {
        return studentRepository.findById(id)
                .map(estudanteExistente -> {
                    // Atualiza apenas os campos permitidos vindos do DTO
                    estudanteExistente.setName(dto.name());
                    estudanteExistente.setRegistration(dto.registration());

                    return ResponseEntity.ok(studentRepository.save(estudanteExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/grades")
    public Student addNota(@PathVariable Long id, @RequestBody Double valorNota){
        return service.addGrade(id, valorNota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(!studentRepository.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
