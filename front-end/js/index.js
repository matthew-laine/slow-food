import Api from "./api/Api";
import Html from "./utils/html";

const testApi = new Api();
const html = new Html();

testApi.getRequest(`http://localhost:8080/api/departments/1`, responseDept => {
    console.log(responseDept)
})


const menuButton = Html().select(".site-nav__menu-button")
const navUl = Html().select(".site-nav__list")
console.log(menuButton.render())
menuButton.click(event =>{
    event.preventDefault()
    navUl.toggleClass("hidden")
})