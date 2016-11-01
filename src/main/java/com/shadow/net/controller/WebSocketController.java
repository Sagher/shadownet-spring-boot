package com.shadow.net.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shadow.net.config.SpringMongoConfig;
import com.shadow.net.model.Packet;

@Controller
public class WebSocketController {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	final Pageable pageableRequest = new PageRequest(0, 4);
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss.SS");

	@MessageMapping("/newMessage")
	@SendTo("/topic/newMessage")
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public HttpEntity<List<Packet>> list() {

		Query query = new Query();

		Date today = new Date();
		String minBack = dateFormat.format(new Date(today.getTime() - (1000 * 60)));

		query.addCriteria(Criteria.where("direction").is("INCOMING"));
		query.addCriteria(Criteria.where("maliciousType").ne("none"));
		query.addCriteria(Criteria.where("time").gt(minBack));
		query.with(new Sort(Sort.Direction.DESC, "time"));
		query.with(pageableRequest);

		List<Packet> packs = mongoOperation.find(query, Packet.class);

		return new ResponseEntity<List<Packet>>(packs, HttpStatus.OK);
	}

}
