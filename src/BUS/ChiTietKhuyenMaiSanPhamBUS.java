package BUS;

import DAO.ChiTietKhuyenMaiSanPhamDAO;
import DTO.ChiTietKhuyenMaiSanPhamDTO;
import java.util.ArrayList;

public class ChiTietKhuyenMaiSanPhamBUS {

    private ArrayList<ChiTietKhuyenMaiSanPhamDTO> list;
    private ChiTietKhuyenMaiSanPhamDAO dao;

    // Khởi tạo – load theo mã CTKM
    public ChiTietKhuyenMaiSanPhamBUS(String maCTKM) {
        dao = new ChiTietKhuyenMaiSanPhamDAO();
        list = dao.selectALL(maCTKM);
    }

    public ArrayList<ChiTietKhuyenMaiSanPhamDTO> getAll() {
        return list;
    }

    public int add(ChiTietKhuyenMaiSanPhamDTO t) {
        int result = dao.insert(t);
        if (result > 0) list.add(t);
        return result;
    }

    public int delete(ChiTietKhuyenMaiSanPhamDTO dto) {
        int index = getIndexById(dto.getMaCTKM(), dto.getMaSanPham());
        if (index == -1) return 0;

        int result = dao.delete(dto);

        if (result > 0) {
            list.remove(index);
        }
        return result;
    }


    public int update(ChiTietKhuyenMaiSanPhamDTO t) {
        int index = getIndexById(t.getMaCTKM(), t.getMaSanPham());
        if (index == -1) return 0;
        list.set(index, t);
        return 1;
    }

    public int getIndexById(String maCTKM, String maSanPham) {
        for (int i = 0; i < list.size(); i++) {
            ChiTietKhuyenMaiSanPhamDTO ct = list.get(i);
            if (ct.getMaCTKM().equals(maCTKM)
                    && ct.getMaSanPham().equals(maSanPham)) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietKhuyenMaiSanPhamDTO getByIndex(int index) {
        if (index < 0 || index >= list.size()) return null;
        return list.get(index);
    }

    public ArrayList<ChiTietKhuyenMaiSanPhamDTO> search(String key) {
        ArrayList<ChiTietKhuyenMaiSanPhamDTO> result = new ArrayList<>();
        for (ChiTietKhuyenMaiSanPhamDTO t : list) {
            if (t.getMaSanPham().contains(key)) {
                result.add(t);
            }
        }
        return result;
    }

    public int checkDup(String maCTKM, String maSanPham) {
        return getIndexById(maCTKM, maSanPham);
    }

    public String[] getArr() {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).getMaSanPham();
        }
        return arr;
    }
}
