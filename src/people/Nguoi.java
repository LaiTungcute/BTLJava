package people;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Nguoi {
    Pattern patternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$");
    Pattern patternPhoneNumber = Pattern.compile("^[0-9\\-\\+]{9,15}$");
    Scanner sc = new Scanner(System.in);
    protected String ma,Ten;
    protected String DiaChi;
    protected String SDT;
    protected String Password;

    public Nguoi() {
    }

    public Nguoi(String ma, String ten, String diaChi, String SDT, String password) {
        this.ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        this.SDT = SDT;
        Password = password;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void nhap() {
        System.out.print("Nhap ma: ");
        ma = sc.nextLine();
        System.out.print("Nhap ten: ");
        Ten = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        DiaChi = sc.nextLine();
        do {
            System.out.print("Nhap so dien thoai: ");
            SDT = sc.nextLine();
            if(!patternPhoneNumber.matcher(SDT).find()) {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai...");
            }
        }while (!patternPhoneNumber.matcher(SDT).find());
        do {
            System.out.print("Nhap mat khau: ");
            Password = sc.nextLine();
            if(!patternPassword.matcher(Password).find()) {
                System.out.println("Mat khau khong hop le. Vui long nhap lai...");
            }
        }while (!patternPassword.matcher(Password).find());
    }

   public void xuat() {
       System.out.printf("%-10s %-15s %-15s %-15s %-15s",ma, Ten, DiaChi, SDT, Password);
   }
}