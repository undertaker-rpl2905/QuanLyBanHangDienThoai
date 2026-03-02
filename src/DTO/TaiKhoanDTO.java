/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Objects;

public class TaiKhoanDTO {

    // ===== Thuộc tính =====
    private String maTaiKhoan;
    private String tenDangNhap;
    private String matKhau;
    private String maNhanVien;
    private String maVaiTro;

    // ===== Constructor không tham số 
    public TaiKhoanDTO() {
    }

    // ===== Constructor có tham số 
    public TaiKhoanDTO(String maTaiKhoan, String tenDangNhap,
                       String matKhau, String maNhanVien,
                       String maVaiTro) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
        this.maVaiTro = maVaiTro;
    }

    //  Getter setter
    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    //hashCode & equals (phân biệt theo mã tài khoản) 
    @Override
    public int hashCode() {
        return Objects.hash(maTaiKhoan);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TaiKhoanDTO other = (TaiKhoanDTO) obj;
        return Objects.equals(maTaiKhoan, other.maTaiKhoan);
    }

    //  toString 
    @Override
    public String toString() {
        return "TaiKhoanDTO{" +
                "maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", maVaiTro='" + maVaiTro + '\'' +
                '}';
    }
}
