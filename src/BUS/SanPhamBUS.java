/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class SanPhamBUS {
    private final SanPhamDAO spDAO = new SanPhamDAO();
    private ArrayList<SanPhamDTO> listSP = new ArrayList<>();
    public SanPhamBUS(){
        listSP = spDAO.selectALL();
    }
    public ArrayList<SanPhamDTO> getAll() {
        return listSP;
    }
    public String generateMaSP() {
        String lastMa = spDAO.getLastMaSP();
        if (lastMa == null) {
            return "SP001";
        }
        int so = Integer.parseInt(lastMa.substring(2));
        so++;
        return String.format("SP%03d", so);
    }

    public boolean add(SanPhamDTO sp) {
        sp.setMaSp(generateMaSP());
        boolean check = spDAO.insert(sp) != 0;
        if (check) {
            listSP.add(sp);
        }
        return check;
    }
    public boolean delete(SanPhamDTO sp) {
        boolean check = spDAO.delete(sp) != 0;
        if (check) {
            listSP.remove(sp);
        }
        return check;
    }
    public boolean update(SanPhamDTO sp) {
        boolean check = spDAO.update(sp) != 0;
        if (check) {
            int index = getIndexById(sp.getMaSp());
            if (index != -1) {
                listSP.set(index, sp);
            }
        }
        return check;
    }
    public int getIndexById(String maSP) {
        for (int i = 0; i < listSP.size(); i++) {
            if (listSP.get(i).getMaSp().equals(maSP)) {
                return i;
            }
        }
        return -1;
    }

    public SanPhamDTO getByIndex(int index) {
        if (index < 0 || index >= listSP.size()) {
            return null;
        }
        return listSP.get(index);
    }
    public ArrayList<SanPhamDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<SanPhamDTO> result = new ArrayList<>();

        for (SanPhamDTO sp : listSP) {
            if (String.valueOf(sp.getMaSp()).contains(text)
                    || sp.getTenSp().toLowerCase().contains(text)) {
                result.add(sp);
            }
        }
        return result;
    }
    public boolean checkDup(String tenSP) {
        for (SanPhamDTO sp : listSP) {
            if (sp.getTenSp().equalsIgnoreCase(tenSP.trim())) {
                return false;
            }
        }
        return true;
    }
    public String getTenSp(String maSP) {
        int index = getIndexById(maSP);
        if (index == -1) {
            return null;
        }
        return listSP.get(index).getTenSp();
    }

    public String[] getArr() {
        String[] result = new String[listSP.size()];
        for (int i = 0; i < listSP.size(); i++) {
            result[i] = listSP.get(i).getTenSp();
        }
        return result;
    }
    //Lọc sản phẩm theo mã loại, mã hãng
    public List<SanPhamDTO> getFilterTable(int maLoai, int maHang) {

        List<SanPhamDTO> result = new ArrayList<>();

        for (SanPhamDTO e : spDAO.selectALL()) {

            boolean matchLoai = (maLoai == -1 || e.getMaLoai() == maLoai);
            boolean matchHang = (maHang == -1 || e.getMaHang() == maHang);

            if (matchLoai && matchHang) {
                result.add(e);
            }
        }

        return result;
    }
}
