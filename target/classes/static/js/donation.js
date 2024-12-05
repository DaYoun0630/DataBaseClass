document.getElementById('info-form').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지

    // 입력값 가져오기
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const name = document.getElementById('name').value;
    const birthdate = document.getElementById('birthdate').value;
    const address = document.getElementById('address').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;

    // 필수 입력값 확인
    if (!username || !password || !name || !birthdate || !address || !email || !phone) {
        alert('모든 필드를 채워주세요!');
        return;
    }

    // 가입 처리 (현재는 alert로 처리)
    alert(`회원가입 정보:
    아이디: ${username}
    비밀번호: ${password}
    이름: ${name}
    생년월일: ${birthdate}
    주소: ${address}
    이메일: ${email}
    전화번호: ${phone}`);

    // 실제 서비스에서는 여기서 회원가입을 처리하는 백엔드 API 호출이 필요합니다.
});

// 로그인 페이지로 이동
document.getElementById('login-link').addEventListener('click', function() {
    window.location.href = 'login.html'; // 로그인 페이지로 이동
});

document.addEventListener("DOMContentLoaded", function() {
    // 라디오 버튼 요소들
    const creditcardRadio = document.getElementById("creditcard");
    const bankRadio = document.getElementById("bank");
    const phoneRadio = document.getElementById("phone");

    creditcardRadio.checked = true;

    // 각 결제수단에 해당하는 입력 필드들
    const creditcardInput = document.getElementById("creditcard-input");
    const bankInput = document.getElementById("bank-input");
    const phoneInput = document.getElementById("phone-input");

    // 결제 수단을 선택할 때마다 해당하는 입력 필드를 보여주고 나머지는 숨김
    function togglePaymentFields() {
        // 모든 입력 필드를 숨김
        creditcardInput.style.display = "none";
        bankInput.style.display = "none";
        phoneInput.style.display = "none";

        // 선택된 결제 수단에 맞는 입력 필드를 보임
        if (creditcardRadio.checked) {
            creditcardInput.style.display = "block";
        } else if (bankRadio.checked) {
            bankInput.style.display = "block";
        } else if (phoneRadio.checked) {
            phoneInput.style.display = "block";
        }
    }

    // 결제 수단 라디오 버튼에 이벤트 리스너 추가
    creditcardRadio.addEventListener("change", togglePaymentFields);
    bankRadio.addEventListener("change", togglePaymentFields);
    phoneRadio.addEventListener("change", togglePaymentFields);
});

window.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const projectName = params.get("projectName");
    const targetAmount = params.get("targetAmount");
    const quantity = params.get("quantity");

    if (projectName && targetAmount && quantity) {
        // 페이지에 전달받은 데이터 표시
        document.getElementById("project-name-display").innerText = projectName;
        document.getElementById("target-amount-display").innerText = targetAmount;
        document.getElementById("quantity-display").innerText = quantity;
    }
});

