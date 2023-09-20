<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Regex</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
          integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
          crossorigin="anonymous"/>
    <style>
        * {
            margin: 0 auto;
            box-sizing: border-box;
        }

        body {
            padding-top: 5%;
            height: 100vh;
            display: flex;
            flex-direction: column;
            font-family: "Helvetica Neue", serif;
            background-color: #f4f4f5;
        }

        body > div {
            margin: auto;
        }


        /* ======= Toast message ======== */

        #toast {
            position: fixed;
            top: 32px;
            right: 32px;
            z-index: 999999;
        }

        .toast {
            display: flex;
            align-items: center;
            background-color: #fff;
            border-radius: 2px;
            padding: 20px 0;
            min-width: 400px;
            max-width: 450px;
            border-left: 4px solid;
            box-shadow: 0 5px 8px rgba(0, 0, 0, 0.08);
            transition: all linear 0.3s;
        }

        @keyframes slideInLeft {
            from {
                opacity: 0;
                transform: translateX(calc(100% + 32px));
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        @keyframes fadeOut {
            to {
                opacity: 0;
            }
        }

        .toast--success {
            border-color: #47d864;
        }

        .toast--success .toast__icon {
            color: #47d864;
        }


        .toast--error {
            border-color: #ff623d;
        }

        .toast--error .toast__icon {
            color: #ff623d;
        }

        .toast + .toast {
            margin-top: 24px;
        }

        .toast__icon {
            font-size: 24px;
        }

        .toast__icon,
        .toast__close {
            padding: 0 16px;
        }

        .toast__body {
            flex-grow: 1;
        }

        .toast__title {
            font-size: 16px;
            font-weight: 600;
            color: #333;
        }

        .toast__msg {
            font-size: 14px;
            color: #888;
            margin-top: 6px;
            line-height: 1.5;
        }

        .toast__close {
            font-size: 20px;
            color: rgba(0, 0, 0, 0.3);
            cursor: pointer;
        }

    </style>
</head>
<body>

<form action="validate" method="post">
    <input type="text" placeholder="Enter email" name="email">
    <button type="submit">Check email</button>
</form>


<c:if test="${not empty email}">
    <div id="toast">
        <div class="toast toast--success">
            <div class="toast__icon">
                <i class="fas fa-check-circle"></i>
            </div>
            <div class="toast__body">
                <h3 class="toast__title">Success</h3>
                <p class="toast__msg">Hi ${email}</p>
            </div>
            <div class="toast__close">
                <i class="fas fa-times"></i>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${not empty message}">
    <div id="toast">
        <div class="toast toast--error">
            <div class="toast__icon">
                <i class="fas fa-exclamation-circle"></i>
            </div>
            <div class="toast__body">
                <h3 class="toast__title">Error</h3>
                <p class="toast__msg">${message}</p>
            </div>
            <div class="toast__close">
                <i class="fas fa-times"></i>
            </div>
        </div>
    </div>
</c:if>

<script>
    // Lấy thẻ toast
    const toast = document.getElementById('toast');

    // Lấy biểu tượng "x" để bấm để đóng
    const closeIcon = toast.querySelector('.toast__close');

    // Ẩn toast sau 5 giây
    setTimeout(() => {
        toast.style.animation = 'fadeOut 0.5s';
        setTimeout(() => {
            toast.style.display = 'none';
        }, 300);
    }, 3000);

    // Xử lý sự kiện khi bấm vào biểu tượng "x"
    closeIcon.addEventListener('click', () => {
        toast.style.animation = 'fadeOut 0.5s';
        setTimeout(() => {
            toast.style.display = 'none';
        }, 300);
    });
</script>

</body>
</html>
