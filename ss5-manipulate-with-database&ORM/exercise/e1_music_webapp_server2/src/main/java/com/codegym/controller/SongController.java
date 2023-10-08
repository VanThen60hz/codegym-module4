package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import com.codegym.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/song/")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("list")
    public String home(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Song> songs = songService.findAll();
        model.addAttribute("listSong", songs);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping(path = {"/form", "/form/{id}"})
    public String newSongForm(Model model, @PathVariable(required = false) String id){
        model.addAttribute("song", new Song());
        return "form";

    }

    @PostMapping("/save")
    public RedirectView saveProduct(@ModelAttribute("song") Song song,
                                    @RequestParam("audio") MultipartFile multipartFile) throws IOException {



        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        song.setSongs(fileName);

        Song saveSong = songService.add(song);

        String uploadDir = "song-audios/" + saveSong.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/song/list ", true);
    }
}
