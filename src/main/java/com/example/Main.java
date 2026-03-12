package com.example;

import com.example.dao.SinhVienDAO;
import com.example.model.SinhVien;
import com.example.service.SinhVienService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

        private static final Scanner sc = new Scanner(System.in);
        private static final SinhVienDAO dao = new SinhVienDAO();

        public static void main(String[] args) {

            while (true) {

                System.out.println("\n===== QUAN LY SINH VIEN =====");
                System.out.println("1. Them sinh vien");
                System.out.println("2. Xoa sinh vien");
                System.out.println("3. Sua sinh vien");
                System.out.println("4. Danh sach tat ca sinh vien");
                System.out.println("5. Danh sach sinh vien theo lop");
                System.out.println("6. Danh sach sinh vien theo nganh");
                System.out.println("7. Sap xep sinh vien theo diem TB");
                System.out.println("8. Danh sach sinh vien theo thang sinh");
                System.out.println("0. Thoat");
                System.out.print("Chon: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        themSinhVien();
                        break;

                    case 2:
                        xoaSinhVien();
                        break;

                    case 3:
                        suaSinhVien();
                        break;

                    case 4:
                        hienThiTatCa();
                        break;

                    case 5:
                        timTheoLop();
                        break;

                    case 6:
                        timTheoNganh();
                        break;

                    case 7:
                        sapXepTheoDiem();
                        break;

                    case 8:
                        timTheoThangSinh();
                        break;

                    case 0:
                        System.out.println("Tam biet!");
                        return;

                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            }
        }

        // Thêm sinh viên
        private static void themSinhVien() {

            System.out.print("Ma SV: ");
            String maSV = sc.nextLine();

            while (!SinhVienService.checkMaSV(maSV)) {
                System.out.print("Ma SV khong hop le. Nhap lai: ");
                maSV = sc.nextLine();
            }

            System.out.print("Ho ten: ");
            String hoTen = SinhVienService.chuanHoaHoTen(sc.nextLine());

            System.out.print("Ngay sinh (yyyy-mm-dd): ");
            LocalDate ngaySinh = LocalDate.parse(sc.nextLine());

            while (!SinhVienService.checkNgaySinh(ngaySinh)) {
                System.out.print("Ngay sinh khong hop le. Nhap lai: ");
                ngaySinh = LocalDate.parse(sc.nextLine());
            }

            while (!SinhVienService.checkTuoi(ngaySinh)) {
                System.out.print("Tuoi khong hop le. Nhap lai ngay sinh: ");
                ngaySinh = LocalDate.parse(sc.nextLine());
            }

            System.out.print("Nganh (CNTT/KTPM): ");
            String nganh = sc.nextLine();

            while (!SinhVienService.checkNganh(nganh)) {
                System.out.print("Nganh khong hop le. Nhap lai: ");
                nganh = sc.nextLine();
            }

            System.out.print("Diem TB: ");
            double diem = Double.parseDouble(sc.nextLine());

            while (!SinhVienService.checkDiem(diem)) {
                System.out.print("Diem khong hop le. Nhap lai: ");
                diem = Double.parseDouble(sc.nextLine());
            }

            System.out.print("Lop sinh hoat: ");
            String lop = sc.nextLine();

            SinhVien sv = new SinhVien(maSV, hoTen, ngaySinh, nganh, diem, lop);

            if (dao.addSinhVien(sv)) {
                System.out.println("Them sinh vien thanh cong!");
            } else {
                System.out.println("Them sinh vien that bai!");
            }
        }

        // Xóa sinh viên
        private static void xoaSinhVien() {

            System.out.print("Nhap ma SV can xoa: ");
            String maSV = sc.nextLine();

            if (dao.deleteSinhVien(maSV)) {
                System.out.println("Xoa thanh cong!");
            } else {
                System.out.println("Khong tim thay sinh vien!");
            }
        }

        // Sửa sinh viên
        private static void suaSinhVien() {

            System.out.print("Nhap ma SV can sua: ");
            String maSV = sc.nextLine();

            System.out.print("Ho ten moi: ");
            String hoTen = SinhVienService.chuanHoaHoTen(sc.nextLine());

            System.out.print("Ngay sinh (yyyy-mm-dd): ");
            LocalDate ngaySinh = LocalDate.parse(sc.nextLine());

            System.out.print("Nganh: ");
            String nganh = sc.nextLine();

            System.out.print("Diem TB: ");
            double diem = Double.parseDouble(sc.nextLine());

            System.out.print("Lop: ");
            String lop = sc.nextLine();

            SinhVien sv = new SinhVien(maSV, hoTen, ngaySinh, nganh, diem, lop);

            if (dao.updateSinhVien(sv)) {
                System.out.println("Cap nhat thanh cong!");
            } else {
                System.out.println("Cap nhat that bai!");
            }
        }

        // Hiển thị tất cả sinh viên
        private static void hienThiTatCa() {

            List<SinhVien> list = dao.getAllSinhVien();

            for (SinhVien sv : list) {
                System.out.println(sv);
            }
        }

        // Tìm theo lớp
        private static void timTheoLop() {

            System.out.print("Nhap lop: ");
            String lop = sc.nextLine();

            List<SinhVien> list = dao.getSinhVienByClass(lop);

            for (SinhVien sv : list) {
                System.out.println(sv);
            }
        }

        // Tìm theo ngành
        private static void timTheoNganh() {

            System.out.print("Nhap nganh (CNTT/KTPM): ");
            String nganh = sc.nextLine();

            List<SinhVien> list = dao.getSinhVienByMajor(nganh);

            for (SinhVien sv : list) {
                System.out.println(sv);
            }
        }

        // Sắp xếp theo điểm
        private static void sapXepTheoDiem() {

            List<SinhVien> list = dao.sortByDiem();

            for (SinhVien sv : list) {
                System.out.println(sv);
            }
        }

        // Sinh viên theo tháng sinh
        private static void timTheoThangSinh() {

            System.out.print("Nhap thang sinh (1-12): ");
            int month = Integer.parseInt(sc.nextLine());

            List<SinhVien> list = dao.getSinhVienByBirthMonth(month);

            for (SinhVien sv : list) {
                System.out.println(sv);
            }
        }
    }