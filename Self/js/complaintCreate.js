document.getElementById('complaint-create-form').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 기본 동작 막기

    // 입력값 가져오기
    const complaintType = document.getElementById('complaint-type').value;
    const complaintTitle = document.getElementById('complaint-title').value;
    const complaintContent = document.getElementById('complaint-content').value;

    // 민원 데이터 객체
    const complaint = {
        type: complaintType,
        title: complaintTitle,
        content: complaintContent,
        status: '접수됨', // 기본 상태는 접수됨
    };

    // 기존 민원 목록 가져오기 (없으면 빈 배열)
    let complaints = JSON.parse(localStorage.getItem('complaints')) || [];

    // 새로운 민원 추가
    complaints.push(complaint);

    // 민원 목록을 localStorage에 저장
    localStorage.setItem('complaints', JSON.stringify(complaints));

    // 민원 작성 후, 목록 페이지로 이동
    // 수정 필요, 현재는 작동X
    window.location.href = 'complaint.html';
});

