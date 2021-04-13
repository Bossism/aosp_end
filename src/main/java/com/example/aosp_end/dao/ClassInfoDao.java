package com.example.aosp_end.dao;

import com.example.aosp_end.bean.Classinfo;

import java.util.List;

public interface ClassInfoDao {
    List<Classinfo> getAll();

    List<Classinfo> getAllByVersionId(Long id);
}
