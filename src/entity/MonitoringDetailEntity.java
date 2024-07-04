/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class MonitoringDetailEntity {
    private int id;
    private String progress_tambak;
    private String nama;
    private int tambakid;
    private Date tglUpdate;
    private String ket;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getTambakId() {
        return tambakid;
    }
    
    public void setTambakId(int tambakId) {
        this.tambakid = tambakId;
    }
    
    public String getProgressTambak() {
        return progress_tambak;
    }
    
    public void setProgressTambak(String progress_tambak) {
        this.progress_tambak = progress_tambak;
    }
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
  
    public String getKet() {
        return ket;
    }
    
    public void setKet(String ket) {
        this.ket = ket;
    }
    
    public Date getTglUpdate() {
        return tglUpdate;
    }
    
    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }
    
}
