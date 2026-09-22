# Quản Lý Sinh Viên (Console App)

<p>
  <img src="https://img.shields.io/badge/Java-17%2B-orange" alt="Java">
  <img src="https://img.shields.io/badge/Build-Maven-blue" alt="Maven">
  <img src="https://img.shields.io/badge/Interface-Console-lightgrey" alt="Console App">
</p>

Ứng dụng **console (dòng lệnh)** quản lý thông tin sinh viên, viết bằng **Java**, quản lý bằng **Maven**, có kết nối cơ sở dữ liệu để lưu trữ dữ liệu lâu dài.

---

## Giới thiệu (About)

Dự án mô phỏng nghiệp vụ quản lý sinh viên cơ bản qua giao diện dòng lệnh: thêm, sửa, xóa, tìm kiếm thông tin sinh viên, dữ liệu được lưu trong cơ sở dữ liệu (script khởi tạo có sẵn trong thư mục `database/`). Phù hợp cho mục đích học tập, thực hành lập trình hướng đối tượng (OOP) trong Java kết hợp thao tác với JDBC/CSDL.

> Ghi chú: danh sách tính năng dưới đây là suy luận từ cấu trúc thư mục (`database/`, `Screenshot/`). Bạn bổ sung/chỉnh sửa lại cho khớp chính xác với các chức năng thực tế trong `src/main/java/com/example`.

---

## Tính năng chính (dự kiến — chỉnh lại theo thực tế)

- Thêm sinh viên mới
- Sửa thông tin sinh viên
- Xóa sinh viên
- Tìm kiếm sinh viên theo tên/mã số
- Hiển thị danh sách toàn bộ sinh viên
- Lưu trữ dữ liệu qua cơ sở dữ liệu (xem thư mục `database/`)

---

## Công nghệ sử dụng

| Thành phần | Công nghệ |
|---|---|
| Ngôn ngữ | Java 17+ |
| Build tool | Maven |
| Database | Script khởi tạo có sẵn trong thư mục `database/` (SQL) |
| IDE | IntelliJ IDEA / Eclipse / VS Code |

---

## Cấu trúc dự án

```
quan-ly-sinh-vien-console/
├── .idea/                          # Cấu hình IntelliJ IDEA
├── Screenshot/                       # Ảnh chụp màn hình chạy chương trình
├── database/                           # Script SQL khởi tạo cơ sở dữ liệu
├── src/
│   └── main/
│       └── java/
│           └── com/example/            # Source code chính (Model, DAO, Main...)
├── .gitignore
└── pom.xml                                # Cấu hình Maven
```

---

## Bắt đầu (Getting Started)

### Yêu cầu

- [JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- MySQL/SQL Server (hoặc DB tương ứng script trong `database/`)
- IntelliJ IDEA / Eclipse / VS Code

### Cài đặt

```bash
git clone https://github.com/nhunguy-swe/quan-ly-sinh-vien-console.git
cd quan-ly-sinh-vien-console
```

### Cấu hình Database

1. Mở thư mục `database/`, chạy script SQL có sẵn để tạo cơ sở dữ liệu và bảng cần thiết.
2. Cập nhật thông tin kết nối (host, username, password, tên database) trong file cấu hình kết nối của project (thường nằm trong `src/main/java/com/example`, ví dụ lớp `DBConnection`/`DBUtils`).

### Chạy chương trình

Mở project bằng IntelliJ IDEA/Eclipse dưới dạng Maven Project, sau đó chạy lớp `Main` chính. Hoặc build và chạy qua terminal:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.example.Main"
```

> Thay `com.example.Main` bằng đúng tên class chứa hàm `main()` trong dự án của bạn.

---

## Ảnh chụp màn hình

Xem thêm ảnh minh họa chương trình đang chạy trong thư mục [`Screenshot/`](./Screenshot).

---

## Tác giả

- GitHub: [@nhunguy-swe](https://github.com/nhunguy-swe)

---

## Giấy phép

Dự án này được thực hiện cho mục đích học tập cá nhân. Bạn có thể tham khảo, sử dụng lại code cho mục đích học tập.
