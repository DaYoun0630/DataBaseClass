//회원가입 창

document.getElementById('signup-form').addEventListener('submit', function(event) {
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
