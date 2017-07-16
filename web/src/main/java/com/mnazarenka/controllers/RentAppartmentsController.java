package com.mnazarenka.controllers;

import com.mnazarenka.dao.entity.EconomAppartment;
import com.mnazarenka.dao.entity.LuxAppartment;
import com.mnazarenka.dao.entity.StandartAppartment;
import com.mnazarenka.service.AppartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RentAppartmentsController {
    private AppartmentService appartmentService;

    //@Value("#{new Integer.parseInt('${items.counts}')}")
    private Integer pageCounts = 3;

    @Autowired
    public RentAppartmentsController(AppartmentService appartmentService) {
        this.appartmentService = appartmentService;
    }

    @GetMapping("/user/rent/{type}")
    public String goToRentPage(@PathVariable String type, Model model) {

        switch (type) {
            case "lux": {
                List<LuxAppartment> appartments = appartmentService.getAppartmentsByRange(0, pageCounts, LuxAppartment.class);
                model.addAttribute("appartments", appartments);
                break;
            }
            case "standart": {
                List<StandartAppartment> appartments = appartmentService.getAppartmentsByRange(0, pageCounts, StandartAppartment.class);
                model.addAttribute("appartments", appartments);
                break;
            }
            case "econom": {
                List<EconomAppartment> appartments = appartmentService.getAppartmentsByRange(0, pageCounts, EconomAppartment.class);
                model.addAttribute("appartments", appartments);
                break;
            }
        }
        return "user/appartments";
    }

    @GetMapping("/user/rent/{type}/{pageNumber}")
    public String goToRentPageWithPaging(@PathVariable String type, @PathVariable int pageNumber, Model model) {

        switch (type) {
            case "lux": {
                pageNumber = getCurrentPageNumber(pageNumber);
                List<LuxAppartment> appartments = appartmentService.getAppartmentsByRange(pageNumber - 1, pageCounts, LuxAppartment.class);
                model.addAttribute("appartments", appartments);
                break;
            }
            case "standart": {
                pageNumber = getCurrentPageNumber(pageNumber);
                List<StandartAppartment> appartments = appartmentService.getAppartmentsByRange(pageNumber - 1, pageCounts, StandartAppartment.class);
                model.addAttribute("appartments", appartments);
                break;
            }
            case "econom": {
                pageNumber = getCurrentPageNumber(pageNumber);
                List<EconomAppartment> appartments = appartmentService.getAppartmentsByRange(pageNumber - 1, pageCounts, EconomAppartment.class);
                model.addAttribute("appartments", appartments);
                break;
            }
        }


        return "user/appartments";
    }

    private int getCurrentPageNumber(int pageNumber) {
        if (pageNumber != 1) {
            pageNumber = (pageNumber - 1) * pageCounts + 1;
        }
        return pageNumber;
    }

}
