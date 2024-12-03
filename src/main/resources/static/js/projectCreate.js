document.addEventListener("DOMContentLoaded", async function () {
    const API_BASE_URL = "/api/projects";

    const targetAmountInput = document.getElementById("project-target-amount");
    const amountInKorean = document.getElementById("amount-in-korean");
    const userIdInput = document.getElementById("user-id");

    localStorage.setItem("token", "YOUR_JWT_TOKEN"); // 서버로부터 받은 토큰 설정

    if (!userIdInput) {
        alert("필수 입력 필드(user-id)가 없습니다. 페이지를 다시 로드해주세요.");
        console.error("user-id 요소를 찾을 수 없습니다. HTML에 해당 필드가 있는지 확인하세요.");
        return;
    }

    // 사용자 ID 동적 로드
    try {
        const response = await fetch(`${API_BASE_URL}/current-user`, {
            method: "GET",
            headers: {
                "Authorization": `Bearer ${localStorage.getItem("token")}`, // JWT 토큰
            },
        });

        if (!response.ok) {
            throw new Error("사용자 정보를 가져오는 데 실패했습니다.");
        }

        const userId = await response.text();
        userIdInput.value = userId; // 사용자 ID 설정
    } catch (error) {
        console.error("사용자 ID 로드 오류:", error);
        alert("로그인 정보를 확인할 수 없습니다. 다시 로그인해주세요.");
    }

    // 목표 금액 입력 처리
    targetAmountInput.addEventListener("input", function () {
        const rawValue = targetAmountInput.value.replace(/[^0-9]/g, ""); // 숫자만 허용
        const numericValue = parseInt(rawValue, 10);

        if (!isNaN(numericValue)) {
            // 쉼표 추가
            targetAmountInput.value = numericValue.toLocaleString();

            // 한글 금액 변환
            amountInKorean.textContent = convertNumberToKorean(numericValue) + "원";
        } else {
            amountInKorean.textContent = "";
        }
    });

    // 숫자를 한글로 변환하는 함수
    function convertNumberToKorean(number) {
        const units = ["", "만", "억", "조", "경"];
        const digits = ["", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"];
        let result = "";
        let unitIndex = 0;

        while (number > 0) {
            const chunk = number % 10000;
            if (chunk > 0) {
                let chunkResult = "";
                const thousands = Math.floor(chunk / 1000);
                const hundreds = Math.floor((chunk % 1000) / 100);
                const tens = Math.floor((chunk % 100) / 10);
                const ones = chunk % 10;

                if (thousands > 0) chunkResult += digits[thousands] + "천";
                if (hundreds > 0) chunkResult += digits[hundreds] + "백";
                if (tens > 0) chunkResult += digits[tens] + "십";
                if (ones > 0) chunkResult += digits[ones];

                result = chunkResult + units[unitIndex] + result;
            }
            unitIndex++;
            number = Math.floor(number / 10000);
        }

        return result || "영";
    }

    // 폼 제출 처리
    const form = document.getElementById("project-create-form");
    form.addEventListener("submit", async function (event) {
        event.preventDefault();

        const formData = {
            projectName: document.getElementById("project-name").value,
            projectDescription: document.getElementById("project-content").value,
            category: { id: document.getElementById("category-id").value },
            projectStartDate: document.getElementById("project-start-date").value,
            projectEndDate: document.getElementById("project-end-date").value,
            projectTargetAmount: document.getElementById("project-target-amount").value.replace(/,/g, ""),
            user: { userId: userIdInput.value }, // 동적으로 가져온 사용자 ID 사용
        };

        try {
            const response = await fetch(`${API_BASE_URL}/apply`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(formData),
            });

            if (!response.ok) {
                throw new Error("서버 오류");
            }

            alert("프로젝트 신청이 성공적으로 저장되었습니다.");
            form.reset();
            amountInKorean.textContent = ""; // 초기화
        } catch (error) {
            console.error("프로젝트 신청 중 오류:", error);
            alert("프로젝트 신청 중 오류가 발생했습니다.");
        }
    });
});
