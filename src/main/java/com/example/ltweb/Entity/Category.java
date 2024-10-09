package com.example.ltweb.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Categories")
@NamedQuery(name = "Category.findAll",query = "SELECT c FROM Category c ")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatogeryId")
    private int categoryid;

    @Column(name = "CatogeryName",columnDefinition = "nvarchar(50) not null")
    @NotEmpty(message = "Không được bỏ trống")
    private String categoryname;

    @Column(name = "Images",columnDefinition = "nvarchar(500) null")
    private String images;


    private int status;

    //bi-directional many-to-one association to Video
    @OneToMany(mappedBy="category")
    private List<Video> videos;


    public Video addVideo(Video video) {
        getVideos().add(video);
        video.setCategory(this);
        return video;
    }

    public Video removeVideo(Video video) {
        getVideos().remove(video);
        video.setCategory(null);
        return video;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", categoryname='" + categoryname + '\'' +
                ", images='" + images + '\'' +
                ", status=" + status +
                ", videos=" + videos +
                '}';
    }
}