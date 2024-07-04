/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implement;

import entity.TambakEntity;
import entity.MonitoringDetailEntity;
import setting.Koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class MonitoringImplement {
     private String className = "BelanjaImplement";
    
     public List<TambakEntity> getListData() {
        List<TambakEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT tambak.*, lahan.lokasi FROM tambak JOIN lahan ON tambak.lahan_id = lahan.id ORDER BY tambak.id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                TambakEntity tambakEntity = new TambakEntity();

                tambakEntity.setId(resultSet.getInt("tambak.id"));
                tambakEntity.setNama(resultSet.getString("tambak.nama"));
                tambakEntity.setLahanId(resultSet.getInt("tambak.lahan_id"));
                tambakEntity.setTglSebar(resultSet.getDate("tambak.tgl_sebar"));
                tambakEntity.setTglPerkiraanPanen(resultSet.getDate("tambak.tgl_perkiraan_panen"));
                tambakEntity.setVarietas(resultSet.getString("tambak.varietas"));
                tambakEntity.setTotalbibit(resultSet.getInt("tambak.total_bibit"));
                tambakEntity.setLokasi(resultSet.getString("lahan.lokasi"));

                list.add(tambakEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }
    
   public List<TambakEntity> getListDataByParameter(String searchParameter) {
        List<TambakEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT tambak.*, lahan.lokasi FROM tambak JOIN lahan ON tambak.lahan_id = lahan.id "
                    + "WHERE tambak.nama LIKE '%" + searchParameter + "%' OR lahan.lokasi LIKE '%" + searchParameter + "%' ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                TambakEntity tambakEntity = new TambakEntity();

                tambakEntity.setId(resultSet.getInt("tambak.id"));
                tambakEntity.setNama(resultSet.getString("tambak.nama"));
                tambakEntity.setLahanId(resultSet.getInt("tambak.lahan_id"));
                tambakEntity.setTglSebar(resultSet.getDate("tambak.tgl_tanam"));
                tambakEntity.setTglPerkiraanPanen(resultSet.getDate("tambak.tgl_perkiraan_panen"));
                tambakEntity.setVarietas(resultSet.getString("tambak.varietas"));
                tambakEntity.setTotalbibit(resultSet.getInt("tambak.total_bibit"));
                tambakEntity.setLokasi(resultSet.getString("lahan.lokasi"));

                list.add(tambakEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }
    
public String insertData(MonitoringDetailEntity monitoringDetailEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO tambak_detail VALUES (?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, monitoringDetailEntity.getId());
            preparedStatement.setInt(2, monitoringDetailEntity.getTambakId());
            preparedStatement.setString(3, monitoringDetailEntity.getProgressTambak());
            preparedStatement.setDate(4, monitoringDetailEntity.getTglUpdate());
            preparedStatement.setString(5, monitoringDetailEntity.getKet());
            
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data Berhasil ditambah";
            } else {
                message = "Data gagal ditambah";
            }
            preparedStatement.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function insertGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function insertGudang");
        }
        return message;
    }
    
    public List<MonitoringDetailEntity> getListMonitoringDetail(int idTambak) {
        List<MonitoringDetailEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT tambak_detail.*, tambak.nama "
                    + "FROM tambak_detail JOIN tambak ON tambak_detail.tambak_id =  tambak.id "
                    + "WHERE tambak_detail.tambak_id = '"+idTambak+"' "
                    + "ORDER BY tambak_detail.id";
            
            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while(resultSet.next()) {
                MonitoringDetailEntity monitoringDetailEntity = new MonitoringDetailEntity();
                
                monitoringDetailEntity.setId(resultSet.getInt("tambak_detail.id"));
                monitoringDetailEntity.setTambakId(resultSet.getInt("tambak_detail.tambak_id"));
                monitoringDetailEntity.setNama(resultSet.getString("tambak.nama"));
                monitoringDetailEntity.setProgressTambak(resultSet.getString("tambak_detail.progress_tambak"));
                monitoringDetailEntity.setTglUpdate(resultSet.getDate("tambak_detail.tgl_update"));
                monitoringDetailEntity.setKet(resultSet.getString("tambak_detail.ket"));

                list.add(monitoringDetailEntity);
            }
            
            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", function getListTransaksiDetail \n Detail : "+error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class "+className+", function getListTransaksiDetail");
        } return list;
    }
    
    
    public String deleteData(int tambakid) {
        String message = "";
        PreparedStatement preparedStatementTransaksi = null;
        PreparedStatement preparedStatementTransaksiDetail  = null;
        try {
            String sqlDeletetambak = "DELETE FROM tambak WHERE id = ?";
            String sqlDeleteTambakDetail = "DELETE FROM tambak_detail WHERE tambak_id = ?";
            
            preparedStatementTransaksiDetail = Koneksi.getConnection().prepareStatement(sqlDeleteTambakDetail);
            preparedStatementTransaksiDetail.setInt(1, tambakid);
            preparedStatementTransaksiDetail.executeUpdate();
            
            preparedStatementTransaksi = Koneksi.getConnection().prepareStatement(sqlDeletetambak);
            preparedStatementTransaksi.setInt(1, tambakid);
            int isSuccess1 = preparedStatementTransaksi.executeUpdate();
            
            if(isSuccess1 ==1) {
                message = "Data berhasil dihapus";
            } else {
                message = "Data gagal dihapus";
            } preparedStatementTransaksi.close();
        }  catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", function deleteKasir \n Detail : "+error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class "+className+", function deleteKasir");
        } return message;
    }
}