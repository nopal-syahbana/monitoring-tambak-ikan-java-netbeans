/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import static controller.LahanController.lahanImplement;
import static controller.LahanController.lahanTableModel;
import entity.LahanEntity;
import implement.LahanImplement;
import table.LahanTableModel;
import GUIview.TambakView;
import GUIview.LahanCariView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public class LahanCariController {
    
    private static String className = "LahanCariController";
         public static LahanTableModel lahanTableModel = new LahanTableModel();
         public static LahanImplement lahanImplement = new LahanImplement();
         
     public void setTableModel(LahanCariView lahanCariView) {
        try {
            lahanCariView.tableCari.setModel(lahanTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanCariView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }
   public void loadData(LahanCariView lahanCariView) {
        try {
            List<LahanEntity> list = lahanImplement.getListData();
            lahanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanCariView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }
     
    public void searchData(LahanCariView lahanCariView) {
        try {
            String searchParameter = LahanCariView.textCari.getText();

            List<LahanEntity> list = lahanImplement.getListDataByParameter(searchParameter);
            lahanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanCariView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }
     
      public void refresh(LahanCariView lahanCariView) {
        try {
            LahanCariView.textCari.setText("");
            LahanCariView.textCari.requestFocus();

            loadData(lahanCariView);
        } catch (Exception error) {
            System.err.println("Terjadi kesalahan pada class " + className + "methode refresh \n Detail :" + error);
            JOptionPane.showMessageDialog(lahanCariView, "Terjadi kesalahan pada class" + className + ", methode refresh");

        }
    }

    public void tableCariAction(final LahanCariView lahanCariView) {
        LahanCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = LahanCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    LahanEntity lahanEntity = lahanTableModel.get(row);

                    TambakView.textIdLahan.setText(Integer.toString(lahanEntity.getId()));
                    TambakView.textLokasi.setText(lahanEntity.getLokasi());

                    lahanCariView.dispose();
                }
            }
        });
    }
}
