/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import java.util.ArrayList;
import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;

/**
 *
 * @author admin
 */
public class PhieuNhapBUS {
    private static PhieuNhapDAO dao = PhieuNhapDAO.getInstance();
    private ArrayList<PhieuNhapDTO> list = new ArrayList<>();
    
    public PhieuNhapBUS(){
        list = dao.selectALL();
    }
    
    public int generateID(){
        if(list.isEmpty()){
            return 1;
        }
        
        int maxID = list.get(0).getMaPHN();
        for(PhieuNhapDTO dto : list){
            if(dto.getMaPHN() > maxID){
                maxID = dto.getMaPHN();
            }
        }
        return maxID + 1;
    }
    
    public boolean add(PhieuNhapDTO dto){
        dto.setMaPHN(generateID());
        boolean rs = dao.insert(dto) != 0;
        if(rs){
            list.add(dto);
        }
        return rs;
    }
}
