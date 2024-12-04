document.getElementById('project-create-form').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지

    // 프로젝트 이름과 내용 가져오기
    const projectName = document.getElementById('project-name').value;
    const projectContent = document.getElementById('project-content').value;

    // 입력값 검증
    if (!projectName || !projectContent) {
        alert('프로젝트 이름과 내용을 모두 입력해주세요!');
        return;
    }

    // 프로젝트 신청 처리 (현재는 alert로 처리)
    alert(`프로젝트 신청 완료:
    이름: ${projectName}
    내용: ${projectContent}`);

    // 프로젝트 신청 후 메인 페이지로 돌아감
    window.location.href = 'mainPage.html';
});
