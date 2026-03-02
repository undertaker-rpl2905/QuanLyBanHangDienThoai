package DTO;
import java.time.LocalDate;
import java.util.Objects;

public class NhanVienDTO {

    // ===== Thuộc tính =====
    private String maNV;
    private String ho;
    private String ten;
    private LocalDate ngaySinh;   
    private String diaChi;
    private String dienThoai;
    private double luongThang;

    //  Constructor không tham số 
    public NhanVienDTO() {
    }

    // Constructor có tham số 
    public NhanVienDTO(String maNV, String ho, String ten,
                       LocalDate ngaySinh, String diaChi,
                       String dienThoai, double luongThang) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.luongThang = luongThang;
    }

    //  Getter , Setter 
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public double getLuongThang() {
        return luongThang;
    }

    public void setLuongThang(double luongThang) {
        this.luongThang = luongThang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNV);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NhanVienDTO other = (NhanVienDTO) obj;
        return Objects.equals(maNV, other.maNV);
    }

    //  toString 
    @Override
    public String toString() {
        return "NhanVienDTO{" +
                "maNV='" + maNV + '\'' +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", dienThoai='" + dienThoai + '\'' +
                ", luongThang=" + luongThang +
                '}';
    }
}
