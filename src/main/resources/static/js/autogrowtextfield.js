function AutoGrowTextArea(textField, id) {
  if (textField.clientHeight < textField.scrollHeight) {
    textField.style.height = textField.scrollHeight + "px";
    if (textField.clientHeight < textField.scrollHeight) {
      textField.style.height =
        textField.scrollHeight * 2 - textField.clientHeight + "px";
    }
  }
  populatePreviewArticle(id);
}
const populatePreviewH1 = (id) => {
    const heading = document.getElementById("title");
    const text = document.getElementById(id).value;
    heading.innerHTML = text;
}
const populatePreviewArticle = (id) => {
  const article = document.getElementById("article");
  const text = document.getElementById(id).value;
  article.innerHTML = text;
}