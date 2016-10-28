package com.shadow.net.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shadow.net.Packet;


public interface PacketRepository extends MongoRepository<Packet, String>{

	List<Packet> findByMaliciousTypeOrderByTimeDesc(String MaliciousType);
	
	int countByMaliciousType(String MaliciousType);
	
	List<Packet> findByUrlCheckOrderByTimeDesc(Boolean UrlCheck);
	
	List<Packet> findByHashStatusOrderByTimeDesc(Boolean HashStatus);

	List<Packet> deleteByMaliciousType(String MaliciousType);
	
	List<Packet> findByMaliciousTypeOrderByTimeDesc(String MaliciousType, Pageable pageable);

	
}