import Api from "./api/Api";
import Html from "./utils/html";

const testApi = new Api();
const html = new Html();

testApi.getRequest(`http://localhost:8080/api/departments/1`, responseDept => {
    console.log(responseDept)
})

const menuButton = Html().select("nav-list__menu-button").click(event =>{
    event.preventDefault()
    const navUl = Html().select("site-nav__list").toggleClass()
})