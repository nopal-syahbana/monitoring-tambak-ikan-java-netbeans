/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author it2-PC
 */
public class PengeluaranEntity {
          public int id;
      public int idTambak;
      public int idUser;
      public int idKaryawan;
      public BigDecimal biayaPanen;
      public BigDecimal biayaLain;
      public BigDecimal biayaIkan;
      public BigDecimal totalPengeluaran;
      public String namaTambak;
      public String namaUser;
      public String ket;
      public Timestamp createdAt;
      public Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTambak() {
        return idTambak;
    }

    public void setIdTambak(int idTambak) {
        this.idTambak = idTambak;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public BigDecimal getBiayaPanen() {
        return biayaPanen;
    }

    public void setBiayaPanen(BigDecimal biayaPanen) {
        this.biayaPanen = biayaPanen;
    }

    public BigDecimal getBiayaLain() {
        return biayaLain;
    }

    public void setBiayaLain(BigDecimal biayaLain) {
        this.biayaLain = biayaLain;
    }

    public BigDecimal getBiayaIkan() {
        return biayaIkan;
    }

    public void setBiayaIkan(BigDecimal biayaIkan) {
        this.biayaIkan = biayaIkan;
    }

    public BigDecimal getTotalPengeluaran() {
        return totalPengeluaran;
    }

    public void setTotalPengeluaran(BigDecimal totalPengeluaran) {
        this.totalPengeluaran = totalPengeluaran;
    }

    public String getNamaTambak() {
        return namaTambak;
    }

    public void setNamaTambak(String namaTambak) {
        this.namaTambak = namaTambak;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
      
      

}
