package com.example.demo.controller;

import com.example.demo.Entity.Medicine;
import com.example.demo.Service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")

public class Endpoints {

    private final MedicineService medicineService;

    public Endpoints(MedicineService service){
        this.medicineService = service;
    }
    @GetMapping
    public List<Medicine> getAll() {
        return medicineService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Medicine product) {
        if(medicineService.existsByName(product.getName())){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Medicine already Exists");
        }
        Medicine saved = medicineService.saveProduct(product);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        medicineService.deleteProduct(id);
    }
}
