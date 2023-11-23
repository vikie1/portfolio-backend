import { getUrl } from "./urls.js";

const getServer = (url, isArticle, hide) => {
  const abortController = new AbortController();
  const data = (async () => {
    try {
      const result = await fetch(url, { signal: abortController.signal }).then(
        (res) => {
          if (!res.ok) {
            throw Error("Did not get data from server");
          }
          return res.json();
        }
      );
      if (isArticle) {
        renderBlogArticle(
          result.current.name,
          result.current.post,
          hide
        );
        result.related.map((blog) => {
          let pathVariables = window.location.pathname.split("/");
          if (pathVariables[2] != blog.id) {
            if (blog) {
              document.getElementById("related").innerHTML =
                "Get related articles";
            }
            createArticleCard(blog, true);
          }
        });
      } else {
        result.blog.map((blog) => createArticleCard(blog));
      }
      return result;
    } catch (error) {
      console.error(error);
    }
  })();
  return data;
};

const createArticleCard = (blog, related) => {
  const currentDiv = document.getElementById(related ? "related" : "articlesContainer");
  const div = document.createElement("div");
  const card = document.createElement("div");
  const cardImage = document.createElement("img");
  const cardBody = document.createElement("div");
  const articleName = document.createElement("strong");
  const cardText = document.createElement("p");
  const text = document.createTextNode(blog.description);
  const divBtnGroup = document.createElement("div");
  const divBtn = document.createElement("div");
  const btn = document.createElement("button");
  const btntext = document.createTextNode("Edit");
  const btndel = document.createElement("button");
  const btndeltext = document.createTextNode("Delete");
  const topicNode = document.createElement("small");
  blog.topic.forEach((element, index) => {
    const topictext = document.createTextNode(index === 0? element.name : ", " + element.name);
    topicNode.appendChild(topictext);
  });
  div.className = "col";
  card.className = "card shadow-sm";
  cardImage.className = "bd-placeholder-img card-img-top";
  const imgURL = blog.imgURL;
  if (!imgURL || imgURL === "null" || imgURL === "undefined") {
    cardImage.src =
      "https://res.cloudinary.com/mesmusiq-entertainment/image/upload/v1626255115/blogpictures/vjc0l0xva0jfv8bst051.jpg";
  } else {
    cardImage.src = imgURL;
  }
  cardImage.alt = "Blog image";
  cardImage.width = "100%";
  cardImage.height = "225";
  cardImage.preserveAspectRatio = "xMidYMid slice";
  cardImage.focusable = "false";
  cardBody.className = "card-body";
  articleName.innerHTML = blog.name;
  cardText.className = "card-text";
  cardText.appendChild(text);
  divBtnGroup.className = "d-flex justify-content-between align-items-center";
  divBtn.className = "btn-group";
  btn.type = "button";
  btn.className = "btn btn-sm btn-outline-secondary";
  btn.id = "" + blog.id;
  // btn.setAttribute("onclick", "handleBtnClick(this.id)");
  btn.addEventListener('click', () => handleBtnClick(blog.id));
  btn.appendChild(btntext);
  btndel.type = "button";
  btndel.className = "btn btn-sm btn-outline-secondary";
  btndel.id = "del" + blog.id;
  btndel.setAttribute("onclick", "handleBtnDel(this.id)");
  btndel.appendChild(btndeltext);
  topicNode.className = "text-muted";
  topicNode.id = "topic" + blog.id;
  divBtn.appendChild(btn);
  divBtn.appendChild(btndel);
  divBtnGroup.appendChild(divBtn);
  divBtnGroup.appendChild(topicNode);
  cardBody.appendChild(articleName);
  cardBody.appendChild(cardText);
  cardBody.appendChild(divBtnGroup);
  card.appendChild(cardImage);
  card.appendChild(cardBody);
  div.appendChild(card);
  currentDiv.appendChild(div);
};

//encodeURIComponent(string);
const renderBlogArticle = (title, body) => {
  document.title = title
  const article = document.getElementById("article");
  article.innerHTML = body;
};

const getArticles = () => {
  getServer(getUrl("lfvBlogAPI"), false, false);
};

const handleBtnClick = (id) => {
  getServer(getUrl("lfvBlogAPI") + "/id/" + id, true, true);
};

const getArticle = () => {
  const pathVariables = window.location.pathname.split("/");
  getServer(
    getUrl("lfvBlogAPI") + pathVariables[2] + "/" + pathVariables[3],
    true,
    false
  );
};

const handleBtnDel = (id) => {
  const urlId = id.replace("del", "");
  const url = "/admin/blog/" + urlId;
  let csrfToken = getCookie("XSRF-TOKEN");
  const postConfigs = {
    headers: {
      "X-XSRF-TOKEN": csrfToken,
    },
    method: "DELETE",
  };
  fetch(url, postConfigs).then((res) => {
    window.location.reload();
    return false;
  });
};

const getCookie = (name) => {
  if (!document.cookie) {
    return null;
  }
  const csrfCookie = document.cookie
    .split(";")
    .map((c) => c.trim())
    .filter((c) => c.startsWith(name + "="));
  if (csrfCookie.length === 0) {
    return null;
  }
  return decodeURIComponent(csrfCookie[0].split("=")[1]);
};

document.body.onload = getArticles();