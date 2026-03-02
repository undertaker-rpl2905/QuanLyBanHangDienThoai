/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author thsdo
 */
import java.util.Objects;

public class ChiTietKhuyenMaiSanPhamDTO {
    private String maCTKM;
    private String maSanPham;
    private Double phanTramGiam;
    private Double soTienGiam;
    private Integer soLuongToiDa;

    public ChiTietKhuyenMaiSanPhamDTO() {}

    public ChiTietKhuyenMaiSanPhamDTO(String maCTKM, String maSanPham,
                                      Double phanTramGiam, Double soTienGiam,
                                      Integer soLuongToiDa) {
        this.maCTKM = maCTKM;
        this.maSanPham = maSanPham;
        this.phanTramGiam = phanTramGiam;
        this.soTienGiam = soTienGiam;
        this.soLuongToiDa = soLuongToiDa;
    }

    public String getMaCTKM() { return maCTKM; }
    public void setMaCTKM(String maCTKM) { this.maCTKM = maCTKM; }
    public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }
    public Double getPhanTramGiam() { return phanTramGiam; }
    public void setPhanTramGiam(Double phanTramGiam) { this.phanTramGiam = phanTramGiam; }
    public Double getSoTienGiam() { return soTienGiam; }
    public void setSoTienGiam(Double soTienGiam) { this.soTienGiam = soTienGiam; }
    public Integer getSoLuongToiDa() { return soLuongToiDa; }
    public void setSoLuongToiDa(Integer soLuongToiDa) { this.soLuongToiDa = soLuongToiDa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietKhuyenMaiSanPhamDTO that)) return false;
        return Objects.equals(maCTKM, that.maCTKM) &&
               Objects.equals(maSanPham, that.maSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCTKM, maSanPham);
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMaiSanPhamDTO{" +
                "maCTKM='" + maCTKM + '\'' +
                ", maSanPham='" + maSanPham + '\'' +
                ", phanTramGiam=" + phanTramGiam +
                ", soTienGiam=" + soTienGiam +
                ", soLuongToiDa=" + soLuongToiDa +
                '}';
    }
}

