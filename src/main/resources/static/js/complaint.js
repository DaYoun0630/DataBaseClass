// API에서 민원 데이터를 가져와 테이블에 렌더링
async function fetchComplaints() {
    try {
        const response = await fetch('/api/complaints'); // API 요청
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();

        // 민원 데이터를 테이블에 추가
        const tableBody = document.querySelector('#complaint-data-table tbody');
        tableBody.innerHTML = ''; // 기존 데이터 제거

        data.forEach((complaint) => {
            const row = document.createElement('tr');

            row.innerHTML = `
                <td>${complaint.id}</td>
                <td>${complaint.userId}</td>
                <td>${complaint.content}</td>
                <td>${complaint.creationDate}</td>
                <td>${complaint.statusType}</td>
                <td>${complaint.employeeId || 'N/A'}</td>
                <td>${complaint.answer || 'N/A'}</td>
            `;

            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error fetching complaints:', error);
    }
}

// 페이지가 로드되었을 때 데이터 가져오기
document.addEventListener('DOMContentLoaded', () => {
    fetchComplaints();
});
// 민원 작성 버튼 이벤트
document.getElementById('complaintCreate-btn').addEventListener('click', () => {
    window.location.href = 'complaintCreate.html'; // 올바른 HTML 파일 이름 사용
});
