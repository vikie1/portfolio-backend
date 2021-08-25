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
          result.blog[0].name,
          result.blog[0].fullArticle,
          hide
        );
        result.related.map((blog) => {
          let pathVariables = window.location.pathname.split("/");
          if (pathVariables[2] != blog.id) {
            if (blog) {
              window.getElementById("related").innerHTML =
                "Get related articles";
            }
            createArticleCard(
              blog.imgURL,
              blog.name,
              blog.topic,
              blog.description,
              blog.id
            );
          }
        });
      } else {
        result.blog.map((blog) => {
          createArticleCard(
            blog.imgURL,
            blog.name,
            blog.topic,
            blog.description,
            blog.id
          );
        });
      }
      return result;
    } catch (error) {
      console.error(error);
    }
  })();
  return data;
};

const createArticleCard = (imgURL, title, topic, description, id) => {
  const currentDiv = document.getElementById("articlesContainer");
  const div = document.createElement("div");
  const card = document.createElement("div");
  const cardImage = document.createElement("img");
  const cardBody = document.createElement("div");
  const articleName = document.createElement("strong");
  const cardText = document.createElement("p");
  const text = document.createTextNode(description);
  const divBtnGroup = document.createElement("div");
  const divBtn = document.createElement("div");
  const btn = document.createElement("button");
  const btntext = document.createTextNode("Read");
  const btndel = document.createElement("button");
  const btndeltext = document.createTextNode("Delete");
  const topicNode = document.createElement("small");
  const topictext = document.createTextNode(topic);
  div.className = "col";
  card.className = "card shadow-sm";
  cardImage.className = "bd-placeholder-img card-img-top";
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
  articleName.innerHTML = title;
  cardText.className = "card-text";
  cardText.appendChild(text);
  divBtnGroup.className = "d-flex justify-content-between align-items-center";
  divBtn.className = "btn-group";
  btn.type = "button";
  btn.className = "btn btn-sm btn-outline-secondary";
  btn.id = "" + id;
  btn.setAttribute("onclick", "handleBtnClick(this.id)");
  btn.appendChild(btntext);
  btndel.type = "button";
  btndel.className = "btn btn-sm btn-outline-secondary";
  btndel.id = "del" + id;
  btndel.setAttribute("onclick", "handleBtnDel(this.id)");
  btndel.appendChild(btndeltext);
  topicNode.className = "text-muted";
  topicNode.id = "topic" + id;
  topicNode.appendChild(topictext);
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
const renderBlogArticle = (title, body, hide) => {
  const heading = document.getElementById("title");
  const article = document.getElementById("article");
  const h1Text = document.createTextNode(title);
  heading.appendChild(h1Text);
  article.innerHTML = body;
};

const getArticles = () => {
  getServer("/api/blog", false, false);
};

const handleBtnClick = (id) => {
  const topicId = document.getElementById("topic" + id);
  topicUrl = encodeURIComponent(topicId.innerText);
  window.location.href = "/blog/" + id + "/" + topicUrl;
  // getServer("/api/blog/" + id + "/" + topicUrl, true, true);
};

const getArticle = () => {
  const pathVariables = window.location.pathname.split("/");
  getServer(
    "/api/blog/" + pathVariables[2] + "/" + pathVariables[3],
    true,
    false
  );
};

const handleBtnDel = (id) => {
  const urlId = id.replace("del", "");
  const url = "/admin/blog/delete/" + urlId;
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
