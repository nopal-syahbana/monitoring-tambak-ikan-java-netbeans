/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.PengeluaranEntity;
import setting.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author it2-PC
 */
public class PengeluaranImplement {
    
    private String className = "PengeluaranImplement";

    public List<PengeluaranEntity> getListData() {
        List<PengeluaranEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT pengeluaran.*, tambak.nama FROM pengeluaran JOIN tambak ON pengeluaran.tambak_id = tambak.id "
                    + "ORDER BY pengeluaran.id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                PengeluaranEntity pengeluaranEntity = new PengeluaranEntity();

                pengeluaranEntity.setId(resultSet.getInt("pengeluaran.id"));
                pengeluaranEntity.setIdTambak(resultSet.getInt("pengeluaran.tambak_id"));
                pengeluaranEntity.setNamaTambak(resultSet.getString("tambak.nama"));
                pengeluaranEntity.setBiayaIkan(resultSet.getBigDecimal("pengeluaran.biaya_ikan"));
                pengeluaranEntity.setBiayaPanen(resultSet.getBigDecimal("pengeluaran.biaya_panen"));
                pengeluaranEntity.setBiayaLain(resultSet.getBigDecimal("pengeluaran.biaya_lain"));
                pengeluaranEntity.setTotalPengeluaran(resultSet.getBigDecimal("pengeluaran.total_pengeluaran"));
                pengeluaranEntity.setKet(resultSet.getString("pengeluaran.ket"));
                pengeluaranEntity.setCreatedAt(resultSet.getTimestamp("pengeluaran.created_at"));
                pengeluaranEntity.setUpdatedAt(resultSet.getTimestamp("pengeluaran.updated_at"));

                list.add(pengeluaranEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }

    public List<PengeluaranEntity> getListDataByParameter(String searchParameter) {
        List<PengeluaranEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT pengeluaran.*, tambak.nama FROM pengeluaran JOIN tambak ON pengeluaran.tambak_id = tambak.id "
                    + "WHERE tambak.nama LIKE '%" + searchParameter + "%' ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                PengeluaranEntity pengeluaranEntity = new PengeluaranEntity();

                pengeluaranEntity.setId(resultSet.getInt("pengeluaran.id"));
                pengeluaranEntity.setIdTambak(resultSet.getInt("pengeluaran.tambak_id"));
                pengeluaranEntity.setNamaTambak(resultSet.getString("tambak.nama"));
                pengeluaranEntity.setBiayaIkan(resultSet.getBigDecimal("pengeluaran.biaya_ikan"));
                pengeluaranEntity.setBiayaPanen(resultSet.getBigDecimal("pengeluaran.biaya_panen"));
                pengeluaranEntity.setBiayaLain(resultSet.getBigDecimal("pengeluaran.biaya_lain"));
                pengeluaranEntity.setTotalPengeluaran(resultSet.getBigDecimal("pengeluaran.total_pengeluaran"));
                pengeluaranEntity.setKet(resultSet.getString("pengeluaran.ket"));
                pengeluaranEntity.setCreatedAt(resultSet.getTimestamp("pengeluaran.created_at"));
                pengeluaranEntity.setUpdatedAt(resultSet.getTimestamp("pengeluaran.updated_at"));

                list.add(pengeluaranEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }

    public String insertData(PengeluaranEntity pengeluaranEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO pengeluaran VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, pengeluaranEntity.getId());
            preparedStatement.setInt(2, pengeluaranEntity.getIdTambak());
            preparedStatement.setBigDecimal(3, pengeluaranEntity.getBiayaIkan());
            preparedStatement.setBigDecimal(4, pengeluaranEntity.getBiayaPanen());
            preparedStatement.setBigDecimal(5, pengeluaranEntity.getBiayaLain());
            preparedStatement.setBigDecimal(6, pengeluaranEntity.getTotalPengeluaran());
            preparedStatement.setString(7, pengeluaranEntity.getKet());
            preparedStatement.setTimestamp(8, pengeluaranEntity.getCreatedAt());
            preparedStatement.setTimestamp(9, pengeluaranEntity.getUpdatedAt());
            
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

    public String updateData(PengeluaranEntity pengeluaranEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE pengeluaran SET tambak_id = ?, biaya_tanaman = ? "
                    + ", biaya_panen = ?, biaya_lain = ?, total_pengeluaran = ?,ket = ?, updated_at = ? WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, pengeluaranEntity.getIdTambak());
            preparedStatement.setBigDecimal(2, pengeluaranEntity.getBiayaIkan());
            preparedStatement.setBigDecimal(3, pengeluaranEntity.getBiayaPanen());
            preparedStatement.setBigDecimal(4, pengeluaranEntity.getBiayaLain());
            preparedStatement.setBigDecimal(5, pengeluaranEntity.getTotalPengeluaran());
            preparedStatement.setString(6, pengeluaranEntity.getKet());
            preparedStatement.setTimestamp(7, pengeluaranEntity.getUpdatedAt());
            preparedStatement.setInt(8, pengeluaranEntity.getId());
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
            String sqlDelete = "DELETE FROM pengeluaran WHERE id = ?";

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
