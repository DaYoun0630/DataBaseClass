//// DOMContentLoaded 이벤트: HTML 문서가 완전히 로드되었을 때 실행
//document.addEventListener('DOMContentLoaded', function () {
//    // URL에서 projectId 추출
//    const urlParams = new URLSearchParams(window.location.search); // 현재 페이지 URL의 쿼리 파라미터 분석
//    const projectId = urlParams.get('projectId'); // projectId 값 가져오기
//
//    if (projectId) {
//        // 서버로부터 해당 projectId에 대한 프로젝트 데이터 가져오기
//        fetch(`http://localhost:8080/api/auth/project/${projectId}`)
//            .then(response => {
//                // 응답이 성공적이지 않을 경우 에러 처리
//                if (!response.ok) {
//                    throw new Error('Network response was not ok');
//                }
//                // JSON 데이터로 변환
//                return response.json();
//            })
//            .then(project => {
//                // 데이터를 HTML 요소에 동적으로 삽입
//                document.getElementById('project-title').textContent = project.projectName; // 프로젝트 이름
//                document.getElementById('project-description').textContent = project.projectDescription; // 프로젝트 설명
//                document.getElementById('project-start-date').textContent = project.projectStartDate; // 프로젝트 시작일
//                document.getElementById('project-end-date').textContent = project.projectEndDate; // 프로젝트 종료일
//                document.getElementById('project-target-amount').textContent = project.projectTargetAmount.toLocaleString(); // 목표 금액 (천 단위 콤마)
//                document.getElementById('project-category').textContent = project.categoryId; // 프로젝트 카테고리
//
//                 // 상품 종류에 프로젝트 이름 추가
//                const selectElement = document.getElementById("project");
//                const option = document.createElement("option");
//                option.value = projectId; // 프로젝트 ID를 값으로 설정
//                option.textContent = projectData.projectName; // 프로젝트 이름을 텍스트로 설정
//                selectElement.appendChild(option);
//            })
//            .catch(error => {
//                // 데이터 요청 중 발생한 에러를 처리
//                console.error('Error fetching project data:', error);
//            });
//    } else {
//        // projectId가 URL에 없는 경우 에러 메시지 출력
//        console.error('No projectId found in URL');
//    }
//});
document.addEventListener("DOMContentLoaded", function() {
    // URL에서 projectId 추출
    const urlParams = new URLSearchParams(window.location.search);
    const projectId = urlParams.get("projectId");

    // API에서 프로젝트 데이터를 가져오는 함수
    fetch(`/api/auth/project/${projectId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(projectData => {
            // 프로젝트 상세 정보 업데이트
            document.getElementById("project-title").textContent = projectData.projectName;
            document.getElementById("project-description").textContent = projectData.projectDescription;
            document.getElementById("project-start-date").textContent = projectData.projectStartDate;
            document.getElementById("project-end-date").textContent = projectData.projectEndDate;
            document.getElementById("project-target-amount").textContent = projectData.projectTargetAmount.toLocaleString();
            document.getElementById("project-category").textContent = projectData.categoryId;

            // "상품 종류" 선택 옵션에 프로젝트 이름 추가
            const projectSelect = document.getElementById("project");
            const option = document.createElement("option");
            option.value = projectId; // 프로젝트 ID를 값으로 설정
            option.textContent = projectData.projectName; // 프로젝트 이름을 텍스트로 설정
            projectSelect.appendChild(option);
        })
        .catch(error => {
            console.error("Error fetching project data:", error);
        });
});
document.getElementById("checkout-btn").addEventListener("click", () => {
    const projectName = document.getElementById("project-title").innerText; // 프로젝트 이름
    const targetAmount = document.getElementById("project-target-amount").innerText; // 목표 금액
    const quantity = document.getElementById("quantity").value; // 선택한 개수

    // 쿼리 파라미터로 전달
    const params = new URLSearchParams({
        projectName,
        targetAmount,
        quantity
    });

    // donation.html로 이동
    window.location.href = `donation.html?${params.toString()}`;
});
