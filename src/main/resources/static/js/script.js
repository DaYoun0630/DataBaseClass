// 장바구니에 상품 추가하는 기능
function addToCart(projectName) {
    alert(projectName + "이(가) 장바구니에 추가되었습니다!");
}

// 검색 기능
function searchProject() {
    const query = document.getElementById('search-input').value;
    if (query.trim() === "") {
        alert("검색어를 입력해주세요.");
    } else {
        alert(`"${query}"에 대한 검색 결과를 표시합니다.`); 
        // 실제로는 여기에 검색 결과를 표시하는 로직이 필요합니다.
    }
}
