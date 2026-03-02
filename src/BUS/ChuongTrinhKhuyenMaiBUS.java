package BUS;

import DAO.ChuongTrinhKhuyenMaiDAO;
import DTO.ChuongTrinhKhuyenMaiDTO;
import java.util.ArrayList;

public class ChuongTrinhKhuyenMaiBUS {

    private ArrayList<ChuongTrinhKhuyenMaiDTO> list;
    private ChuongTrinhKhuyenMaiDAO dao;

    // Khởi tạo – load dữ liệu
    public ChuongTrinhKhuyenMaiBUS() {
        dao = new ChuongTrinhKhuyenMaiDAO();
        list = dao.selectALL();
    }

    // Lấy toàn bộ danh sách
    public ArrayList<ChuongTrinhKhuyenMaiDTO> getAll() {
        return list;
    }

    // Thêm
    public int add(ChuongTrinhKhuyenMaiDTO t) {
        if (checkDup(t.getMaCTKM()) != -1) return 0;
        int result = dao.insert(t);
        if (result > 0) list.add(t);
        return result;
    }

    // Xóa
    public int delete(String maCTKM) {
        int index = getIndexById(maCTKM);
        if (index == -1) return 0;
        int result = dao.delete(list.get(index));
        if (result > 0) list.remove(index);
        return result;
    }

    // Sửa
    public int update(ChuongTrinhKhuyenMaiDTO t) {
        int index = getIndexById(t.getMaCTKM());
        if (index == -1) return 0;
        int result = dao.update(t);
        if (result > 0) list.set(index, t);
        return result;
    }

    // Tìm vị trí theo mã
    public int getIndexById(String maCTKM) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaCTKM().equals(maCTKM)) {
                return i;
            }
        }
        return -1;
    }

    // Lấy phần tử theo vị trí
    public ChuongTrinhKhuyenMaiDTO getByIndex(int index) {
        if (index < 0 || index >= list.size()) return null;
        return list.get(index);
    }

    // Tìm kiếm theo mã hoặc tên
    public ArrayList<ChuongTrinhKhuyenMaiDTO> search(String key) {
        ArrayList<ChuongTrinhKhuyenMaiDTO> result = new ArrayList<>();
        for (ChuongTrinhKhuyenMaiDTO t : list) {
            if (t.getMaCTKM().toLowerCase().contains(key.toLowerCase())
                    || t.getTenCTKM().toLowerCase().contains(key.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    // Kiểm tra trùng mã
    public int checkDup(String maCTKM) {
        return getIndexById(maCTKM);
    }

    // Lấy tên theo mã
    public String getTen(String maCTKM) {
        int index = getIndexById(maCTKM);
        return index != -1 ? list.get(index).getTenCTKM() : "";
    }

    // Trả mảng tên cho combobox
    public String[] getArr() {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).getTenCTKM();
        }
        return arr;
    }
}
