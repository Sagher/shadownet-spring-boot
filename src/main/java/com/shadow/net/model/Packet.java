package com.shadow.net.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MaliciousPackets")
public class Packet {

	@Id
	public String id;

	public String time, sourceIP, destinationIP, direction, maliciousType, requestUrl, hash, location,countryCode;

	int sourcePort, destPort, segments;
	
	Boolean urlCheck, hashStatus;

	public String getId() {
		return id;
	}

	public String getTime() {
		return time;
	}

	public String getSourceIP() {
		return sourceIP;
	}

	public String getDestinationIP() {
		return destinationIP;
	}

	public String getDirection() {
		return direction;
	}

	public String getMaliciousType() {
		return maliciousType;
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public int getDestPort() {
		return destPort;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public Boolean getUrlCheck() {
		return urlCheck;
	}
	
	public String getHash(){
		return hash;
	}
	
	public Boolean getHashStatus(){
		return hashStatus;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getCountryCode(){
		return countryCode;
	}

}