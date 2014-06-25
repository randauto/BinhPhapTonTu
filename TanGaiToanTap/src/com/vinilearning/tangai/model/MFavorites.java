package com.vinilearning.tangai.model;

/**
 * tblFavorites.
 * 
 * @author TuanLQ.
 * 
 */
public class MFavorites {
	private int id;
	private int idDanhSach;

	public MFavorites() {
	}

	public MFavorites(int id, int idDanhSach) {
		this.id = id;
		this.idDanhSach = idDanhSach;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDanhSach() {
		return idDanhSach;
	}

	public void setIdDanhSach(int idDanhSach) {
		this.idDanhSach = idDanhSach;
	}
}
