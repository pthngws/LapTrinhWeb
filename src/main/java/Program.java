import com.example.ltweb.Model.UserModel;
import com.example.ltweb.Service.IUserService;
import com.example.ltweb.Service.UserService;

public class Program {
    public static void main(String[] args) {
        UserModel user = new UserModel("123123","123@123","1231231","1");
        IUserService use = new UserService();
        use.insert(user);
    }
}
