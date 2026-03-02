package DAO;

import DTO.VaiTroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VaiTroDAO implements DAOInterface<VaiTroDTO> {

    public static VaiTroDAO getInstance() {
        return new VaiTroDAO();
    }

    @Override
    public int insert(VaiTroDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: SQL
            String sql = "INSERT INTO VaiTro(MaVaiTro, TenVaiTro) VALUES (?, ?)";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaVaiTro());
            pst.setString(2, t.getTenVaiTro());

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
    public int update(VaiTroDTO t) {
        int ketQua = 0;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "UPDATE VaiTro SET TenVaiTro = ? WHERE MaVaiTro = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getTenVaiTro());
            pst.setString(2, t.getMaVaiTro());

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
    public int delete(VaiTroDTO t) {
        int ketQua = 0;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "DELETE FROM VaiTro WHERE MaVaiTro = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaVaiTro());

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
    public ArrayList<VaiTroDTO> selectALL() {
        ArrayList<VaiTroDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM VaiTro";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            ResultSet rs = pst.executeQuery();

            // Bước 5
            while (rs.next()) {
                String maVaiTro = rs.getString("MaVaiTro");
                String tenVaiTro = rs.getString("TenVaiTro");

                VaiTroDTO vt = new VaiTroDTO(maVaiTro, tenVaiTro);
                ketQua.add(vt);
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public VaiTroDTO selectById(VaiTroDTO t) {
        VaiTroDTO ketQua = null;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM VaiTro WHERE MaVaiTro = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaVaiTro());

            // Bước 5
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ketQua = new VaiTroDTO(
                        rs.getString("MaVaiTro"),
                        rs.getString("TenVaiTro")
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
    public ArrayList<VaiTroDTO> selectByCondition(String condition) {
        ArrayList<VaiTroDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM VaiTro WHERE " + condition;

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            ResultSet rs = pst.executeQuery();

            // Bước 5
            while (rs.next()) {
                VaiTroDTO vt = new VaiTroDTO(
                        rs.getString("MaVaiTro"),
                        rs.getString("TenVaiTro")
                );
                ketQua.add(vt);
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
