/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author user
 */

import DAO.BaoHanhDAO;
import DTO.BaoHanhDTO;
import java.util.ArrayList;

public class BaoHanhBUS {

    private final BaoHanhDAO bhDAO = new BaoHanhDAO();
    private ArrayList<BaoHanhDTO> listBH = new ArrayList<>();

    public BaoHanhBUS() {
        listBH = bhDAO.selectALL();
    }

    public ArrayList<BaoHanhDTO> getAll() {
        return listBH;
    }

    public String generateMaBH() {
        String lastMa = bhDAO.getLastMaBH();
        if (lastMa == null) {
            return "BH001";
        }
        int so = Integer.parseInt(lastMa.substring(2));
        so++;
        return String.format("BH%03d", so);
    }

    public boolean add(BaoHanhDTO bh) {
        bh.setMaBH(generateMaBH());
        boolean check = bhDAO.insert(bh) != 0;
        if (check) {
            listBH.add(bh);
        }
        return check;
    }

    public boolean delete(BaoHanhDTO bh) {
        boolean check = bhDAO.delete(bh) != 0;
        if (check) {
            int index = getIndexById(bh.getMaBH());
            if (index != -1) {
                listBH.remove(index);
            }
        }
        return check;
    }

    public boolean update(BaoHanhDTO bh) {
        boolean check = bhDAO.update(bh) != 0;
        if (check) {
            int index = getIndexById(bh.getMaBH());
            if (index != -1) {
                listBH.set(index, bh);
            }
        }
        return check;
    }

    public int getIndexById(String maBH) {
        for (int i = 0; i < listBH.size(); i++) {
            if (listBH.get(i).getMaBH().equals(maBH)) {
                return i;
            }
        }
        return -1;
    }

    public BaoHanhDTO getByIndex(int index) {
        if (index < 0 || index >= listBH.size()) {
            return null;
        }
        return listBH.get(index);
    }

    public ArrayList<BaoHanhDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<BaoHanhDTO> result = new ArrayList<>();

        for (BaoHanhDTO bh : listBH) {
            if (bh.getMaBH().toLowerCase().contains(text)
                    || bh.getTenBH().toLowerCase().contains(text)) {
                result.add(bh);
            }
        }
        return result;
    }

    public boolean checkDup(String tenBH) {
        for (BaoHanhDTO bh : listBH) {
            if (bh.getTenBH().equalsIgnoreCase(tenBH.trim())) {
                return false;
            }
        }
        return true;
    }

    public String getTenBH(String maBH) {
        int index = getIndexById(maBH);
        if (index == -1) {
            return null;
        }
        return listBH.get(index).getTenBH();
    }

    public String[] getArr() {
        String[] result = new String[listBH.size()];
        for (int i = 0; i < listBH.size(); i++) {
            result[i] = listBH.get(i).getTenBH();
        }
        return result;
    }
}

