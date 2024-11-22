document.getElementById('complaint-create-form').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지

    // 민원 등록 처리 (현재는 alert로 처리)
    const complaintType = document.getElementById('complaint-type').value;
    const complaintTitle = document.getElementById('complaint-title').value;
    const complaintContent = document.getElementById('complaint-content').value;

    if (!complaintTitle || !complaintContent) {
        alert('제목과 내용을 모두 입력해주세요!');
        return;
    }

    alert(`민원 등록 완료:
    유형: ${complaintType}
    제목: ${complaintTitle}
    내용: ${complaintContent}`);

    // 민원 등록 후 민원 목록 페이지로 돌아감
    window.location.href = 'complaint.html';
});
