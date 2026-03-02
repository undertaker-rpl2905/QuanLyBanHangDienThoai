package DAO;

import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhaCungCapDAO implements DAOInterface<NhaCungCapDTO> {

    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }

    @Override
    public int insert(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "INSERT INTO NhaCungCap (maNCC, tenNCC, sdt, diachi) VALUES (?, ?, ?, ?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, t.getMaNCC());
            pst.setString(2, t.getTenNCC());
            pst.setString(3, t.getSDT());
            pst.setString(4, t.getDiaChi());

            ketQua = pst.executeUpdate();

            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "UPDATE NhaCungCap SET tenNCC = ?, sdt = ?, diachi = ? WHERE maNCC = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getTenNCC());
            pst.setString(2, t.getSDT());
            pst.setString(3, t.getDiaChi());
            pst.setInt(4, t.getMaNCC());

            ketQua = pst.executeUpdate();
            
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "DELETE FROM NhaCungCap WHERE maNCC = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaNCC());

            ketQua = pst.executeUpdate();
            
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectALL() {
        ArrayList<NhaCungCapDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "SELECT * FROM NhaCungCap";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int maNCC = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");

                NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, sdt, diachi);
                ketQua.add(ncc);
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
    public NhaCungCapDTO selectById(NhaCungCapDTO t) {
        NhaCungCapDTO ketQua = null;
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "SELECT * FROM NhaCungCap WHERE maNCC = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaNCC());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int maNCC = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");

                ketQua = new NhaCungCapDTO(maNCC, tenNCC, sdt, diachi);
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
    public ArrayList<NhaCungCapDTO> selectByCondition(String condition) {
        ArrayList<NhaCungCapDTO> ketQua = new ArrayList<>();
        try {
            Connection con = SQLServerConnect.getConnection();
            
            String sql = "SELECT * FROM NhaCungCap WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int maNCC = rs.getInt("maNCC");
                String tenNCC = rs.getString("tenNCC");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");

                NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, sdt, diachi);
                ketQua.add(ncc);
            }
            
            rs.close();
            pst.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }
    public int getLastMaNCC() {
        int lastMa = 0;
        try {
            Connection con = SQLServerConnect.getConnection();

            String sql = "SELECT TOP 1 maNCC FROM NhaCungCap ORDER BY maNCC DESC";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lastMa = rs.getInt("maNCC");
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