package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.util.CommonUntil;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    public ResponseEntity<Resource> downloadFile(String code) {
        Resource resource = null;
        String id = code.substring(0, code.length() - 2);
        int idDecode = Integer.parseInt(CommonUntil.decode64(id));
        Optional<Product> optionalProduct = products.stream().filter(e -> e.getId() == idDecode).findFirst();

        String fileName = "";
        String mine = "";
        if (optionalProduct.isPresent()) {
            String path = optionalProduct.get().getPath();
            resource = loadFileAsResource(path);
            fileName = optionalProduct.get().getName();
            mine = optionalProduct.get().getFileType();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mine))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    public Resource loadFileAsResource(String filePath) {
        Resource resource = null;
        try {
            resource = new UrlResource(Paths.get(filePath).toUri());
            if (resource.exists())
                return resource;
        } catch (MalformedURLException e) {
            e.fillInStackTrace();
        }
        return resource;
    }
}
