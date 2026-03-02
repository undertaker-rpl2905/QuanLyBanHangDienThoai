package DAO;

import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaiKhoanDAO implements DAOInterface<TaiKhoanDTO> {

    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }

    @Override
    public int insert(TaiKhoanDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: SQL
            String sql = "INSERT INTO TaiKhoan(MaTK, TenDangNhap, MatKhau, MaNV, MaVaiTro) "
                       + "VALUES (?, ?, ?, ?, ?)";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị
            pst.setString(1, t.getMaTaiKhoan());
            pst.setString(2, t.getTenDangNhap());
            pst.setString(3, t.getMatKhau());
            pst.setString(4, t.getMaNhanVien());
            pst.setString(5, t.getMaVaiTro());

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
    public int update(TaiKhoanDTO t) {
        int ketQua = 0;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "UPDATE TaiKhoan "
                       + "SET TenDangNhap = ?, MatKhau = ?, MaNV = ?, MaVaiTro = ? "
                       + "WHERE MaTK = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getTenDangNhap());
            pst.setString(2, t.getMatKhau());
            pst.setString(3, t.getMaNhanVien());
            pst.setString(4, t.getMaVaiTro());
            pst.setString(5, t.getMaTaiKhoan());

            // Bước 5
            ketQua = pst.executeUpdate();

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(TaiKhoanDTO t) {
        int ketQua = 0;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "DELETE FROM TaiKhoan WHERE MaTK = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaTaiKhoan());

            // Bước 5
            ketQua = pst.executeUpdate();

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<TaiKhoanDTO> selectALL() {
        ArrayList<TaiKhoanDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM TaiKhoan";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            ResultSet rs = pst.executeQuery();

            // Bước 5
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("MaTK"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getString("MaVaiTro")
                );
                ketQua.add(tk);
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public TaiKhoanDTO selectById(TaiKhoanDTO t) {
        TaiKhoanDTO ketQua = null;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM TaiKhoan WHERE MaTaiKhoan = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaTaiKhoan());

            // Bước 5
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ketQua = new TaiKhoanDTO(
                        rs.getString("MaTK"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getString("MaVaiTro")
                );
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<TaiKhoanDTO> selectByCondition(String condition) {
        ArrayList<TaiKhoanDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM TaiKhoan WHERE " + condition;

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            ResultSet rs = pst.executeQuery();

            // Bước 5
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO(
                        rs.getString("MaTK"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getString("MaVaiTro")
                );
                ketQua.add(tk);
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public TaiKhoanDTO selectByUser(String username) {
        TaiKhoanDTO ketQua = null;
        try {
            // Bước 1: Kết nối
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Câu lệnh SQL
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";

            // Bước 3: PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị
            pst.setString(1, username);

            // Bước 5: Thực thi
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ketQua = new TaiKhoanDTO(
                        rs.getString("MaTK"),
                        rs.getString("TenDangNhap"),
                        rs.getString("MatKhau"),
                        rs.getString("MaNV"),
                        rs.getString("MaVaiTro")
                );
            }

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
