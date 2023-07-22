package com.example.KhoaHoc_Springboot_CRUD.service;

import com.example.KhoaHoc_Springboot_CRUD.entity.KhoaHoc;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface CourseService {
    KhoaHoc getKhoaHoc(Long id);

    List<KhoaHoc> getKhoaHocAll();

    KhoaHoc createKhoaHoc( KhoaHoc khoaHoc);

    KhoaHoc updateKhoaHoc( Long id, KhoaHoc khoaHocData);

    void deleteKhoaHoc( Long id);
}
