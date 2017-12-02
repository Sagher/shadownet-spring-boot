package com.shadow.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shadow.net.model.Packet;
import com.shadow.net.repository.PacketRepository;
import com.shadow.net.utils.CountTopTen;

@Controller
public class StatisticsController {

    @Autowired
    private PacketRepository packetRepo;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String home(Model model) {

        java.util.List<Packet> packets = packetRepo.findAll();

        model.addAttribute("top10countries", CountTopTen.countByCountries(packets));
        model.addAttribute("top10ips", CountTopTen.countByIps(packets));
        model.addAttribute("top10urls", CountTopTen.countByUrls(packets));
        model.addAttribute("top10hashes", CountTopTen.countByHash(packets));

        return "statistics";

    }

}
