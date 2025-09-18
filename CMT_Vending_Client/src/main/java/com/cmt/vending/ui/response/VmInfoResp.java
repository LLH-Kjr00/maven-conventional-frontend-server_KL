package com.cmt.vending.ui.response;

import java.util.ArrayList;
import java.util.List;

import com.cmt.vending.server.model.TabInfo;

public class VmInfoResp extends Response {
	// video playlist 
	private List<Integer> globalVideo = null;
	
	// AllTab (the tab showing all the product)
	private TabInfo allTab = null;
	
	//Tabs (each showing different type of product)
	private ArrayList<TabInfo> tabs = null;
	
	/**
	 * Constructor
	 * @param seq
	 */
	public VmInfoResp(int seq) {
		super(seq);
	}
	
	/**
	 * Set the video playlist 
	 * @param globalVideo
	 */
	public void setGlobalVideo(List<Integer> globalVideo) {
		this.globalVideo = globalVideo;
	}
	/**
	 * Get the video playlist
	 * @return
	 */
	public List<Integer> getGlobalVideo() {
		return globalVideo;
	}

	
	/**
	 * Set AllTab (the tab showing all the product)
	 * @param allTab
	 */
	public void setAllTab(TabInfo allTab) {
		this.allTab = allTab;
	}
	/**
	 * Get AllTab (the tab showing all the product)
	 * @return
	 */
	public TabInfo getAllTab() {
		return allTab;
	}

	
	/**
	 * Set Tabs (each showing different type of product)
	 * @param tabs
	 */
	public void setTabs(ArrayList<TabInfo> tabs) {
		this.tabs = tabs;
	}
	/**
	 * Get Tabs (each showing different type of product)
	 * @return
	 */
	public ArrayList<TabInfo> getTabs() {
		return tabs;
	}

}
