package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {

    private final PhieuNhapDAO pnDAO = PhieuNhapDAO.getInstance();
    private ArrayList<PhieuNhapDTO> listPN = new ArrayList<>();

    public PhieuNhapBUS() {
        listPN = pnDAO.selectALL();
    }

    public ArrayList<PhieuNhapDTO> getAll() {
        return listPN;
    }

    // Tạo mã phiếu nhập
    public int generateID() {

        if (listPN.isEmpty()) {
            return 1;
        }

        int maxID = listPN.get(0).getMaPHN();

        for (PhieuNhapDTO pn : listPN) {

            if (pn.getMaPHN() > maxID) {
                maxID = pn.getMaPHN();
            }
        }

        return maxID + 1;
    }

    // Thêm
    public boolean add(PhieuNhapDTO pn) {

        pn.setMaPHN(generateID());

        boolean check = pnDAO.insert(pn) != 0;

        if (check) {
            listPN.add(pn);
        }

        return check;
    }

    // Xóa
    public boolean delete(PhieuNhapDTO pn) {

        boolean check = pnDAO.delete(pn) != 0;

        if (check) {

            int index = getIndexById(pn.getMaPHN());

            if (index != -1) {
                listPN.remove(index);
            }
        }

        return check;
    }

    // Sửa
    public boolean update(PhieuNhapDTO pn) {

        boolean check = pnDAO.update(pn) != 0;

        if (check) {

            int index = getIndexById(pn.getMaPHN());

            if (index != -1) {
                listPN.set(index, pn);
            }
        }

        return check;
    }

    // Tìm index
    public int getIndexById(int maPN) {

        for (int i = 0; i < listPN.size(); i++) {

            if (listPN.get(i).getMaPHN() == maPN) {
                return i;
            }
        }

        return -1;
    }

    // Lấy theo index
    public PhieuNhapDTO getByIndex(int index) {

        if (index < 0 || index >= listPN.size()) {
            return null;
        }

        return listPN.get(index);
    }

    // Search
    public ArrayList<PhieuNhapDTO> search(String text) {

        text = text.toLowerCase();
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();

        for (PhieuNhapDTO pn : listPN) {

            if (String.valueOf(pn.getMaPHN()).contains(text)
                || String.valueOf(pn.getMaNCC()).contains(text)) {

                result.add(pn);
            }
        }

        return result;
    }

    // Kiểm tra trùng
    public boolean checkDup(int maPN) {

        for (PhieuNhapDTO pn : listPN) {

            if (pn.getMaPHN() == maPN) {
                return false;
            }
        }

        return true;
    }

    // Lấy mã PN
    public int getMaPN(int maPN) {

        int index = getIndexById(maPN);

        if (index == -1) {
            return -1;
        }

        return listPN.get(index).getMaPHN();
    }

    // Mảng cho combobox
    public String[] getArr() {

        String[] result = new String[listPN.size()];

        for (int i = 0; i < listPN.size(); i++) {

            result[i] = String.valueOf(listPN.get(i).getMaPHN());
        }

        return result;
    }
}
