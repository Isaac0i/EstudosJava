package com.isaacinacio.parkinglot.repository;

import com.isaacinacio.parkinglot.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, Long> {
}
