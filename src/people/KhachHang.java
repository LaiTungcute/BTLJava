package people;
import CayCoi.*;
import File.FileController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhachHang extends Nguoi{
    private static FileController fileController = new FileController();
    static Scanner sc=new Scanner(System.in);
    static List<cay> cays=new ArrayList<>();
    private String vip;

    public KhachHang(String vip) {
        this.vip = vip;
    }

    public KhachHang(String ma, String ten, String diaChi, String SDT, String password, String vip) {
        super(ma, ten, diaChi, SDT, password);
        this.vip = vip;
    }

    public String getVip() {
        return vip;
    }

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, String diaChi, String SDT, String password) {
        super(ma, ten, diaChi, SDT, password);
    }

    public void choose() {
        System.out.println("============XIN CHAO QUY KHACH====================");
        int choose=0,choose1=0,choose2=0;
        do{
            System.out.println("----------------Cac tinh nang-----------------");
            System.out.println("|     1. Mua mat hang                        |");
            System.out.println("|     2. Doi tra mat hang                    |");
            System.out.println("|     3. Danh gia, phan hoi                  |");
            System.out.println("|     4. Exit                                |");
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.print("Xin moi nhap su lua chon: ");
            choose= sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    muaHang();
                    break;
                case 2:
                    doiHang();
                    break;
                case 3: {
                    System.out.println("----------------Cac tinh nang-----------------");
                    System.out.println("|     1. Hai long                            |");
                    System.out.println("|     2. Khong hai long                      |");
                    System.out.println("|     3. Thoat                               |");
                    System.out.println("----------------------------------------------");
                    System.out.println();
                    System.out.print("Nhap su lua chon: ");
                    choose2=sc.nextInt();
                    sc.nextLine();
                    switch (choose2) {
                        case 1:
                            System.out.println("Hay cho cua hang chung toi that nhieu feedback tot nhe");
                            break;
                        case 2: {
                            String nx;
                            System.out.print("Hay phan hoi y kien ve su khong hai long cua ban:");
                            nx = sc.nextLine();
                            System.out.println("Y kien cua ban da duoc gui di. Hay doi thong tin tu chung toi");
                            break;
                        }
                        case 3:
                            System.out.println("Cam on da su dung dich vu cua chung toi");
                            break;
                        default:
                            System.out.println("Loi lua chon");
                    }
                }
                case 4:
                    System.out.println("Cam on da su dung dich vu cua chung toi");
                    break;
                default:
                    System.out.println("Loi lua chon");
            }
            if(choose==4) break;
        }while (choose!=0);
    }

    public void muaHang(){
        cays = fileController.readCayFromFile("CayCoi.DAT");
        String name;
        int soLuong;
        cay s = new cay();
        do {
            System.out.print("Nhap ten: ");
            int c = 0;
            name= sc.nextLine();
            for (int i=0;i<cays.size();i++) {
                if(name.compareToIgnoreCase(cays.get(i).getTen())==0) {
                    c = 1;
                    s = cays.get(i);
                    break;
                }
            }
            if (c==0) System.out.println("Khong co loai cay nay. Vui long chon lai...");
            else break;
        }while (true);

        do {
            System.out.print("Nhap so luong: ");
            soLuong = sc.nextInt();
            if (soLuong>s.getSoLuong()) System.out.println("Cua hang chua nhap kip hang. Vui long nhap lai...");
        }while (soLuong>s.getSoLuong());
//        xu+=soLuong;
        if(vip.compareToIgnoreCase("VIP")==0) {
            System.out.println("So tien ban can tra la: " + (s.getGiaCa()*soLuong - (float)s.getGiaCa()*soLuong*(25/100)));
        }
        else {
            System.out.println("So tien ban can tra la: " + s.getGiaCa()*soLuong);
        }
        hoaDon(s, soLuong);
        fileController.UpdateNewSLCay(cays, "CayCoi.DAT", soLuong, name);
    }

    public void doiHang(){
        cays = fileController.readCayFromFile("CayCoi.DAT");
        String tinhTrang;
        System.out.println("Nhap tinh trang hien tai: ");
        tinhTrang=sc.nextLine();
        System.out.println("Nhap mat hang ban muon doi: ");
        String name;
        int soLuong;
        cay s = new cay();
        do {
            System.out.print("Nhap ten: ");
            int c = 0;
            name= sc.nextLine();
            for (int i=0;i<cays.size();i++) {
                if(name.compareToIgnoreCase(cays.get(i).getTen())==0) {
                    c = 1;
                    s = cays.get(i);
                    break;
                }
            }
            if (c==0) System.out.println("Khong co loai cay nay. Vui long chon lai...");
            else break;
        }while (true);

        do {
            System.out.println("Nhap so luong: ");
            soLuong = sc.nextInt();
            if (soLuong>s.getSoLuong()) System.out.println("Cua hang chua nhap kip hang. Vui long nhap lai...");
        }while (soLuong>s.getSoLuong());
        fileController.UpdateNewSLCay(cays, "CayCoi.DAT", soLuong, name);
    }

    public void hoaDon(cay s, int soLuong){
        System.out.println("Thong tin da mua la: ");
        System.out.printf("%-10s %-15s %-15s %-15s %-10s %-15s %-15s %-10s %-10s\n",
                "Ma","Ten", "Ngay nhap", "Tinh trang", "So luong", "Gia ca","The loai","Mau sac","Kich co");
        System.out.printf("%-10s %-15s %-15s %-15s %-10d %-15.2f %-15s %-10s %-10d\n", s.getMaTV(), s.getTen(),
        s.getNgayNhap(), s.getTinhTrang(), soLuong, s.getGiaCa()*soLuong, s.getTheLoai(), s.getMauSac(), s.getKichCo());
        double sum = s.getGiaCa()*soLuong;
        System.out.println("Tong tien la: "+ sum);
        System.out.println("Thue VAT: "+0.1*sum);
        System.out.println("Tong bill: "+(sum+0.1*sum));
    }


    //xuat
    public void xuat() {
        super.xuat();
        System.out.printf("%-10s",vip);
    }
}