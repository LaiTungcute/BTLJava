package File;

import CayCoi.cay;
import people.KhachHang;
import people.NhanVien;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public Scanner getScanner() {
        return this.scanner;
    }

    public void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterWrite() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFileToRead(String fileName) {
        try {
            scanner = new Scanner(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead() {
        scanner.close();
    }

    //Cay
    public void writeCayToFile(String fileName, cay a) {
        openFileToWrite(fileName);
        printWriter.println(
                a.getMaTV() + "|" + a.getTen() + "|" +
                        a.getSoLuong() + "|" + a.getGiaCa() + "|" +
                        a.getNgayNhap() + "|" + a.getTinhTrang() + "|" +
                        a.getTheLoai() + "|" + a.getMauSac() + "|" + a.getKichCo()
        );
        closeFileAfterWrite();
    }

    public cay createDataCay(String data) {
        String[] datas = data.split("\\|");
        cay tree = new cay(datas[0], datas[1], datas[2], datas[3], Integer.parseInt(datas[4]), Double.parseDouble(datas[5]), datas[6], datas[7], Integer.parseInt(datas[8]));
        return tree;
    }

    public List<cay> readCayFromFile(String fileName) {
        openFileToRead(fileName);
        List<cay> trees = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            cay tree = createDataCay(data);
            trees.add(tree);
        }
        closeFileAfterRead();
        return trees;
    }

    public void UpdateCayFile(List<cay> trees, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        openFileToWrite(fileName);
        for (cay a : trees) {
            printWriter.println(
                    a.getMaTV() + "|" + a.getTen() + "|" +
                            a.getNgayNhap() + "|" + a.getTinhTrang() + "|" +
                            a.getSoLuong() + "|" + a.getGiaCa() + "|" +
                            a.getTheLoai() + "|" + a.getMauSac() + "|" + a.getKichCo()
            );
        }
        closeFileAfterWrite();
    }

    public void UpdateNewSLCay(List<cay> trees, String fileName, int SL, String name) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        openFileToWrite(fileName);
        for (cay a : trees) {
            if (name.compareToIgnoreCase(a.getTen()) == 0) {
                printWriter.println(
                        a.getMaTV() + "|" + a.getTen() + "|" +
                                a.getNgayNhap() + "|" + a.getTinhTrang() + "|" +
                                (a.getSoLuong() - SL) + "|" + a.getGiaCa() + "|" +
                                a.getTheLoai() + "|" + a.getMauSac() + "|" + a.getKichCo()
                );
            } else {
                printWriter.println(
                        a.getMaTV() + "|" + a.getTen() + "|" +
                                a.getNgayNhap() + "|" + a.getTinhTrang() + "|" +
                                a.getSoLuong() + "|" + a.getGiaCa() + "|" +
                                a.getTheLoai() + "|" + a.getMauSac() + "|" + a.getKichCo()
                );
            }
        }
        closeFileAfterWrite();
    }

    //nhan vien
    public void writeNVToFile(String fileName, NhanVien a) {
        openFileToWrite(fileName);
        printWriter.println(
                a.getMa() + "|" + a.getTen() + "|" + a.getDiaChi() +
                        "|" + a.getSDT() + "|" + a.getPassword() + "|" + a.getSoNgay()
        );
        closeFileAfterWrite();
    }

    public NhanVien createDataNV(String data) {
        String[] datas = data.split("\\|");
        NhanVien nhanVien = new NhanVien(datas[0], datas[1], datas[2], datas[3], datas[4], Integer.parseInt(datas[5]));
        return nhanVien;
    }

    public List<NhanVien> readNVFromFile(String fileName) {
        openFileToRead(fileName);
        List<NhanVien> nhanViens = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            NhanVien nhanVien = createDataNV(data);
            nhanViens.add(nhanVien);
        }
        closeFileAfterRead();
        return nhanViens;
    }

    public void UpdateNVFile(List<NhanVien> nhanViens, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        openFileToWrite(fileName);
        for (NhanVien a : nhanViens) {
            printWriter.println(
                    a.getMa() + "|" + a.getTen() + "|" + a.getDiaChi() + "|"
                            + a.getSDT() + "|" + a.getPassword() + "|" + a.getSoNgay()
            );
        }
        closeFileAfterWrite();
    }

    //Khach hang
    public void writeKHToFile(String fileName, KhachHang a) {
        openFileToWrite(fileName);
        printWriter.println(
                a.getMa() + "|" + a.getTen() + "|" + a.getDiaChi() +
                        "|" + a.getSDT() + "|" + a.getPassword() + "|" + a.getVip()
        );
        closeFileAfterWrite();
    }

    public KhachHang createDataKH(String data) {
        String[] datas = data.split("\\|");
        KhachHang khachHang = new KhachHang(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5]);
        return khachHang;
    }

    public List<KhachHang> readKHFromFile(String fileName) {
        openFileToRead(fileName);
        List<KhachHang> khachHangs = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            KhachHang khachHang = createDataKH(data);
            khachHangs.add(khachHang);
        }
        closeFileAfterRead();
        return khachHangs;
    }

    public void UpdateKHFile(List<KhachHang> khachHangs, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        openFileToWrite(fileName);
        for (KhachHang a : khachHangs) {
            printWriter.println(
                    a.getMa() + "|" + a.getTen() + "|" + a.getDiaChi() + "|"
                            + a.getSDT() + "|" + a.getPassword() + "|" + a.getVip()
            );
        }
        closeFileAfterWrite();
    }
}