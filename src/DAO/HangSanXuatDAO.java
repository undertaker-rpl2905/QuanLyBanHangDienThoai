package DAO;

import DTO.HangSanXuatDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HangSanXuatDAO implements DAOInterface<HangSanXuatDTO> {

    public static HangSanXuatDAO getInstance() {
        return new HangSanXuatDAO();
    }

    @Override
    public int insert(HangSanXuatDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "INSERT INTO HangSanXuat(MaHang, TenHang, DiaChi) VALUES (?, ?, ?)";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho các dấu ?
            pst.setInt(1, t.getMaHang());
            pst.setString(2, t.getTenHang());
            pst.setString(3, t.getDiaChi());

            // Bước 5: Thực thi câu lệnh
            ketQua = pst.executeUpdate();

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(HangSanXuatDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            String sql = "UPDATE HangSanXuat SET TenHang = ?, DiaChi = ? WHERE MaHang = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getTenHang());
            pst.setString(2, t.getDiaChi());
            pst.setInt(3, t.getMaHang());

            ketQua = pst.executeUpdate();
            SQLServerConnect.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HangSanXuatDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            String sql = "DELETE FROM HangSanXuat WHERE MaHang = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaHang());

            ketQua = pst.executeUpdate();
            SQLServerConnect.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HangSanXuatDTO> selectALL() {
        ArrayList<HangSanXuatDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1: Tạo kết nối
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết SQL
            String sql = "SELECT * FROM HangSanXuat";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Thực thi -> nhận ResultSet
            ResultSet rs = pst.executeQuery();

            // Bước 5: Duyệt ResultSet
            while (rs.next()) {
                // Lấy dữ liệu từng cột
                int maHang = rs.getInt("MaHang");
                String tenHang = rs.getString("TenHang");
                String diaChi = rs.getString("DiaChi");

                // Tạo đối tượng DTO
                HangSanXuatDTO hsx = new HangSanXuatDTO(maHang, tenHang, diaChi);

                // Thêm vào danh sách
                ketQua.add(hsx);
            }

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public HangSanXuatDTO selectById(HangSanXuatDTO t) {
        HangSanXuatDTO ketQua = null;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT * FROM HangSanXuat WHERE MaHang = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaHang());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int maHang = rs.getInt("MaHang");
                String tenHang = rs.getString("TenHang");
                String diaChi = rs.getString("DiaChi");

                ketQua = new HangSanXuatDTO(maHang, tenHang, diaChi);
            }

            SQLServerConnect.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HangSanXuatDTO> selectByCondition(String condition) {
        ArrayList<HangSanXuatDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT * FROM HangSanXuat WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int maHang = rs.getInt("MaHang");
                String tenHang = rs.getString("TenHang");
                String diaChi = rs.getString("DiaChi");

                HangSanXuatDTO hsx = new HangSanXuatDTO(maHang, tenHang, diaChi);
                ketQua.add(hsx);
            }

            SQLServerConnect.closeConnection(con);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }
    public int getLastMaHang() {
        int lastMa = 0;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT TOP 1 MaHang FROM HangSanXuat ORDER BY MaHang DESC";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lastMa = rs.getInt("MaHang");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastMa;
    }

}
