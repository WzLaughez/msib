package com.msib.msib.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class proyek {
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nama_proyek;

    @Column
    private String client;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column
    private LocalDate tgl_mulai;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column
    private LocalDate tgl_selesai;

    @Column
    private String pimpinan_proyek;

    @Column
    private String keterangan;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @ManyToMany
    @JoinTable(
        name = "proyek_lokasi",
        joinColumns = @JoinColumn(name = "proyek_id"),
        inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<lokasi> lokasi = new HashSet<>();
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama_proyek() {
        return nama_proyek;
    }
    public void setNama_proyek(String nama_proyek) {
        this.nama_proyek = nama_proyek;
    }

    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getTgl_mulai() {
        return tgl_mulai;
    }
    public void setTgl_mulai(LocalDate tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public LocalDate getTgl_selesai() {
        return tgl_selesai;
    }
    public void setTgl_selesai(LocalDate tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getPimpinan_proyek() {
        return pimpinan_proyek;
    }
    public void setPimpinan_proyek(String pimpinan_proyek) {
        this.pimpinan_proyek = pimpinan_proyek;
    }

    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Set<lokasi> getLokasi() {
        return lokasi;
    }
    public void setLokasi(Set<lokasi> lokasi) {
        this.lokasi = lokasi;
    }
}
