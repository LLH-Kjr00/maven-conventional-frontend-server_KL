package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IdlePlayList {
	
	private List<Integer>  playList = new Vector<>();

	public List<Integer> getPlayList() {
		return playList;
	}

	public void setPlayList(List<Integer> playList) {
		this.playList = playList;
	}

}
