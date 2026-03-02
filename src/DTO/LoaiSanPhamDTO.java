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

public class LoaiSanPhamDTO {
    private int maLoai;
    private String tenLoai;

    // Constructor không tham số
    public LoaiSanPhamDTO() {
    }

    // Constructor có tham số
    public LoaiSanPhamDTO(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    // Getter & Setter
    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    // hashCode & equals (phân biệt theo mã loại)
    @Override
    public int hashCode() {
        return Objects.hash(maLoai);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LoaiSanPhamDTO)) return false;
        LoaiSanPhamDTO other = (LoaiSanPhamDTO) obj;
        return maLoai == other.maLoai;
    }

    // toString
    @Override
    public String toString() {
        return "LoaiSanPhamDTO{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}

