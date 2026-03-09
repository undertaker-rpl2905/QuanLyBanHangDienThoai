package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

public class ChiTietPhieuNhapBUS {

    private final ChiTietPhieuNhapDAO ctpnDAO = ChiTietPhieuNhapDAO.getInstance();
    private ArrayList<ChiTietPhieuNhapDTO> listCTPN = new ArrayList<>();

    public ChiTietPhieuNhapBUS() {
        listCTPN = ctpnDAO.selectAll();
    }

    public ArrayList<ChiTietPhieuNhapDTO> getAll() {
        return listCTPN;
    }

    // Lấy chi tiết theo mã phiếu nhập
    public ArrayList<ChiTietPhieuNhapDTO> getAllByMaPN(int maPN) {

        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();

        for (ChiTietPhieuNhapDTO ct : listCTPN) {

            if (ct.getMaPHN() == maPN) {
                result.add(ct);
            }
        }

        return result;
    }

    // Thêm
    public boolean add(ChiTietPhieuNhapDTO ct) {

        boolean check = ctpnDAO.insert(ct) != 0;

        if (check) {
            listCTPN.add(ct);
        }

        return check;
    }

    // Xóa
    public boolean delete(ChiTietPhieuNhapDTO ct) {

        boolean check = ctpnDAO.delete(ct) != 0;

        if (check) {
            listCTPN.remove(ct);
        }

        return check;
    }

    // Sửa
    public boolean update(ChiTietPhieuNhapDTO ct) {

        boolean check = ctpnDAO.update(ct) != 0;

        if (check) {

            int index = getIndexById(ct.getMaPHN(), ct.getMaSP());

            if (index != -1) {
                listCTPN.set(index, ct);
            }
        }

        return check;
    }

    // Tìm index theo khóa kép
    public int getIndexById(int maPN, String maSP) {

        for (int i = 0; i < listCTPN.size(); i++) {

            if (listCTPN.get(i).getMaPHN() == maPN &&
                listCTPN.get(i).getMaSP().equalsIgnoreCase(maSP)) {

                return i;
            }
        }

        return -1;
    }

    // Lấy theo index
    public ChiTietPhieuNhapDTO getByIndex(int index) {

        if (index < 0 || index >= listCTPN.size()) {
            return null;
        }

        return listCTPN.get(index);
    }

    // Search
    public ArrayList<ChiTietPhieuNhapDTO> search(String text) {

        text = text.toLowerCase();

        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();

        for (ChiTietPhieuNhapDTO ct : listCTPN) {

            if (String.valueOf(ct.getMaPHN()).contains(text)
                    || ct.getMaSP().toLowerCase().contains(text)) {

                result.add(ct);
            }
        }

        return result;
    }

    // Kiểm tra trùng sản phẩm trong phiếu nhập
    public boolean checkDup(int maPN, String maSP) {

        for (ChiTietPhieuNhapDTO ct : listCTPN) {

            if (ct.getMaPHN() == maPN &&
                ct.getMaSP().equalsIgnoreCase(maSP.trim())) {

                return false;
            }
        }

        return true;
    }

    // Lấy tên hiển thị
    public String getTen(int maPN, String maSP) {

        int index = getIndexById(maPN, maSP);

        if (index == -1) {
            return null;
        }

        return listCTPN.get(index).getMaPHN() + " - " + listCTPN.get(index).getMaSP();
    }

    // Mảng cho combobox
    public String[] getArr() {

        String[] result = new String[listCTPN.size()];

        for (int i = 0; i < listCTPN.size(); i++) {

            result[i] = listCTPN.get(i).getMaPHN()
                    + "-"
                    + listCTPN.get(i).getMaSP();
        }

        return result;
    }
}
