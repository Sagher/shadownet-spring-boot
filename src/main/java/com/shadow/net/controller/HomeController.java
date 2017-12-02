package com.shadow.net.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
import com.shadow.net.repository.PacketRepository;

@Controller
public class HomeController {

    @Autowired
    private PacketRepository packetRepo;

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss.SS");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, @RequestParam(value = "filter", defaultValue = "all") String filter) {

        if (filter.equals("all")) {
            model.addAttribute("pronum", packetRepo.countByMaliciousType("PROBING"));
            model.addAttribute("malnum", packetRepo.countByMaliciousType("MALWARE"));
            model.addAttribute("webnum", packetRepo.countByMaliciousType("WEB"));
            model.addAttribute("sipnum", packetRepo.countByMaliciousType("SIP"));
            model.addAttribute("sshnum", packetRepo.countByMaliciousType("SSH"));
            model.addAttribute("dbnum", packetRepo.countByMaliciousType("DB"));
        } else if (filter.equals("hour")) {

            Date today = new Date();
            String lastHour = dateFormat.format(new Date(today.getTime() - (1000 * 60 * 60)));

            long pronum = filterContent(lastHour, "PROBING");
            model.addAttribute("pronum", pronum);

            long malnum = filterContent(lastHour, "MALWARE");
            model.addAttribute("malnum", malnum);

            long webnum = filterContent(lastHour, "WEB");
            model.addAttribute("webnum", webnum);

            long sipnum = filterContent(lastHour, "SIP");
            model.addAttribute("sipnum", sipnum);

            long sshnum = filterContent(lastHour, "SSH");
            model.addAttribute("sshnum", sshnum);

            long dbnum = filterContent(lastHour, "DB");
            model.addAttribute("dbnum", dbnum);

        } else if (filter.equals("day")) {

            Date today = new Date();
            String lastDay = dateFormat.format(new Date(today.getTime() - (1000 * 60 * 60 * 24)));

            long pronum = filterContent(lastDay, "PROBING");
            model.addAttribute("pronum", pronum);

            long malnum = filterContent(lastDay, "MALWARE");
            model.addAttribute("malnum", malnum);

            long webnum = filterContent(lastDay, "WEB");
            model.addAttribute("webnum", webnum);

            long sipnum = filterContent(lastDay, "SIP");
            model.addAttribute("sipnum", sipnum);

            long sshnum = filterContent(lastDay, "SSH");
            model.addAttribute("sshnum", sshnum);

            long dbnum = filterContent(lastDay, "DB");
            model.addAttribute("dbnum", dbnum);

        } else if (filter.equals("week")) {

            Date today = new Date();
            String lastWeek = dateFormat.format(new Date(today.getTime() - (1000 * 60 * 60 * 24 * 7)));

            long pronum = filterContent(lastWeek, "PROBING");
            model.addAttribute("pronum", pronum);

            long malnum = filterContent(lastWeek, "MALWARE");
            model.addAttribute("malnum", malnum);

            long webnum = filterContent(lastWeek, "WEB");
            model.addAttribute("webnum", webnum);

            long sipnum = filterContent(lastWeek, "SIP");
            model.addAttribute("sipnum", sipnum);

            long sshnum = filterContent(lastWeek, "SSH");
            model.addAttribute("sshnum", sshnum);

            long dbnum = filterContent(lastWeek, "DB");
            model.addAttribute("dbnum", dbnum);

        }

        return "index";
    }

    private long filterContent(String filter, String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("time").gt(filter));
        query.addCriteria(Criteria.where("maliciousType").is(type));

        long count = mongoOperation.count(query, Packet.class);
        return count;
    }
}
