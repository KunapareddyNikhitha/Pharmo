package com.example.demo.Service;

import com.example.demo.Entity.Medicine;
import com.example.demo.Repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepository medicienRepo;

    public MedicineService(MedicineRepository productRepo) {
        this.medicienRepo = productRepo;
    }

    public List<Medicine> getAllProducts() {
        return medicienRepo.findAll();
    }

    public Medicine saveProduct(Medicine product) {
        return medicienRepo.save(product);
    }

    public void deleteProduct(Long id) {
        medicienRepo.deleteById(id);
    }

    public boolean existsByName(String name) {
        return medicienRepo.existsByName(name);
    }
}
