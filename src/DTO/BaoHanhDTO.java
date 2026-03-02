package DTO;

import java.util.Date;
import java.util.Objects;

public class BaoHanhDTO {

    private String maBH;
    private String tenBH;          
    private String maHD;
    private String maSP;
    private int thoiHan;           // số tháng bảo hành
    private Date ngayBatDau;
    private Date ngayKetThuc;

    // Constructor không tham số
    public BaoHanhDTO() {
    }

    // Constructor đầy đủ tham số
    public BaoHanhDTO(String maBH, String tenBH, String maHD, String maSP,
                      int thoiHan, Date ngayBatDau, Date ngayKetThuc) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.maHD = maHD;
        this.maSP = maSP;
        this.thoiHan = thoiHan;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBH);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaoHanhDTO other = (BaoHanhDTO) obj;
        return Objects.equals(this.maBH, other.maBH);
    }

    @Override
    public String toString() {
        return "BaoHanhDTO{" +
                "maBH='" + maBH + '\'' +
                ", tenBH='" + tenBH + '\'' +
                ", maHD='" + maHD + '\'' +
                ", maSP='" + maSP + '\'' +
                ", thoiHan=" + thoiHan +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }
}
