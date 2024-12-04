// DOM 요소들
const creditcardInput = document.getElementById('creditcard-input');
const bankInput = document.getElementById('bank-input');
const phoneInput = document.getElementById('phone-input');

// 결제 방법 선택 시 입력란 변경
const paymentOptions = document.querySelectorAll('input[name="complaints"]');

paymentOptions.forEach(option => {
    option.addEventListener('change', function() {
        creditcardInput.style.display = 'none';
        bankInput.style.display = 'none';
        phoneInput.style.display = 'none';

        // 선택된 결제 수단에 맞는 입력란
        if (this.value === 'creditcard') {
            creditcardInput.style.display = 'block';
        } else if (this.value === 'bank') {
            bankInput.style.display = 'block';
        } else if (this.value === 'phone') {
            phoneInput.style.display = 'block';
        }
    });
});

// 페이지 로딩 시 기본으로 선택된 결제 방법의 입력란을 보이도록 설정
window.addEventListener('DOMContentLoaded', function() {
    const checkedOption = document.querySelector('input[name="complaints"]:checked');
    if (checkedOption) {
        if (checkedOption.value === 'creditcard') {
            creditcardInput.style.display = 'block';
        } else if (checkedOption.value === 'bank') {
            bankInput.style.display = 'block';
        } else if (checkedOption.value === 'phone') {
            phoneInput.style.display = 'block';
        }
    }
});
