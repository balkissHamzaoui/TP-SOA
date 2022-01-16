package operations;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Random;


@WebService
public class UserService {

    // ArrayList to store all users
    private ArrayList<User> usersList=new ArrayList<User>();

    //GET ALL USERS
    @WebMethod
    public ArrayList<User> getUsers() {
        return  usersList;
    }

    // GET USER BY ID
    @WebMethod
    public User getUserById(@WebParam(name="id") long id){
            User userTofind = null;
        for(User user: usersList){
            if(user.getId()==id){
                userTofind= new User(user);
            }
        }
        return userTofind;
    }

    //ADD NEW USER
    @WebMethod
    public User addUser(@WebParam(name = "name") String name,@WebParam(name = "FamilyName") String FamilyName){
        long id= new Random().nextLong();
        User user=new User(id,name,FamilyName);
        usersList.add(user);

        return user;
    }

    //DELETE USER BY ID
    @WebMethod
    public void deleteUser(@WebParam(name = "id") long id){
        User userTodelete=null;
        for(User user: usersList){
            if(user.getId()==id){
                userTodelete=new User(user);
            }
        }

        usersList.remove(userTodelete);
    }

    // UPDATE USER NAME
    @WebMethod
    public User updateUser(@WebParam(name = "id") long id,@WebParam(name = "name") String name){
        User userToUpdate=null;
        for(User user: usersList){
            if(user.getId()==id){
                user.setName(name);
                userToUpdate=new User(user);
            }
        }
        return userToUpdate;
    }

}
