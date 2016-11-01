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

	@RequestMapping(value = "/malicious-ips", method = RequestMethod.GET)
	public String maliciousips(Model model) {
		model.addAttribute("probing", packetRepo.findByMaliciousTypeOrderByTimeDesc("PROBING"));
		model.addAttribute("malware", packetRepo.findByMaliciousTypeOrderByTimeDesc("MALWARE"));
		model.addAttribute("web", packetRepo.findByMaliciousTypeOrderByTimeDesc("WEB"));
		model.addAttribute("sip", packetRepo.findByMaliciousTypeOrderByTimeDesc("SIP"));
		model.addAttribute("ssh", packetRepo.findByMaliciousTypeOrderByTimeDesc("SSH"));
		model.addAttribute("db", packetRepo.findByMaliciousTypeOrderByTimeDesc("DB"));

		return "malicious-ips";

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

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Model model) {
		packetRepo.deleteAll();
		return "redirect:/";

	}

}