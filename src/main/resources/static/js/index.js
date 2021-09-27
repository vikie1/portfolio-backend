import {home} from "/modules/home.jsx"
const routes = {
'/': home
}
const render = () => {
    document.getElementById("content").innerHTML = document.getElementById('stupid');
}
window.onload=render();