package BUS;

import DAO.ChiTietKhuyenMaiHoaDonDAO;
import DTO.ChiTietKhuyenMaiHoaDonDTO;
import java.util.ArrayList;

public class ChiTietKhuyenMaiHoaDonBUS {

    private final ChiTietKhuyenMaiHoaDonDAO dao = new ChiTietKhuyenMaiHoaDonDAO();
    private ArrayList<ChiTietKhuyenMaiHoaDonDTO> listCTKM_HD = new ArrayList<>();

    // load theo mã CTKM
    public ChiTietKhuyenMaiHoaDonBUS(String maCTKM) {
        listCTKM_HD = dao.selectALL(maCTKM);
    }

    public ArrayList<ChiTietKhuyenMaiHoaDonDTO> getAll() {
        return listCTKM_HD;
    }

    public boolean add(ChiTietKhuyenMaiHoaDonDTO t) {
        boolean check = dao.insert(t) != 0;
        if (check) {
            listCTKM_HD.add(t);
        }
        return check;
    }

    public boolean delete(ChiTietKhuyenMaiHoaDonDTO dto) {
        boolean check = dao.delete(dto) != 0;
        if (check) {
            listCTKM_HD.remove(dto);
        }
        return check;
    }

    public boolean update(ChiTietKhuyenMaiHoaDonDTO t) {
        boolean check = dao.update(t) != 0;
        if (check) {
            int index = getIndexById(t.getMaCTKM(), t.getGiaTriToiThieu());
            if (index != -1) {
                listCTKM_HD.set(index, t);
            }
        }
        return check;
    }

    public int getIndexById(String maCTKM, double giaTriToiThieu) {
        for (int i = 0; i < listCTKM_HD.size(); i++) {
            ChiTietKhuyenMaiHoaDonDTO ct = listCTKM_HD.get(i);

            if (ct.getMaCTKM().equals(maCTKM)
                    && ct.getGiaTriToiThieu() == giaTriToiThieu) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietKhuyenMaiHoaDonDTO getByIndex(int index) {
        if (index < 0 || index >= listCTKM_HD.size()) {
            return null;
        }
        return listCTKM_HD.get(index);
    }

    public ArrayList<ChiTietKhuyenMaiHoaDonDTO> search(double minValue) {
        ArrayList<ChiTietKhuyenMaiHoaDonDTO> result = new ArrayList<>();

        for (ChiTietKhuyenMaiHoaDonDTO t : listCTKM_HD) {
            if (t.getGiaTriToiThieu() >= minValue) {
                result.add(t);
            }
        }

        return result;
    }

    public boolean checkDup(String maCTKM, double giaTriToiThieu) {
        return getIndexById(maCTKM, giaTriToiThieu) == -1;
    }

    public String[] getArr() {
        String[] arr = new String[listCTKM_HD.size()];

        for (int i = 0; i < listCTKM_HD.size(); i++) {
            arr[i] = listCTKM_HD.get(i).getGiaTriToiThieu() + "";
        }

        return arr;
    }
}