package view;

import connData.ConnJDBC;
import model.Product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.Color;

public class MainView extends javax.swing.JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DateChooserPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_2;
	private JTextField textField_7;
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 723);
		contentPane = new DateChooserPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(582, 10, 1, 1);
		contentPane.add(desktopPane);
		
		JLabel lblAge = new JLabel("Mã nhóm");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(10, 155, 78, 56);
		contentPane.add(lblAge);
		DateChooserPanel dateChooserPanel = new DateChooserPanel();
		JLabel lblGender = new JLabel("Tên HH");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(10, 221, 78, 56);
		contentPane.add(lblGender);
		
		JLabel lblMajor = new JLabel("Đơn vị tính");
		lblMajor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMajor.setBounds(10, 287, 78, 56);
		contentPane.add(lblMajor);
		
		JLabel lblScore = new JLabel("Hạn SD");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(20, 353, 78, 56);
		contentPane.add(lblScore);
		
		textField = new JTextField();
		textField.setBounds(116, 78, 190, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 157, 190, 56);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 290, 190, 56);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 370, 190, 56);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            // TODO add your handling code here:
                    
                            String MaHH,MaNhom,TenHH,DonViTinh;
                            Date HanSD;
                            float TrongLuong;
                            String NoiSX;
                            try{
                            	MaHH = textField.getText();
                            	MaNhom = textField_1.getText();
                            	TenHH = textField_2.getText();
                            	DonViTinh = textField_3.getText();
                            	HanSD = format.parse(textField_4.getText());
                            	TrongLuong = Float.parseFloat(textField_5.getText());
                            	NoiSX = textField_6.getText();
                            	Product product = new Product(MaHH,MaNhom,TenHH,DonViTinh,HanSD,TrongLuong,NoiSX);
                                ConnJDBC.insert(product);
                                showData(ConnJDBC.findAll());
                            } catch(NumberFormatException e1){
                            	JFrame f = new JFrame();
                            	JOptionPane.showMessageDialog(f,"Thêm mới thất bại, phải nhập số ở trường Trọng lượng");  
                                return;
                            }
                            catch (ParseException e2) {
                            	JFrame f = new JFrame();
                            	JOptionPane.showMessageDialog(f,"Thêm mới thất bại,nhập sai định dạng trường Hạn SD");  
                                return;
							}
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(675, 618, 162, 47);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame t = new JFrame();
				int a = JOptionPane.showConfirmDialog(t, "Xác nhận xóa trường dữ liệu này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if(a == 0) {
					Product p = new Product();
	                p.setMaHH(textField.getText());
	                ConnJDBC.delete(p);
	                showData(ConnJDBC.findAll());
				}
                
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(473, 618, 162, 47);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("Tìm theo tên");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = new Product();
				p.setTenHH(textField_7.getText());
				showData(ConnJDBC.findByName(p));
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(994, 53, 150, 47);
		contentPane.add(btnFind);
		
		JButton btnRefresh = new JButton("Làm Mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(ConnJDBC.findAll());
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(675, 551, 162, 47);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Cập Nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame t = new JFrame();
				int a = JOptionPane.showConfirmDialog(t, "Xác nhận tiến hành cập nhật trường dữ liệu này?", "Xác nhận cập nhật", JOptionPane.YES_NO_OPTION);
				System.out.print(a);
				if(a == 0) {
					String MaHH,MaNhom,TenHH,DonViTinh;
                    Date HanSD;
                    float TrongLuong;
                    String NoiSX;
	                try{
	                	MaHH = textField.getText();
	                	
                    	MaNhom = textField_1.getText();
                    	TenHH = textField_2.getText();
                    	DonViTinh = textField_3.getText();
                    	HanSD = format.parse(textField_4.getText());
                    	TrongLuong = Float.parseFloat(textField_5.getText());
                    	NoiSX = textField_6.getText();
                    	Product product = new Product(MaHH,MaNhom,TenHH,DonViTinh,HanSD,TrongLuong,NoiSX);
	                    ConnJDBC.update(product);
	                    showData(ConnJDBC.findAll());
	                } catch(NumberFormatException e1){
	                	JFrame f = new JFrame();
	                	JOptionPane.showMessageDialog(f,"Cập nhật thất bại, phải nhập số ở trường Trọng lượng");  
	                    return;
	                }
	                catch (ParseException e2) {
						// TODO: handle exception
	                	JFrame f = new JFrame();
                    	JOptionPane.showMessageDialog(f,"Cập nhật thất bại, nhập sai định dạng trường Hạn SD");  
                        return;
					}
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(473, 551, 162, 47);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 119, 793, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				" Mã HH", "       Mã nhóm", "Tên hàng hóa", "  Đơn vị tính", "         Hạn SD", "    Trọng lượng", "      Nơi SX", 
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	tableMouseClicked(evt);
	            }
	        });

		scrollPane.setViewportView(table);
		showData(ConnJDBC.findAll());
		
		JLabel lblPht = new JLabel("Trọng lượng");
		lblPht.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPht.setBounds(10, 451, 96, 56);
		contentPane.add(lblPht);
		
		JLabel lblTng = new JLabel("Nơi SX");
		lblTng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTng.setBounds(10, 546, 78, 56);
		contentPane.add(lblTng);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(116, 454, 190, 56);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(116, 542, 190, 56);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý bán hàng siêu thị");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(415, 0, 550, 56);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 221, 190, 56);
		contentPane.add(textField_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(672, 62, 293, 33);
		contentPane.add(textField_7);
		
		JLabel lblMHh = new JLabel("Mã HH");
		lblMHh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMHh.setBounds(10, 78, 78, 56);
		contentPane.add(lblMHh);
		
		JLabel lblDdmm = new JLabel("dd/mm/yyyy");
		lblDdmm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDdmm.setBounds(10, 387, 135, 40);
		contentPane.add(lblDdmm);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.setForeground(new Color(255, 0, 0));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThot.setBounds(882, 578, 162, 47);
		contentPane.add(btnThot);
		
	}
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		 // Do something.
		 int row = table.getSelectedRow();
	        textField.setText(table.getValueAt(row, 0).toString());
	        textField_1.setText(table.getValueAt(row, 1).toString());
	        textField_2.setText(table.getValueAt(row, 2).toString());
	        textField_3.setText(table.getValueAt(row, 3).toString());
	        textField_4.setText(table.getValueAt(row, 4).toString());
	        textField_5.setText(table.getValueAt(row, 5).toString());
	        textField_6.setText(table.getValueAt(row, 6).toString());
	        
	    
		}
	public void showData(List<Product>lps) {
		System.out.println("runm");
		List<Product>lp= new ArrayList<>();
		lp = lps;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		lp.forEach((p)->{
			
			tableModel.addRow(new Object[] {
					p.getMaHH(),p.getMaNhom(),p.getTenHH(),
					p.getDonViTinh(),format.format(p.getHSD()),
					p.getTrongLuong(),p.getNoiSX()
			});
		});
	}
}
