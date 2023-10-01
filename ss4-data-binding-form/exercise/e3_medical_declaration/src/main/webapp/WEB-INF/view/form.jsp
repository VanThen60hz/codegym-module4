<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tờ Khai Y Tế</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css"/>
    <style>
        body {
            width: 90%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h2>TO KHAI Y TE</h2>
    <h4>Đây là tài liệu quan trọng, thông tin của bạn sẽ giúp cơ quan y tế liên lạc khi cần thiết để
        phòng chống dịch bệnh truyền nhiễm.</h4>
    <h6 class="text-danger mt-3">Lưu ý: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình
        sự.</h6>
</div>

<form:form method="post" modelAttribute="result" action="/save" class="container mt-3">
    <div class="mb-3">
        <label for="fullName" class="form-label">Họ và tên (ghi chữ in hoa) <span class="text-danger">(*)</span></label>
        <form:input type="text" class="form-control" id="fullName" path="fullName"/>

    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Năm sinh <span class="text-danger">(*)</span></label>
            <form:select path="yearBirthday" items="${birthYears}" class="form-select">
                <form:option value="" label="--Chọn--"/>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Giới tính <span class="text-danger">(*)</span></label>
            <form:select path="gender" items="${genders}" class="form-select">
                <form:option value="" label="--Chọn--"/>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Quốc tịch <span class="text-danger">(*)</span></label>
            <form:select path="nationality" items="${nationalities}" class="form-select">
                <form:option value="" label="--Chọn--"/>
            </form:select>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="text-danger">(*)</span></label>
        <input type="text" class="form-control" path="identification"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Thông tin di chuyển <span class="text-danger">(*)</span></label>
        <div>
            <form:radiobuttons path="vehicle" items="${vehicles}"/>
        </div>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Số hiệu phương tiện</label>
            <input type="text" class="form-control" path="numberPlate"/>
        </div>
        <div class="col">
            <label class="form-label">Số ghế</label>
            <input type="text" class="form-control" path="numberSeat"/>
        </div>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Ngày khởi hành <span class="text-danger">(*)</span></label>
            <div class="row">
                <div class="col">
                    <form:select path="startDay" items="${startDays}" class="form-select">
                        <form:option value="" label="Ngày"/>
                    </form:select>
                </div>
                <div class="col">
                    <form:select path="startMonth" items="${startMonths}" class="form-select">
                        <form:option value="" label="Tháng"/>
                    </form:select>
                </div>
                <div class="col">
                    <form:select path="startYear" items="${startYears}" class="form-select">
                        <form:option value="" label="Năm"/>
                    </form:select>
                </div>
            </div>
        </div>
        <div class="col">
            <label class="form-label">Ngày kết thúc <span class="text-danger">(*)</span></label>
            <div class="row">
                <div class="col">
                    <form:select path="endDay" items="${endDays}" class="form-select">
                        <form:option value="" label="Ngày"/>
                    </form:select>
                </div>
                <div class="col">
                    <form:select path="endMonth" items="${endMonths}" class="form-select">
                        <form:option value="" label="Tháng"/>
                    </form:select>
                </div>
                <div class="col">
                    <form:select path="endYear" items="${endYears}" class="form-select">
                        <form:option value="" label="Năm"/>
                    </form:select>
                </div>
            </div>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào <span class="text-danger">(*)</span></label>
        <input type="text" class="form-control" path="infoWithin14days"/>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Tỉnh/thành <span class="text-danger">(*)</span></label>
            <form:select path="city" items="${cities}" class="form-select">
                <form:option value="" label="--Chọn--"/>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Quận/huyện <span class="text-danger">(*)</span></label>
            <form:select path="district" items="${districts}" class="form-select">
                <form:option value="" label="--Chọn--"/>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Phường/xã <span class="text-danger">(*)</span></label>
            <form:select path="ward" items="${wards}" class="form-select">
                <form:option value="" label="--Chọn--"/>
            </form:select>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Địa chỉ nơi ở <span class="text-danger">(*)</span></label>
        <input type="text" class="form-control" path="address"/>
    </div>

    <div class="mb-3 row">
        <div class="col">
            <label class="form-label">Điện thoại <span class="text-danger">(*)</span></label>
            <input type="text" class="form-control" path="phone"/>
        </div>
        <div class="col">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" path="email"/>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây: <span
                class="text-danger">(*)</span></label>
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Triệu chứng</th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Sốt</td>
                        <td><input type="radio" name="sot" value="1"/></td>
                        <td><input type="radio" name="sot" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Ho</td>
                        <td><input type="radio" name="ho" value="1"/></td>
                        <td><input type="radio" name="ho" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Kho thở</td>
                        <td><input type="radio" name="khotho" value="1"/></td>
                        <td><input type="radio" name="khotho" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Đau họng</td>
                        <td><input type="radio" name="dauhong" value="1"/></td>
                        <td><input type="radio" name="dauhong" value="0"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Triệu chứng</th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Nôn/buồn nôn</td>
                        <td><input type="radio" name="non" value="1"/></td>
                        <td><input type="radio" name="non" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Tiêu chảy</td>
                        <td><input type="radio" name="tieuchay" value="1"/></td>
                        <td><input type="radio" name="tieuchay" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Xuất huyết ngoài da</td>
                        <td><input type="radio" name="xuathuyet" value="1"/></td>
                        <td><input type="radio" name="xuathuyet" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Nổi ban ngoài da</td>
                        <td><input type="radio" name="noiban" value="1"/></td>
                        <td><input type="radio" name="noiban" value="0"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Lịch sử phơi nhiễm. Trong vòng 14 ngày qua, Anh/Chị có: <span
                class="text-danger">(*)</span></label>
        <table class="table">
            <thead>
            <tr>
                <th></th>
                <th>Có</th>
                <th>Không</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Đến trang trại chăn nuôi/cho buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động vật <span
                        class="text-danger">(*)</span></td>
                <td><input type="radio" name="dentrangtrai" value="1"/></td>
                <td><input type="radio" name="dentrangtrai" value="0"/></td>
            </tr>
            <tr>
                <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span class="text-danger">(*)</span>
                </td>
                <td><input type="radio" name="tiepxucgan" value="1"/></td>
                <td><input type="radio" name="tiepxucgan" value="0"/></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="mb-3 text-danger">
        Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của bạn chỉ đạo
        quốc gia và phòng chống dịch Covid-19.
        Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.
    </div>
    <div class="mb-3 text-center">
        <button class="btn btn-success" type="submit">Gửi tờ khai</button>
    </div>
</form:form>
</body>
</html>
