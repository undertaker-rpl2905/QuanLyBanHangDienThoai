/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Panel;

import BUS.ChuongTrinhKhuyenMaiBUS;
import DTO.ChuongTrinhKhuyenMaiDTO;

import GUI.Component.ButtonToolBar;
import GUI.Component.HeaderRightPanel;
import GUI.Component.TablePanel;
import GUI.Component.FilterItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class KhuyenMaiGUI extends JPanel {

    private ButtonToolBar toolBar;
    private HeaderRightPanel header;
    private TablePanel tablePanel;

    private FilterItem filterLoai;

    private JTable table;
    private DefaultTableModel model;

    private ChuongTrinhKhuyenMaiBUS bus;

    public KhuyenMaiGUI() {

        bus = new ChuongTrinhKhuyenMaiBUS();

        initComponent();
        loadData();
    }

    private void initComponent() {

        setLayout(new BorderLayout());

        // ===== Toolbar =====
        toolBar = new ButtonToolBar();

        // ===== Header =====
        header = new HeaderRightPanel();

        // Filter loại khuyến mãi
        filterLoai = new FilterItem(
                "Loại KM",
                new String[]{
                        "Tất cả",
                        "Giảm %",
                        "Giảm tiền",
                        "Quà tặng"
                }
        );

        header.add(filterLoai);

        // ===== Table =====
        tablePanel = new TablePanel(
                "DANH SÁCH CHƯƠNG TRÌNH KHUYẾN MÃI",
                new String[]{
                        "STT",
                        "Mã CTKM",
                        "Tên CTKM",
                        "Loại KM",
                        "Ngày BD",
                        "Ngày KT",
                        "Trạng thái"
                }
        );

        table = tablePanel.getTable();
        model = (DefaultTableModel) table.getModel();

        table.setRowHeight(35);

        add(toolBar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(header, BorderLayout.EAST);

        initEvent();
    }

    private void initEvent() {

        toolBar.btnThem.addActionListener(e -> add());
        toolBar.btnSua.addActionListener(e -> edit());
        toolBar.btnXoa.addActionListener(e -> delete());
        toolBar.btnLamMoi.addActionListener(e -> loadData());

    }

    private void loadData() {

        model.setRowCount(0);

        ArrayList<ChuongTrinhKhuyenMaiDTO> list = bus.getAll();

        int stt = 1;

        for (ChuongTrinhKhuyenMaiDTO km : list) {

            model.addRow(new Object[]{
                    stt++,
                    km.getMaCTKM(),
                    km.getTenCTKM(),
                    km.getLoaiKhuyenMai(),
                    km.getNgayBatDau(),
                    km.getNgayKetThuc(),
                    km.getTrangThai()
            });

        }

    }

    private void add() {
        JOptionPane.showMessageDialog(this,"Thêm khuyến mãi");
    }

    private void edit() {

        int row = table.getSelectedRow();

        if(row==-1){
            JOptionPane.showMessageDialog(this,"Chọn dòng cần sửa");
            return;
        }

        JOptionPane.showMessageDialog(this,"Sửa khuyến mãi");
    }

    private void delete() {

        int row = table.getSelectedRow();

        if(row==-1){
            JOptionPane.showMessageDialog(this,"Chọn dòng cần xóa");
            return;
        }

        String ma = table.getValueAt(row,1).toString();

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Xóa khuyến mãi "+ma+" ?"
        );

        if(confirm==JOptionPane.YES_OPTION){

            bus.delete(ma);
            loadData();

        }

    }

}


