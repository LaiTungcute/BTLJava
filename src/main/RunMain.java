package main;
import people.*;
import File.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    static List<NhanVien> nhanViens = new ArrayList<>();
    static List<KhachHang> khachHangs = new ArrayList<>();
    static FileController fileController = new FileController();
//    static List<cay> trees = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n;
        do {
            System.out.println("-------------Cua hang cay canh--------------------");
            System.out.println("|    1. Dang nhap voi tu cach la admin           |");
            System.out.println("|    2. Dang nhap/dang xuat voi tu cach la user  |");
            System.out.println("|    0. Thoat                                    |");
            System.out.println("--------------------------------------------------");
            System.out.print("Nhap lua con cua ban: ");
            n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;
                case 0:
                    System.out.println("Thank you!!!");
                    System.exit(0);
                default:
                    System.out.println("Khong co lua chon nay. Vui long nhap lai");
            }
        }while (true);
    }

    //admin
    public static void admin() throws IOException {
        nhanViens = fileController.readNVFromFile("NhanVien.DAT");
        String userName;
        String passWord;
        NhanVien s = new NhanVien();
       do {
           System.out.print("Nhap ten: ");
           int c = 0;
           userName = sc.nextLine();
           for (int i=0;i<nhanViens.size();i++) {
               if(userName.compareToIgnoreCase(nhanViens.get(i).getTen())==0) {
                   c = 1;
                   s = nhanViens.get(i);
                   break;
               }
           }
           if (c==0) System.out.println("Ten nay khong hop le. Vui long nhap lai...");
           else break;
       }while (true);

       do {
           System.out.print("Nhap mat khau: ");
           int a=0;
           passWord = sc.nextLine();
               if (passWord.compareToIgnoreCase(s.getPassword())==0) {
                   a=1;
                   break;
               }
           if(a==0)  System.out.println("Mat khau nay sai. Vui long nhap lai...");
           else break;
       }while (true);

       NhanVien nhanVien = s;
       nhanVien.choose();
    }

    //user
    public static void user() {
        khachHangs = fileController.readKHFromFile("KhachHang.DAT");
        String userName;
        String passWord;
        KhachHang s = new KhachHang();
        do {
            System.out.print("Nhap ten: ");
            int c = 0;
            userName = sc.nextLine();
            for (int i=0;i<khachHangs.size();i++) {
                if(userName.compareToIgnoreCase(khachHangs.get(i).getTen())==0) {
                    c = 1;
                    s = khachHangs.get(i);
                    break;
                }
            }
            if (c==0) System.out.println("Ten nay khong hop le. Vui long nhap lai...");
            else break;
        }while (true);

        do {
            System.out.print("Nhap mat khau: ");
            int a=0;
            passWord = sc.nextLine();
            if (passWord.compareToIgnoreCase(s.getPassword())==0) {
                a=1;
                break;
            }
            if(a==0)  System.out.println("Mat khau nay sai. Vui long nhap lai...");
            else break;
        }while (true);

        KhachHang khachHang = s;
        khachHang.choose();
    }
}