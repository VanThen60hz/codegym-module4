package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import com.codegym.util.CommonUntil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
@PropertySource("classpath:upload_file.properties")
public class ProductController {
    private final IProductService productService = new ProductService();

    @Value("${path_upload}")
    private String path_upload;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "home";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductForm productForm) {
        String file_upload = "";
        List<Product> products = productService.findAll();

        int lastId = 0;

        if (!products.isEmpty()) {
            lastId = products.get(products.size() - 1).getId();
        }
        productForm.setId(lastId + 1);

        MultipartFile multipartFile = productForm.getImage();
        String idEncode = CommonUntil.encode64(String.valueOf(productForm.getId()));

        try {
            File dir = new File(System.getProperty(path_upload) + File.separator + "img");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            file_upload = dir.getAbsolutePath() + File.separator + CommonUntil.encodeMD5(multipartFile.getName() + LocalDateTime.now());
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(file_upload));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescription(), String.format("img/%s"
                , idEncode + "QG"), CommonUntil.getMimeTypeFromFileName(multipartFile.getOriginalFilename()), file_upload);
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("img/{code}")
    public ResponseEntity<Resource> showImage(@PathVariable String code) {
        return productService.downloadFile(code);
    }
}