import Html from "../html";
import Api from "../../api/Api";

export default () => new Components();

class Components {

    getAppContext() {
        return Html().select('#app');
    }

    createWrapperDiv() {
        return Html().create('div')
            .addClass('wrapper');
    }

    createContainerDiv() {
        return Html().create('div')
            .addClass('container');
    }

    createSingleItem(name, info, imageUrl) {
        const item = Html().create('div')
            .addClass('item-box')
            .addChild(
                Html().create('figure')
                    .addClass('item-figure')
                    .addChild(
                        Html().create('img')
                            .addClass('item-figure__img')
                            .addAttribute('src', imageUrl)
                    )
            )
            .addChild(
                Html().create('h1')
                    .addClass('item-name-header')
                    .text(this.capitalizeFirstLetter(name))
            )
            .addChild(
                Html().create('span')
                    .addClass('item-info-span')
                    .text(this.capitalizeFirstLetter(info))
            );
        return item;
    }

    createItemGrid(itemCollection) {
        const itemGrid = Html().create('div')
            .addClass('item-grid');
        itemCollection.forEach(item => {
            const itemToAdd = this.createSingleItem(item.name, item.categoryName, item.imageUrl);
            itemGrid.addChild(itemToAdd);
        });
        return itemGrid;
    }

    itemGridToContainer(endPoint) {
        let container = this.createContainerDiv();
        Api().getRequest(`http://localhost:8080/api/${endPoint}`, (responseCollection) => {
            container.addChild(this.createItemGrid(responseCollection));
        });
        return container;
    }

    createSiteTitleHeader() {
        return Html().create('div')
            .addClass('site-title')
            .addChild(Html().create('h1')
                .addClass('site-title__header-title')
                .text('Slow Food')
            )
            .addChild(Html().create('h2')
                .addClass('site-title__header-subtitle')
                .text('Definitely not fast food'));
    }

    createSiteNavListItem(requestedData) {
        return Html().create('li')
            .addClass('site-nav__list-item')
            .addChild(Html().create('button')
                .addClass('site-nav__list-item-button')
                .text(this.capitalizeFirstLetter(requestedData))
                .click(event => {
                    event.preventDefault();
                    this.toggleMenu(requestedData);
                }));
    }

    createSiteNavList() {
        const entities = ['departments', 'categories', 'products'];
        const siteNavList = Html().create('ul')
            .addClass('site-nav__list');
        entities.forEach((entity) => {
            let itemToAdd = this.createSiteNavListItem(entity);
            siteNavList.addChild(itemToAdd);
        });
        return siteNavList;
    }

    createVisibleSiteNav() {
        const siteNav = Html().create('nav')
            .addClass('site-nav')
            .addChild(
                this.createSiteNavList()
            );
        return siteNav
    }

    createSiteHeader() {
        const header = Html().create('header')
            .addClass('site-header')
            .addChild(
                this.createSiteTitleHeader()
            )
            .addChild(
                this.createVisibleSiteNav()
            );
        return header;
    }

    toggleMenu(requestedData) {

    }

    renderWholePage() {
        const app = this.getAppContext();
        const wrapper = this.createWrapperDiv();
        const container = this.itemGridToContainer('products');
        const header = this.createSiteHeader();
        wrapper.addChild(header);
        wrapper.addChild(container);
        app.addChild(wrapper);
    }

    capitalizeFirstLetter(str){
        if(str) {
            return str.charAt(0).toUpperCase() + str.slice(1);
        }
        else{
            return "";
        }
    }
}
