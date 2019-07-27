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

    renderWholePage() {
        const app = this.getAppContext();
        const wrapper = this.createWrapperDiv();
        const container = this.itemGridToContainer('products');
        wrapper.addChild(container);
        app.addChild(wrapper);
    }

    capitalizeFirstLetter(str){
        return str.charAt(0).toUpperCase() + str.slice(1)
    }
}
