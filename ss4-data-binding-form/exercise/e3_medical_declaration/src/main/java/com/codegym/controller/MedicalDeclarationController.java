package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.MedicalDeclarationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MedicalDeclarationController {
    private final MedicalDeclarationService medicalDeclarationService;

    public MedicalDeclarationController(MedicalDeclarationService medicalDeclarationService) {
        this.medicalDeclarationService = medicalDeclarationService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<MedicalDeclaration> res = medicalDeclarationService.findAll();
        model.addAttribute("res", res);
        return "list";
    }

    @GetMapping(path = {"/form", "/form/{id}"})
    public String form(Model model, @PathVariable(required = false) Optional<Integer> id) {
        MedicalDeclaration res = new MedicalDeclaration();
        model.addAttribute("birthYears", new String[]{"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003"});
        model.addAttribute("genders", new String[]{"--Chon--", "Nam", "Nữ", "LGBT"});
        model.addAttribute("nationalities", new String[]{"Việt Nam", "Mỹ", "Tung Quốc"});
        model.addAttribute("vehicles", new String[]{"Máy bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        String[] startDays = new String[31];
        String[] endDays = new String[31];
        for (int i = 0; i <= 30; i++) {
            startDays[i] = String.valueOf(i + 1);
            endDays[i] = String.valueOf(i + 1);
        }
        model.addAttribute("startDays", startDays);
        model.addAttribute("endDays", endDays);
        String[] startMonths = new String[12];
        String[] endMonths = new String[12];
        for (int i = 0; i <= 11; i++) {
            startMonths[i] = String.valueOf(i + 1);
            endMonths[i] = String.valueOf(i + 1);
        }

        model.addAttribute("startMonths", startMonths);
        model.addAttribute("endMonths", endMonths);

        String[] startYears = new String[23];
        String[] endYears = new String[23];
        for (int i = 0; i <= 22; i++) {
            startYears[i] = String.valueOf(i + 2000);
            endYears[i] = String.valueOf(i + 2000);
        }
        model.addAttribute("startYears", startYears);
        model.addAttribute("endYears", endYears);

        model.addAttribute("cities", new String[]{"HCM", "Đà Nẵng", "Hà Nội", "Hải Phòng"});
        model.addAttribute("districts", new String[]{"Hải Châu", "Thanh Khê", "Sơn Trà"});
        model.addAttribute("wards", new String[]{"Vĩnh Trung", "Thanh Bình", "Mỏi tay quá"});


        if (id.isPresent()) {
            Optional<MedicalDeclaration> optionalMedicalDeclaration = medicalDeclarationService.findById(id.get());
            if (optionalMedicalDeclaration.isPresent()) {
                res = optionalMedicalDeclaration.get();
            }
        }

        model.addAttribute("result", res);
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("result") MedicalDeclaration medicalDeclaration) {
        medicalDeclarationService.save(medicalDeclaration);
        return "redirect:/list";
    }
}
