package com.isaac.school.repository;

import com.isaac.school.model.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GradeRepository extends JpaRepository<Grade, Long> {
}
