document.addEventListener("DOMContentLoaded", () => {
    // 검색 버튼 동작
    const searchButton = document.querySelector(".search-bar button");
    searchButton.addEventListener("click", () => {
      const query = document.querySelector(".search-bar input").value;
      alert(`"${query}" 검색 결과를 보여줍니다.`);
    });
  
    // 프로젝트 만들기 버튼
    const createProjectButton = document.querySelector(".create-project");
    createProjectButton.addEventListener("click", () => {
      alert("프로젝트 만들기 페이지로 이동합니다!");
    });
  });
  