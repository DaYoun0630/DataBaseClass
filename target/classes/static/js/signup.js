document.getElementById("signup-form").addEventListener("submit", async function (event) {
        event.preventDefault(); // 기본 폼 제출 방지

        const formData = {
            userId: document.getElementById("userId").value,
            userName: document.getElementById("userName").value,
            userPassword: document.getElementById("userPassword").value,
            userEmail: document.getElementById("userEmail").value,
            userPhoneNumber: document.getElementById("userPhoneNumber").value,
            userBirthdate: document.getElementById("userBirthdate").value,
            userAddress: document.getElementById("userAddress").value
        };

        try {
            const response = await fetch("http://localhost:8080/api/auth/signup", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                alert("회원가입이 성공적으로 완료되었습니다.");
                document.getElementById("signup-form").reset();
            } else {
                const error = await response.json();
                alert("회원가입 실패: " + error.message);
            }
        } catch (error) {
            alert("회원가입 중 오류가 발생했습니다.");
        }
    });