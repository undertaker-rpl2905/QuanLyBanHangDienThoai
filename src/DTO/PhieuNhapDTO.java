package DTO;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuNhapDTO {
    private int maPHN;
    private String maNV;
    private int maNCC;
    private Timestamp ngay;
    private double tongTien;
    private int trangThai;  

    public PhieuNhapDTO() {
        this.trangThai = 1;
    }

    public PhieuNhapDTO(int maPHN, String maNV, int maNCC,
                        Timestamp ngay, double tongTien, int trangThai) {
        this.maPHN = maPHN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngay = ngay;   
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaPHN() {
        return maPHN;
    }

    public String getMaNV() {
        return maNV;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public Timestamp getNgay() {
        return ngay;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaPHN(int maPHN) {
        this.maPHN = maPHN;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setNgay(Timestamp ngay) {
        this.ngay = ngay;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public int getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieuNhapDTO phieuNhap = (PhieuNhapDTO) o;
        return maPHN == phieuNhap.maPHN;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPHN);
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" +
                "maPHN=" + maPHN +
                ", maNV='" + maNV + '\'' +
                ", maNCC=" + maNCC +
                ", ngay=" + ngay +
                ", tongTien=" + tongTien +
                ", trangThai=" + trangThai +
                '}';
    }

}