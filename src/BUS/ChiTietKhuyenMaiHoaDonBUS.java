package BUS;

import DAO.ChiTietKhuyenMaiHoaDonDAO;
import DTO.ChiTietKhuyenMaiHoaDonDTO;
import java.util.ArrayList;

public class ChiTietKhuyenMaiHoaDonBUS {

    private ArrayList<ChiTietKhuyenMaiHoaDonDTO> list;
    private ChiTietKhuyenMaiHoaDonDAO dao;

    // Khởi tạo – load theo mã CTKM
    public ChiTietKhuyenMaiHoaDonBUS(String maCTKM) {
        dao = new ChiTietKhuyenMaiHoaDonDAO();
        list = dao.selectALL(maCTKM);
    }

    public ArrayList<ChiTietKhuyenMaiHoaDonDTO> getAll() {
        return list;
    }

    public int add(ChiTietKhuyenMaiHoaDonDTO t) {
        int result = dao.insert(t);
        if (result > 0) list.add(t);
        return result;
    }

    public int delete(ChiTietKhuyenMaiHoaDonDTO dto) {
        int index = getIndexById(dto.getMaCTKM(), dto.getGiaTriToiThieu());
        if (index == -1) return 0;

        int result = dao.delete(dto);

        if (result > 0) {
            list.remove(index);
        }

        return result;
    }

    public int update(ChiTietKhuyenMaiHoaDonDTO t) {
        int index = getIndexById(t.getMaCTKM(), t.getGiaTriToiThieu());
        if (index == -1) return 0;
        list.set(index, t);
        return 1; // thường bảng chi tiết ít update
    }

    public int getIndexById(String maCTKM, double giaTriToiThieu) {
        for (int i = 0; i < list.size(); i++) {
            ChiTietKhuyenMaiHoaDonDTO ct = list.get(i);
            if (ct.getMaCTKM().equals(maCTKM)
                    && ct.getGiaTriToiThieu() == giaTriToiThieu) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietKhuyenMaiHoaDonDTO getByIndex(int index) {
        if (index < 0 || index >= list.size()) return null;
        return list.get(index);
    }

    public ArrayList<ChiTietKhuyenMaiHoaDonDTO> search(double minValue) {
        ArrayList<ChiTietKhuyenMaiHoaDonDTO> result = new ArrayList<>();
        for (ChiTietKhuyenMaiHoaDonDTO t : list) {
            if (t.getGiaTriToiThieu() >= minValue) {
                result.add(t);
            }
        }
        return result;
    }

    public int checkDup(String maCTKM, double giaTriToiThieu) {
        return getIndexById(maCTKM, giaTriToiThieu);
    }

    public String[] getArr() {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).getGiaTriToiThieu() + "";
        }
        return arr;
    }
}
