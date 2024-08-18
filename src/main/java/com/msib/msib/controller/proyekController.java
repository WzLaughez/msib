package com.msib.msib.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msib.msib.controller.dto.ProyekRequestDto;
import com.msib.msib.models.lokasi;
import com.msib.msib.models.proyek;
import com.msib.msib.repo.lokasiRepo;
import com.msib.msib.repo.proyekRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class proyekController {
    
    @Autowired
    private proyekRepo proyekRepo;

    @Autowired
    private lokasiRepo lokasiRepo;

    @GetMapping("proyek")
    public List<proyek> getProyeks() {
        return proyekRepo.findAll();
    }
    @GetMapping("proyek/{id}")
    public proyek get1Proyek(@PathVariable Integer id) {
        proyek proyek = proyekRepo.findById(id).get();
        return proyek;
    }
    
    @PostMapping("proyek")
    public ResponseEntity<proyek> CreateProyek (@RequestBody ProyekRequestDto request) {
        //TODO: process POST request
        Set<lokasi> lokasiSet = new HashSet<>();
        for (Integer lokasi_id : request.getLokasi_id()) {
            lokasi lokasi = lokasiRepo.findById(lokasi_id).orElseThrow();
            lokasiSet.add(lokasi);
        }

        proyek proyek = new proyek();
        proyek.setNama_proyek(request.getNama_proyek());
        proyek.setClient(request.getClient());
        proyek.setTgl_mulai(request.getTgl_mulai());
        proyek.setTgl_selesai(request.getTgl_selesai());
        proyek.setPimpinan_proyek(request.getPimpinan_proyek());
        proyek.setKeterangan(request.getKeterangan());
        proyek.setLokasi(lokasiSet);

        proyek savedProyek = proyekRepo.save(proyek);
        return new ResponseEntity<>(savedProyek, HttpStatus.CREATED);
    }
    
    @PutMapping("proyek/{id}")
    public ResponseEntity<proyek> updateProyek(@PathVariable Integer id, @RequestBody proyek proyek) {
        //TODO: process PUT request
        Optional<proyek> existingProyekOptional = proyekRepo.findById(id);

        if(!existingProyekOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }

        proyek updateProyek = existingProyekOptional.get();
        updateProyek.setNama_proyek(proyek.getNama_proyek());
        updateProyek.setClient(proyek.getClient());
        updateProyek.setTgl_mulai(proyek.getTgl_mulai());
        updateProyek.setTgl_selesai(proyek.getTgl_selesai());
        updateProyek.setPimpinan_proyek(proyek.getPimpinan_proyek());
        updateProyek.setKeterangan(proyek.getKeterangan());
        proyekRepo.save(updateProyek);
        return ResponseEntity.ok(updateProyek);
    }

    @DeleteMapping("proyek/{id}")
    public ResponseEntity<proyek> deleteproyek(@PathVariable Integer id){
        Optional<proyek> existingProyekOptional = proyekRepo.findById(id);

        
        if(!existingProyekOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        proyek deleteproyek = existingProyekOptional.get();
        proyekRepo.delete(deleteproyek);

        return ResponseEntity.noContent().build();
    }
}
