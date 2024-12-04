

document.getElementById('userProfile-btn').addEventListener('click', function() {
    window.location.href = 'userProfile.html'; // 개인정보 페이지로 이동
});

document.getElementById('notification-btn').addEventListener('click', function() {
    window.location.href = 'nofication.html'; // 알림페이지로 이동
});

document.getElementById('delete-account-btn').addEventListener('click', function() {
    alert('탈퇴가 완료됐습니다.');
    // 한 번 확인 받는 페이지 필요?
    window.location.href = 'login.html'; // 다시 로그인 페이지로 이동
});
