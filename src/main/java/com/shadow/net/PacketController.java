package com.shadow.net;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shadow.net.repository.PacketRepository;

@Controller
public class PacketController {

	@Autowired
	PacketRepository packetRepo;

	@RequestMapping("/")
	public String home(Model model) {

		// model.addAttribute("packets", packetRepo.findAll());
		model.addAttribute("probes", packetRepo.findByMaliciousType("PROBING"));
		model.addAttribute("malwares", packetRepo.findByMaliciousType("MALWARE"));
		model.addAttribute("web", packetRepo.findByMaliciousType("WEB"));
		model.addAttribute("sip", packetRepo.findByMaliciousType("SIP"));
		model.addAttribute("ssh", packetRepo.findByMaliciousType("SSH"));
		model.addAttribute("db", packetRepo.findByMaliciousType("DB"));
		
		model.addAttribute("pronum", packetRepo.countByMaliciousType("PROBING"));
		model.addAttribute("malnum", packetRepo.countByMaliciousType("MALWARE"));
		model.addAttribute("webnum", packetRepo.countByMaliciousType("WEB"));
		model.addAttribute("sipnum", packetRepo.countByMaliciousType("SIP"));
		model.addAttribute("sshnum", packetRepo.countByMaliciousType("SSH"));
		model.addAttribute("dbnum", packetRepo.countByMaliciousType("DB"));

		return "index";
	}
	
	@RequestMapping("/urls")
	public String urls(Model model){
		
		model.addAttribute("urls", packetRepo.findByUrlCheck(true));
		return "urls";
		
	}
	
	@RequestMapping("/hashes")
	public String hashes(Model model){
		
		model.addAttribute("hashes", packetRepo.findByHashStatus(true));
		return "hashes";
		
	}
	
}