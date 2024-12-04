window.addEventListener('load', function() {
    const index = localStorage.getItem('currentComplaintIndex');
    const complaints = JSON.parse(localStorage.getItem('complaints')) || [];
    const complaint = complaints[index];

    // 민원 상세 정보 출력
    const complaintDetailContainer = document.getElementById('complaint-detail');
    complaintDetailContainer.innerHTML = `
        <p><strong>민원 유형:</strong> ${complaint.type}</p>
        <p><strong>제목:</strong> ${complaint.title}</p>
        <p><strong>내용:</strong> ${complaint.content}</p>
        <p><strong>진행 상태:</strong> ${complaint.status}</p>
    `;

    // 수정 버튼 클릭 시 수정 페이지로 이동
    document.getElementById('edit-btn').addEventListener('click', function() {
        localStorage.setItem('editComplaintIndex', index);
        window.location.href = 'complaintEdit.html';
    });

    // 취소 버튼 클릭 시 목록 페이지로 이동
    document.getElementById('cancel-btn').addEventListener('click', function() {
        window.location.href = 'complaint.html';
    });
});
