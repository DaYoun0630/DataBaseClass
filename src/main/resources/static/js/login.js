document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 시 페이지 리로드 방지

    const username = document.getElementById('login-username').value; // 아이디 값
    const password = document.getElementById('login-password').value; // 비밀번호 값

    // 로그인 요청을 서버로 보내기
    fetch('/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: username, // useridOrEmail을 userId로 수정
            userPassword: password // password 필드 고정
        })
    })
    .then(response => response.json()) // 서버 응답을 JSON 형식으로 받기
    .then(data => {
        if (data.success) {
            // 로그인 성공 시 메인 페이지로 이동
            window.location.href = 'mainPage.html';
        } else {
            alert('로그인 실패: ' + data.message); // 로그인 실패 시 메시지 표시
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert("로그인 요청 중 오류가 발생했습니다.");
    });
});
