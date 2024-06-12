# PROJECT cá nhân "PhongTroPTIT" phát triển bằng SpringBoot + Angular

# Phần 1 BackEnd - SpringBoot

## Website tìm kiếm nhà trọ
| Tác giả        | MSV       | Email                         |
|----------------|------------|-------------------------------|
| Ngọ Văn Trọng  | B21DCCN726 | ngovantrong1308@gmail.com     |

### Giới Thiệu:

Tìm kiếm phòng trọ tại Hà Nội để ở luôn là một trong những vấn đề khó khăn đối với những người đi thuê, đặc biệt là đối với các bạn sinh viên từ quê vào thành phố để tiếp tục con đường học tập. Còn đối với người cho thuê, họ cũng khó có thể tiếp cận với những người đi thuê với các cách tiếp thị truyền thống.

Để giảm thiểu khó khăn này, mình đã quyết định phát triển một website tìm kiếm nhà trọ cho sinh viên trường mình (Học Viện Công Nghệ Bưu Chính Viễn Thông).

Website được phát triển bằng Spring Boot và Angular.

### Các chức năng hiện có:

- **Người dùng chưa đăng nhập:**
  - Tìm kiếm phòng trọ
  - Đăng ký
  - Đăng nhập

- **Thành viên:**
  - Các chức năng của người dùng chưa đăng nhập
  - Quản lý tin đăng
  - Quản lý bình luận và đánh giá
  - Quản lý thông báo
  - Đăng xuất

- **Kiểm duyệt viên:**
  - Các chức năng của thành viên
  - Quản lý tin đăng của thành viên
  - Xem hoạt động của hệ thống

- **Quản trị viên:**
  - Các chức năng của kiểm duyệt viên
  - Quản lý thành viên

## Hướng dẫn cài đặt và sử dụng

### Yêu cầu

- Java Development Kit (JDK) 8+
- Node.js và npm
- Angular CLI
-  Visual Studio Code (hoặc IDE khác hỗ trợ Angular)
- MySQL Workbench
- IntelliJ IDEA (hoặc IDE khác hỗ trợ Spring Boot)

### Khởi tạo dự án Spring Boot

1. Truy cập [Spring Initializr](https://start.spring.io/).
2. Chọn các tùy chọn sau:
    - Project: Maven Project
    - Language: Java
    - Spring Boot: 2.5.4 (hoặc phiên bản mới nhất)
    - Group: com.example
    - Artifact: PhongTroPTIT
    - Name: PhongTroPTIT
    - Description: Dự án cá nhân về PhongTroPTIT
    - Packaging: Jar
    - Java: 8
3. Thêm các dependencies cần thiết như Spring Web, Spring Data JPA, MySQL Driver, Spring Boot DevTools.
4. Nhấn "Generate" để tải về tệp zip của dự án.
5. Giải nén tệp zip và mở dự án bằng IntelliJ IDEA.

### Cài đặt

1. **Clone repository**

    ```bash
    git clone https://github.com/TrongNgoVan/BackEnd-SpringBoot-PhongTroPTIT.git
    cd PhongTroPTIT
    ```

2. **Cài đặt BackEnd**

    ```bash
    cd backend
    ./mvnw install
    ./mvnw spring-boot:run
    ```

3. **Cài đặt FrontEnd**

    ```bash
    cd ../frontend
    npm install
    ng serve
    ```

4. **Khởi động ứng dụng**

    -  Bật trình duyệt, gõ `http://localhost:8080` để vào trang dành cho người dùng hoặc `http://localhost:8080/admin` để vào trang quản lý.
 



