/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Objects;

public class VaiTroDTO {

    // ===== Thuộc tính 
    private String maVaiTro;
    private String tenVaiTro;

    // ===== Constructor không tham số 
    public VaiTroDTO() {
    }

    // ===== Constructor có tham số 
    public VaiTroDTO(String maVaiTro, String tenVaiTro) {
        this.maVaiTro = maVaiTro;
        this.tenVaiTro = tenVaiTro;
    }

    //  Getter & Setter
    public String getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    //  hashCode & equals 
    @Override
    public int hashCode() {
        return Objects.hash(maVaiTro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VaiTroDTO other = (VaiTroDTO) obj;
        return Objects.equals(maVaiTro, other.maVaiTro);
    }

    // toString 
    @Override
    public String toString() {
        return "VaiTroDTO{" +
                "maVaiTro='" + maVaiTro + '\'' +
                ", tenVaiTro='" + tenVaiTro + '\'' +
                '}';
    }
}

