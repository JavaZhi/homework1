package com.baizhi;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework1ApplicationTests {
    @Autowired
    private ChapterDao chapterDao;
    @Test
    public void contextLoads() {
        List<Chapter> chapters = chapterDao.selectChapter();
        for (Chapter chapter : chapters) {
            System.out.println(chapter);

        }
    }

}
