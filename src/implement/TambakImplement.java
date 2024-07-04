/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implement;

import entity.TambakEntity;
import setting.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class TambakImplement {
      
    private String className = "TambakImplement";

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
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }

    public String insertData(TambakEntity tambakEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO tambak VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, tambakEntity.getId());
            preparedStatement.setString(2, tambakEntity.getNama());
            preparedStatement.setInt(3, tambakEntity.getLahanId());
            preparedStatement.setString(4, tambakEntity.getVarietas());
            preparedStatement.setInt(5, tambakEntity.getTotalbibit());
            preparedStatement.setDate(6, tambakEntity.getTglSebar());
            preparedStatement.setDate(7, tambakEntity.getTglPerkiraanPanen());
            
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

    public String updateData(TambakEntity tambakEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE tambak SET nama = ?, lahan_id = ?,varietas = ?,total_bibit = ?,tgl_sebar = ?,tgl_perkiraan_panen = ? WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, tambakEntity.getNama());
            preparedStatement.setInt(2, tambakEntity.getLahanId());
            preparedStatement.setString(3, tambakEntity.getVarietas());
            preparedStatement.setInt(4, tambakEntity.getTotalbibit());
            preparedStatement.setDate(5, tambakEntity.getTglSebar());
            preparedStatement.setDate(6, tambakEntity.getTglPerkiraanPanen());
            preparedStatement.setInt(7, tambakEntity.getId());
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data berhasil diubah";
            } else {
                message = "Data gagal diubah";
            }
            preparedStatement.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function updateGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function updateGudang");
        }
        return message;
    }

    public String deleteData(int id) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM tambak WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data berhasil dihapus";
            } else {
                message = "Data gagal dihapus";
            }
            preparedStatement.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function deleteGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function deleteGudang");
        }
        return message;
    }
}