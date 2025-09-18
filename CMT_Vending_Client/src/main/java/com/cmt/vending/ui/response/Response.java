package com.cmt.vending.ui.response;

/**
 *  Class of Response (to UI) object
 */
public class Response {
	private int seq;

	public Response(int seq) {
		this.seq = seq;
	}
	public Response() {
		
	}
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
}
