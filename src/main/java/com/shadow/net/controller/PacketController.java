package com.shadow.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shadow.net.repository.PacketRepository;

@Controller
public class PacketController {

	@Autowired
	private PacketRepository packetRepo;

	@RequestMapping(value = "/probing", method = RequestMethod.GET)
	public String probing(Model model) {
		model.addAttribute("probing", packetRepo.findByMaliciousTypeOrderByTimeDesc("PROBING"));
		return "ips/probing";

	}

	@RequestMapping(value = "/malware", method = RequestMethod.GET)
	public String malware(Model model) {
		model.addAttribute("malware", packetRepo.findByMaliciousTypeOrderByTimeDesc("MALWARE"));
		return "ips/malware";

	}

	@RequestMapping(value = "/web", method = RequestMethod.GET)
	public String web(Model model) {
		model.addAttribute("web", packetRepo.findByMaliciousTypeOrderByTimeDesc("WEB"));
		return "ips/web";

	}

	@RequestMapping(value = "/sip", method = RequestMethod.GET)
	public String sip(Model model) {
		model.addAttribute("sip", packetRepo.findByMaliciousTypeOrderByTimeDesc("SIP"));
		return "ips/sip";

	}

	@RequestMapping(value = "/ssh", method = RequestMethod.GET)
	public String ssh(Model model) {
		model.addAttribute("ssh", packetRepo.findByMaliciousTypeOrderByTimeDesc("SSH"));
		return "ips/ssh";

	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String db(Model model) {
		model.addAttribute("db", packetRepo.findByMaliciousTypeOrderByTimeDesc("DB"));
		return "ips/db";

	}

	@RequestMapping(value = "/urls", method = RequestMethod.GET)
	public String urls(Model model) {
		model.addAttribute("urls", packetRepo.findByUrlCheckOrderByTimeDesc(true));
		return "urls";

	}

	@RequestMapping(value = "/hashes", method = RequestMethod.GET)
	public String hashes(Model model) {
		model.addAttribute("hashes", packetRepo.findByHashStatusOrderByTimeDesc(true));
		return "hashes";

	}

	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String setting(Model model) {
		return "setting";

	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Model model) {
		packetRepo.deleteAll();
		return "redirect:/";

	}

}