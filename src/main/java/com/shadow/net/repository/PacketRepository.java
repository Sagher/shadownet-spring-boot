package com.shadow.net.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.shadow.net.Packet;


public interface PacketRepository extends CrudRepository<Packet, String>{

	List<Packet> findByMaliciousTypeOrderByTimeDesc(String MaliciousType);
	
	int countByMaliciousType(String MaliciousType);
	
	List<Packet> findByUrlCheckOrderByTimeDesc(Boolean UrlCheck);
	
	List<Packet> findByHashStatusOrderByTimeDesc(Boolean HashStatus);

	List<Packet> deleteByMaliciousType(String MaliciousType);
	
	List<Packet> findByMaliciousTypeOrderByTimeDesc(String MaliciousType, Pageable pageable);
	
}