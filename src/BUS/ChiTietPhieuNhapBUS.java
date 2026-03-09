package BUS;


import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

public class ChiTietPhieuNhapBUS {

    private final ChiTietPhieuNhapDAO dao = ChiTietPhieuNhapDAO.getInstance();
    private ArrayList<ChiTietPhieuNhapDTO> list = new ArrayList<>();

    public ChiTietPhieuNhapBUS() {
    }

    public ArrayList<ChiTietPhieuNhapDTO> getAll(String maPHN) {
        list = dao.selectALL(maPHN);
        return list;
    }

    public boolean add(ChiTietPhieuNhapDTO dto) {
        boolean rs = dao.insert(dto) != 0;
        if (rs) {
            list.add(dto);
        }
        return rs;
    }

    public boolean delete(ChiTietPhieuNhapDTO dto) {
        boolean rs = dao.delete(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaPHN(), dto.getMaSP());
            if (index != -1) {
                list.remove(index);
            }
        }
        return rs;
    }

    public boolean update(ChiTietPhieuNhapDTO dto) {
        boolean rs = dao.update(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaPHN(), dto.getMaSP());
            if (index != -1) {
                list.set(index, dto);
            }
        }
        return rs;
    }

    public int getIndexById(int maPHN, String maSP) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaPHN() == maPHN && list.get(i).getMaSP().equals(maSP)) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkDup(String maSP) {
        for (ChiTietPhieuNhapDTO dto : list) {
            if (dto.getMaSP().equals(maSP)) {
                return false;
            }
        }
        return true;
    }
}