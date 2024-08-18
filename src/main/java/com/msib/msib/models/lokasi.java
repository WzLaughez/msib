package com.msib.msib.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class lokasi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nama_lokasi;

    @Column
    private String negara;

    @Column
    private String provinsi;

    @Column
    private String kota;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @ManyToMany(mappedBy = "lokasi")
    private Set<proyek> proyek;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }
    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getKota() {
        return kota;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNegara() {
        return negara;
    }
    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


}
