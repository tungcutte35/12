package com.example.KhoaHoc_Springboot_CRUD.controller;
import com.example.KhoaHoc_Springboot_CRUD.entity.KhoaHoc;
import com.example.KhoaHoc_Springboot_CRUD.repository.KhoaHocRepository;
import com.example.KhoaHoc_Springboot_CRUD.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/khoahoc")
@Slf4j
public class KhoaHocController {

//    @Autowired
//    private KhoaHocRepository khoaHocRepository;
    @Autowired
    private CourseService courseService;


    @Cacheable(value = "khoahoc", key = "#id")
    @GetMapping("/{id}")
    public KhoaHoc getKhoaHoc(@PathVariable("id") Long id) {

//        try {
//            log.info("Getting user with ID {}.", id);
//            return khoaHocRepository.findById(id)
//                    .orElseThrow(() -> new Exception("KhoaHoc not found with id: " + id));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        log.info("Getting user with ID {}.", id);
        return courseService.getKhoaHoc(id);

    }


    @Cacheable("khoahoc")
    @GetMapping("/")
    public List<KhoaHoc> getKhoaHocAll() {
        return courseService.getKhoaHocAll();
    }

    @PostMapping("/")
    public KhoaHoc createKhoaHoc(@RequestBody KhoaHoc khoaHoc) {
        KhoaHoc khoaHocNew = courseService.createKhoaHoc(khoaHoc);
        System.out.println("GET ID CREATE: " + khoaHocNew.getId());
        return khoaHocNew;

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKhoaHoc(@PathVariable Long id, @RequestBody KhoaHoc khoaHocData) {
        courseService.updateKhoaHoc(id, khoaHocData);

        return ResponseEntity.ok("Update course is success");
    }

    @DeleteMapping("/{id}")
    public void deleteKhoaHoc(@PathVariable Long id) {

        courseService.deleteKhoaHoc(id);

        ResponseEntity.ok("Delete course is success");
    }
}
