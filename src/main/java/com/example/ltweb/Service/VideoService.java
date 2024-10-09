package com.example.ltweb.Service;

import com.example.ltweb.DAO.IVideoDao;
import com.example.ltweb.DAO.VideoDaoImpl;
import com.example.ltweb.Entity.Video;

import java.util.List;

public class VideoService implements IVideoService {
    IVideoDao videoDao = new VideoDaoImpl();

    @Override
    public void insert(Video video) {
        Video vid = videoDao.findById(video.getVideoId());
        if(vid==null){
            videoDao.insert(video);
        }
        else{
            System.out.println("Đã tồn tại tài khoản");
        }
    }

    @Override
    public void delete(Video video) throws Exception {
        Video vid = videoDao.findById(video.getVideoId());
        if(vid!=null){
            videoDao.delete(video);
        }
        else{
            System.out.println("Không tồn tại tài khoản");
        }
    }

    @Override
    public void update(Video video) {
        Video vid = videoDao.findById(video.getVideoId());
        if(vid!=null){
            videoDao.update(video);
        }
        else{
            System.out.println("Không tồn tại tài khoản");
        }
    }

    @Override
    public Video findById(String id) {
        return videoDao.findById(id);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public List<Video> findListById(String id) {
        return videoDao.findListById(id);
    }
}
