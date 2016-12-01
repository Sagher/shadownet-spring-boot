package com.shadow.net.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BlockList")
public class BlockList {

	@Id
	public String id;

	public String sourceIP, location;

	public String getId() {
		return id;
	}

	public void setSourceIP(String sip) {
		this.sourceIP = sip;
	}

	public String getSourceIP() {
		return sourceIP;
	}

	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getLocation() {
		return location;
	}

}