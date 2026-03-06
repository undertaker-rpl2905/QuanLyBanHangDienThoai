/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author user
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author user
 */
public class SanPhamDAO implements DAOInterface<SanPhamDTO> {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    @Override
    public int insert(SanPhamDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "INSERT INTO SanPham(MaSp, TenSp, SoLuongTon, DonGia, DonViTinh, MaLoai, MaHang) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho các dấu ?
            pst.setString(1, t.getMaSp());
            pst.setString(2, t.getTenSp());
            pst.setInt(3, t.getSoLuongTon());
            pst.setDouble(4, t.getDonGia());
            pst.setString(5, t.getDonViTinh());
            pst.setInt(6, t.getMaLoai());
            pst.setInt(7, t.getMaHang());

            // Bước 5: Thực thi
            ketQua = pst.executeUpdate(); // trả về số dòng bị thay đổi

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(SanPhamDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "UPDATE SanPham "
                       + "SET TenSp = ?, SoLuongTon = ?, DonGia = ?, DonViTinh = ?, MaLoai = ?, MaHang = ? "
                       + "WHERE MaSp = ?";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho các dấu ?
            pst.setString(1, t.getTenSp());
            pst.setInt(2, t.getSoLuongTon());
            pst.setDouble(3, t.getDonGia());
            pst.setString(4, t.getDonViTinh());
            pst.setInt(5, t.getMaLoai());
            pst.setInt(6, t.getMaHang());
            pst.setString(7, t.getMaSp());

            // Bước 5: Thực thi
            ketQua = pst.executeUpdate(); // số dòng bị thay đổi

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(SanPhamDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "DELETE FROM SanPham WHERE MaSp = ?";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho dấu ?
            pst.setString(1, t.getMaSp());

            // Bước 5: Thực thi
            ketQua = pst.executeUpdate(); // số dòng bị xóa

            // Bước 6: Ngắt kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<SanPhamDTO> selectALL() {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "SELECT * FROM SanPham";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 5: Duyệt ResultSet
            while (rs.next()) {
                String maSp = rs.getString("MaSp");
                String tenSp = rs.getString("TenSp");
                int soLuongTon = rs.getInt("SoLuongTon");
                double donGia = rs.getDouble("DonGia");
                String donViTinh = rs.getString("DonViTinh");
                int maLoai = rs.getInt("MaLoai");
                int maHang = rs.getInt("MaHang");

                SanPhamDTO sp = new SanPhamDTO(maSp, tenSp, soLuongTon, donGia, donViTinh, maLoai, maHang);
                ketQua.add(sp);
            }

            // Bước 6: Ngắt kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public SanPhamDTO selectById(SanPhamDTO t) {
        SanPhamDTO ketQua = null;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "SELECT * FROM SanPham WHERE MaSp = ?";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho ?
            pst.setString(1, t.getMaSp());

            // Bước 5: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 6: Duyệt ResultSet
            if (rs.next()) {
                String maSp = rs.getString("MaSp");
                String tenSp = rs.getString("TenSp");
                int soLuongTon = rs.getInt("SoLuongTon");
                double donGia = rs.getDouble("DonGia");
                String donViTinh = rs.getString("DonViTinh");
                int maLoai = rs.getInt("MaLoai");
                int maHang = rs.getInt("MaHang");

                ketQua = new SanPhamDTO(maSp, tenSp, soLuongTon, donGia, donViTinh, maLoai, maHang);
            }
            

            // Bước 7: Ngắt kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<SanPhamDTO> selectByCondition(String condition) {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "SELECT * FROM SanPham WHERE " + condition;

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 5: Duyệt ResultSet
            while (rs.next()) {
                String maSp = rs.getString("MaSp");
                String tenSp = rs.getString("TenSp");
                int soLuongTon = rs.getInt("SoLuongTon");
                double donGia = rs.getDouble("DonGia");
                String donViTinh = rs.getString("DonViTinh");
                int maLoai = rs.getInt("MaLoai");
                int maHang = rs.getInt("MaHang");

                SanPhamDTO sp = new SanPhamDTO(maSp, tenSp, soLuongTon, donGia, donViTinh, maLoai, maHang);

                ketQua.add(sp);
            }

            // Bước 6: Ngắt kết nối CSDL
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public String getLastMaSP() {
        String lastMa = null;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Câu SQL (SQL Server dùng TOP 1)
            String sql = "SELECT TOP 1 MaSp FROM SanPham ORDER BY MaSp DESC";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 5: Lấy kết quả
            if (rs.next()) {
                lastMa = rs.getString("MaSp");
            }

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastMa;
    }
    public List<SanPhamDTO> getSearchTable(String text, String searchType) {
        List<SanPhamDTO> result = new ArrayList<>();

        if (text == null) {
            text = "";
        }

        text = text.trim().toLowerCase();

        for (SanPhamDTO sp : this.selectALL()) {

            String maSp = sp.getMaSp() != null ? sp.getMaSp().toLowerCase() : "";
            String tenSp = sp.getTenSp() != null ? sp.getTenSp().toLowerCase() : "";

            switch (searchType) {
                case "Tất cả":
                    if (maSp.contains(text) || tenSp.contains(text)) {
                        result.add(sp);
                    }
                    break;

                case "Mã":
                    if (maSp.contains(text)) {
                        result.add(sp);
                    }
                    break;

                case "Tên":
                    if (tenSp.contains(text)) {
                        result.add(sp);
                    }
                    break;

                default:
                    result.add(sp); // nếu lỗi thì trả về toàn bộ
                    break;
            }
        }

        return result;
    }
}

