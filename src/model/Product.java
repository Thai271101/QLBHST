package model;

import java.util.*;

public class Product {
	private String MaHH;
	private String MaNhom;
	private String TenHH,DonViTinh;
	private Date HSD;
	private Float TrongLuong;
	private String NoiSX;
	public Product() {
		super();
	}
	public Product(String maHH, String maNhom, String tenHH, String donViTinh, Date hSD, Float trongLuong,
			String noiSX) {
		super();
		MaHH = maHH;
		MaNhom = maNhom;
		TenHH = tenHH;
		DonViTinh = donViTinh;
		HSD = hSD;
		TrongLuong = trongLuong;
		NoiSX = noiSX;
	}
	public String getMaHH() {
		return MaHH;
	}
	public void setMaHH(String maHH) {
		MaHH = maHH;
	}
	public String getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}
	public String getTenHH() {
		return TenHH;
	}
	public void setTenHH(String tenHH) {
		TenHH = tenHH;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public Date getHSD() {
		return HSD;
	}
	public void setHSD(Date hSD) {
		HSD = hSD;
	}
	public Float getTrongLuong() {
		return TrongLuong;
	}
	public void setTrongLuong(Float trongLuong) {
		TrongLuong = trongLuong;
	}
	public String getNoiSX() {
		return NoiSX;
	}
	public void setNoiSX(String noiSX) {
		NoiSX = noiSX;
	}
	@Override
	public String toString() {
		return "Product [MaHH=" + MaHH + ", MaNhom=" + MaNhom + ", TenHH=" + TenHH + ", DonViTinh=" + DonViTinh
				+ ", HSD=" + HSD + ", TrongLuong=" + TrongLuong + ", NoiSX=" + NoiSX + "]";
	}
	
    
	
    
 
}