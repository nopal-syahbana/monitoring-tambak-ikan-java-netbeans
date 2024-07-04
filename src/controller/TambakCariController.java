/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.TambakEntity;
import implement.TambakImplement;
import table.TambakTableModel;
import GUIview.TambakCariView;
import GUIview.TambakView;
import GUIview.MonitoringView;
import GUIview.PendapatanView;
import GUIview.PengeluaranView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public class TambakCariController {
      
    private static String className = "TambakCariController";
         public static TambakTableModel tambakTableModel = new TambakTableModel();
         public static TambakImplement tambakImplement = new TambakImplement();
         
     public void setTableModel(TambakCariView tambakCariView) {
        try {
            tambakCariView.tableCari.setModel(tambakTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesakebun pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakCariView, "Terjadi kesa tambak pada class " + className + ", methode setTableModel");
        }
    }
   public void loadData(TambakCariView tambakCariView) {
        try {
            List<TambakEntity> list = tambakImplement.getListData();
            tambakTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakCariView, "Terjadi kesa kebun pada class " + className + ", methode loadData");
        }
    }
     
    public void searchData(TambakCariView tambakCariView) {
        try {
            String searchParameter = TambakCariView.textCari.getText();

            List<TambakEntity> list = tambakImplement.getListDataByParameter(searchParameter);
            tambakTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakCariView, "Terjadi kesakebun pada class " + className + ", methode searchData");
        }
    }
     
      public void refresh(TambakCariView tambakCariView) {
        try {
            TambakCariView.textCari.setText("");
            TambakCariView.textCari.requestFocus();

            loadData(tambakCariView);
        } catch (Exception error) {
            System.err.println("Terjadi kesalahan pada class " + className + "methode refresh \n Detail :" + error);
            JOptionPane.showMessageDialog(tambakCariView, "Terjadi kesalahan pada class" + className + ", methode refresh");

        }
    }

    public void tableCariAction(final TambakCariView tambakCariView) {
        TambakCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TambakCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    TambakEntity tambakEntity = tambakTableModel.get(row);

                    MonitoringView.textIdKebun.setText(Integer.toString(tambakEntity.getId()));
                    MonitoringView.textNamaKebun.setText(tambakEntity.getNama());
                    
                    tambakCariView.dispose();
                }
            }
        });
    }

    public void tableCariAction1(final TambakCariView kebunCariView) {
        TambakCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TambakCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    TambakEntity kebunEntity = tambakTableModel.get(row);

                   
                    PendapatanView.textIdTambak.setText(Integer.toString(kebunEntity.getId()));
                    PendapatanView.textNamaTambak.setText(kebunEntity.getNama());

                    
                    kebunCariView.dispose();
                }
            }
        });
    }
    
    public void tableCariAction2(final TambakCariView kebunCariView) {
        TambakCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TambakCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    TambakEntity kebunEntity = tambakTableModel.get(row);

                   
                    PengeluaranView.textIdKebun.setText(Integer.toString(kebunEntity.getId()));
                    PengeluaranView.textNama.setText(kebunEntity.getNama());

                    
                    kebunCariView.dispose();
                }
            }
        });
    }
}
