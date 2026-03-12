package com.example.model;

import java.time.LocalDate;

public class SinhVien {

    private String maSV;
    private String hoTen;
    private LocalDate ngaySinh;
    private String nganhDaoTao;
    private double diemTrungBinh;
    private String lopSinhHoat;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String nganhDaoTao, double diemTrungBinh, String lopSinhHoat) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nganhDaoTao = nganhDaoTao;
        this.diemTrungBinh = diemTrungBinh;
        this.lopSinhHoat = lopSinhHoat;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getLopSinhHoat() {
        return lopSinhHoat;
    }

    public void setLopSinhHoat(String lopSinhHoat) {
        this.lopSinhHoat = lopSinhHoat;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", nganhDaoTao='" + nganhDaoTao + '\'' +
                ", diemTrungBinh=" + diemTrungBinh +
                ", lopSinhHoat='" + lopSinhHoat + '\'' +
                '}';
    }
}