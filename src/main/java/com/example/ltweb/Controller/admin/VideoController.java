package com.example.ltweb.Controller.admin;

import com.example.ltweb.Entity.Category;
import com.example.ltweb.Entity.Video;
import com.example.ltweb.Service.CategoryService;
import com.example.ltweb.Service.IVideoService;
import com.example.ltweb.Service.VideoService;
import com.example.ltweb.utils.Constant;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold= 1024 * 1024, maxFileSize= 1024 * 1024*5, maxRequestSize = 1024 * 1024*5*5)
@WebServlet(urlPatterns = {"/admin/videos","/admin/video/add","/admin/video/edit","/admin/video/insert",
        "/admin/video/delete", "/admin/video/update"})
public class VideoController extends HttpServlet {
    IVideoService videoService = new VideoService();
    String categoryid ="";
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("videos")) {
            List<Video> list = videoService.findAll();
            req.setAttribute("videoList", list);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        }
        else if(url.contains("add")) {
            List<Category> list = categoryService.findAll();
            req.setAttribute("listCate", list);
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        }
        else if(url.contains("edit")) {
            String videoid = req.getParameter("id");
            Video video = videoService.findById(videoid);
            req.setAttribute("video",video);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        }
        else if (url.contains("delete")){
            String id = req.getParameter("id");
            Video video = videoService.findById(id);
            try {
                videoService.delete(video);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (url.contains("insert")) {
            String videoId = req.getParameter("video");
            String status = req.getParameter("status");
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            int active = Integer.parseInt(status);
            String des = req.getParameter("description");
            String title = req.getParameter("title");
            int views = Integer.parseInt(req.getParameter("views"));

            String fname = "";

            Video video = new Video();
            video.setVideoId(videoId); // Thiết lập ID video
            video.setActive(active); // Thiết lập trạng thái video
            video.setDescription(des); // Thiết lập mô tả video
            video.setTitle(title); // Thiết lập tiêu đề video
            video.setViews(views); // Thiết lập số lượt xem video

            // Thiết lập đối tượng Category cho Video
            Category category = categoryService.findById(categoryid);
            video.setCategory(category);

            String uploadPath = Constant.UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            try{
                Part part = req.getPart("poster");
                if (part.getSize() > 0) {
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    //Doi ten file
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    //upload file
                    part.write(uploadPath + "/" + fname);
                    //ghi ten file vao data
                    video.setPoster(fname);
                }
                else{
                    video.setPoster("https://images.samsung.com/is/image/samsung/p6pim/vn/sm-a556elvdxxv/gallery/vn-galaxy-a55-5g-sm-a556-sm-a556elvdxxv-540189638?$650_519_PNG$");
                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

            videoService.insert(video);
            resp.sendRedirect(req.getContextPath() + "/admin/videos?id=" + categoryid);
        }
        else if(url.contains("update")){
            String videoID = req.getParameter("videoid");
            int active = Integer.parseInt(req.getParameter("active"));
            int views = Integer.parseInt(req.getParameter("views"));

            Video vi = new Video();
            vi.setVideoId(videoID);
            vi.setDescription(req.getParameter("description"));
            vi.setTitle(req.getParameter("title"));
            vi.setViews(views);
            vi.setActive(active);

            String fname = "";
            String uploadPath = Constant.UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            try{
                Part part = req.getPart("images");
                if (part.getSize() > 0) {
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    //Doi ten file
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    part.write(uploadPath + "/" + fname);
                    //ghi ten file vao data
                    vi.setPoster(fname);
                }
                else{
                    vi.setPoster("https://images.samsung.com/is/image/samsung/p6pim/vn/sm-a556elvdxxv/gallery/vn-galaxy-a55-5g-sm-a556-sm-a556elvdxxv-540189638?$650_519_PNG$");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            videoService.update(vi);
            resp.sendRedirect(req.getContextPath() + "/admin/videos?id=" + categoryid);
        }
    }
}
