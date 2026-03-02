/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Objects;

public class ChiTietHoaDonDTO {
    private String maHD;
    private String maSP;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    // Constructor mặc định
    public ChiTietHoaDonDTO() {
        maHD = "";
        maSP = "";
        soLuong = 0;
        donGia = 0;
        thanhTien = 0;
    }

    // Constructor đầy đủ tham số
    public ChiTietHoaDonDTO(String maHD, String maSP, int soLuong, double donGia, double thanhTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    // Getters và Setters
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }

    public double getThanhTien() { return thanhTien; }
    public void setThanhTien(double thanhTien) { this.thanhTien = thanhTien; }

    // hashCode và equals (Dựa trên cả maHD và maSP vì đây là khóa chính kết hợp)
    @Override
    public int hashCode() {
        return Objects.hash(maHD, maSP);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChiTietHoaDonDTO other = (ChiTietHoaDonDTO) obj;
        return Objects.equals(maHD, other.maHD) && Objects.equals(maSP, other.maSP);
    }

    // Hàm toString
    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{" +
                "maHD='" + maHD + '\'' +
                ", maSP='" + maSP + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
