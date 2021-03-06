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

    createMenuDiv() {
        return Html().create('div')
            .addClass('menu')
            .stopHover(() =>{
                this.hideMenu()
            });
    }

    getWrapperDiv() {
        return Html().select('.wrapper');
    }

    getContainerDiv() {
        return Html().select('.container');
    }

    getMenuDiv() {
        return Html().select('.menu');
    }
    
    makeSingleProductPage(name, price, categoryName, imageUrl) {
        return Html().create('article')
        .addClass('product-article')
        .addChild(
            Html().create('h1')
            .addClass('single-item-name')
            // .text(this.capitalizeFirstLetter(name))
            .text(this.capitalizeEachWord(name))
            )
            .addChild(
                Html().create('h2')
                    .addClass('single-item-category')
                    .text(this.capitalizeEachWord(categoryName))
            )
            .addChild(
                Html().create('figure')
                .addClass('single-item-figure')
                    .addChild(
                        Html().create('img')
                            .addClass('single-item-figure__img')
                            .addAttribute('src', imageUrl)
                    )
            )
            .addChild(
                Html().create('h2')
                    .addClass('single-item-price')
                    .text(price)
            )
    }

    renderSingleProductPage(id) {
        const wrapper = this.getWrapperDiv();
        const container = this.createContainerDiv();
        const header = this.getSiteHeader();
        const menu = this.getMenuDiv();
        Api().getRequest(`http://localhost:8080/api/products/${id}`, (product) => {
            container.addChild(this.makeSingleProductPage(product.name, product.price, product.categoryName, product.imageUrl))
        });
        wrapper.replace(header);
        wrapper.addChild(menu);
        wrapper.addChild(container);
        return container;
    }

    createSingleItem(name, info, imageUrl, id) {
        const item = Html().create('div')
            .addClass('item-box')
            .click(event => {
                event.preventDefault();
                this.renderSingleProductPage(id);
            })
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
                    .text(this.capitalizeEachWord(name))
            )
            .addChild(
                Html().create('span')
                    .addClass('item-info-span')
                    .text(this.capitalizeEachWord(info))
            );
        return item;
    }

    createItemGrid(itemCollection) {
        const itemGrid = Html().create('div')
            .addClass('item-grid');
        itemCollection.forEach(item => {
            const itemToAdd = this.createSingleItem(item.name, item.categoryName, item.imageUrl, item.id);
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
                .text(this.capitalizeEachWord(requestedData))
                .click(event => {
                    event.preventDefault();
                    this.showMenu(requestedData);
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

    getSiteHeader() {
        return Html().select('.site-header');
    }

    createMenuList(requestedData) {
        const menuList = Html().create('ul')
            .addClass('menu-list');
        Api().getRequest(`http://localhost:8080/api/${requestedData}`, (response) => {
            let directToRelatedProductsPage = false;
            if (response.categories) {
                requestedData = 'categories';
                response = response.categories;
            }
            if (response.products) {
                response = response.products;
                directToRelatedProductsPage = true;
            }
            if(directToRelatedProductsPage) {
                this.hideMenu()
                this.renderProductsPage(response)
            }
            response.forEach(item => {
                let itemEndPoint = requestedData + '/' + item.id;
                menuList.addChild(
                    Html().create('li')
                        .addClass('menu-list__item')
                        .addChild(
                            Html().create('button')
                                .addClass('menu-list__item-button')
                                .text(this.capitalizeEachWord(item.name))
                                .click(event => {
                                    event.preventDefault()
                                        this.showMenu(itemEndPoint);
                                })
                        )
                )
            })
        });
        return menuList;
    }

    showMenu(requestedData) {
        if(requestedData === 'products') {
            this.renderAllProductsPage();
        }
        else {
            const menu = this.getMenuDiv();
            const menuList = this.createMenuList(requestedData);
            menu.replace(menuList);
        }
    }

    hideMenu() {
        const menu = this.getMenuDiv();
        menu.replace();
    }

    renderProductsPage(productsCollection) {
        const wrapper = this.getWrapperDiv();
        const container = this.createContainerDiv();
        const header = this.getSiteHeader();
        const menu = this.getMenuDiv();
        const productGrid = this.createItemGrid(productsCollection);
        container.addChild(productGrid);
        wrapper.replace(header);
        wrapper.addChild(menu);
        wrapper.addChild(container);
        return container;
    }

    renderAllProductsPage() {
        const wrapper = this.getWrapperDiv();
        const container = this.itemGridToContainer('products');
        const header = this.getSiteHeader();
        const menu = this.getMenuDiv();
        wrapper.replace(header);
        wrapper.addChild(menu);
        wrapper.addChild(container);
        return container;
    }

    renderHomePage() {
        const app = this.getAppContext();
        const wrapper = this.createWrapperDiv();
        const container = this.createContainerDiv();
        const header = this.createSiteHeader();
        const menu = this.createMenuDiv();
        wrapper.addChild(header);
        wrapper.addChild(container);
        wrapper.addChild(menu);
        app.replace(wrapper);
    }

    capitalizeEachWord(str){
        return str.split(' ')
        .map((s) => s.charAt(0).toUpperCase() + s.substring(1))
        .join(' ');
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
