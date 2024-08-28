
import java.util.LinkedList;

public class Acct {

    private LinkedList<User> users;

    public Acct() {
        this.users = new LinkedList<User>();
    }

    public boolean createUser(String name, String password) {
        User user = new User();
        if (findUser(name) >= 0) {
            System.out.println("User already exists!");
            return false;
        }

        user.setUsername(name);
        user.setPassword(password);
        user.setActive(true);
        users.add(user);
        return true;
    }


    private int findUser(String name) {

        for (int i = 0; i < users.size(); i++) {
            User checkedUser = users.get(i);
            if (checkedUser.getUsername().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateUser(String name, String password) {
        User user = new User();
        int index = findUser(name);
        if (index < 0) {
            System.out.println("User does not exist!");
            return false;
        }

        user.setUsername(name);
        user.setPassword(password);
        users.set(index,user);
        return true;
    }

    public boolean deleteUser(String name){
        int index = findUser(name);
        if(index < 0){
            System.out.println("User does not exist!");
            return false;
        }
        users.remove(index);
        return true;
    }

    @Override
    public String toString() {
        return "Acct{" +
                ", users=" + users +
                '}';
    }
}
