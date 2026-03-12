package com.example.dao;

import com.example.dao.DBConnection;
import com.example.model.SinhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    // Thêm sinh viên
    public boolean addSinhVien(SinhVien sv) {
        String sql = "INSERT INTO sinh_vien VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setDate(3, Date.valueOf(sv.getNgaySinh()));
            ps.setString(4, sv.getNganhDaoTao());
            ps.setDouble(5, sv.getDiemTrungBinh());
            ps.setString(6, sv.getLopSinhHoat());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sinh viên
    public boolean deleteSinhVien(String maSV) {

        String sql = "DELETE FROM sinh_vien WHERE ma_sv=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maSV);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật sinh viên
    public boolean updateSinhVien(SinhVien sv) {

        String sql = "UPDATE sinh_vien SET ho_ten=?, ngay_sinh=?, nganh_dao_tao=?, diem_tb=?, lop_sinh_hoat=? WHERE ma_sv=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sv.getHoTen());
            ps.setDate(2, Date.valueOf(sv.getNgaySinh()));
            ps.setString(3, sv.getNganhDaoTao());
            ps.setDouble(4, sv.getDiemTrungBinh());
            ps.setString(5, sv.getLopSinhHoat());
            ps.setString(6, sv.getMaSV());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Lấy tất cả sinh viên
    public List<SinhVien> getAllSinhVien() {

        List<SinhVien> list = new ArrayList<>();

        String sql = "SELECT * FROM sinh_vien";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                SinhVien sv = new SinhVien(
                        rs.getString("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getDate("ngay_sinh").toLocalDate(),
                        rs.getString("nganh_dao_tao"),
                        rs.getDouble("diem_tb"),
                        rs.getString("lop_sinh_hoat")
                );

                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy sinh viên theo lớp
    public List<SinhVien> getSinhVienByClass(String lop) {

        List<SinhVien> list = new ArrayList<>();

        String sql = "SELECT * FROM sinh_vien WHERE lop_sinh_hoat=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, lop);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SinhVien sv = new SinhVien(
                        rs.getString("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getDate("ngay_sinh").toLocalDate(),
                        rs.getString("nganh_dao_tao"),
                        rs.getDouble("diem_tb"),
                        rs.getString("lop_sinh_hoat")
                );

                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy sinh viên theo ngành
    public List<SinhVien> getSinhVienByMajor(String nganh) {

        List<SinhVien> list = new ArrayList<>();

        String sql = "SELECT * FROM sinh_vien WHERE nganh_dao_tao=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nganh);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SinhVien sv = new SinhVien(
                        rs.getString("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getDate("ngay_sinh").toLocalDate(),
                        rs.getString("nganh_dao_tao"),
                        rs.getDouble("diem_tb"),
                        rs.getString("lop_sinh_hoat")
                );

                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Sắp xếp theo điểm trung bình
    public List<SinhVien> sortByDiem() {

        List<SinhVien> list = new ArrayList<>();

        String sql = "SELECT * FROM sinh_vien ORDER BY diem_tb DESC";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                SinhVien sv = new SinhVien(
                        rs.getString("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getDate("ngay_sinh").toLocalDate(),
                        rs.getString("nganh_dao_tao"),
                        rs.getDouble("diem_tb"),
                        rs.getString("lop_sinh_hoat")
                );

                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Sinh viên theo tháng sinh
    public List<SinhVien> getSinhVienByBirthMonth(int month) {

        List<SinhVien> list = new ArrayList<>();

        String sql = "SELECT * FROM sinh_vien WHERE MONTH(ngay_sinh)=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, month);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SinhVien sv = new SinhVien(
                        rs.getString("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getDate("ngay_sinh").toLocalDate(),
                        rs.getString("nganh_dao_tao"),
                        rs.getDouble("diem_tb"),
                        rs.getString("lop_sinh_hoat")
                );

                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
