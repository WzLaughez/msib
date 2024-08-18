package com.msib.msib.controller.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProyekRequestDto {
    
    private String nama_proyek;
    private String client;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate tgl_mulai;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate tgl_selesai;
    
    private String pimpinan_proyek;
    private String keterangan;
    private List<Integer> lokasi_id; // List of Lokasi IDs

    // Getters and Setters

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

    public void setLokasi_id(List<Integer> lokasi_id) {
        this.lokasi_id = lokasi_id;
    }
    public List<Integer> getLokasi_id() {
        return lokasi_id;
    }
}
