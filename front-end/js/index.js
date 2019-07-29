import Api from "./api/Api";
import Html from "./utils/html";
import Components from "./utils/components/components";

const api = new Api();
const html = new Html();

const components = new Components();

Components().renderHomePage();

// Components().createSingleItem('foo', 'bar', 'http://lorempixel.com/400/200');


// const menuButton = Html().select(".site-nav__menu-button")
// const navUl = Html().select(".site-nav__list")
// console.log(menuButton.render())
// menuButton.click(event =>{
//     event.preventDefault()
//     navUl.toggleClass("hidden")
// })