package com.msib.msib.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.msib.msib.models.lokasi;
import com.msib.msib.repo.lokasiRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class lokasiController {
    
    @Autowired
    private lokasiRepo lokasiRepo;
    
    
    @GetMapping(value = "Lokasi")
    public List<lokasi> getAllLokasi() {
        return lokasiRepo.findAll();
    }

    @PostMapping(value = "Lokasi")
    public lokasi CreateLokasi(@RequestBody lokasi lokasi) {
        //TODO: process POST request
        lokasiRepo.save(lokasi);
        return lokasi;
    }
    
    @PutMapping("Lokasi/{id}")
    public ResponseEntity<lokasi> updateLokasi(@PathVariable Integer id, @RequestBody lokasi lokasi) {
        //TODO: process PUT request
        Optional<lokasi> existingLokasiOptional = lokasiRepo.findById(id);

        if(!existingLokasiOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }

        lokasi updateLokasi = existingLokasiOptional.get();
        updateLokasi.setKota(lokasi.getKota());
        updateLokasi.setNama_lokasi(lokasi.getNama_lokasi());
        updateLokasi.setNegara(lokasi.getNegara());
        updateLokasi.setProvinsi(lokasi.getProvinsi());
        lokasiRepo.save(updateLokasi);
        return ResponseEntity.ok(updateLokasi);
    }

    @DeleteMapping("Lokasi/{id}")
    public ResponseEntity<lokasi> deleteLokasi(@PathVariable Integer id){
        Optional<lokasi> existingLokasiOptional = lokasiRepo.findById(id);

        
        if(!existingLokasiOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        lokasi deleteLokasi = existingLokasiOptional.get();
        lokasiRepo.delete(deleteLokasi);

        return ResponseEntity.noContent().build();
    }
}
