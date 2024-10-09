package com.example.ltweb.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import com.example.ltweb.Config.JPAConfig;
import com.example.ltweb.DAO.IVideoDao;
import com.example.ltweb.Entity.Video;

import java.util.List;

public class VideoDaoImpl implements IVideoDao {
    @Override
    public void insert(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            enma.persist(video); // Lưu video vào cơ sở dữ liệu
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans.isActive()) {
                trans.rollback(); // Hoàn tác giao dịch nếu có lỗi
            }
            throw e;
        } finally {
            if (enma.isOpen()) {
                enma.close(); // Đóng EntityManager
            }
        }
    }

    @Override
    public void delete(Video video) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            if (video != null) {
                video = enma.merge(video); // Hợp nhất video vào EntityManager
                enma.remove(video); // Xóa video
            } else {
                throw new Exception("Không tìm thấy video");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans.isActive()) {
                trans.rollback(); // Hoàn tác giao dịch nếu có lỗi
            }
            throw e;
        } finally {
            if (enma.isOpen()) {
                enma.close(); // Đóng EntityManager
            }
        }
    }

    @Override
    public void update(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            enma.merge(video); // Cập nhật video
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (trans.isActive()) {
                trans.rollback(); // Hoàn tác giao dịch nếu có lỗi
            }
            throw e;
        } finally {
            if (enma.isOpen()) {
                enma.close(); // Đóng EntityManager
            }
        }
    }

    @Override
    public Video findById(String id) {
        EntityManager enma = JPAConfig.getEntityManager();
        return enma.find(Video.class, id); // Tìm video theo ID
    }

    @Override
    public List<Video> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
        return query.getResultList(); // Trả về danh sách tất cả video
    }

    @Override
    public List<Video> findListById(String categoryId) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createQuery("SELECT v FROM Video v WHERE v.category.categoryid = :categoryId", Video.class);
        query.setParameter("categoryId", Integer.parseInt(categoryId)); // Chuyển đổi categoryId từ String sang int
        return query.getResultList(); // Trả về danh sách video theo categoryId
    }
}