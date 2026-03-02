/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author user
 */
import java.util.Objects;

public class SanPhamDTO {
    private String maSp;
    private String tenSp;
    private int soLuongTon;
    private double donGia;
    private String donViTinh;
    private int maLoai;
    private int maHang;

    // Constructor không tham số
    public SanPhamDTO() {
    }

    // Constructor có tham số
    public SanPhamDTO(String maSp, String tenSp, int soLuongTon, double donGia,
                      String donViTinh, int maLoai, int maHang) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.maLoai = maLoai;
        this.maHang = maHang;
    }

    // Getter & Setter
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    // hashCode & equals (phân biệt theo mã sản phẩm)
    @Override
    public int hashCode() {
        return Objects.hash(maSp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SanPhamDTO)) return false;
        SanPhamDTO other = (SanPhamDTO) obj;
        return Objects.equals(maSp, other.maSp);
    }

    // toString
    @Override
    public String toString() {
        return "SanPhamDTO{" +
                "maSp='" + maSp + '\'' +
                ", tenSp='" + tenSp + '\'' +
                ", soLuongTon=" + soLuongTon +
                ", donGia=" + donGia +
                ", donViTinh='" + donViTinh + '\'' +
                ", maLoai=" + maLoai +
                ", maHang=" + maHang +
                '}';
    }
}

