package com.example.ltweb.DAO;
import com.example.ltweb.Config.JPAConfig;
import com.example.ltweb.Entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import jakarta.persistence.*;

public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public void insert(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            //gọi phuong thức để insert, update, delete
            enma.persist(category);// ham insert
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            //gọi phuong thức để insert, update, delete
            enma.merge(category); // ham update
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }


    @Override
    public void delete(int cateid) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            //gọi phuong thức để insert, update, delete
            Category category = enma.find(Category.class, cateid);
            if (category != null) {
                enma.remove(category);
            } else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public Category findById(int cateid) {
        EntityManager enma = JPAConfig.getEntityManager();
        Category category = enma.find(Category.class, cateid);
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    @Override
    public List<Category> searchByName(String catname) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.categoryname like :catename";
        TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
        query.setParameter("catename", "%" + catname + "%");
        return query.getResultList();
    }

    @Override
    public Category findByName(String catename) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT c FROM Category c WHERE c.categoryname = :name";
            Category category = enma.createQuery(jpql, Category.class)
                    .setParameter("name", catename)
                    .getSingleResult();
            return category;
        } catch (NoResultException e) {
            System.out.println("Không tìm thấy Category với name: " + catename);
            return null;
        } finally {
            enma.close();
        }
    }

    @Override
    public List<Category> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        query.setFirstResult(page * pagesize);
        query.setMaxResults(pagesize);
        return query.getResultList();
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT count(c) FROM Category c";
        Query query = enma.createQuery(jpql);
        return ((Long) query.getSingleResult()).intValue();
    }

}
