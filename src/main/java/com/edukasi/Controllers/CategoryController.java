package com.edukasi.Controllers;

import com.edukasi.Models.Category;
import com.edukasi.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/kategory")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResponseEntity<?> index() throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            List<Category> category = categoryRepository.findAll();
            map.put("data", category);
            map.put("status", "success");
            return ResponseEntity.ok().body(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create() throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            List<Category> category = categoryRepository.findAll();
            map.put("data", category);
            map.put("status", "success");
            return ResponseEntity.ok().body(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/show/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> show() throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            List<Category> category = categoryRepository.findAll();
            map.put("data", category);
            map.put("status", "success");
            return ResponseEntity.ok().body(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update() throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            List<Category> category = categoryRepository.findAll();
            map.put("data", category);
            map.put("status", "success");
            return ResponseEntity.ok().body(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete() throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            List<Category> category = categoryRepository.findAll();
            map.put("data", category);
            map.put("status", "success");
            return ResponseEntity.ok().body(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
