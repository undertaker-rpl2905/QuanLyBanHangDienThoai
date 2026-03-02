/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author user
 */

import DTO.HoaDonDTO;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class HoaDonDAO implements DAOInterface<HoaDonDTO> {

    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }

    @Override
    public int insert(HoaDonDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "INSERT INTO HoaDon (MaHD, MaNV, MaKH, NgayLapHD, TongTien) "
                       + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getMaHD());
            pst.setString(2, t.getMaNV());
            pst.setString(3, t.getMaKH());
            pst.setTimestamp(4, Timestamp.valueOf(t.getNgayLapHD()));
            pst.setDouble(5, t.getTongTien());

            ketQua = pst.executeUpdate();

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(HoaDonDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "UPDATE HoaDon "
                       + "SET MaNV = ?, MaKH = ?, NgayLapHD = ?, TongTien = ? "
                       + "WHERE MaHD = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getMaKH());
            pst.setTimestamp(3, Timestamp.valueOf(t.getNgayLapHD()));
            pst.setDouble(4, t.getTongTien());
            pst.setString(5, t.getMaHD());

            ketQua = pst.executeUpdate();

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HoaDonDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "DELETE FROM HoaDon WHERE MaHD = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHD());

            ketQua = pst.executeUpdate();

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HoaDonDTO> selectALL() {
        ArrayList<HoaDonDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT * FROM HoaDon";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLapHD = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");

                HoaDonDTO hd = new HoaDonDTO(maHD, maNV, maKH, ngayLapHD, tongTien);
                ketQua.add(hd);
            }

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public HoaDonDTO selectById(HoaDonDTO t) {
        HoaDonDTO ketQua = null;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHD());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLapHD = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");

                ketQua = new HoaDonDTO(maHD, maNV, maKH, ngayLapHD, tongTien);
            }

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<HoaDonDTO> selectByCondition(String condition) {
        ArrayList<HoaDonDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT * FROM HoaDon WHERE " + condition;

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                String maNV = rs.getString("MaNV");
                String maKH = rs.getString("MaKH");
                LocalDateTime ngayLapHD = rs.getTimestamp("NgayLapHD").toLocalDateTime();
                double tongTien = rs.getDouble("TongTien");

                HoaDonDTO hd = new HoaDonDTO(maHD, maNV, maKH, ngayLapHD, tongTien);
                ketQua.add(hd);
            }

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public String getLastMaHD() {
        String lastMa = null;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT TOP 1 MaHD FROM HoaDon ORDER BY MaHD DESC";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lastMa = rs.getString("MaHD");
            }

            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastMa;
    }
}

