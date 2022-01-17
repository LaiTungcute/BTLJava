package CayCoi;

import java.util.Scanner;

public class cay extends ThucVat{
    Scanner sc = new Scanner(System.in);
    private String theLoai;
    private String mauSac;
    private int kichCo;

    public cay(String theLoai, String mauSac, int kichCo) {
        this.theLoai = theLoai;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
    }

    public cay(String maTV, String ten, String ngayNhap, String tinhTrang, int soLuong, double giaCa, String theLoai, String mauSac, int kichCo) {
        super(maTV, ten, ngayNhap, tinhTrang, soLuong, giaCa);
        this.theLoai = theLoai;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
    }

    public cay() {
    }

    public cay(String maTV, String ten, String ngayNhap, String tinhTrang, int soLuong, double giaCa) {
        super(maTV, ten, ngayNhap, tinhTrang, soLuong, giaCa);
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getKichCo() {
        return kichCo;
    }

    public void setKichCo(int kichCo) {
        this.kichCo = kichCo;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Nhap the loai: ");
        theLoai = sc.nextLine();
        System.out.print("Nhap mau sac: ");
        mauSac = sc.nextLine();
        System.out.print("Nhap kich co: ");
        kichCo = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        super.xuat();
        System.out.printf("%-20s %-10s %-10d\n", theLoai,mauSac,kichCo);
    }
}