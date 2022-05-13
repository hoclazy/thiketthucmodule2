package view;

import control.PhoneBook;
import date.DateFormatter;
import model.User;
import validate.DateValidate;
import validate.EmailValidate;
import validate.PhoneNumberValidate;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public static void builtMenu() {
        System.out.println("---- CHUONG TRINH QUAN LY DANH BA ----");
        System.out.println("MOI CHON CHUC NANG: ");
        System.out.println("1. Xem");
        System.out.println("2. Them ");
        System.out.println("3. Cap nhat");
        System.out.println("4. Xoa");
        System.out.println("5. Tim kiem");
        System.out.println("6. Đoc tu file");
        System.out.println("7. Ghi tu file");
        System.out.println("8. Thoat");
    }

    public static User createUser(Scanner scl) {
        DateValidate dateValidate = new DateValidate();
        EmailValidate emailValidate = new EmailValidate();
        PhoneNumberValidate phoneNumberValidate = new PhoneNumberValidate();
        System.out.print("Nhap ten: ");
        String name = scl.nextLine().trim();
        String phoneNumber = "";
        while (true) {
            System.out.print("Nhap so dien thoai: ");
            String phoneNumberTemp = scl.nextLine().trim();
            if (phoneNumberValidate.validate(phoneNumberTemp)) {
                phoneNumber = phoneNumberTemp;
                break;
            }
            System.out.println("So dien thoai cua ban chua dung dinh dang");
        }
        System.out.print("Nhap nhom: ");
        String group = scl.nextLine().trim();
        System.out.print("Nhap gioi tinh: ");
        String sex = scl.nextLine().trim().toLowerCase();
        System.out.print("Nhap dia chi: ");
        String address = scl.nextLine();
        String email = "";
        while (true) {
            System.out.print("Nhap email: ");
            String emailTemp = scl.nextLine().trim();
            if (emailValidate.validate(emailTemp)) {
                email = emailTemp;
                break;
            }
            System.out.println("Email cua ban chua dung dinh dang");
        }
        LocalDate dateOfBirth = LocalDate.now();
        while (true) {
            System.out.print("Nhap ngay sinh(nam - thang - ngay): ");
            String date = scl.nextLine();
            if (dateValidate.validate(date)) {
                dateOfBirth = DateFormatter.parseDate(date);
                break;
            }
            System.out.println("Ban phai nhap dung dinh dang");
        }
        return new User(phoneNumber, group, name, sex, address, dateOfBirth, email);
    }

    public static void editUser(Scanner scl, PhoneBook phoneBook) {
        DateValidate dateValidate = new DateValidate();
        EmailValidate emailValidate = new EmailValidate();
        PhoneNumberValidate phoneNumberValidate = new PhoneNumberValidate();
        String phoneNumber = "";
        boolean flag = true;
        while (flag) {
            while (true) {
                System.out.print("Nhap so dien thoai can sua: ");
                String phoneNumberTemp = scl.nextLine().toLowerCase();
                if (phoneNumberValidate.validate(phoneNumberTemp)) {
                    phoneNumber = phoneNumberTemp;
                    break;
                }
                System.out.println("So dien thoai cua ban chua dung dinh dang");
            }
            if (phoneBook.findIndexByNumberPhone(phoneNumber) != -1) {
                flag = false;
            }
        }

        System.out.print("Nhap ten: ");
        String name = scl.nextLine().trim();
        System.out.print("Nhap nhom: ");
        String group = scl.nextLine().trim();
        System.out.print("Nhap gioi tinh: ");
        String sex = scl.nextLine().trim().toLowerCase();
        System.out.print("Nhap dia chi: ");
        String address = scl.nextLine();
        String email = "";
        while (true) {
            System.out.print("Nhap email: ");
            String emailTemp = scl.nextLine().trim();
            if (emailValidate.validate(emailTemp)) {
                email = emailTemp;
                break;
            }
            System.out.println("Email cua ban chua dung dinh dang");
        }
        LocalDate dateOfBirth = LocalDate.now();
        while (true) {
            System.out.print("Nhap ngay sinh(nam - thang - ngay): ");
            String date = scl.nextLine();
            if (dateValidate.validate(date)) {
                dateOfBirth = DateFormatter.parseDate(date);
                break;
            }
            System.out.println("Ban phải nhap dung dinh dang");
        }
        phoneBook.updateUser(phoneNumber, new User(phoneNumber, group, name, sex, address, dateOfBirth, email));

    }

    public static void deleteUser(Scanner scl, PhoneBook phoneBook) {
        System.out.print("Nhap so dien thoai can xoa: ");
        String numberPhone = scl.nextLine().trim().toLowerCase();
        phoneBook.deleteUser(numberPhone);
    }

    public static void findUser(Scanner scl, PhoneBook phoneBook) {
        System.out.print("Nhap so dien thoai can tim: ");
        String user = scl.nextLine().trim();
        for (User u : phoneBook.findUserByNumberPhoneOrName(user)) {
            System.out.println(u);
        }
    }
}
