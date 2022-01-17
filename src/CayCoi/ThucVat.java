package CayCoi;
import java.util.Scanner;

public class ThucVat {
        protected String maTV,ten,ngayNhap,tinhTrang;
        protected int soLuong;
        protected double giaCa;

        public ThucVat(){
        }
        public ThucVat(String maTV,String ten,String ngayNhap,String tinhTrang,int soLuong,double giaCa){
            this.maTV=maTV;
            this.giaCa=giaCa;
            this.ngayNhap=ngayNhap;
            this.soLuong=soLuong;
            this.ten=ten;
            this.tinhTrang=tinhTrang;
        }

    public ThucVat(String maTV, String ten, String ngayNhap, int soLuong) {
    }

    public String getMaTV() {
            return maTV;
        }

        public void setMaTV(String maTV) {
            this.maTV = maTV;
        }

        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getNgayNhap() {
            return ngayNhap;
        }

        public void setNgayNhap(String ngayNhap) {
            this.ngayNhap = ngayNhap;
        }

        public String getTinhTrang() {
            return tinhTrang;
        }

        public void setTinhTrang(String tinhTrang) {
            this.tinhTrang = tinhTrang;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }

        public double getGiaCa() {
            return giaCa;
        }

        public void setGiaCa(double giaCa) {
            this.giaCa = giaCa;
        }
        public void nhap(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Nhap ma thuc vat: ");
            maTV=sc.nextLine();
            System.out.print("Nhap ten thuc vat: ");
            ten=sc.nextLine();
            System.out.print("Nhap ngay nhap: ");
            ngayNhap=sc.nextLine();
            System.out.print("Nhap tinh trang: ");
            tinhTrang=sc.nextLine();
            System.out.print("Nhap so luong: ");
            soLuong=sc.nextInt();
            System.out.print("Nhap gia ca: ");
            giaCa=sc.nextDouble();
            sc.nextLine();
        }
        public void xuat(){
            System.out.printf("%-10s %-20s %-20s %-20s %-10d %-20.2f",maTV, ten, ngayNhap, tinhTrang, soLuong, giaCa);
        }
}