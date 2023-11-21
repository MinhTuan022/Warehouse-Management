/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.LoaiSanPham_jTreeChart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.general.DefaultPieDataset;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Pham Thanh Nghia
 */
public class dBaoCao {

    private static dBaoCao instance;

    public static dBaoCao getInstance() {
        if (instance == null) {
            instance = new dBaoCao();
        }
        return instance;
    }

    //Tạo biểu đồ tròn về loại sản phẩm trong kho
    public JPanel createChartPanelLoaiSanPham_jTreeChart() {
        double tong_so_luong = 0;
        double du_thua = 0;
        ArrayList<LoaiSanPham_jTreeChart> arr = dLoaiSanPham.getInstance().getListLoaiSanPham_jTreeChart();
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                tong_so_luong = tong_so_luong + (double) arr.get(i).So_Luong;
                
            }
            if (arr.size() <= 6) {
                for (int i = 0; i < arr.size(); i++) {
                    double number = ((arr.get(i).So_Luong) / tong_so_luong) * 100;
                    pieDataset.setValue(arr.get(i).Ten_Loai_Sp, number);
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    du_thua = tong_so_luong - arr.get(i).So_Luong;
                    double number = ((arr.get(i).So_Luong) / tong_so_luong) * 100;
                    pieDataset.setValue(arr.get(i).Ten_Loai_Sp, number);
                }
                double number = (du_thua / tong_so_luong) * 10;
                pieDataset.setValue("Loại khác", number);
            }

        } else {
            pieDataset.setValue("Chưa có dữ liệu trong kho", new Integer(90));
            pieDataset.setValue("Chưa có gì ", new Integer(10));

        }
        JFreeChart chart = ChartFactory.createPieChart3D("Phần trăm theo loại sản phẩm trong kho", pieDataset, true, true, true);
        return new ChartPanel(chart);
    }

//    /
    
}
