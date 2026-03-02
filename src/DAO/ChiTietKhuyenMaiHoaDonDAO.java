package DAO;

import DTO.ChiTietKhuyenMaiHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietKhuyenMaiHoaDonDAO implements ChiTietInterface<ChiTietKhuyenMaiHoaDonDTO> {

    @Override
    public int insert(ChiTietKhuyenMaiHoaDonDTO t) {
        int result = 0;
        String sql = "INSERT INTO ChiTietKhuyenMaiHoaDon VALUES (?,?,?,?,?)";
        try {
            Connection con = SQLServerConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, t.getMaCTKM());
            ps.setDouble(2, t.getGiaTriToiThieu());
            ps.setObject(3, t.getPhanTramGiam());
            ps.setObject(4, t.getSoTienGiam());
            ps.setObject(5, t.getGiamToiDa());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(ChiTietKhuyenMaiHoaDonDTO t) {
        int result = 0;

        String sql = "DELETE FROM ChiTietKhuyenMaiHoaDon "
                   + "WHERE MaCTKM = ? AND GiaTriToiThieu = ?";

        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Tạo PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Bước 3: Gán giá trị cho ?
            ps.setString(1, t.getMaCTKM());
            ps.setDouble(2, t.getGiaTriToiThieu());

            // Bước 4: Thực thi
            result = ps.executeUpdate();

            // Bước 5: Đóng kết nối
            SQLServerConnect.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
}


    @Override
    public int update(ChiTietKhuyenMaiHoaDonDTO t) {
        int result = 0;

        String sql = "UPDATE ChiTietKhuyenMaiHoaDon "
                   + "SET PhanTramGiam = ?, SoTienGiam = ?, GiamToiDa = ? "
                   + "WHERE MaCTKM = ? AND GiaTriToiThieu = ?";

        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Tạo PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Bước 3: Gán giá trị cho ?
            ps.setDouble(1, t.getPhanTramGiam());
            ps.setDouble(2, t.getSoTienGiam());
            ps.setDouble(3, t.getGiamToiDa());
            ps.setString(4, t.getMaCTKM());
            ps.setDouble(5, t.getGiaTriToiThieu());

            // Bước 4: Thực thi
            result = ps.executeUpdate();

            // Bước 5: Đóng kết nối
            SQLServerConnect.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ArrayList<ChiTietKhuyenMaiHoaDonDTO> selectALL(String t) {
        ArrayList<ChiTietKhuyenMaiHoaDonDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM ChiTietKhuyenMaiHoaDon WHERE MaCTKM = ?";

        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Tạo PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Bước 3: Gán MaCTKM từ tham số t
            ps.setString(1, t);

            // Bước 4: Thực thi
            ResultSet rs = ps.executeQuery();

            // Bước 5: Duyệt ResultSet
            while (rs.next()) {
                ChiTietKhuyenMaiHoaDonDTO ct = new ChiTietKhuyenMaiHoaDonDTO(
                        rs.getString("MaCTKM"),
                        rs.getDouble("GiaTriToiThieu"),
                        rs.getDouble("PhanTramGiam"),
                        rs.getDouble("SoTienGiam"),
                        rs.getDouble("GiamToiDa")
                );
                list.add(ct);
            }

            // Bước 6: Đóng kết nối
            SQLServerConnect.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
