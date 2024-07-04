/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package table;

import entity.TambakEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class MonitoringTableModel extends AbstractTableModel {

    private List<TambakEntity> list = new ArrayList<>();

    public void insert(TambakEntity tambakEntity) {
        list.add(tambakEntity);
        fireTableDataChanged();
    }

    public void update(int row, TambakEntity tambakEntity) {
        list.set(row, tambakEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public TambakEntity get(int row) {
        return list.get(row);
    }

    public void setList(List<TambakEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        String jenkel ="Laki-Laki";
//        if(list.get(rowIndex).getJenkel().equals("p")) {
//            jenkel="Perempuan";
//        }
//        
//        String status_aktif;
//        if(list.get(rowIndex).getStatusAktif() == "0") {
//            status_aktif="Sudah Berhenti";
//        } else {
//            status_aktif = "Masih Aktif";
//        }
        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getLokasi();
            case 3:
                return list.get(rowIndex).getTotalbibit();
            case 4:
                return list.get(rowIndex).getTglSebar();
            case 5:
                return list.get(rowIndex).getTglPerkiraanPanen();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Tambak";
            case 2:
                return "Lokasi";
            case 3:
                return "Total Bibit";
            case 4:
                return "Tgl Sebar";
            case 5:
                return "Tgl Perkiraan Panen";
            default:
                return null;
        }
    }

}