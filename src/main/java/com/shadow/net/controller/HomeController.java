package com.shadow.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shadow.net.repository.PacketRepository;

@Controller
public class HomeController {

	@Autowired
	private PacketRepository packetRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("pronum", packetRepo.countByMaliciousType("PROBING"));
		model.addAttribute("malnum", packetRepo.countByMaliciousType("MALWARE"));
		model.addAttribute("webnum", packetRepo.countByMaliciousType("WEB"));
		model.addAttribute("sipnum", packetRepo.countByMaliciousType("SIP"));
		model.addAttribute("sshnum", packetRepo.countByMaliciousType("SSH"));
		model.addAttribute("dbnum", packetRepo.countByMaliciousType("DB"));

		return "index";
	}

}
