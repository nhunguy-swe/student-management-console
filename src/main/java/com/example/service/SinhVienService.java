package com.example.service;

import java.time.LocalDate;
import java.time.Period;

public class SinhVienService {

    // Chuẩn hóa họ tên
    public static String chuanHoaHoTen(String hoTen) {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            return "";
        }

        hoTen = hoTen.trim().toLowerCase();
        String[] arr = hoTen.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1))
                    .append(" ");
        }

        return result.toString().trim();
    }

    // Kiểm tra mã sinh viên đúng định dạng
    // CNTT: 455105xxxx
    // KTPM: 455109xxxx
    public static boolean checkMaSV(String maSV) {
        if (maSV == null) return false;

        return maSV.matches("455105\\d{4}") || maSV.matches("455109\\d{4}");
    }

    // Kiểm tra ngành đào tạo
    public static boolean checkNganh(String nganh) {
        if (nganh == null) return false;

        return nganh.equalsIgnoreCase("CNTT") ||
                nganh.equalsIgnoreCase("KTPM");
    }

    // Kiểm tra điểm trung bình
    public static boolean checkDiem(double diem) {
        return diem >= 0.0 && diem <= 10.0;
    }

    // Kiểm tra tuổi sinh viên (15 - 110)
    public static boolean checkTuoi(LocalDate ngaySinh) {
        if (ngaySinh == null) return false;

        int tuoi = Period.between(ngaySinh, LocalDate.now()).getYears();

        return tuoi >= 15 && tuoi <= 110;
    }

    // Kiểm tra ngày sinh hợp lệ (không lớn hơn hiện tại)
    public static boolean checkNgaySinh(LocalDate ngaySinh) {
        if (ngaySinh == null) return false;

        return !ngaySinh.isAfter(LocalDate.now());
    }
}
