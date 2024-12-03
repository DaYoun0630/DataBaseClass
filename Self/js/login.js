// 로그인창
document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지

    // 입력값 가져오기
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    // 필수 입력값 확인
    if (!username || !password) {
        alert('아이디와 비밀번호를 모두 입력해주세요!');
        return;
    }

    // 로그인 처리 (현재는 로그인 정보가 제대로 입력되었을 때 index.html로 이동)
    alert(`아이디: ${username}\n비밀번호: ${password}로 로그인 성공!`);

    // 로그인 성공 후 index.html 페이지로 이동
    window.location.href = 'mainPage.html';
});

// 회원가입 페이지로 이동
document.getElementById('signup-link').addEventListener('click', function() {
    window.location.href = 'signup.html'; // 회원가입 페이지로 이동
});
