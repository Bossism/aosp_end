package com.example.aosp_end.controller;

import com.example.aosp_end.bean.Classinfo;
import com.example.aosp_end.dao.ClassInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassController {

    @Autowired
    ClassInfoDao classInfoDao;

    @RequestMapping("addclass")
    public Object getClassChange() {
        List<Classinfo> classinfo = classInfoDao.getAll();
        List<Integer> ids = new ArrayList<>();
        List<Integer> addrows = new ArrayList<>();
        for (int i = 0; i < classinfo.size(); i++) {
            ids.add(classinfo.get(i).getId());
            addrows.add(classinfo.get(i).getAdd_row());
        }
        List<Object> res = new ArrayList<>();
        res.add(ids);
        res.add(addrows);
        return res;
    }
}
