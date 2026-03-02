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

public class HangSanXuatDTO {
    private int maHang;
    private String tenHang;
    private String diaChi;

    // Constructor không tham số
    public HangSanXuatDTO() {
    }

    // Constructor có tham số
    public HangSanXuatDTO(int maHang, String tenHang, String diaChi) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.diaChi = diaChi;
    }

    // Getter & Setter
    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // hashCode & equals (phân biệt theo mã hãng)
    @Override
    public int hashCode() {
        return Objects.hash(maHang);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HangSanXuatDTO)) return false;
        HangSanXuatDTO other = (HangSanXuatDTO) obj;
        return maHang == other.maHang;
    }

    // toString
    @Override
    public String toString() {
        return "HangSanXuatDTO{" +
                "maHang=" + maHang +
                ", tenHang='" + tenHang + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}

