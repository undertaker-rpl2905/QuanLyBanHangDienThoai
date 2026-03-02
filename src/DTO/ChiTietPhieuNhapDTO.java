package DTO;

import java.util.Objects;

public class ChiTietPhieuNhapDTO {
    private int maPHN;
    private String maSP;
    private double donGia;
    private double thanhTien;

    public ChiTietPhieuNhapDTO() {
    }

    public ChiTietPhieuNhapDTO(int maPHN, String maSP, double donGia, double thanhTien) {
        this.maPHN = maPHN;
        this.maSP = maSP;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public int getMaPHN() {
        return maPHN;
    }

    public String getMaSP() {
        return maSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setMaPHN(int maPHN) {
        this.maPHN = maPHN;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietPhieuNhapDTO that = (ChiTietPhieuNhapDTO) o;
        return maPHN == that.maPHN && Objects.equals(maSP, that.maSP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPHN, maSP);
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhap {" +
                "maPHN=" + maPHN +
                ", maSP='" + maSP + '\'' +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
}