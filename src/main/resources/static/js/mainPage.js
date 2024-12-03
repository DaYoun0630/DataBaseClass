document.getElementById('create-project-btn').addEventListener('click', function() {
    window.location.href = 'projectCreate.html'; // 프로젝트 만들기 버튼 클릭 시 프로젝트 신청 페이지로 이동
});

document.addEventListener('DOMContentLoaded', function() {
    const navbar = document.getElementById('navbar');
    const mainContent = document.getElementById('main-content');

    if (navbar && mainContent) {
        navbar.style.display = 'block';
        mainContent.style.display = 'block';
    } else {
        console.error('Navbar or main content not found.');
    }

    // 서버에서 프로젝트 데이터 가져오기
    fetch('http://localhost:8080/api/auth/project')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#project-data-table tbody');
            tableBody.innerHTML = ''; // 기존 내용을 초기화

            data.forEach(project => {
                const row = `
                    <tr>
                        <td>${project.project_application_id}</td>
                        <td>${project.project_name}</td>
                        <td>${project.project_description}</td>
                        <td>${project.project_start_date}</td>
                        <td>${project.project_end_date}</td>
                        <td>${project.project_target_amount.toLocaleString()}</td>
                        <td>${project.category_id}</td>
                        <td>${project.project_application_review}</td>
                    </tr>
                `;
                tableBody.insertAdjacentHTML('beforeend', row);
            });
        })
        .catch(error => console.error('Error fetching project data:', error));
});

