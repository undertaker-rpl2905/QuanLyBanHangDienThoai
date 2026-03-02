/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HangSanXuatDAO;
import DTO.HangSanXuatDTO;
import java.util.ArrayList;

public class HangSanXuatBUS {

    private ArrayList<HangSanXuatDTO> listHSX;
    private final HangSanXuatDAO hsxDAO = HangSanXuatDAO.getInstance();

    public HangSanXuatBUS() {
        listHSX = hsxDAO.selectALL();
    }

    // getAll() – lấy toàn bộ dữ liệu
    public ArrayList<HangSanXuatDTO> getAll() {
        return listHSX;
    }
    public int generateMaHang() {
        int lastMa = hsxDAO.getLastMaHang();
        if (lastMa == 0) {
            return 1;
        }
        return lastMa + 1;
    }

    // ===================== CRUD =====================
    // add() – thêm
    public boolean add(HangSanXuatDTO hsx) {
        hsx.setMaHang(generateMaHang());
        boolean check = hsxDAO.insert(hsx) != 0;
        if (check) {
            listHSX.add(hsx);
        }
        return check;
    }

    // delete() – xóa
    public boolean delete(HangSanXuatDTO hsx) {
        boolean check = hsxDAO.delete(hsx) != 0;
        if (check) {
            listHSX.remove(hsx);
        }
        return check;
    }

    // update() – sửa
    public boolean update(HangSanXuatDTO hsx) {
        boolean check = hsxDAO.update(hsx) != 0;
        if (check) {
            int index = getIndexById(hsx.getMaHang());
            if (index != -1) {
                listHSX.set(index, hsx);
            }
        }
        return check;
    }

    // getIndexById() – tìm vị trí theo mã
    public int getIndexById(int maHang) {
        for (int i = 0; i < listHSX.size(); i++) {
            if (listHSX.get(i).getMaHang()==(maHang)) {
                return i;
            }
        }
        return -1;
    }

    // getByIndex() – lấy phần tử theo vị trí
     public HangSanXuatDTO getByIndex(int index) {
        if (index < 0 || index >= listHSX.size()) {
            return null;
        }
        return listHSX.get(index);
    }

    // search() – tìm theo điều kiện (mã, tên)
    public ArrayList<HangSanXuatDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<HangSanXuatDTO> result = new ArrayList<>();

        for (HangSanXuatDTO hsx : listHSX) {
            if (String.valueOf(hsx.getMaHang()).contains(text) || hsx.getTenHang().toLowerCase().contains(text)) {
                result.add(hsx);
            }
        }
        return result;
    }


    // checkDup() – kiểm tra trùng dữ liệu
    public boolean checkDup(String tenHang) {
        for (HangSanXuatDTO hsx : listHSX) {
            if (hsx.getTenHang().equalsIgnoreCase(tenHang.trim())) {
                return false;
            }
        }
        return true;
    }

    public String getTenHang(int maHang) {
        int index = getIndexById(maHang);
        if (index == -1) {
            return null;
        }
        return listHSX.get(index).getTenHang();
    }


    public String[] getArr() {
        String[] result = new String[listHSX.size()];
        for (int i = 0; i < listHSX.size(); i++) {
            result[i] = listHSX.get(i).getTenHang();
        }
        return result;
    }
    public int getMaByTen(String tenHang) {
    for (HangSanXuatDTO h : hsxDAO.selectALL()) {
        if (h.getTenHang().equalsIgnoreCase(tenHang)) {
            return h.getMaHang();
        }
    }
    return -1;
}
}

