import com.example.ltweb.DAO.CategoryDaoImpl;
import com.example.ltweb.DAO.ICategoryDao;
import com.example.ltweb.Model.CategoryModel;
import com.example.ltweb.Model.UserModel;
import com.example.ltweb.Service.IUserService;
import com.example.ltweb.Service.UserService;

public class Program {
    public static void main(String[] args) {
        ICategoryDao categoryDao = new CategoryDaoImpl();
//        System.out.println(categoryDao.findByName("iphone"));
//        CategoryModel categoryModel = new CategoryModel("samson","3",1);
//        categoryDao.insert(categoryModel);
        System.out.println(categoryDao.searchByName("sam"));
    }
}
