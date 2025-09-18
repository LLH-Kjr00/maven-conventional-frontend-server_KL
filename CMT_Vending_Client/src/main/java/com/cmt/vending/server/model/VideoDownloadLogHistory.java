package com.cmt.vending.server.model;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

import com.cmt.vending.ws.obj.xsd.VideoDownloadLogInfo;

@XmlRootElement
public class VideoDownloadLogHistory {
	private List<VideoDownloadLogInfo> history = new Vector<>();

	public List<VideoDownloadLogInfo> getHistory() {
		return history;
	}

	public void setHistory(List<VideoDownloadLogInfo> history) {
		this.history = history;
	}
}
