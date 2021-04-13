package com.example.aosp_end.controller;

import com.example.aosp_end.bean.Classinfo;
import com.example.aosp_end.bean.Version;
import com.example.aosp_end.dao.ClassInfoDao;
import com.example.aosp_end.dao.VersionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class VersionController {

    @Autowired
    VersionDao versionDao;
    @Autowired
    ClassInfoDao classInfoDao;

    @RequestMapping("add")
    public Object getVersionChange(){
        List<Version> versions = versionDao.getAll();
        List<Classinfo> classinfos;
        List<List<Object>> res = new ArrayList<>();
        for (Version version:
             versions) {
            classinfos = classInfoDao.getAllByVersionId(version.getId());
            int count = 0;
            List<Object> temp = new ArrayList<>();
            for (int i = 0; i < classinfos.size(); i++) {
                if ( classinfos.get(i).getState() == 1) {
                    count++;
                }
            }
            temp.add(version.getCommit_date());
            temp.add(count);
            res.add(temp);
        }
        return res;
    }

    @RequestMapping("del")
    public Object getDelChange() {
        List<Version> versions = versionDao.getAll();
        List<Classinfo> classinfos;
        List<List<Object>> res = new ArrayList<>();
        for (Version version:
                versions) {
            classinfos = classInfoDao.getAllByVersionId(version.getId());
            int count = 0;
            List<Object> temp = new ArrayList<>();
            for (int i = 0; i < classinfos.size(); i++) {
                if ( classinfos.get(i).getState() == -1) {
                    count++;
                }
            }
            temp.add(version.getCommit_date());
            temp.add(count);
            res.add(temp);
        }
        return res;
    }

    @RequestMapping("modify")
    public Object getModifyChange() {
        List<Version> versions = versionDao.getAll();
        List<Classinfo> classinfos;
        List<List<Object>> res = new ArrayList<>();
        for (Version version:
                versions) {
            classinfos = classInfoDao.getAllByVersionId(version.getId());
            int count = 0;
            List<Object> temp = new ArrayList<>();
            for (int i = 0; i < classinfos.size(); i++) {
                if ( classinfos.get(i).getState() == 0) {
                    count++;
                }
            }
            temp.add(version.getCommit_date());
            temp.add(count);
            res.add(temp);
        }
        return res;
    }

    @RequestMapping("change")
    public Object Change() {
        List<Version> versions = versionDao.getAll();
        List<Classinfo> classinfos;
        List<List<List<Object>>> res = new ArrayList<>();
        List<List<Object>> adds = new ArrayList<>();
        List<List<Object>> dels = new ArrayList<>();
        List<List<Object>> mods = new ArrayList<>();
        for (Version version:
                versions) {
            classinfos = classInfoDao.getAllByVersionId(version.getId());
            int add_count = 0;
            int del_count = 0;
            int mod_count = 0;
            List<Object> add_temp = new ArrayList<>();
            List<Object> del_temp = new ArrayList<>();
            List<Object> mod_temp = new ArrayList<>();
            for (int i = 0; i < classinfos.size(); i++) {
                if ( classinfos.get(i).getState() == 1) {
                    add_count++;
                }
                if ( classinfos.get(i).getState() == -1) {
                    del_count++;
                }
                if ( classinfos.get(i).getState() == 0) {
                    mod_count++;
                }
            }
            add_temp.add(version.getCommit_date());
            del_temp.add(version.getCommit_date());
            mod_temp.add(version.getCommit_date());
            add_temp.add(add_count);
            del_temp.add(del_count);
            mod_temp.add(mod_count);
            adds.add(add_temp);
            dels.add(del_temp);
            mods.add(mod_temp);
        }
        res.add(adds);
        res.add(dels);
        res.add(mods);
        return res;
    }

    @RequestMapping("codeclone")
    public Object getCodeClone() {
        List<Version> versions = versionDao.getAll();
        List<Classinfo> classinfos;
        List<List<Object>> res = new ArrayList<>();
        for (Version version:
                versions) {
            classinfos = classInfoDao.getAllByVersionId(version.getId());
            if (classinfos.size() == 0) {
                continue;
            }
            double degree = 0;
            List<Object> temp = new ArrayList<>();
            for (int i = 0; i < classinfos.size(); i++) {
                if ( classinfos.get(i).getState() == 0) {
                    degree = (double) ( classinfos.get(i).getAdd_row() + classinfos.get(i).getDel_row() ) / (double) classinfos.get(i).getCode_row();
                }else{
                    degree = 0;
                }
                temp.add(version.getCommit_date());
                temp.add(degree);
            }
            res.add(temp);
        }
        return res;
    }
}
