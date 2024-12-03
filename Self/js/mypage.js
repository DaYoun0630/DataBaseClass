

document.querySelector('.apply-btn').addEventListener('click', function() {
    alert('알림 설정이 적용됐습니다.');
});

document.getElementById('editsignup-link').addEventListener('click', function() {
    window.location.href = 'editsignup.html'; // 개인정보 수정 페이지로 이동
});

document.getElementById('mainpage-link').addEventListener('click', function() {
    window.location.href = 'index.html'; // 메인페이지로 이동
});