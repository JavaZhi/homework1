package com.baizhi.controller;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService cs;

    @ResponseBody
    @RequestMapping("/findAll")
    public Object findAll() {
        System.out.println("findAll111111");
        System.out.println("3333333333333");
        List<Chapter> list = cs.findAll();
        return list;
    }

    @RequestMapping("/insertChapter")
    public void insertChapter(MultipartFile upFile, Chapter cc, HttpServletRequest req) {
        System.out.println("insertChapter");
        if (upFile.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = upFile.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "F:/sss/"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            upFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        cc.setUrl(filename);
        System.out.println("controllerInset999999" + cc);
        cs.saveChapter(cc);

    }

    @RequestMapping("/findA")
    public void findA() {
        System.out.println(111111111);
    }

    @RequestMapping("/downFile")
    public void dowmFile(HttpSession session, HttpServletRequest req, HttpServletResponse res) throws IOException {
        String path = "111.jpg";
        path = URLDecoder.decode(path, "UTF-8");
        String RealPathDir = session.getServletContext().getRealPath(path);
        //下载资源的路径
        InputStream in = new FileInputStream(RealPathDir);
        //获得输出流
        OutputStream out = res.getOutputStream();
        //设置响应头，指定文件下载到客户端的文件名和打开方式
        //设置响应类型
        path.lastIndexOf(".");
        String ext = path.substring(path.lastIndexOf("."));
        res.setContentType(req.getSession().getServletContext().getMimeType(ext));
        res.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(path, "UTF-8"));
        IOUtils.copy(in, out);


    }
    @RequestMapping("/down")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("aaaaaaaaaaa");
        String fileName = "yyyy.xls";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "F:\\webTest\\homework1\\src\\main\\webapp\\";
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

