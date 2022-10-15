package connData;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import model.Product;

public class ConnJDBC {
	static String url="jdbc:mysql://localhost:3306/QLBH";
	static String user="root";
	static String password="";
	public static Connection getConnection() {// connection function
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		}catch(Exception ex) {
		ex.printStackTrace();
	}
		return connection;
}
	public static HashMap<String,String> findAllAccount(){
		HashMap<String,String> logininfo = new HashMap<String,String>();
		String query="select*from login";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				
				 String userName = rs.getString("userName");
				 String passWord = rs.getString("passWord");
				 logininfo.put(userName, passWord);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return logininfo;
	}
	public static List<Product>findAll(){
		List<Product>pl= new ArrayList<>();
		String query="select*from QLBH";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				 Product p = new Product(rs.getString("MaHH"),rs.getString("MaNhom"),rs.getString("TenHH"),rs.getString("DonViTinh"),
						rs.getDate("HanSD"),rs.getFloat("TrongLuong"),rs.getString("NoiSX"));
				 pl.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return pl;
	}
	public static void insert(Product p) {
		String query="insert into QLBH(MaHH, MaNhom,TenHH, DonViTinh, HanSD, TrongLuong , NoiSX) values(?,?,?,?,?,?,?)";
		try {
			
		
			
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, p.getMaHH());
			pstmt.setString(2, p.getMaNhom());
			pstmt.setString(3, p.getTenHH());
			pstmt.setString(4, p.getDonViTinh());
			java.sql.Date sqlDate = new java.sql.Date(p.getHSD().getTime()); 
			pstmt.setDate(5, sqlDate);
                        pstmt.setFloat(6, p.getTrongLuong());
                        pstmt.setString(7, p.getNoiSX());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void delete(Product p) {
		String query="delete from QLBH where MaHH='"+p.getMaHH()+"'";
		try {
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<Product>findByName(Product p) {
		List<Product>pl= new ArrayList<>();
		String query="select*from QLBH where TenHH like '%"+p.getTenHH()+"%'";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Product pr  = new Product(rs.getString("MaHH"),rs.getString("MaNhom"),rs.getString("TenHH"),rs.getString("DonViTinh"),
						rs.getDate("HanSD"),rs.getFloat("TrongLuong"),rs.getString("NoiSX"));
				
				pl.add(pr);
				System.out.println(pr.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pl;
        }
	public static void update(Product p) {
		

		String query="Update QLBH set MaNhom=?,TenHH=?,DonViTinh=?,HanSD=?,TrongLuong=?,NoiSX= ? where MaHH='"+p.getMaHH()+"'";
		try {
			System.out.println(query);
			Connection connection=getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
//			pstmt.setString(1, p.getMaHH());
			pstmt.setString(1, p.getMaNhom());
			pstmt.setString(2, p.getTenHH());
			pstmt.setString(3, p.getDonViTinh());
			java.sql.Date sqlDate = new java.sql.Date(p.getHSD().getTime()); 
			pstmt.setDate(4, sqlDate);
                        pstmt.setFloat(5, p.getTrongLuong());
                        pstmt.setString(6, p.getNoiSX());

            pstmt.executeUpdate();
            System.out.println("ok");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}


	
}