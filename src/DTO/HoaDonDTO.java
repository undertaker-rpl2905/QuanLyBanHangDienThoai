/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.time.LocalDateTime;
import java.util.*;
public class HoaDonDTO{
    private String maHD;
    private String maNV;
    private String maKH;
    private LocalDateTime ngayLapHD;
    private double tongTien;
    public HoaDonDTO()
    {
        maHD="";
        maNV="";
        maKH="";
        ngayLapHD=null;
        tongTien=0;
    }
    public HoaDonDTO(String maHD, String maNV, String maKH, LocalDateTime ngayLapHD, double tongTien )
    {
        this.maHD=maHD;
        this.maNV=maNV;
        this.maKH=maKH;
        this.ngayLapHD=ngayLapHD;
        this.tongTien=tongTien;
    }
    public String getMaHD() {return maHD;}
    public void setMaHD(String maHD) {this.maHD=maHD;}
    
    public String getMaNV() {return maNV;}
    public void setMaNV(String maNV) {this.maNV=maNV;}

    public String getMaKH() {return maKH;}
    public void setMaKH(String maKH) {this.maKH=maKH;}

    public LocalDateTime getNgayLapHD() {return ngayLapHD;}
    public void setNgayLapHD(LocalDateTime ngayLapHD) {this.ngayLapHD=ngayLapHD;}

    public double getTongTien() {return tongTien;}
    public  void setTongTien(double tongTien) {this.tongTien=tongTien;}

    @Override
    public int hashCode() {
        return Objects.hash(maHD);
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass())  return false;
        HoaDonDTO other = (HoaDonDTO) obj;
        return Objects.equals(maHD, other.maHD);
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" +
                "maHD='" + maHD + '\'' +
                ", maNV='" + maNV + '\'' +
                ", maKH='" + maKH + '\'' +
                ", ngayLapHD='" + ngayLapHD + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }
}
