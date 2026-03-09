package GUI.Panel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class PhieuNhap extends JPanel {
    public PhieuNhap(){
        initUI();
    }
    
    public void initUI(){
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10,10,10,10));
        
        //PANEL
        JPanel pnlTopBar = new JPanel();
        pnlTopBar.setLayout(new BorderLayout());
        
        JPanel pnlTopBarLeftSub = new JPanel();
        pnlTopBarLeftSub.setLayout(new FlowLayout());
        
        JPanel pnlTopBarRightSub = new JPanel();
        pnlTopBarRightSub.setLayout(new FlowLayout());
        
        JPanel pnlMain = new JPanel();
        pnlMain.setBackground(Color.WHITE);
        pnlMain.setBorder(new EmptyBorder(10,0,10,0));
        pnlMain.setLayout(new BorderLayout(10, 0));
        
        JPanel pnlMainContent = new JPanel();
        JPanel pnlMainRight = new JPanel();
        pnlMainRight.setPreferredSize(new Dimension(250, 0));
        
        pnlTopBar.add(pnlTopBarLeftSub, BorderLayout.WEST);
        pnlTopBar.add(pnlTopBarRightSub, BorderLayout.EAST);
        pnlMain.add(pnlMainRight, BorderLayout.WEST);
        pnlMain.add(pnlMainContent, BorderLayout.CENTER);
        
        this.add(pnlTopBar, BorderLayout.NORTH); 
        this.add(pnlMain, BorderLayout.CENTER);
        
        //TOP BAR PANEL IMPLEMENTS
        //Left Sub
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
        
        JButton btnTopBarThem = new JButton("Thêm", iconThem);
        JButton btnTopBarSua = new JButton("Sửa", iconSua);
        JButton btnTopBarXoa = new JButton("Xóa", iconXoa);
        JButton btnTopBarXuatFile = new JButton("Xuất file", iconXuatFile);
        
        pnlTopBarLeftSub.add(btnTopBarThem);
        pnlTopBarLeftSub.add(btnTopBarSua);
        pnlTopBarLeftSub.add(btnTopBarXoa);
        pnlTopBarLeftSub.add(btnTopBarXuatFile);
       
        //Right Sub
        JTextField txtTopBarTimKiem = new JTextField("Nhập mã phiếu nhập");
        txtTopBarTimKiem.setPreferredSize(new Dimension(200, 32));
        
        FontIcon iconLamMoi = new FontIcon();
        iconLamMoi.setIkon(FontAwesomeSolid.SYNC_ALT);
        iconLamMoi.setIconSize(20);
        JButton btnTopBarLamMoi = new JButton("Làm mới", iconLamMoi);
        
        pnlTopBarRightSub.add(txtTopBarTimKiem);
        pnlTopBarRightSub.add(btnTopBarLamMoi);
        
        
        //MAIN PANEL IMPLEMENTS
        
        //MAIN RIGHT
        pnlMainRight.setLayout(new BorderLayout());
        
        JPanel pnlMainRightFilter = new JPanel();
        JPanel pnlMainRightInfo = new JPanel();

        //MAIN RIGHT FILTER
        pnlMainRightFilter.setLayout(new BoxLayout(pnlMainRightFilter,BoxLayout.Y_AXIS));
        pnlMainRightFilter.setBorder(new EmptyBorder(20,10,10,10));
        
        FontIcon iconLoc = new FontIcon();
        iconLoc.setIkon(FontAwesomeSolid.FILTER);
        iconLoc.setIconSize(20);
        iconLoc.setIconColor(Color.decode("#d4802c"));
       
        JButton btnMainFilterLoc = new JButton("Lọc", iconLoc);
        
        Dimension labelSize = new Dimension(65, 30); // Ép nhãn rộng bằng nhau
        
        JLabel lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setPreferredSize(labelSize);
        JDateChooser dateTuNgay = new JDateChooser();
        dateTuNgay.setDateFormatString("dd/MM/yyyy");
        dateTuNgay.setPreferredSize(new Dimension(140,25));
        
        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setPreferredSize(labelSize);
        JDateChooser dateDenNgay = new JDateChooser();
        dateDenNgay.setDateFormatString("dd/MM/yyyy");
        dateDenNgay.setPreferredSize(new Dimension(140,25));

        // Áp dụng lại "Chia khay" để ngay hàng thẳng lối
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        row1.add(lblTuNgay);
        row1.add(dateTuNgay);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        row2.add(lblDenNgay);
        row2.add(dateDenNgay);
        
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        row3.add(btnMainFilterLoc);

        pnlMainRightFilter.add(row1);
        pnlMainRightFilter.add(row2);
        pnlMainRightFilter.add(row3);
        
        pnlMainRight.add(pnlMainRightFilter, BorderLayout.NORTH);
        pnlMainRight.add(pnlMainRightInfo, BorderLayout.CENTER);

        
    }

}
