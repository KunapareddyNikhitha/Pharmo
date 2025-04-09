package com.example.demo.Repository;

import com.example.demo.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    boolean existsByName(String name);
}

