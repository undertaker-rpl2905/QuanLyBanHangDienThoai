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

public class ChiTietKhuyenMaiHoaDonDTO {
    private String maCTKM;
    private double giaTriToiThieu;
    private Double phanTramGiam;
    private Double soTienGiam;
    private Double giamToiDa;

    public ChiTietKhuyenMaiHoaDonDTO() {}

    public ChiTietKhuyenMaiHoaDonDTO(String maCTKM, double giaTriToiThieu,
                                     Double phanTramGiam, Double soTienGiam,
                                     Double giamToiDa) {
        this.maCTKM = maCTKM;
        this.giaTriToiThieu = giaTriToiThieu;
        this.phanTramGiam = phanTramGiam;
        this.soTienGiam = soTienGiam;
        this.giamToiDa = giamToiDa;
    }

    public String getMaCTKM() { return maCTKM; }
    public void setMaCTKM(String maCTKM) { this.maCTKM = maCTKM; }
    public double getGiaTriToiThieu() { return giaTriToiThieu; }
    public void setGiaTriToiThieu(double giaTriToiThieu) { this.giaTriToiThieu = giaTriToiThieu; }
    public Double getPhanTramGiam() { return phanTramGiam; }
    public void setPhanTramGiam(Double phanTramGiam) { this.phanTramGiam = phanTramGiam; }
    public Double getSoTienGiam() { return soTienGiam; }
    public void setSoTienGiam(Double soTienGiam) { this.soTienGiam = soTienGiam; }
    public Double getGiamToiDa() { return giamToiDa; }
    public void setGiamToiDa(Double giamToiDa) { this.giamToiDa = giamToiDa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietKhuyenMaiHoaDonDTO that)) return false;
        return Double.compare(that.giaTriToiThieu, giaTriToiThieu) == 0 &&
               Objects.equals(maCTKM, that.maCTKM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCTKM, giaTriToiThieu);
    }

    @Override
    public String toString() {
        return "ChiTietKhuyenMaiHoaDonDTO{" +
                "maCTKM='" + maCTKM + '\'' +
                ", giaTriToiThieu=" + giaTriToiThieu +
                ", phanTramGiam=" + phanTramGiam +
                ", soTienGiam=" + soTienGiam +
                ", giamToiDa=" + giamToiDa +
                '}';
    }
}

