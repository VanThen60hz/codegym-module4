package com.codegym.dethithu.controller;

import com.codegym.dethithu.dto.StadiumDTO;
import com.codegym.dethithu.exception.StadiumNotFoundException;
import com.codegym.dethithu.model.Area;
import com.codegym.dethithu.model.FieldType;
import com.codegym.dethithu.model.RentalTimeSlot;
import com.codegym.dethithu.model.Stadium;
import com.codegym.dethithu.service.impl.StadiumService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/stadium")
public class StadiumController {

    @ModelAttribute("areaValues")
    public Area[] areaValues() {
        return Area.values();
    }

    @ModelAttribute("fieldTypeValues")
    public FieldType[] fieldTypeValues() {
        return FieldType.values();
    }

    @ModelAttribute("rentalTimeSlotValues")
    public RentalTimeSlot[] rentalTimeSlotValues() {
        return RentalTimeSlot.values();
    }

    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public ModelAndView listStadium(@PageableDefault(size = 3, page = 0, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
                                    @RequestParam(name = "nameSearch", defaultValue = "", required = false) String nameSearch,
                                    @RequestParam(name = "areaSearch", defaultValue = "", required = false) Area areaSearch,
                                    @RequestParam(name = "fieldTypeSearch", defaultValue = "", required = false) FieldType fieldTypeSearch) {
        ModelAndView modelAndView = new ModelAndView("/index");


        Page<Stadium> stadiums = stadiumService.findByNameContaining(nameSearch, pageable);
        if (fieldTypeSearch == null && areaSearch != null) {
            stadiums = stadiumService.findByNameContainingAndArea(nameSearch, areaSearch, pageable);
        } else if (fieldTypeSearch != null && areaSearch == null) {
            stadiums = stadiumService.findByNameContainingAndFieldType(nameSearch, fieldTypeSearch, pageable);
        } else if (fieldTypeSearch != null && areaSearch != null) {
            stadiums = stadiumService.findByNameContainingAndAreaAndFieldType(nameSearch, areaSearch, fieldTypeSearch, pageable);
        }
        modelAndView.addObject("stadiums", stadiums);
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("areaSearch", areaSearch);
        modelAndView.addObject("fieldTypeSearch", fieldTypeSearch);


        return modelAndView;
    }

    @GetMapping(path = {"create", "edit/{id}", "detail/{id}"})
    public ModelAndView form(@Valid @ModelAttribute StadiumDTO stadiumDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView modelAndView, @PathVariable(required = false) String id) {
        modelAndView.setViewName("/form");

        if (id == null) {
            modelAndView.addObject("stadium", new Stadium());
        } else {
            Optional<Stadium> foundStadium = stadiumService.findById(Integer.parseInt(id));
            if (foundStadium == null) {
                throw new StadiumNotFoundException("Stadium with id " + id + " not found");
            }
            modelAndView.addObject("stadium", foundStadium);
        }
        return modelAndView;
    }


    @GetMapping("delete/{id}")
    public String deleteStadium(@PathVariable String id) {
        stadiumService.remove(Integer.parseInt(id));
        return "redirect:/stadium";
    }

    @PostMapping("save")
    public String saveStadium(@ModelAttribute("stadium") @Valid StadiumDTO stadium, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            // Handle validation errors
            // Return the view containing the form
            redirectAttributes.addFlashAttribute("message", "Stadium saved faithfully!");
            if (stadium.getId() == null) {
                return "redirect:/stadium/create";
            }
            return "redirect:/stadium/edit/" + stadium.getId();
        }

        Stadium newStadium = new Stadium();
        BeanUtils.copyProperties(stadium, newStadium);
        stadiumService.save(newStadium);

        redirectAttributes.addFlashAttribute("message", "Stadium saved successfully!");
        return "redirect:/stadium";
    }


}
