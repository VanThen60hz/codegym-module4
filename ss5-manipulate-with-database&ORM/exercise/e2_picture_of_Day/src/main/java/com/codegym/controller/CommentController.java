package com.codegym.controller;
import com.codegym.model.Comment;
import com.codegym.model.Picture;
import com.codegym.repository.CommentRepository;
import com.codegym.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Controller
public class CommentController {
    private final CommentRepository commentRepository;
    private final PictureRepository pictureRepository;

    public CommentController(CommentRepository commentRepository, PictureRepository pictureRepository){
        this.commentRepository = commentRepository;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping(value = {"/","/{c}"})
    public String home(Model model, @PathVariable(required = false) Integer c) {
        if(c != null){
            commentRepository.updateLike(c);
        }

        model.addAttribute("comment", new Comment());
        ZonedDateTime tz = ZonedDateTime.now(ZoneId.of("America/New_York"));
        Optional<Picture> optionalPicture = pictureRepository.find(tz.toLocalDate());
        model.addAttribute("picture", optionalPicture.isPresent() ? optionalPicture.get() : new Picture());

        return "home";
    }

    @PostMapping
    public String save(Comment comment) {
        commentRepository.save(comment);
        return "redirect:/";
    }
}