package com.shadow.net.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shadow.net.geoIP.GeoIPv4;
import com.shadow.net.model.BlockList;
import com.shadow.net.repository.BlockListRepo;
import com.shadow.net.utils.ExecuteShellScript;

@Controller
public class BlockListController {

	@Autowired
	private BlockListRepo blockListRepo;


	@RequestMapping(value = "/blocklist", method = RequestMethod.GET)
	public String setting(Model model, @RequestParam(value = "ip", defaultValue = "default") String ip)
			throws IOException {

		if (ip.equals("default")) {
			model.addAttribute("blockList", blockListRepo.findAll());
			return "blocklist";
		} else {
			ExecuteShellScript execute = new ExecuteShellScript();
			execute.blockIP(ip);

			BlockList bl = new BlockList();
			bl.setSourceIP(ip);
			bl.setLocation(GeoIPv4.getLocation(ip));

			blockListRepo.save(bl);

			model.addAttribute("blockList", blockListRepo.findAll());
			return "blocklist";

		}

	}
}
