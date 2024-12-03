document.addEventListener('DOMContentLoaded', function() {
    const headerContainer = document.getElementById('headerContainer');

    // header.html 파일을 AJAX로 불러오기
    fetch('../html/header.html')
        .then(response => response.text())
        .then(data => {
            headerContainer.innerHTML = data;

            // 각 버튼에 이벤트 리스너 추가
            document.getElementById('logout-btn').addEventListener('click', function() {
                window.location.href = 'login.html'; // 로그아웃 시 로그인 페이지로 이동
            });

            document.getElementById('complaint-btn').addEventListener('click', function() {
                window.location.href = 'complaint.html'; // 민원 페이지로 이동
            });

            document.getElementById('mypage-btn').addEventListener('click', function() {
                window.location.href = 'mypage.html'; // 마이 페이지로 이동
            });

            document.getElementById('logo').addEventListener('click', function() {
                window.location.href = 'mainPage.html'; // 메인 페이지로 이동
            });
        })
        .catch(error => console.error('Error loading header:', error));
});
