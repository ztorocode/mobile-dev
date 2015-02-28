package com.catatanku.model;

public class Catatan {
	private int id, warna;
	private String title, isi, tanggal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWarna() {
		return warna;
	}
	public void setWarna(int warna) {
		this.warna = warna;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsi() {
		return isi;
	}
	public void setIsi(String isi) {
		this.isi = isi;
	}
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}	
}
