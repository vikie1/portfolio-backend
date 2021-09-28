function getDom(element){
    fetch('/components/html/unfinished.html')
    .then((response) => response.text())
    .then((html) => {
        element.innerHTML = html;
    })
    .catch((error) => {
        element.innerHTML = "action not complete due to " + error; 
    })
};

document.getElementById("start").addEventListener("click", function () {
  getDom(document.body)
});
