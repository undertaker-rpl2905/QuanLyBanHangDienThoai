/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author user
 */
import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class KhachHangDAO implements DAOInterface<KhachHangDTO> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHangDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "INSERT INTO KhachHang(MaKH, Ho, Ten, DiaChi) VALUES (?, ?, ?, ?)";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho ?
            pst.setString(1, t.getMaKH());
            pst.setString(2, t.getHo());
            pst.setString(3, t.getTen());
            pst.setString(4, t.getDiaChi());

            // Bước 5: Thực thi
            ketQua = pst.executeUpdate();

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(KhachHangDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Câu lệnh SQL
            String sql = "UPDATE KhachHang SET Ho = ?, Ten = ?, DiaChi = ? WHERE MaKH = ?";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị
            pst.setString(1, t.getHo());
            pst.setString(2, t.getTen());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getMaKH());

            // Bước 5: Thực thi
            ketQua = pst.executeUpdate();

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(KhachHangDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: SQL
            String sql = "DELETE FROM KhachHang WHERE MaKH = ?";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị
            pst.setString(1, t.getMaKH());

            // Bước 5: Thực thi
            ketQua = pst.executeUpdate();

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHangDTO> selectALL() {
        ArrayList<KhachHangDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: SQL
            String sql = "SELECT * FROM KhachHang";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 5: Duyệt ResultSet
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String ho = rs.getString("Ho");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");

                KhachHangDTO kh = new KhachHangDTO(maKH, ho, ten, diaChi);
                ketQua.add(kh);
            }

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public KhachHangDTO selectById(KhachHangDTO t) {
        KhachHangDTO ketQua = null;
        try {
            // Bước 1: Kết nối
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: SQL
            String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị
            pst.setString(1, t.getMaKH());

            // Bước 5: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 6: Lấy kết quả
            if (rs.next()) {
                String maKH = rs.getString("MaKH");
                String ho = rs.getString("Ho");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");

                ketQua = new KhachHangDTO(maKH, ho, ten, diaChi);
            }

            // Bước 7: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHangDTO> selectByCondition(String condition) {
        ArrayList<KhachHangDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1: Kết nối
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: SQL
            String sql = "SELECT * FROM KhachHang WHERE " + condition;

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Thực thi
            ResultSet rs = pst.executeQuery();

            // Bước 5: Duyệt ResultSet
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String ho = rs.getString("Ho");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");

                KhachHangDTO kh = new KhachHangDTO(maKH, ho, ten, diaChi);
                ketQua.add(kh);
            }

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    // Optional: Lấy mã khách hàng cuối cùng
    public String getLastMaKH() {
        String lastMa = null;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT TOP 1 MaKH FROM KhachHang ORDER BY MaKH DESC";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lastMa = rs.getString("MaKH");
            }

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastMa;
    }
}

