package com.shadow.net.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shadow.net.Packet;


public interface PacketRepository extends CrudRepository<Packet, String>{

	List<Packet> findByMaliciousType(String MaliciousType);
	
	int countByMaliciousType(String MaliciousType);
	
	List<Packet> findByUrlCheck(Boolean UrlCheck);
	
	List<Packet> findByHashStatus(Boolean HashStatus);

	
	//List<Packet> findByMaliciousType(String MaliciousType, Pageable pageable);
	
	//@Query 
	//("{$or:[{ 'maliciousType'  : {}}, { 'sourceIP'  : {}}")
	//List<Packet> findByFilter(String filter);

	//List<Packet> findByTime(String Time);
}