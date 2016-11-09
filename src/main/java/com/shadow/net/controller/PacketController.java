package com.shadow.net.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shadow.net.config.SpringMongoConfig;
import com.shadow.net.model.Packet;

@Controller
public class PacketController {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	@RequestMapping(value = "/probing", method = RequestMethod.GET)
	public String probing(Model model, @RequestParam(value = "size", defaultValue = "2000") int size) {
		List<Packet> probing = filterContent(size, "PROBING");
		model.addAttribute("probing", probing);
		return "ips/probing";

	}

	@RequestMapping(value = "/malware", method = RequestMethod.GET)
	public String malware(Model model, @RequestParam(value = "size", defaultValue = "2000") int size) {
		List<Packet> malwares = filterContent(size, "MALWARE");
		model.addAttribute("malware", malwares);
		return "ips/malware";

	}

	@RequestMapping(value = "/web", method = RequestMethod.GET)
	public String web(Model model, @RequestParam(value = "size", defaultValue = "2000") int size) {
		List<Packet> web = filterContent(size, "WEB");
		model.addAttribute("web", web);
		return "ips/web";

	}

	@RequestMapping(value = "/sip", method = RequestMethod.GET)
	public String sip(Model model, @RequestParam(value = "size", defaultValue = "2000") int size) {
		List<Packet> sip = filterContent(size, "SIP");
		model.addAttribute("sip", sip);
		return "ips/sip";

	}

	@RequestMapping(value = "/ssh", method = RequestMethod.GET)
	public String ssh(Model model, @RequestParam(value = "size", defaultValue = "2000") int size) {
		List<Packet> ssh = filterContent(size, "SSH");
		model.addAttribute("ssh", ssh);
		return "ips/ssh";

	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String db(Model model, @RequestParam(value = "size", defaultValue = "2000") int size) {
		List<Packet> db = filterContent(size, "DB");
		model.addAttribute("db", db);
		return "ips/db";

	}

	private List<Packet> filterContent(int size, String filter) {
		Query query = new Query();
		Pageable pageableRequest = new PageRequest(0, size);

		query.addCriteria(Criteria.where("maliciousType").is(filter));
		query.with(new Sort(Sort.Direction.DESC, "time"));
		query.with(pageableRequest);

		return mongoOperation.find(query, Packet.class);

	}
}