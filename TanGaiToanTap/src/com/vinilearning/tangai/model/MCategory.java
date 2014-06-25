package com.vinilearning.tangai.model;

/**
 * Category Object.
 * 
 * @author TuanLQ.
 * 
 */
public class MCategory {
	protected int id;

	protected String content;

	public MCategory() {
	}

	public MCategory(int id, String content) {
		this.content = content;
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
