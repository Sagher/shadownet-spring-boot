package com.shadow.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shadow.net.repository.PacketRepository;

@Controller
public class MiscController {

    @Autowired
    private PacketRepository packetRepo;

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
