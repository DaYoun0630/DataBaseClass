document.addEventListener("DOMContentLoaded", function() {
    // 알림 설정 값 불러오기 (로컬 스토리지에서 값 읽기)
    const complaintsCheckbox = document.getElementById("complaints");
    const commentsCheckbox = document.getElementById("comments");
    const projectsCheckbox = document.getElementById("projects");
    const donationsCheckbox = document.getElementById("donations");

    // 로컬 스토리지에서 알림 설정 값 불러오기 (기본값: true)
    complaintsCheckbox.checked = localStorage.getItem("complaints") === "true" || true;
    commentsCheckbox.checked = localStorage.getItem("comments") === "true" || true;
    projectsCheckbox.checked = localStorage.getItem("projects") === "true" || true;
    donationsCheckbox.checked = localStorage.getItem("donations") === "true" || true;

    // 콘솔 로그 추가: 로컬 스토리지에서 불러온 값 확인 - 필요? 삭제?
    console.log("complaints:", localStorage.getItem("complaints"));
    console.log("comments:", localStorage.getItem("comments"));
    console.log("projects:", localStorage.getItem("projects"));
    console.log("donations:", localStorage.getItem("donations"));

    // 저장 버튼 클릭 시
    document.getElementById("notification-form").addEventListener("submit", function(event) {
        event.preventDefault();

        // 각 알림 수신 여부 로컬 스토리지에 저장
        localStorage.setItem("complaints", complaintsCheckbox.checked);
        localStorage.setItem("comments", commentsCheckbox.checked);
        localStorage.setItem("projects", projectsCheckbox.checked);
        localStorage.setItem("donations", donationsCheckbox.checked);

        // 콘솔 로그 추가: 저장된 값 확인 - 필요할까? 삭제?
        console.log("저장된 complaints:", complaintsCheckbox.checked);
        console.log("저장된 comments:", commentsCheckbox.checked);
        console.log("저장된 projects:", projectsCheckbox.checked);
        console.log("저장된 donations:", donationsCheckbox.checked);

        // 팝업 표시
        document.getElementById("popup").style.display = "flex";
    });

    // 팝업 창 닫기
    document.getElementById("close-popup").addEventListener("click", function() {
        document.getElementById("popup").style.display = "none";
    });
});
