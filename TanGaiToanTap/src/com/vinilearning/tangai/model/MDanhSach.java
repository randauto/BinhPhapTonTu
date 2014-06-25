package com.vinilearning.tangai.model;

/**
 * tblDanhSach.
 * 
 * @author TuanLQ.
 * 
 */
public class MDanhSach extends MCategory {

	private int itemId;

	private int parentId;

	public MDanhSach() {
	}

	public MDanhSach(int id, int itemId, String content, int parentId) {
		this.id = id;
		this.itemId = itemId;
		this.parentId = parentId;
		this.content = content;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
