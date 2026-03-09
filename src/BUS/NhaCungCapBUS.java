package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    
    private final NhaCungCapDAO dao = NhaCungCapDAO.getInstance();
    private ArrayList<NhaCungCapDTO> list = new ArrayList<>();
    
    public NhaCungCapBUS() {
        list = dao.selectALL();
    }
    
    public ArrayList<NhaCungCapDTO> getAll() {
        return list;
    }
    
    public int generateID() {
        if (list.isEmpty()) {
            return 1;
        }
        
        int maxID = list.get(0).getMaNCC();
        for (NhaCungCapDTO dto : list) {
            if (dto.getMaNCC() > maxID) {
                maxID = dto.getMaNCC();
            }
        }
        return maxID + 1;  
    }
    
    public boolean add(NhaCungCapDTO dto) {
        dto.setMaNCC(generateID());
        boolean rs = dao.insert(dto) != 0;
        if (rs) {
            list.add(dto);
        }
        return rs;
    }
    
    public boolean delete(NhaCungCapDTO dto) {
        boolean rs = dao.delete(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaNCC());
            if (index != -1) {
                list.remove(index);
            }
        }
        return rs;
    }

    public boolean update(NhaCungCapDTO dto) {
        boolean rs = dao.update(dto) != 0;
        if (rs) {
            int index = getIndexById(dto.getMaNCC());
            if (index != -1) {
                list.set(index, dto);
            }
        }
        return rs;
    }

    public int getIndexById(int maNCC) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNCC() == maNCC) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkDup(String tenNCC) {
        for (NhaCungCapDTO dto : list) {
            if (dto.getTenNCC().equalsIgnoreCase(tenNCC.trim())) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<NhaCungCapDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        
        for (NhaCungCapDTO dto : list) {
            if (String.valueOf(dto.getMaNCC()).contains(text)
                    || dto.getTenNCC().toLowerCase().contains(text)
                    || dto.getSDT().contains(text)) {
                result.add(dto);
            }
        }
        return result;
    }
    
    public String getTenNCC(int maNCC) {
        int index = getIndexById(maNCC);
        if (index == -1) {
            return null;
        }
        return list.get(index).getTenNCC();
    }

    public String[] getArr() {
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getTenNCC();
        }
        return result;
    }
}