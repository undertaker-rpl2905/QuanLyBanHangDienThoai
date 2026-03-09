package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {

    private final TaiKhoanDAO dao = TaiKhoanDAO.getInstance();
    private ArrayList<TaiKhoanDTO> list = new ArrayList<>();

    public TaiKhoanBUS() {
        list = dao.selectALL();
    }

    public ArrayList<TaiKhoanDTO> getAll() {
        return list;
    }

    public void refresh() {
        list = dao.selectALL();
    }

    public boolean add(TaiKhoanDTO dto) {
        if (!checkDupMa(dto.getMaTaiKhoan()) || !checkDupTenDangNhap(dto.getTenDangNhap())) {
            return false;
        }
        boolean rs = dao.insert(dto) != 0;
        if (rs) {
            list.add(dto);
        }
        return rs;
    }

    public boolean delete(TaiKhoanDTO dto) {
        boolean rs = dao.delete(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaTaiKhoan());
            if (index != -1) {
                list.remove(index);
            }
        }
        return rs;
    }

    public boolean update(TaiKhoanDTO dto) {
        boolean rs = dao.update(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaTaiKhoan());
            if (index != -1) {
                list.set(index, dto);
            }
        }
        return rs;
    }

    public int getIndexById(String maTaiKhoan) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaTaiKhoan().equalsIgnoreCase(maTaiKhoan)) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkDupMa(String maTaiKhoan) {
        for (TaiKhoanDTO dto : list) {
            if (dto.getMaTaiKhoan().equalsIgnoreCase(maTaiKhoan)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDupTenDangNhap(String tenDangNhap) {
        for (TaiKhoanDTO dto : list) {
            if (dto.getTenDangNhap().equalsIgnoreCase(tenDangNhap)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<TaiKhoanDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();

        for (TaiKhoanDTO dto : list) {
            if (dto.getMaTaiKhoan().toLowerCase().contains(text)
                    || dto.getTenDangNhap().toLowerCase().contains(text)
                    || dto.getMaNhanVien().toLowerCase().contains(text)
                    || dto.getMaVaiTro().toLowerCase().contains(text)) {
                result.add(dto);
            }
        }
        return result;
    }

    public TaiKhoanDTO login(String tenDangNhap, String matKhau) {
        for (TaiKhoanDTO dto : list) {
            if (dto.getTenDangNhap().equalsIgnoreCase(tenDangNhap)
                    && dto.getMatKhau().equals(matKhau)) {
                return dto;
            }
        }
        return null;
    }

    public String[] getArrTenDangNhap() {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getTenDangNhap();
        }
        return result;
    }
}