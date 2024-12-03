document.getElementById("checkout-btn").addEventListener("click", function() {
    const product = document.getElementById("product").value;
    const quantity = document.getElementById("quantity").value;
    
    const cartSummary = `선택한 상품: ${product}, 개수: ${quantity}`;
    document.getElementById("cart-summary").textContent = cartSummary;

    fetch('http://localhost:8080/api/auth/mainPage')
});

