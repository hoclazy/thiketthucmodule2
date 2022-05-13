package view;

import control.PhoneBook;
import file.FileUserCSV;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static PhoneBook phoneBook = new PhoneBook();
    public static void createMain() {
        Scanner scn = new Scanner(System.in);
        Scanner scl = new Scanner(System.in);
        int choose = 0;
        String select;
        do {
            Menu.builtMenu();
            do {
                try {
                    System.out.print("Nhap lua chon cua ban: ");
                    choose = scn.nextInt();
                } catch (InputMismatchException e) {
                    choose = -1;
                    System.out.println("Chon cac so co trong menu.");
                    scn.nextLine();
                }
            } while (!(choose >= 1 && choose <= 8));
            switch (choose) {
                case 1:
                    phoneBook.showPhoneBook();
                    break;
                case 2:
                    do {
                        phoneBook.addUser(Menu.createUser(scl));
                        do {
                            System.out.print("Ban muon nhap tiep khong (y/n): ");
                            select = scl.nextLine();
                        } while (!(select.equals("n") || select.equals("y")));
                    } while (select.equals("y"));
                    break;
                case 3:
                    do {
                        Menu.editUser(scl, phoneBook);
                        do {
                            System.out.print("Sua tiep chu (y/n): ");
                            select = scl.nextLine();
                        } while (!(select.equals("n") || select.equals("y")));
                    } while (select.equals("y"));
                    break;
                case 4:
                    do {
                        Menu.deleteUser(scl, phoneBook);
                        do {
                            System.out.print("Ban muon xoa tiep chu? (y/n): ");
                            select = scl.nextLine();
                        } while (!(select.equals("n") || select.equals("y")));
                    } while (select.equals("y"));
                    break;
                case 5:
                    Menu.findUser(scl, phoneBook);
                    break;
                case 6:
                    FileUserCSV.readFile(phoneBook);
                    System.out.println("Doc file thanh cong");
                    break;
                case 7:
                    FileUserCSV.writeFile(phoneBook);
                    System.out.println("Ghi file thanh cong");
                    break;
            }
        } while (choose <= 7);
    }
}
