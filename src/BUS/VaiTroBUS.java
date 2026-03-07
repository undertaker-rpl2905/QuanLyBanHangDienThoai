package BUS;

import DAO.VaiTroDAO;
import DTO.VaiTroDTO;
import java.util.ArrayList;

public class VaiTroBUS {

    private final VaiTroDAO dao = VaiTroDAO.getInstance();
    private ArrayList<VaiTroDTO> list = new ArrayList<>();

    public VaiTroBUS() {
        list = dao.selectALL();
    }

    public ArrayList<VaiTroDTO> getAll() {
        return list;
    }

    public void refresh() {
        list = dao.selectALL();
    }

    public boolean add(VaiTroDTO dto) {
        if (!checkDupMa(dto.getMaVaiTro()) || !checkDupTen(dto.getTenVaiTro())) {
            return false;
        }
        boolean rs = dao.insert(dto) != 0;
        if (rs) {
            list.add(dto);
        }
        return rs;
    }

    public boolean delete(VaiTroDTO dto) {
        boolean rs = dao.delete(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaVaiTro());
            if (index != -1) {
                list.remove(index);
            }
        }
        return rs;
    }

    public boolean update(VaiTroDTO dto) {
        boolean rs = dao.update(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaVaiTro());
            if (index != -1) {
                list.set(index, dto);
            }
        }
        return rs;
    }

    public int getIndexById(String maVaiTro) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaVaiTro().equalsIgnoreCase(maVaiTro)) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkDupMa(String maVaiTro) {
        for (VaiTroDTO dto : list) {
            if (dto.getMaVaiTro().equalsIgnoreCase(maVaiTro)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDupTen(String tenVaiTro) {
        for (VaiTroDTO dto : list) {
            if (dto.getTenVaiTro().equalsIgnoreCase(tenVaiTro)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<VaiTroDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<VaiTroDTO> result = new ArrayList<>();

        for (VaiTroDTO dto : list) {
            if (dto.getMaVaiTro().toLowerCase().contains(text)
                    || dto.getTenVaiTro().toLowerCase().contains(text)) {
                result.add(dto);
            }
        }
        return result;
    }

    public String[] getArrTenVaiTro() {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getMaVaiTro() + " - " + list.get(i).getTenVaiTro();
        }
        return result;
    }

    public String getTenVaiTro(String maVaiTro) {
        int index = getIndexById(maVaiTro);
        if (index == -1) {
            return null;
        }
        return list.get(index).getTenVaiTro();
    }
}