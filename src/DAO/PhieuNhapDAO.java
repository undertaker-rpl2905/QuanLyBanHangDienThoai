package DAO;

import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class PhieuNhapDAO implements DAOInterface<PhieuNhapDTO> {

    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }

    @Override
    public int insert(PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "INSERT INTO PhieuNhap (maPHN, maNV, maNCC, ngay, tongtien) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, t.getMaPHN());
            pst.setString(2, t.getMaNV());
            pst.setInt(3, t.getMaNCC());
            
            pst.setTimestamp(4, t.getNgay());
            
            pst.setDouble(5, t.getTongTien());

            ketQua = pst.executeUpdate();
            
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "UPDATE PhieuNhap SET maNV=?, maNCC=?, ngay=?, tongtien=? WHERE maPHN=?";
            
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getMaNV());
            pst.setInt(2, t.getMaNCC());
            pst.setTimestamp(3, t.getNgay());
            pst.setDouble(4, t.getTongTien());
            
            pst.setInt(5, t.getMaPHN());

            ketQua = pst.executeUpdate();
            
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(PhieuNhapDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "DELETE FROM PhieuNhap WHERE maPHN = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaPHN());

            ketQua = pst.executeUpdate();
            
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<PhieuNhapDTO> selectALL() {
        ArrayList<PhieuNhapDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "SELECT * FROM PhieuNhap";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int maPHN = rs.getInt("maPHN");
                String maNV = rs.getString("maNV");
                int maNCC = rs.getInt("maNCC");
                
                Timestamp ngay = rs.getTimestamp("ngay");
                
                double tongTien = rs.getDouble("tongtien");

                PhieuNhapDTO pn = new PhieuNhapDTO(maPHN, maNV, maNCC, ngay, tongTien);
                ketQua.add(pn);
            }
            
            rs.close();
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public PhieuNhapDTO selectById(PhieuNhapDTO t) {
        PhieuNhapDTO ketQua = null;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "SELECT * FROM PhieuNhap WHERE maPHN = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaPHN());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int maPHN = rs.getInt("maPHN");
                String maNV = rs.getString("maNV");
                int maNCC = rs.getInt("maNCC");
                Timestamp ngay = rs.getTimestamp("ngay");
                double tongTien = rs.getDouble("tongtien");

                ketQua = new PhieuNhapDTO(maPHN, maNV, maNCC, ngay, tongTien);
            }
            
            rs.close();
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<PhieuNhapDTO> selectByCondition(String condition) {
        ArrayList<PhieuNhapDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "SELECT * FROM PhieuNhap WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int maPHN = rs.getInt("maPHN");
                String maNV = rs.getString("maNV");
                int maNCC = rs.getInt("maNCC");
                Timestamp ngay = rs.getTimestamp("ngay");
                double tongTien = rs.getDouble("tongtien");

                PhieuNhapDTO pn = new PhieuNhapDTO(maPHN, maNV, maNCC, ngay, tongTien);
                ketQua.add(pn);
            }
            
            rs.close();
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }
    public int getLastMaPHN() {
        int lastMa = 0;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT TOP 1 maPHN FROM PhieuNhap ORDER BY maPHN DESC";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lastMa = rs.getInt("maPHN");
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