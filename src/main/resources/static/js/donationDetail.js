window.addEventListener('load', function() {
    // localStorage에서 후원 정보 가져오기
    const donationData = JSON.parse(localStorage.getItem('donationData'));

    if (donationData) {
        // 후원 정보 출력
        const donationDetailContainer = document.getElementById('donation-detail-info');
        donationDetailContainer.innerHTML = `
            <h3>개인정보</h3>
            <p><strong>이름:</strong> ${donationData.name}</p>
            <p><strong>이메일:</strong> ${donationData.email}</p>
            <p><strong>전화번호:</strong> ${donationData.phone}</p>
            
            <h3>결제정보</h3>
            <p><strong>결제 수단:</strong> ${donationData.paymentMethod}</p>
            ${donationData.paymentMethod === 'creditcard' ? `
                <p><strong>카드번호:</strong> ${donationData.cardNumber}</p>
            ` : donationData.paymentMethod === 'bank' ? `
                <p><strong>은행:</strong> ${donationData.bankName}</p>
                <p><strong>계좌번호:</strong> ${donationData.accountNumber}</p>
            ` : `
                <p><strong>휴대폰 번호:</strong> ${donationData.phoneNumber}</p>
            `}
            
            <h3>배송정보</h3>
            <p><strong>주소:</strong> ${donationData.address}</p>
        `;

        // 뒤로가기 버튼 클릭 시 목록 페이지로 이동
        document.getElementById('back-btn').addEventListener('click', function() {
            window.location.href = 'mypage.html';
        });

        // 수정 버튼 클릭 시 donation.html 페이지로 이동
        document.getElementById('edit-btn').addEventListener('click', function() {
            window.location.href = 'editdonation.html';
        });

        // 취소 버튼 클릭 시 확인 팝업 후 삭제
        document.getElementById('cancel-btn').addEventListener('click', function() {
            if (confirm('후원을 취소하시겠습니까?')) {
                localStorage.removeItem('donationData');
                alert('후원 정보가 취소되었습니다.');
                window.location.href = 'mypage.html';
            }
        });
    }
});
