package BUS;

import DAO.ChiTietKhuyenMaiSanPhamDAO;
import DTO.ChiTietKhuyenMaiSanPhamDTO;
import java.util.ArrayList;

public class ChiTietKhuyenMaiSanPhamBUS {

    private final ChiTietKhuyenMaiSanPhamDAO dao = new ChiTietKhuyenMaiSanPhamDAO();
    private ArrayList<ChiTietKhuyenMaiSanPhamDTO> listCTKM_SP = new ArrayList<>();

    // load theo mã CTKM
    public ChiTietKhuyenMaiSanPhamBUS(String maCTKM) {
        listCTKM_SP = dao.selectALL(maCTKM);
    }

    public ArrayList<ChiTietKhuyenMaiSanPhamDTO> getAll() {
        return listCTKM_SP;
    }

    public boolean add(ChiTietKhuyenMaiSanPhamDTO t) {
        boolean check = dao.insert(t) != 0;
        if (check) {
            listCTKM_SP.add(t);
        }
        return check;
    }

    public boolean delete(ChiTietKhuyenMaiSanPhamDTO dto) {
        boolean check = dao.delete(dto) != 0;
        if (check) {
            listCTKM_SP.remove(dto);
        }
        return check;
    }

    public boolean update(ChiTietKhuyenMaiSanPhamDTO t) {
        boolean check = dao.update(t) != 0;
        if (check) {
            int index = getIndexById(t.getMaCTKM(), t.getMaSanPham());
            if (index != -1) {
                listCTKM_SP.set(index, t);
            }
        }
        return check;
    }

    public int getIndexById(String maCTKM, String maSanPham) {
        for (int i = 0; i < listCTKM_SP.size(); i++) {
            ChiTietKhuyenMaiSanPhamDTO ct = listCTKM_SP.get(i);
            if (ct.getMaCTKM().equals(maCTKM)
                    && ct.getMaSanPham().equals(maSanPham)) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietKhuyenMaiSanPhamDTO getByIndex(int index) {
        if (index < 0 || index >= listCTKM_SP.size()) {
            return null;
        }
        return listCTKM_SP.get(index);
    }

    public ArrayList<ChiTietKhuyenMaiSanPhamDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<ChiTietKhuyenMaiSanPhamDTO> result = new ArrayList<>();

        for (ChiTietKhuyenMaiSanPhamDTO t : listCTKM_SP) {
            if (t.getMaSanPham().toLowerCase().contains(text)) {
                result.add(t);
            }
        }

        return result;
    }

    public boolean checkDup(String maCTKM, String maSanPham) {
        return getIndexById(maCTKM, maSanPham) == -1;
    }

    public String[] getArr() {
        String[] arr = new String[listCTKM_SP.size()];
        for (int i = 0; i < listCTKM_SP.size(); i++) {
            arr[i] = listCTKM_SP.get(i).getMaSanPham();
        }
        return arr;
    }
}