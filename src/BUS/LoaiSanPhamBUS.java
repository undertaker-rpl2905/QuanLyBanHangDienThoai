/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiSanPhamDAO;
import DTO.LoaiSanPhamDTO;
import java.util.ArrayList;

public class LoaiSanPhamBUS {

    private final LoaiSanPhamDAO lspDAO = new LoaiSanPhamDAO();
    private ArrayList<LoaiSanPhamDTO> listLSP = new ArrayList<>();

    public LoaiSanPhamBUS() {
        listLSP = lspDAO.selectALL();
    }

    public ArrayList<LoaiSanPhamDTO> getAll() {
        return listLSP;
    }
    public int generateMaLoai() {
        int lastMa = lspDAO.getLastMaLoai();
        if (lastMa == 0) {
            return 1;
        }
        return lastMa + 1;
    }


    public boolean add(LoaiSanPhamDTO lsp) {
        lsp.setMaLoai(generateMaLoai());
        boolean check = lspDAO.insert(lsp) != 0;
        if (check) {
            listLSP.add(lsp);
        }
        return check;
    }


    public boolean delete(LoaiSanPhamDTO lsp) {
        boolean check = lspDAO.delete(lsp) != 0;
        if (check) {
            int index = getIndexById(lsp.getMaLoai());
            if (index != -1) {
                listLSP.remove(index);
            }
        }
        return check;
    }

    public boolean update(LoaiSanPhamDTO lsp) {
        boolean check = lspDAO.update(lsp) != 0;
        if (check) {
            int index = getIndexById(lsp.getMaLoai());
            if (index != -1) {
                listLSP.set(index, lsp);
            }
        }
        return check;
    }


    // Tìm vị trí theo mã
    public int getIndexById(int maLoai) {
        for (int i = 0; i < listLSP.size(); i++) {
            if (listLSP.get(i).getMaLoai() == maLoai) {
                return i;
            }
        }
        return -1;
    }

    // Lấy theo vị trí
    public LoaiSanPhamDTO getByIndex(int index) {
        if (index < 0 || index >= listLSP.size()) {
            return null;
        }
        return listLSP.get(index);
    }

    // Tìm kiếm theo mã hoặc tên
    public ArrayList<LoaiSanPhamDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<LoaiSanPhamDTO> result = new ArrayList<>();

        for (LoaiSanPhamDTO lsp : listLSP) {
            if (String.valueOf(lsp.getMaLoai()).contains(text)
                    || lsp.getTenLoai().toLowerCase().contains(text)) {
                result.add(lsp);
            }
        }
        return result;
    }

    public boolean checkDup(String tenLoai) {
        for (LoaiSanPhamDTO lsp : listLSP) {
            if (lsp.getTenLoai().equalsIgnoreCase(tenLoai.trim())) {
                return false;
            }
        }
        return true;
    }
    public String getTenLoaiSp(int maLoai) {
        int index = getIndexById(maLoai);
        if (index == -1) {
            return null;
        }
        return listLSP.get(index).getTenLoai();
    }

    public String[] getArr() {
        String[] result = new String[listLSP.size()];
        for (int i = 0; i < listLSP.size(); i++) {
            result[i] = listLSP.get(i).getTenLoai();
        }
        return result;
    }
    public int getMaByTen(String tenLoai) {
        for (LoaiSanPhamDTO l : lspDAO.selectALL()) {
            if (l.getTenLoai().equalsIgnoreCase(tenLoai)) {
                return l.getMaLoai();
            }
        }
        return -1; // không tìm thấy
    }
}

