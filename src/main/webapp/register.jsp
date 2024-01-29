<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 페이지</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f4f4;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            margin-top: 50px;
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        label {
            color: #666;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            background-color: #4CAF50;
            border: none;
            width: 100%;
        }
        .btn-primary:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
        }
        .input-group {
        display: flex;
        flex-direction: row;
    }

    .input-group .btn-primary {
        border-top-left-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-control {
        border-radius: 0.2rem; 
    }

    .input-group-append {
        margin-left: -1px;
    }
    </style>
</head>
<body>
    <div class="container">
        <h2>회원가입</h2>
        <form action="register_process.jsp" method="post" onsubmit="return validateForm()">
            <div class="form-group">
   			 <label for="username">아이디:</label>
   			 <div class="input-group">
        	<input type="text" class="form-control" id="username" name="username" required>
       	 <div class="input-group-append">
            <button type="button" class="btn btn-primary" onclick="checkUsername()">중복 체크</button>
       		 </div>
   			 </div>
   			 <div id="usernameError" class="error"></div>
			</div>
			<div id="usernameCheckResult" class="error"></div>
            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" class="form-control" id="password" name="password" required>
                <div id="passwordError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="fullname">이름:</label>
                <input type="text" class="form-control" id="fullname" name="fullname" required>
                <div id="fullnameError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="phone">전화번호:</label>
                <input type="text" class="form-control" id="phone" name="phone" required>
                <div id="phoneError" class="error"></div>
            </div>
            <button type="submit" class="btn btn-primary">가입하기</button>
        </form>
    </div>

    <!-- 부트스트랩 JS 및 jQuery 링크 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var fullname = document.getElementById("fullname").value;
            var phone = document.getElementById("phone").value;
            var usernamePattern = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{5,}$/; // 영문, 숫자 혼용, 5자 이상
            var passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{5,}$/; // 영문, 숫자, 특수문자 포함, 5자 이상
            var fullnamePattern = /^[가-힣]+$/; // 한글만
            var phonePattern = /^010-\d{4}-\d{4}$/; // 010-숫자4자리-숫자4자리

            var usernameError = document.getElementById("usernameError");
            var passwordError = document.getElementById("passwordError");
            var fullnameError = document.getElementById("fullnameError");
            var phoneError = document.getElementById("phoneError");
            var isValid = true;

            if (!username || !password || !fullname || !phone) {
                alert("모든 항목을 입력하세요.");
                isValid = false;
                return false;
            }
            
            if (!usernamePattern.test(username)) {
                usernameError.innerHTML = "아이디는 영문, 숫자를 혼용하여 5자 이상이어야 합니다.";
                isValid = false;
            } else {
                usernameError.innerHTML = "";
            }

            if (!passwordPattern.test(password)) {
                passwordError.innerHTML = "비밀번호는 영문, 숫자, 특수문자를 혼용하여 5자 이상이어야 합니다.";
                isValid = false;
            } else {
                passwordError.innerHTML = "";
            }

            if (!fullnamePattern.test(fullname)) {
                fullnameError.innerHTML = "이름은 한글만 입력 가능합니다.";
                isValid = false;
            } else {
                fullnameError.innerHTML = "";
            }

            if (!phonePattern.test(phone)) {
                phoneError.innerHTML = "전화번호 형식은 010-xxxx-xxxx 형식만 가능합니다.";
                isValid = false;
            } else {
                phoneError.innerHTML = "";
            }

            return isValid;
        }
   

    </script>
</body>
</html>
