package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class NhanVienDAO implements DAOInterface<NhanVienDTO> {

    public static NhanVienDAO getInstance() {
        return new NhanVienDAO();
    }

    @Override
    public int insert(NhanVienDTO t) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối tới CSDL
            Connection con = SQLServerConnect.getConnection();

            // Bước 2: Viết câu lệnh SQL
            String sql = "INSERT INTO NhanVien(MaNV, Ho, Ten, NgaySinh, DiaChi, DienThoai, LuongThang) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Bước 3: Tạo PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4: Gán giá trị cho ?
            pst.setString(1, t.getMaNV());
            pst.setString(2, t.getHo());
            pst.setString(3, t.getTen());
            pst.setDate(4, java.sql.Date.valueOf(t.getNgaySinh()));
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getDienThoai());
            pst.setDouble(7, t.getLuongThang());

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
    public int update(NhanVienDTO t) {
        int ketQua = 0;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "UPDATE NhanVien "
                       + "SET Ho = ?, Ten = ?, NgaySinh = ?, DiaChi = ?, DienThoai = ?, LuongThang = ? "
                       + "WHERE MaNV = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getHo());
            pst.setString(2, t.getTen());
            pst.setDate(3, java.sql.Date.valueOf(t.getNgaySinh()));
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getDienThoai());
            pst.setDouble(6, t.getLuongThang());
            pst.setString(7, t.getMaNV());

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
    public int delete(NhanVienDTO t) {
        int ketQua = 0;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "DELETE FROM NhanVien WHERE MaNV = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaNV());

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
    public ArrayList<NhanVienDTO> selectALL() {
        ArrayList<NhanVienDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM NhanVien";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            ResultSet rs = pst.executeQuery();

            // Bước 5
            while (rs.next()) {
                String maNV = rs.getString("MaNV");
                String ho = rs.getString("Ho");
                String ten = rs.getString("Ten");
                LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
                String diaChi = rs.getString("DiaChi");
                String dienThoai = rs.getString("DienThoai");
                double luongThang = rs.getDouble("LuongThang");

                NhanVienDTO nv = new NhanVienDTO(
                        maNV, ho, ten, ngaySinh,
                        diaChi, dienThoai, luongThang
                );
                ketQua.add(nv);
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public NhanVienDTO selectById(NhanVienDTO t) {
        NhanVienDTO ketQua = null;
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            pst.setString(1, t.getMaNV());

            // Bước 5
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ketQua = new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getDate("NgaySinh").toLocalDate(),
                        rs.getString("DiaChi"),
                        rs.getString("DienThoai"),
                        rs.getDouble("LuongThang")
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
    public ArrayList<NhanVienDTO> selectByCondition(String condition) {
        ArrayList<NhanVienDTO> ketQua = new ArrayList<>();
        try {
            // Bước 1
            Connection con = SQLServerConnect.getConnection();

            // Bước 2
            String sql = "SELECT * FROM NhanVien WHERE " + condition;

            // Bước 3
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 4
            ResultSet rs = pst.executeQuery();

            // Bước 5
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO(
                        rs.getString("MaNV"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getDate("NgaySinh").toLocalDate(),
                        rs.getString("DiaChi"),
                        rs.getString("DienThoai"),
                        rs.getDouble("LuongThang")
                );
                ketQua.add(nv);
            }

            // Bước 6
            SQLServerConnect.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
