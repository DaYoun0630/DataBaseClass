window.addEventListener('load', function() {
    // localStorage에서 후원 정보 가져오기
    const donationData = JSON.parse(localStorage.getItem('donationData'));

    if (donationData) {
        // 후원 정보 폼에 기존 값 설정
        document.getElementById('donor-name').value = donationData.name;
        document.getElementById('donor-email').value = donationData.email;
        document.getElementById('donor-phone').value = donationData.phone;
        document.getElementById('address').value = donationData.address;
        document.getElementById('payment-method').value = donationData.paymentMethod;

        // 결제 정보에 맞게 추가 필드 표시
        if (donationData.paymentMethod === 'creditcard') {
            document.getElementById('creditcard-info').style.display = 'block';
            document.getElementById('bank-info').style.display = 'none';
            document.getElementById('mobile-info').style.display = 'none';
            document.getElementById('card-number').value = donationData.cardNumber;
        } else if (donationData.paymentMethod === 'bank') {
            document.getElementById('bank-info').style.display = 'block';
            document.getElementById('creditcard-info').style.display = 'none';
            document.getElementById('mobile-info').style.display = 'none';
            document.getElementById('bank-name').value = donationData.bankName;
            document.getElementById('account-number').value = donationData.accountNumber;
        } else {
            document.getElementById('mobile-info').style.display = 'block';
            document.getElementById('creditcard-info').style.display = 'none';
            document.getElementById('bank-info').style.display = 'none';
            document.getElementById('mobile-number').value = donationData.phoneNumber;
        }
    }

    // 결제 방법 변경 시 추가 정보 표시
    document.getElementById('payment-method').addEventListener('change', function() {
        const paymentMethod = this.value;
        document.getElementById('creditcard-info').style.display = paymentMethod === 'creditcard' ? 'block' : 'none';
        document.getElementById('bank-info').style.display = paymentMethod === 'bank' ? 'block' : 'none';
        document.getElementById('mobile-info').style.display = paymentMethod === 'mobile' ? 'block' : 'none';
    });

    // 뒤로가기 버튼 클릭 시 목록 페이지로 이동
    document.getElementById('back-btn').addEventListener('click', function() {
        window.location.href = 'mypage.html';
    });

    // 후원 정보 수정 후 저장 버튼 클릭 시
    document.getElementById('save-btn').addEventListener('click', function(event) {
        event.preventDefault(); // 폼 제출 기본 동작 방지

        // 수정된 후원 정보 가져오기
        const updatedDonationData = {
            name: document.getElementById('donor-name').value,
            email: document.getElementById('donor-email').value,
            phone: document.getElementById('donor-phone').value,
            address: document.getElementById('address').value,
            paymentMethod: document.getElementById('payment-method').value,
            // 결제 방법에 맞는 추가 정보
            cardNumber: document.getElementById('card-number').value,
            bankName: document.getElementById('bank-name').value,
            accountNumber: document.getElementById('account-number').value,
            phoneNumber: document.getElementById('mobile-number').value
        };

        // 수정된 정보를 localStorage에 저장
        localStorage.setItem('donationData', JSON.stringify(updatedDonationData));

        // 알림 및 목록 페이지로 이동
        alert('후원 정보가 수정되었습니다.');
        window.location.href = 'mypage.html';
    });
});
