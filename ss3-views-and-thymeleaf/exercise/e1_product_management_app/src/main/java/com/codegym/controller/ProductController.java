package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String home(Model model, @RequestParam(name = "q", required = false) String searchName) {
        List<Product> products = searchName == null ? productService.findAll() : productService.search(searchName);
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/save")
    public String save(Product product,
                       RedirectAttributes redirectAttributes) {
        productService.save(product);

        redirectAttributes.addFlashAttribute("mess", "Thành công");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Optional<Product> opProduct = productService.getById(id);
        opProduct.ifPresent(product -> model.addAttribute("product", product));

        return "form";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable("id") Integer id) {
        Optional<Product> opProduct = productService.getById(id);
        opProduct.ifPresent(product -> model.addAttribute("product", product));

        return "view";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);

        return "redirect:/";
    }

}
