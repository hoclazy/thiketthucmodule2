package control;

import model.User;

import java.util.List;
import java.util.ArrayList;

public class PhoneBook {
    private List<User> users = new ArrayList<>();

    public PhoneBook() {
    }

    public PhoneBook(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public int findIndexByNumberPhone(String numberPhone) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNumberPhone().equals(numberPhone)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void deleteUser(String numberPhone) {
        int index = findIndexByNumberPhone(numberPhone);
        if (index == -1) {
            System.out.println("Khong tim duoc danh ba voi so dien thoai tren");
        }
        else {
            users.remove(index);
            System.out.println("Xoa thanh cong");
        }
    }

    public List<User> findUserByNumberPhoneOrName (String input) {
        List<User> listFinder = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(input) || user.getNumberPhone().contains(input)) {
                listFinder.add(user);
            }
        }
        return listFinder;
    }

    public void updateUser(String numberPhone, User newUser) {
        int index = findIndexByNumberPhone(numberPhone);
        if (index == -1) {
            System.out.println("Khong tim duoc danh ba voi so dien thoai tren.");
        }
        else {
            users.set(index, newUser);
            System.out.println("Sua thanh cong");
        }
    }

    public void showPhoneBook() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
