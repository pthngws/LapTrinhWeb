package com.example.ltweb.DAO;

import com.example.ltweb.Entity.Video;

import java.util.List;

public interface IVideoDao {
    void insert(Video video);

    void delete(Video video) throws Exception;

    void update(Video video);

    Video findById(String id);

    List<Video> findAll();
    List<Video> findListById(String id);
}
