/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.InputStream;
import setting.Koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author nopal nich
 */
public class LaporanController {
    public void buttonCetakPendapatanAction() throws JRException {
        InputStream Report;
        Report = getClass().getResourceAsStream("ReportPendapatan.jasper");
        JasperPrint jp = JasperFillManager.fillReport(Report , null, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
    }
    public void buttonCetakPengeluaranAction() throws JRException {
        InputStream Report;
        Report = getClass().getResourceAsStream("ReportPengeluaran.jasper");
        JasperPrint jp = JasperFillManager.fillReport(Report , null, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
    }
}
