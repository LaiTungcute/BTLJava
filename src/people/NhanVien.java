package people;
import CayCoi.*;
import File.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVien extends Nguoi{
    private  List<cay> trees = new ArrayList<>();
    private static FileController fileController = new FileController();
    public Scanner sc = new Scanner(System.in);
    private int soNgay;

    public NhanVien(int soNgay) {
        this.soNgay = soNgay;
    }

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String diaChi, String SDT, String password) {
        super(ma, ten, diaChi, SDT, password);
    }

    public NhanVien(String ma, String ten, String diaChi, String SDT, String password, int soNgay) {
        super(ma, ten, diaChi, SDT, password);
        this.soNgay = soNgay;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public void choose() throws IOException {
        int n;
        do {
            System.out.println("----------------Cac tinh nang-----------------");
            System.out.println("|     1. Thong tin san pham                  |");
            System.out.println("|     2. Them cac loai moi                   |");
            System.out.println("|     3. Sap xep theo gia ca                 |");
            System.out.println("|     4. Loai bo mat hang                    |");
            System.out.println("|     5. Thong tin ve VIP                    |");
            System.out.println("|     6. Exit                                |");
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.print("Chon 1 hoat dong: ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    thongTin();
                    break;
                case 2:
                    them(trees);
                    break;
                case 3:
                    sapXep();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    quanLy();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Vui long nhap lai: ");
                    break;
            }
            if(n==6) break;
        }while(true);
    }

    //thong tin san pham
    public void thongTin() {
        trees = fileController.readCayFromFile("CayCoi.DAT");
        System.out.printf("%-10s %-20s %-20s %-20s %-10s %-20s %-20s %-10s %-10s\n",
                "Ma","Ten", "Ngay nhap", "Tinh trang", "So luong", "Gia ca","The loai","Mau sac","Kich co");
        for (int i = 0; i < trees.size(); i++) {
            trees.get(i).xuat();
        }
    }

    //them san pham
    public void nhapCay(List<cay> trees) throws IOException {
        cay tree = new cay();
        tree.nhap();
        trees.add(tree);
        fileController.UpdateCayFile(trees,"CayCoi.DAT");
    }

    public void them(List<cay> trees) throws IOException {
        nhapCay(trees);
        thongTin();
    }

    //xoa cay
    public void xoa() {
        for (int i = 0; i < trees.size(); i++) {
            if(trees.get(i).getTinhTrang().compareToIgnoreCase("khong tot")==0) {
                trees.remove(i);
            }
        }
        fileController.UpdateCayFile(trees, "CayCoi.DAT");
        thongTin();
    }

    //sap xep theo gia
    public void sapXep() {
        for (int i = 0; i < trees.size()-1; i++) {
            for (int j = i+1; j < trees.size(); j++) {
                if(trees.get(i).getGiaCa()>trees.get(j).getGiaCa()) {
                    cay tree = trees.get(i);
                    trees.set(i,trees.get(j));
                    trees.set(j,tree);
                }
            }
        }
        fileController.UpdateCayFile(trees, "CayCoi.DAT");
//        thongTin();
    }

    //quan ly VIP
    private void quanLy() {
        System.out.println("-----Ban se duoc giam gia 25% neu ban la thanh vien VIP-----");
    }

    public void nhap() {
        super.nhap();
        System.out.print("Nhap so ngay: ");
        soNgay = sc.nextInt();
        sc.nextLine();
    }

    public void xuat () {
        super.xuat();
        System.out.printf("%-10d", soNgay);
        System.out.println();
    }
}