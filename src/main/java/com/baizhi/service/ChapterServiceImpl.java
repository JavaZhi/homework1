package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ChapterServiceImpl implements  ChapterService{
    @Autowired
    private ChapterDao chapterDao;
    @Override
    public void saveChapter(Chapter c) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String s1 = s.replace("-", "");
        c.setId(s1);
        c.setCreate_time(new Date());
        c.setDuration("123");
        c.setSize("1000");
        c.setAlbumId("1");
        System.out.println(c);
        chapterDao.insertChapter(c);
    }
    @Override
    public List<Chapter> findAll() {
        return chapterDao.selectChapter();
    }
}
