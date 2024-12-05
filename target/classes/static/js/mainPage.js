document.addEventListener('DOMContentLoaded', function() {
    // 서버에서 프로젝트 데이터 가져오기
    fetch('http://localhost:8080/api/auth/project') // REST API 경로
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.querySelector('#project-data-table tbody');
            tableBody.innerHTML = ''; // 기존 내용을 초기화

            data.forEach(project => {
                const row = `
                    <tr data-id="${project.projectApplicationId}">
                        <td>${project.projectApplicationId}</td>
                        <td>${project.projectName}</td>
                        <td>${project.projectDescription}</td>
                        <td>${project.projectStartDate}</td>
                        <td>${project.projectEndDate}</td>
                        <td>${project.projectTargetAmount.toLocaleString()}</td>
                        <td>${project.categoryId}</td>
                        <td>${project.state}</td>
                    </tr>
                `;
                tableBody.insertAdjacentHTML('beforeend', row);
            });
        })
        .catch(error => console.error('Error fetching project data:', error));

    // 동적으로 추가된 <tr> 요소에도 이벤트를 위임
    const table = document.querySelector('#project-data-table tbody');
    table.addEventListener('click', function(event) {
        const row = event.target.closest('tr'); // 클릭된 요소의 상위 <tr> 찾기
        if (row) {
            const projectId = row.getAttribute('data-id'); // data-id 속성에서 프로젝트 ID 가져오기
            if (projectId) {
                // 상세 페이지로 이동 (query parameter로 projectId 전달)
                window.location.href = `project.html?projectId=${projectId}`;
            }
        }
    });
});
