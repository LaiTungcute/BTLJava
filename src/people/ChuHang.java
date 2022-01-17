package people;
import CayCoi.*;
import File.FileController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChuHang extends Nguoi{
    private List<NhanVien> nhanViens = new ArrayList<>();
    private List<cay> trees = new ArrayList<>();
    private static FileController fileControllerNhanVien = new FileController();
    private String MaCH;
    private String ViTri;
    public void choose() {
        int n;
        do {
            System.out.println("1. Quan ly nhan vien");
            System.out.println("2. Dat thoi gian khuyen mai");
            System.out.println("3. Doanh thu cua hang");
            System.out.println("4. Exit");
            System.out.print("Nhap lua chon: ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    qly();
                    break;
                case 2:
                    System.out.println("Thoi gian khuyen mai: 27/1/2022");
                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
            }
        }while (true);
    }

    //Quan ly
    public void qly() {
        int n;
        do {
            System.out.println("1. Nhan them nhan vien");
            System.out.println("2. Sa thai nhan vien");
            System.out.println("3. Tim kiem nhan vien");
            System.out.println("4. Thuong hang thang");
            System.out.println("5. Exit");
            System.out.print("Nhap so lua chon: ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    them();
//                    show();
                    break;
                case 2:
                    System.out.print("Nhap ten nhan vien can sa thai: ");
                    String name = sc.nextLine();
                    xoa(name);
                    break;
                case 3:
                    timKiem();
                    break;
                case 4:
                    thuong();
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Vui long nhap lai...");
                    break;
            }
            if(n==5) break;
        }while (true);
    }

    //hien thi danh sach nhan vien
    public void show() {
        nhanViens = fileControllerNhanVien.readNVFromFile("NhanVien.DAT");
        System.out.printf("%-15s %-15s %-15s %-15s %-10s %-10s\n", "Ma nv", "Ten", "Dia chi", "SDT", "Mat khau", "So ngay");
        for (NhanVien nhanVien: nhanViens) {
            nhanVien.xuat();
        }
    }

    public void them() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.nhap();
        nhanViens.add(nhanVien);
        fileControllerNhanVien.UpdateNVFile(nhanViens, "NhanVien.DAT");
        show();
    }

//    public void them() {
//        Nhap();
//        show();
//    }

    public void xoa(String name) {
        for (int i = 0; i < this.nhanViens.size(); i++) {
            if(name.compareToIgnoreCase(nhanViens.get(i).getTen()) ==0) {
                nhanViens.remove(i);
            }
        }
        fileControllerNhanVien.UpdateNVFile(nhanViens, "NhanVien.DAT");
        show();
    }

    public void timKiem() {
//        nhanViens = fileControllerNhanVien.readNVFromFile("NhanVien.DAT");
        String name = sc.nextLine();
        for (int i = 0; i < nhanViens.size(); i++) {
            if(name.compareToIgnoreCase(nhanViens.get(i).getTen()) ==0) {
                nhanViens.get(i).xuat();
            }
        }
    }

    public void thuong() {
//        nhanViens = fileControllerNhanVien.readNVFromFile("NhanVien.DAT");
        for (int i = 0; i < nhanViens.size(); i++) {
            if(nhanViens.get(i).getSoNgay()>=25){
                System.out.println("Thuong them 2000000");
            }
            else if(nhanViens.get(i).getSoNgay()<=10) {
                System.out.println("Khong co thuong");
            }
            else {
                System.out.println("Thuong 1000000");
            }
        }
    }

    //doanh thu
    public void doanhThu() {
        int n;
        do {
            System.out.println("1. Loai hang ban chay nhat");
            System.out.println("2. Loai hang ton kho");
            System.out.println("3. Loi nhuan cua hang");
            System.out.println("4. Exit");
            System.out.print("Nhap lua chon: ");
            n = sc.nextInt();
            switch (n) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        }while(true);
    }

}