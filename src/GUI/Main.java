/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.Panel.KhuyenMaiGUI;
import GUI.Panel.NhaCungCap;
import GUI.Panel.PhieuNhap;
import GUI.Panel.SanPhamPanel;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main extends JFrame {

    private JPanel mainContent;
    private JPanel sidebar;
    private JPanel infoPanel;

    private JButton btnTrangChu;
    private JButton btnSanPham;
    private JButton btnBaoHanh;
    private JButton btnNhaCungCap;
    private JButton btnPhieuNhap;
    private JButton btnHoaDon;
    private JButton btnKhachHang;
    private JButton btnKhuyenMai;
    private JButton btnNhanVien;
    private JButton btnTaiKhoan;
    private JButton btnVaiTro;
    private JButton btnThongKe;
    private JButton btnLogout;

    private List<JButton> menuItems;

    private final Color ACTIVE_COLOR = new Color(65, 120, 255);

    public Main() {
        initUI();
    }

    private void initUI() {
        setTitle("Quản lý cửa hàng bán hàng điện thoại");
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createMainContent();
        createLeftSide();

        setVisible(true);
    }

    private void createMainContent() {
        mainContent = new JPanel(new BorderLayout());
        mainContent.setBackground(new Color(245, 245, 245));
        add(mainContent, BorderLayout.CENTER);
    }

    private void createLeftSide() {
        JPanel leftContainer = new JPanel(new BorderLayout());
        leftContainer.setPreferredSize(new Dimension(250, 800));
        leftContainer.setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, new Color(220, 220, 220)
        ));
        add(leftContainer, BorderLayout.WEST);

        createInfoPanel();
        createSidebar();

        leftContainer.add(infoPanel, BorderLayout.NORTH);
        leftContainer.add(sidebar, BorderLayout.CENTER);
    }

    private void createInfoPanel() {
        infoPanel = new JPanel(new BorderLayout());
        infoPanel.setBackground(Color.WHITE);

        JLabel lblAvatar = new JLabel("👤", SwingConstants.CENTER);
        lblAvatar.setPreferredSize(new Dimension(80, 80));
        lblAvatar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);
        textPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

        JLabel lblName = new JLabel("Nguyễn Văn A");
        JLabel lblRole = new JLabel("Quản lý");

        lblName.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblRole.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(lblName);
        textPanel.add(lblRole);

        infoPanel.add(lblAvatar, BorderLayout.WEST);
        infoPanel.add(textPanel, BorderLayout.CENTER);
    }

    private void createSidebar() {
        sidebar = new JPanel(new BorderLayout());
        sidebar.setBackground(Color.WHITE);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.WHITE);

        btnTrangChu = createMenuButton("Trang chủ");
        btnSanPham = createMenuButton("Sản phẩm");
        btnBaoHanh = createMenuButton("Bảo hành");
        btnNhaCungCap = createMenuButton("Nhà cung cấp");
        btnPhieuNhap = createMenuButton("Phiếu nhập");
        btnHoaDon = createMenuButton("Hóa đơn");
        btnKhachHang = createMenuButton("Khách hàng");
        btnKhuyenMai = createMenuButton("Khuyến mãi");
        btnNhanVien = createMenuButton("Nhân viên");
        btnTaiKhoan = createMenuButton("Tài khoản");
        btnVaiTro = createMenuButton("Vai trò");
        btnThongKe = createMenuButton("Thống kê");

        menuPanel.add(btnTrangChu);
        menuPanel.add(btnSanPham);
        menuPanel.add(btnBaoHanh);
        menuPanel.add(btnNhaCungCap);
        menuPanel.add(btnPhieuNhap);
        menuPanel.add(btnHoaDon);
        menuPanel.add(btnKhachHang);
        menuPanel.add(btnKhuyenMai);
        menuPanel.add(btnNhanVien);
        menuPanel.add(btnTaiKhoan);
        menuPanel.add(btnVaiTro);
        menuPanel.add(btnThongKe);

        btnLogout = createMenuButton("Đăng xuất");
        btnLogout.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));

        sidebar.add(menuPanel, BorderLayout.CENTER);
        sidebar.add(btnLogout, BorderLayout.SOUTH);

        menuItems = new ArrayList<>();
        menuItems.add(btnTrangChu);
        menuItems.add(btnSanPham);
        menuItems.add(btnBaoHanh);
        menuItems.add(btnNhaCungCap);
        menuItems.add(btnPhieuNhap);
        menuItems.add(btnHoaDon);
        menuItems.add(btnKhachHang);
        menuItems.add(btnKhuyenMai);
        menuItems.add(btnNhanVien);
        menuItems.add(btnTaiKhoan);
        menuItems.add(btnVaiTro);
        menuItems.add(btnThongKe);

        setPanel(new JLabel("Trang chủ", SwingConstants.CENTER));
        setActive(btnTrangChu);

        btnTrangChu.addActionListener(e -> {
            setPanel(new JLabel("Trang chủ", SwingConstants.CENTER));
            setActive(btnTrangChu);
        });

        btnSanPham.addActionListener(e -> {
            setPanel(new SanPhamPanel());
            setActive(btnSanPham);
        });

        btnBaoHanh.addActionListener(e -> {
            setPanel(new JLabel("Trang bảo hành", SwingConstants.CENTER));
            setActive(btnBaoHanh);
        });

        btnNhaCungCap.addActionListener(e -> {
            setPanel(new NhaCungCap());
            setActive(btnNhaCungCap);
        });

        btnPhieuNhap.addActionListener(e -> {
            setPanel(new PhieuNhap());
            setActive(btnPhieuNhap);
        });

        btnHoaDon.addActionListener(e -> {
            setPanel(new JLabel("Trang hóa đơn", SwingConstants.CENTER));
            setActive(btnHoaDon);
        });

        btnKhachHang.addActionListener(e -> {
            setPanel(new JLabel("Trang khách hàng", SwingConstants.CENTER));
            setActive(btnKhachHang);
        });

        btnKhuyenMai.addActionListener(e -> {
            setPanel(new KhuyenMaiGUI());
            setActive(btnKhuyenMai);
        });

        btnNhanVien.addActionListener(e -> {
            setPanel(new JLabel("Trang nhân viên", SwingConstants.CENTER));
            setActive(btnNhanVien);
        });

        btnTaiKhoan.addActionListener(e -> {
            setPanel(new JLabel("Trang tài khoản", SwingConstants.CENTER));
            setActive(btnTaiKhoan);
        });

        btnVaiTro.addActionListener(e -> {
            setPanel(new JLabel("Trang vai trò", SwingConstants.CENTER));
            setActive(btnVaiTro);
        });

        btnThongKe.addActionListener(e -> {
            setPanel(new JLabel("Trang thống kê", SwingConstants.CENTER));
            setActive(btnThongKe);
        });

        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc muốn đăng xuất?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                new LogIn().setVisible(true);
            }
        });
    }

    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFont(new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void setPanel(Component comp) {
        mainContent.removeAll();
        mainContent.add(comp, BorderLayout.CENTER);
        mainContent.revalidate();
        mainContent.repaint();
    }

    private void setActive(JButton selectedBtn) {
        for (JButton btn : menuItems) {
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        }

        selectedBtn.setBackground(ACTIVE_COLOR);
        selectedBtn.setForeground(Color.WHITE);
    }
}
