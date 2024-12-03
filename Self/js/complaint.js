window.addEventListener('load', function() {
    // localStorage에서 민원 목록 가져오기
    const complaints = JSON.parse(localStorage.getItem('complaints')) || [];

    const complaintList = document.querySelector('.complaint-list ul');
    
    // 민원 목록이 없을 경우 메시지 출력
    if (complaints.length === 0) {
        const noComplaintsMessage = document.createElement('li');
        noComplaintsMessage.textContent = "등록된 민원이 없습니다.";
        complaintList.appendChild(noComplaintsMessage);
    } else {
        // 민원 목록 출력
        complaints.forEach((complaint, index) => {
            const li = document.createElement('li');
            li.textContent = `${complaint.type}: ${complaint.title} (${complaint.status})`;

            // 각 민원을 클릭했을 때 상세 페이지로 이동
            li.addEventListener('click', function() {
                localStorage.setItem('currentComplaintIndex', index);
                window.location.href = 'complaintDetail.html';
            });

            complaintList.appendChild(li);
        });
    }
});

// 민원 작성하기 버튼 클릭 시 민원 작성 페이지로 이동
document.getElementById('complaintCreate-btn').addEventListener('click', function() {
    window.location.href = 'complaintCreate.html';
});
