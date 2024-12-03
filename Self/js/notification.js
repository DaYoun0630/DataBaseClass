document.addEventListener("DOMContentLoaded", function() {
    // 알림 설정 값 불러오기 (예시로 localStorage 사용)
    const complaintsCheckbox = document.getElementById("complaints");
    const commentsCheckbox = document.getElementById("comments");
    const projectsCheckbox = document.getElementById("projects");
    const donationsCheckbox = document.getElementById("donations");

    // 예시로 JSON 사용, 나중에 수정할 것!
    // localStorage에서 알림 설정 값 불러오기 (없으면 기본값 true)
    complaintsCheckbox.checked = JSON.parse(localStorage.getItem("complaints")) || true;
    commentsCheckbox.checked = JSON.parse(localStorage.getItem("comments")) || true;
    projectsCheckbox.checked = JSON.parse(localStorage.getItem("projects")) || false;
    donationsCheckbox.checked = JSON.parse(localStorage.getItem("donations")) || true;

    // 저장 버튼 클릭 시
    document.getElementById("notification-form").addEventListener("submit", function(event) {
        event.preventDefault();

        // 각 알림 수신 여부 저장
        localStorage.setItem("complaints", complaintsCheckbox.checked);
        localStorage.setItem("comments", commentsCheckbox.checked);
        localStorage.setItem("projects", projectsCheckbox.checked);
        localStorage.setItem("donations", donationsCheckbox.checked);

        // 팝업 표시
        document.getElementById("popup").style.display = "flex";
    });

    // 팝업 창 닫기
    document.getElementById("close-popup").addEventListener("click", function() {
        document.getElementById("popup").style.display = "none";
    });
});
