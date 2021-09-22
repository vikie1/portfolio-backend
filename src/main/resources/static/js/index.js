import {home} from "/modules/home.js"
const routes = {
'/': home
}
const render = () => {
    document.getElementById("content").innerHTML = home();
}
window.onload=render();