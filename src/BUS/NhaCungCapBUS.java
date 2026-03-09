package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {

    private final NhaCungCapDAO nccDAO = NhaCungCapDAO.getInstance();
    private ArrayList<NhaCungCapDTO> listNCC = new ArrayList<>();

    public NhaCungCapBUS() {
        listNCC = nccDAO.selectALL();
    }

    public ArrayList<NhaCungCapDTO> getAll() {
        return listNCC;
    }

    // Tạo mã NCC
    public int generateID() {

        if (listNCC.isEmpty()) {
            return 1;
        }

        int maxID = listNCC.get(0).getMaNCC();

        for (NhaCungCapDTO ncc : listNCC) {

            if (ncc.getMaNCC() > maxID) {
                maxID = ncc.getMaNCC();
            }
        }

        return maxID + 1;
    }

    // Thêm
    public boolean add(NhaCungCapDTO ncc) {

        ncc.setMaNCC(generateID());

        boolean check = nccDAO.insert(ncc) != 0;

        if (check) {
            listNCC.add(ncc);
        }

        return check;
    }

    // Xóa
    public boolean delete(NhaCungCapDTO ncc) {

        boolean check = nccDAO.delete(ncc) != 0;

        if (check) {

            int index = getIndexById(ncc.getMaNCC());

            if (index != -1) {
                listNCC.remove(index);
            }
        }

        return check;
    }

    // Sửa
    public boolean update(NhaCungCapDTO ncc) {

        boolean check = nccDAO.update(ncc) != 0;

        if (check) {

            int index = getIndexById(ncc.getMaNCC());

            if (index != -1) {
                listNCC.set(index, ncc);
            }
        }

        return check;
    }

    // Tìm index theo mã
    public int getIndexById(int maNCC) {

        for (int i = 0; i < listNCC.size(); i++) {

            if (listNCC.get(i).getMaNCC() == maNCC) {
                return i;
            }
        }

        return -1;
    }

    // Lấy theo index
    public NhaCungCapDTO getByIndex(int index) {

        if (index < 0 || index >= listNCC.size()) {
            return null;
        }

        return listNCC.get(index);
    }

    // Search
    public ArrayList<NhaCungCapDTO> search(String text) {

        text = text.toLowerCase();
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();

        for (NhaCungCapDTO ncc : listNCC) {

            if (String.valueOf(ncc.getMaNCC()).contains(text)
                    || ncc.getTenNCC().toLowerCase().contains(text)
                    || ncc.getSDT().contains(text)) {

                result.add(ncc);
            }
        }

        return result;
    }

    // Kiểm tra trùng tên
    public boolean checkDup(String tenNCC) {

        for (NhaCungCapDTO ncc : listNCC) {

            if (ncc.getTenNCC().equalsIgnoreCase(tenNCC.trim())) {
                return false;
            }
        }

        return true;
    }

    // Lấy tên NCC
    public String getTenNCC(int maNCC) {

        int index = getIndexById(maNCC);

        if (index == -1) {
            return null;
        }

        return listNCC.get(index).getTenNCC();
    }

    // Mảng cho combobox
    public String[] getArr() {

        String[] result = new String[listNCC.size()];

        for (int i = 0; i < listNCC.size(); i++) {

            result[i] = listNCC.get(i).getTenNCC();
        }

        return result;
    }
}
