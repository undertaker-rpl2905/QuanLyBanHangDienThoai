package DTO;

import java.util.Objects;

public class NhaCungCapDTO {
    private int maNCC;
    private String tenNCC;
    private String sdt;
    private String diaChi;

    public NhaCungCapDTO(){

    }

    public NhaCungCapDTO(int maNCC, String tenNCC, String sdt, String diachi){
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.diaChi = diachi;
    }

    //getter
    public int getMaNCC(){
        return this.maNCC;
    }

    public String getTenNCC(){
        return this.tenNCC;
    }

    public String getSDT(){
        return this.sdt;
    }

    public String getDiaChi(){
        return this.diaChi;
    }

    //setter
    public void setMaNCC(int maNCC){
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC){
        this.tenNCC = tenNCC;
    }

    public void setSDT(String sdt){
        this.sdt = sdt;
    }

    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhaCungCapDTO that = (NhaCungCapDTO) o;
        return maNCC == that.maNCC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNCC);
    }


    @Override
    public String toString(){
        return "NhaCungCap {" +
                "maNCC=" + maNCC +
                ", tenNCC='" + tenNCC + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
