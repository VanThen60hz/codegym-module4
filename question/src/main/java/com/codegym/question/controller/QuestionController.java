package com.codegym.question.controller;

import com.codegym.question.dto.QuestionDto;
import com.codegym.question.exception.NotFoundException;
import com.codegym.question.model.Question;
import com.codegym.question.model.Type;
import com.codegym.question.service.IQuestionService;
import com.codegym.question.service.ITypeService;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private final IQuestionService questionService;
    private final ITypeService typeService;

    public QuestionController(IQuestionService questionService, ITypeService typeService) {
        this.questionService = questionService;
        this.typeService = typeService;
    }

    @ModelAttribute("typeValues")
    public List<Type> types() {
        return typeService.findAll();
    }

    @GetMapping
    public ModelAndView listQuestions(@PageableDefault(size = 3, page = 0, sort = "createdDate", direction = Sort.Direction.ASC) Pageable pageable,
                                      @RequestParam(name = "titleSearch",defaultValue = "", required = false) String titleSearch,
                                      @RequestParam(name = "typeSearch",defaultValue = "", required = false) String typeSearch
    ) {
        Page<Question> questions = questionService.findByTittleContainingAndType_NameContaining(titleSearch,typeSearch,pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("questions", questions);
        modelAndView.addObject("titleSearch", titleSearch);
        modelAndView.addObject("typeSearch", typeSearch);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView createForm(@Valid @ModelAttribute QuestionDto questionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
        modelAndView.setViewName("create");

            System.out.println("id null");
            modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @GetMapping(path = {"edit/{id}", "detail/{id}"})
    public ModelAndView form(@Valid @ModelAttribute QuestionDto questionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView modelAndView, @PathVariable(required = false) String id) {
        modelAndView.setViewName("edit");

        if (id == null) {
            System.out.println("id null");
            modelAndView.addObject("question", new Question());
        } else {
            Optional<Question> foundQuestion = questionService.findById(Integer.parseInt(id));
            if (foundQuestion.isEmpty()) {
                throw new NotFoundException("Question with id " + id + " not found");
            }
            modelAndView.addObject("question", foundQuestion);
        }
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String deleteForm(@PathVariable String id,  RedirectAttributes redirectAttributes) {
        Optional<Question> foundQuestion = questionService.findById(Integer.parseInt(id));
        if (foundQuestion.isEmpty()) {
            throw new NotFoundException("Question with id " + id + " not found");
        }
        questionService.remove(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("message", "Question deleted successfully!");
        return "redirect:/question";
    }

    @PostMapping("save")
    public String saveQuestions(@ModelAttribute("question") @Valid QuestionDto questionDto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
//            System.out.println("Error! " + questionDto.getId() + " " + questionDto.getTitle() + " " + questionDto.getContent() + " " + questionDto.getType());
            // Handle validation errors
            // Return the view containing the form
            String errorMessage = Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
            redirectAttributes.addFlashAttribute("message", errorMessage);
//            redirectAttributes.addFlashAttribute("message", "Stadium saved faithfully!");

            if(questionDto.getId() == null){
                return "redirect:/question/create";
            }
            return "redirect:/question/edit/" + questionDto.getId();
        }



        Question newQuestion = new Question();
        BeanUtils.copyProperties(questionDto, newQuestion);
        newQuestion.setCreatedDate(LocalDate.now());
        if (newQuestion.getId() != null) {
            newQuestion.setStatus(1);
        } else {
            newQuestion.setStatus(0);
        }

        questionService.save(newQuestion);

        redirectAttributes.addFlashAttribute("message", "Stadium saved successfully!");
        return "redirect:/question";
    }

}
