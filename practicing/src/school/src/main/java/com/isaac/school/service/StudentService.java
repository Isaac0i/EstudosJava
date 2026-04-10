package com.isaac.school.service;

import com.isaac.school.model.Grade;
import com.isaac.school.model.Student;
import com.isaac.school.repository.GradeRepository;
import com.isaac.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public Student addGrade(Long studentId, Double valorNota) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));

        Grade novaNota = new Grade();
        novaNota.setGrade(valorNota);
        novaNota.setStudent(student);

        gradeRepository.save(novaNota);

        student.getGrades().add(novaNota);

        double media = calculateAverage(student);
        student.setAverageGrade(media);
        student.setStats(media >= 6 ? "Aprovado" : "Reprovado");

        return studentRepository.save(student);
    }

    private double calculateAverage(Student student) {
        if (student.getGrades().isEmpty()) return 0.0;
        
        return student.getGrades().stream()
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0.0);
    }
}
