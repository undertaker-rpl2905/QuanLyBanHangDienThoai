package GUI.Panel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class NhaCungCap extends JPanel {

    public NhaCungCap() {
        initUI();
    }

    private void initUI() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10,10,10,10));
        
        //PANEL
        JPanel pnlTop = new JPanel();
        JPanel pnlTopLeft = new JPanel();
        JPanel pnlTopRight = new JPanel();
        
        JPanel pnlMain = new JPanel();
        pnlMain.setBackground(Color.RED);
        JPanel pnlMainLeft = new JPanel();
        JPanel pnlMainRight = new JPanel();
        
        add(pnlTop, BorderLayout.NORTH);
        add(pnlMain, BorderLayout.CENTER);
        
        //TOP PANEL
        pnlTop.setLayout(new BorderLayout());
        pnlTop.add(pnlTopLeft, BorderLayout.WEST);
        pnlTop.add(pnlTopRight, BorderLayout.EAST);
        
        //LEFT
        FontIcon iconThem = new FontIcon();
        iconThem.setIkon(FontAwesomeSolid.PLUS);
        iconThem.setIconSize(20);
        iconThem.setIconColor(Color.decode("#3fa159"));
        
        FontIcon iconSua = new FontIcon();
        iconSua.setIkon(FontAwesomeSolid.HAMMER);
        iconSua.setIconSize(20);
        iconSua.setIconColor(Color.decode("#b3b354"));
        
        FontIcon iconXoa = new FontIcon();
        iconXoa.setIkon(FontAwesomeSolid.MINUS_CIRCLE);
        iconXoa.setIconSize(20);
        iconXoa.setIconColor(Color.decode("#9e1919"));
        
        FontIcon iconXuatFile = new FontIcon();
        iconXuatFile.setIkon(FontAwesomeSolid.FILE_EXPORT);
        iconXuatFile.setIconSize(20);
        iconXuatFile.setIconColor(Color.decode("#5242b8"));
        
        JButton btnTopThem = new JButton("Thêm", iconThem);
        JButton btnTopSua = new JButton("Sửa", iconSua);
        JButton btnTopXoa = new JButton("Xóa", iconXoa);
        JButton btnTopXuatFile = new JButton("Xuất file", iconXuatFile);
        
        pnlTopLeft.add(btnTopThem);
        pnlTopLeft.add(btnTopSua);
        pnlTopLeft.add(btnTopXoa);
        pnlTopLeft.add(btnTopXuatFile);
                
        //RIGHT
        JTextField txtTimKiem = new JTextField("Nhập mã nhà cung cấp");
        txtTimKiem.setPreferredSize(new Dimension(200,32));
        
        FontIcon iconLamMoi = new FontIcon();
        iconLamMoi.setIkon(FontAwesomeSolid.SYNC_ALT);
        iconLamMoi.setIconSize(20);
        JButton btnTopLamMoi = new JButton("Làm mới", iconLamMoi);
        
        pnlTopRight.add(txtTimKiem);
        pnlTopRight.add(btnTopLamMoi);
            
        //MAIN PANEL
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setLayout(new BorderLayout(10,0));
        pnlMain.setBorder(new EmptyBorder(10,0,0,0));
        
        pnlMain.add(pnlMainLeft, BorderLayout.WEST);
        pnlMain.add(pnlMainRight, BorderLayout.CENTER);

        //Main Left
        pnlMainLeft.setPreferredSize(new Dimension(250,0));
        pnlMainLeft.setBorder(new EmptyBorder(0,10,0,0));
        
        
    }
}

