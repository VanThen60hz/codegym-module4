package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@Controller
public class SongController {
    private final SongService songService;
    @Autowired
    private ServletContext servletContext;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home", "res", songService.getAll());
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "form";
    }

    @PostMapping
    public String save(@ModelAttribute Song song) {
        songService.create(servletContext, song);

        return "redirect:/";
    }

    @GetMapping("img/{code}")
    public ResponseEntity<Resource> viewImage(@PathVariable String code) {
        return songService.downloadFile(this.servletContext, code);
    }
}