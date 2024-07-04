/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TambakEntity;
import implement.TambakImplement;
import table.TambakTableModel;
import GUIview.HomeView;
import GUIview.TambakView;
import GUIview.LahanCariView;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static controller.TambakController.tambakTableModel;
import static controller.TambakController.tambakImplement;

/**
 *
 * @author it2-PC
 */
public class TambakController {
     private static String className = "TambakController";
     public static TambakTableModel tambakTableModel = new TambakTableModel();
    public static TambakImplement tambakImplement = new TambakImplement();

    public void setMaximumFrame(TambakView tambakView) {
        try {
            tambakView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(tambakView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void setTableModel(TambakView tambakView) {
        try {
            TambakView.tableData.setModel(tambakTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(TambakView tambakView) {
        try {
            List<TambakEntity> list = tambakImplement.getListData();
            tambakTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }

    public void refresh(TambakView tambakView) {
        try {
            TambakView.labelStatus.setText("");
            TambakView.labelID.setText("0");
            TambakView.textNama.setText("");
            TambakView.textIdLahan.setText("");
            TambakView.textLokasi.setText("");
            TambakView.textVarietas.setText("");
            TambakView.textTotal.setText("");
            TambakView.tglSebar.setDate(null);
            TambakView.tglPerkiraanPanen.setDate(null);
            TambakView.textCari.setText("");
            TambakView.tableData.clearSelection();

            TambakView.textIdLahan.setEnabled(false);
            TambakView.textLokasi.setEnabled(false);
            TambakView.textNama.setEnabled(false);
            TambakView.textVarietas.setEnabled(false);
            TambakView.textTotal.setEnabled(false);
            TambakView.tglSebar.setEnabled(false);
            TambakView.tglPerkiraanPanen.setEnabled(false);
            TambakView.buttonCari.setEnabled(false);
            TambakView.buttonSimpan.setEnabled(false);
            TambakView.buttonBatal.setEnabled(false);
            TambakView.textCari.setEnabled(true);
            TambakView.tableData.setEnabled(true);
            TambakView.buttonBaru.setEnabled(true);
            TambakView.buttonUbah.setEnabled(true);
            TambakView.buttonHapus.setEnabled(true);
            TambakView.buttonMuatUlang.setEnabled(true);
            TambakView.buttonKeluar.setEnabled(true);

            loadData(tambakView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(TambakView tambakView) {
        try {
            String searchParameter = TambakView.textCari.getText();

            List<TambakEntity> list = tambakImplement.getListDataByParameter(searchParameter);
            tambakTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(TambakView tambakView) {
        try {

           TambakView.labelStatus.setText("INSERT");
            TambakView.labelID.setText("0");
            TambakView.textNama.setText("");
            TambakView.textIdLahan.setText("");
            TambakView.textLokasi.setText("");
            TambakView.textVarietas.setText("");
            TambakView.textTotal.setText("");
            TambakView.tglSebar.setDate(null);
            TambakView.tglPerkiraanPanen.setDate(null);
            TambakView.textCari.setText("");
            TambakView.tableData.clearSelection();
            
            TambakView.buttonCari.setEnabled(true);
            TambakView.textIdLahan.setEnabled(true);
            TambakView.textLokasi.setEnabled(true);
            TambakView.textNama.setEnabled(true);
            TambakView.textVarietas.setEnabled(true);
            TambakView.textTotal.setEnabled(true);
            TambakView.tglSebar.setEnabled(true);
            TambakView.tglPerkiraanPanen.setEnabled(true);
            TambakView.buttonSimpan.setEnabled(true);
            TambakView.buttonBatal.setEnabled(true);
            TambakView.textCari.setEnabled(false);
            TambakView.tableData.setEnabled(false);
            TambakView.buttonBaru.setEnabled(false);
            TambakView.buttonUbah.setEnabled(false);
            TambakView.buttonHapus.setEnabled(false);
            TambakView.buttonMuatUlang.setEnabled(false);
            TambakView.buttonKeluar.setEnabled(false);

            TambakView.textNama.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(TambakView tambakView) {
        try {
            int rowSelected = TambakView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(tambakView, "Silahkan seleksi data yang ingin diubah");
            } else {
                TambakView.labelStatus.setText("UPDATE");

               TambakView.textIdLahan.setEnabled(true);
            TambakView.textLokasi.setEnabled(true);
            TambakView.textNama.setEnabled(true);
            TambakView.textVarietas.setEnabled(true);
            TambakView.textTotal.setEnabled(true);
            TambakView.tglSebar.setEnabled(true);
            TambakView.tglPerkiraanPanen.setEnabled(true);
            TambakView.buttonCari.setEnabled(true);
                TambakView.buttonSimpan.setEnabled(true);
                TambakView.buttonBatal.setEnabled(true);
                TambakView.textCari.setEnabled(false);
                TambakView.tableData.setEnabled(false);
                TambakView.buttonBaru.setEnabled(false);
                TambakView.buttonUbah.setEnabled(false);
                TambakView.buttonHapus.setEnabled(false);
                TambakView.buttonMuatUlang.setEnabled(false);
                TambakView.buttonKeluar.setEnabled(false);
                TambakView.textNama.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(TambakView tambakView) {
        try {
            int rowSelected = TambakView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(tambakView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int id = tambakTableModel.get(rowSelected).getId();
                String nama = tambakTableModel.get(rowSelected).getNama();

                int confirm = JOptionPane.showConfirmDialog(tambakView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = tambakImplement.deleteData(id);
                    JOptionPane.showMessageDialog(tambakView, message);
                }
                refresh(tambakView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    
        public void buttonSimpanAction(TambakView tambakView) {
        try {
            if (TambakView.textNama.getText().equals("")) {
                JOptionPane.showMessageDialog(tambakView, "Lengkapi Nama Tambak");
                TambakView.textNama.requestFocus();
            } else if(TambakView.textIdLahan.getText().equals("")) {
                JOptionPane.showMessageDialog(tambakView, "Cari lahan dulu!");
                tambakView.buttonCari.doClick();
            } else if(TambakView.textVarietas.getText().equals("")) {
                JOptionPane.showMessageDialog(tambakView, "Lengkapi Varietas ");
                TambakView.textVarietas.requestFocus();
            } else if(TambakView.textTotal.getText().equals("")) {
                JOptionPane.showMessageDialog(tambakView, "Lengkapi Total Bibit");
                TambakView.textTotal.requestFocus();
            } else {
                 TambakEntity tambakEntity = new TambakEntity();

                if (TambakView.tglSebar.getDate() == null) {
                    tambakEntity.setTglSebar(null);
                } else {
                    Date d = TambakView.tglSebar.getCalendar().getTime();
                    java.sql.Date tglSebar = new java.sql.Date(d.getTime());
                    tambakEntity.setTglSebar(tglSebar);
                }
                
                if (TambakView.tglPerkiraanPanen.getDate() == null) {
                    tambakEntity.setTglPerkiraanPanen(null);
                } else {
                    Date d = TambakView.tglPerkiraanPanen.getCalendar().getTime();
                    java.sql.Date tglPerkiraanPanen = new java.sql.Date(d.getTime());
                    tambakEntity.setTglPerkiraanPanen(tglPerkiraanPanen);
                }


                tambakEntity.setId(Integer.valueOf(TambakView.labelID.getText()));
                tambakEntity.setNama(TambakView.textNama.getText());
                tambakEntity.setLahanId(Integer.valueOf(TambakView.textIdLahan.getText()));
                tambakEntity.setVarietas(TambakView.textVarietas.getText());
                tambakEntity.setTotalbibit(Integer.valueOf(TambakView.textTotal.getText()));

                String condition = TambakView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = tambakImplement.insertData(tambakEntity);
                    JOptionPane.showMessageDialog(tambakView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = tambakImplement.updateData(tambakEntity);
                    JOptionPane.showMessageDialog(tambakView, message);
                }
                refresh(tambakView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }
    
    public void buttonKeluarAction(TambakView tambakView) {
        try {
            tambakView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(tambakView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }
    
     public void tableDataAction(TambakView tambakView) {
        TambakView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = TambakView.tableData.getSelectedRow();
                if (row != -1) {
                    TambakEntity tambakEntity = tambakTableModel.get(row);
                    
                    TambakView.labelID.setText(Integer.toString(tambakEntity.getId()));
                    TambakView.textNama.setText(tambakEntity.getNama());
                    TambakView.textIdLahan.setText(Integer.toString(tambakEntity.getLahanId()));
                    TambakView.textLokasi.setText(tambakEntity.getLokasi());
                    TambakView.textVarietas.setText(tambakEntity.getVarietas());
                    TambakView.textTotal.setText(Integer.toString(tambakEntity.getTotalbibit()));
                    TambakView.tglSebar.setDate(tambakEntity.getTglSebar());
                    TambakView.tglPerkiraanPanen.setDate(tambakEntity.getTglPerkiraanPanen());
                    
                }
            }
        });
    }
    
      public void cariLahanAction(TambakView tambakView) {
        try {
            LahanCariView lahanCariView = new LahanCariView(null, true);
            lahanCariView.setVisible(true);
        } catch (Exception e) {
            
        }
    }

}
