package com.example.KhoaHoc_Springboot_CRUD.service;

import com.example.KhoaHoc_Springboot_CRUD.entity.KhoaHoc;
import com.example.KhoaHoc_Springboot_CRUD.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private KhoaHocRepository khoaHocRepository;

    @Override
    public KhoaHoc getKhoaHoc(Long id) {
        KhoaHoc khoaHoc = khoaHocRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Course is not exist!");
        });
        return khoaHoc;
    }

    @Override
    public List<KhoaHoc> getKhoaHocAll() {
        return khoaHocRepository.findAll();
    }

    @Override
    public KhoaHoc createKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocRepository.save(khoaHoc);
    }

    @Override
    public KhoaHoc updateKhoaHoc(Long id, KhoaHoc khoaHocData) {
        KhoaHoc khoaHoc = khoaHocRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Course is not exist!");
        });
        if (khoaHocData.getNameCourse() != null) {
            khoaHoc.setNameCourse(khoaHocData.getNameCourse());
        }
        if (khoaHocData.getNameTeacher() != null) {
            khoaHoc.setNameTeacher(khoaHocData.getNameTeacher());
        }
        if (khoaHocData.getOldprice() != null) {
            khoaHoc.setOldprice(khoaHocData.getOldprice());
        }
        if (khoaHocData.getNewprice() != null) {
            khoaHoc.setNewprice(khoaHocData.getNewprice());
        }
        if (khoaHocData.getTag1() != null) {
            khoaHoc.setTag1(khoaHocData.getTag1());
        }
        if (khoaHocData.getTag2() != null) {
            khoaHoc.setTag2(khoaHocData.getTag2());
        }
        if (khoaHocData.getDecription() != null) {
            khoaHoc.setDecription(khoaHocData.getDecription());
        }
        if (khoaHocData.getImageCourse() != null) {
            khoaHoc.setImageCourse(khoaHocData.getImageCourse());
        }
        if (khoaHocData.getImageTeacher() != null) {
            khoaHoc.setImageTeacher(khoaHocData.getImageTeacher());
        }

       return khoaHocRepository.save(khoaHoc);
    }



    @Override
    public void deleteKhoaHoc(Long id) {
        KhoaHoc khoaHoc = khoaHocRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Course is not exist!");
        });

        khoaHocRepository.deleteById(id);
    }
}
