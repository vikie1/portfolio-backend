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
  const btnPublish = document.createElement("button");
  const btnPublishText = document.createTextNode(blog.published ? "unpublish" : "publish");
  const topicNode = document.createElement("small");
  blog.topic.forEach((element, index) => {
    const topictext = document.createTextNode(index === 0? element.name : ", " + element.name);
    topicNode.appendChild(topictext);
  });
  div.className = "col";
  card.className = "card shadow-sm";
  card.style = "cursor: pointer;";
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
  btn.addEventListener('click', (e) => handleEditBtnClick(e, blog.id));
  btn.appendChild(btntext);
  btndel.type = "button";
  btndel.className = "btn btn-sm btn-outline-secondary";
  btndel.id = "del" + blog.id;
  btndel.addEventListener('click', (e) => handleBtnDel(e, blog.id));
  btndel.appendChild(btndeltext);
  btnPublish.type = "button";
  btnPublish.className = "btn btn-sm btn-outline-secondary"
  btnPublish.id = "pub" + blog.id;
  btnPublish.addEventListener('click', (e) => handleBtnPublish(e, blog.id, !blog.published));
  btnPublish.appendChild(btnPublishText);
  topicNode.className = "text-muted";
  topicNode.id = "topic" + blog.id;
  divBtn.appendChild(btn);
  divBtn.appendChild(btndel);
  divBtn.appendChild(btnPublish);
  divBtnGroup.appendChild(divBtn);
  divBtnGroup.appendChild(topicNode);
  cardBody.appendChild(articleName);
  cardBody.appendChild(cardText);
  cardBody.appendChild(divBtnGroup);
  card.appendChild(cardImage);
  card.appendChild(cardBody);
  card.addEventListener('click',  () => handleCardClick(blog.id));
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

const handleCardClick = (id) => {
  getServer(getUrl("lfvBlogAPI") + "/id/" + id, true, true);
};

const handleEditBtnClick = (e, id) => {
  e.stopPropagation();
  window.open(getUrl("adminBlogEdit") + "?id=" + id, "_blank");
}
const handleBtnPublish = (e, id, publish) => {
  e.stopPropagation();
  const url = getUrl("lfvBlogAPI") + "/publish/" + id
  const formData = JSON.stringify(publish);
  let csrfToken = getCookie("XSRF-TOKEN");
  fetch(url, {
    headers: {
      "X-XSRF-TOKEN": csrfToken,
      "content-type": "application/json"
    },
    method: "PUT",
    body: formData,
  }).then(res => {
    if(res.ok) {
      document.getElementById("pub" + id).firstChild.textContent = publish ? "unpublish" : "publish";
    }
  })
}
const getArticle = () => {
  const pathVariables = window.location.pathname.split("/");
  getServer(
    getUrl("lfvBlogAPI") + pathVariables[2] + "/" + pathVariables[3],
    true,
    false
  );
};

const handleBtnDel = (e, id) => {
  e.stopPropagation();
  const url = "/admin/blog/" + id;
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