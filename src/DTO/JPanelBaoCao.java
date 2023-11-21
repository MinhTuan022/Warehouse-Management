/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.dBaoCao;
import javax.swing.JPanel;
import java.lang.*;
/**
 *
 * @author admin
 */
public class JPanelBaoCao {
    public JPanel JPanelPieChart;

    public JPanelBaoCao() {
    }

    public JPanelBaoCao(JPanel JPanelPieChart) {
        this.JPanelPieChart = JPanelPieChart;
    }

    
    public void Run(){
       this.JPanelPieChart = dBaoCao.getInstance().createChartPanelLoaiSanPham_jTreeChart();
    }
    
}
