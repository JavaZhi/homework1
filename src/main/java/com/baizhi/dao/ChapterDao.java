package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    List<Chapter> selectChapter();
    void insertChapter(Chapter c);
}
