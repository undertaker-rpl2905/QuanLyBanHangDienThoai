package DAO;

import DTO.ChiTietKhuyenMaiSanPhamDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietKhuyenMaiSanPhamDAO implements ChiTietInterface<ChiTietKhuyenMaiSanPhamDTO> {

    @Override
    public int insert(ChiTietKhuyenMaiSanPhamDTO t) {
        int result = 0;
        String sql = "INSERT INTO ChiTietKhuyenMaiSanPham VALUES (?,?,?,?,?)";
        try {
            Connection con = SQLServerConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaCTKM());
            ps.setString(2, t.getMaSanPham());
            ps.setObject(3, t.getPhanTramGiam());
            ps.setObject(4, t.getSoTienGiam());
            ps.setObject(5, t.getSoLuongToiDa());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(ChiTietKhuyenMaiSanPhamDTO t) {
        int result = 0;
        String sql = "DELETE FROM ChiTietKhuyenMaiSanPham WHERE MaCTKM = ? AND MaSanPham = ?";

        try {
            Connection con = SQLServerConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaCTKM());
            ps.setString(2, t.getMaSanPham());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public ArrayList<ChiTietKhuyenMaiSanPhamDTO> selectALL(String maCTKM) {
        ArrayList<ChiTietKhuyenMaiSanPhamDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietKhuyenMaiSanPham WHERE MaCTKM=?";
        try {
            Connection con = SQLServerConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maCTKM);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ChiTietKhuyenMaiSanPhamDTO(
                        rs.getString("MaCTKM"),
                        rs.getString("MaSanPham"),
                        rs.getDouble("PhanTramGiam"),
                        rs.getDouble("SoTienGiam"),
                        rs.getInt("SoLuongToiDa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(ChiTietKhuyenMaiSanPhamDTO t) {
        int result = 0;
        String sql = "UPDATE ChiTietKhuyenMaiSanPham "
                   + "SET PhanTramGiam = ?, SoTienGiam = ?, SoLuongToiDa = ? "
                   + "WHERE MaCTKM = ? AND MaSanPham = ?";

        try {
            Connection con = SQLServerConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, t.getPhanTramGiam());
            ps.setDouble(2, t.getSoTienGiam());
            ps.setInt(3, t.getSoLuongToiDa());

            ps.setString(4, t.getMaCTKM());
            ps.setString(5, t.getMaSanPham());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
