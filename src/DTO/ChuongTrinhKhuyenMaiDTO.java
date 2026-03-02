/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author thsdo
 */
import java.time.LocalDate;
import java.util.Objects;

public class ChuongTrinhKhuyenMaiDTO {
    private String maCTKM;
    private String tenCTKM;
    private String loaiKhuyenMai;
    private String moTa;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private int trangThai;

    public ChuongTrinhKhuyenMaiDTO() {}

    public ChuongTrinhKhuyenMaiDTO(String maCTKM, String tenCTKM, String loaiKhuyenMai,
                                   String moTa, LocalDate ngayBatDau,
                                   LocalDate ngayKetThuc, int trangThai) {
        this.maCTKM = maCTKM;
        this.tenCTKM = tenCTKM;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public String getMaCTKM() { return maCTKM; }
    public void setMaCTKM(String maCTKM) { this.maCTKM = maCTKM; }
    public String getTenCTKM() { return tenCTKM; }
    public void setTenCTKM(String tenCTKM) { this.tenCTKM = tenCTKM; }
    public String getLoaiKhuyenMai() { return loaiKhuyenMai; }
    public void setLoaiKhuyenMai(String loaiKhuyenMai) { this.loaiKhuyenMai = loaiKhuyenMai; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public LocalDate getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(LocalDate ngayBatDau) { this.ngayBatDau = ngayBatDau; }
    public LocalDate getNgayKetThuc() { return ngayKetThuc; }
    public void setNgayKetThuc(LocalDate ngayKetThuc) { this.ngayKetThuc = ngayKetThuc; }
    public int getTrangThai() { return trangThai; }
    public void setTrangThai(int trangThai) { this.trangThai = trangThai; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChuongTrinhKhuyenMaiDTO that)) return false;
        return Objects.equals(maCTKM, that.maCTKM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCTKM);
    }

    @Override
    public String toString() {
        return "ChuongTrinhKhuyenMaiDTO{" +
                "maCTKM='" + maCTKM + '\'' +
                ", tenCTKM='" + tenCTKM + '\'' +
                ", loaiKhuyenMai='" + loaiKhuyenMai + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", trangThai=" + trangThai +
                '}';
    }
}

