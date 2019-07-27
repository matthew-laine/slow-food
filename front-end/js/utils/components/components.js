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

    createSingleItem(name, info, imageUrl) {
        const item = Html().create('div')
            .addClass('item-box')
            .addChild(
                Html().create('figure')
                    .addClass('item-figure')
                    // .addChild(
                    //     Html().create('img')
                    //         .addClass('item-figure__img')
                    //         .addAttribute('src', imageUrl)
                    // )
            )
            .addChild(
                Html().create('h1')
                    .addClass('item-name-header')
                    .text(name)
            )
            .addChild(
                Html().create('span')
                    .addClass('item-info-span')
                    .text(info)
            );
            console.log(item);
    }

    createItemGrid(itemCollection) {
        const itemGrid = Html().create('div')
            .addClass('item-grid');
        itemCollection.forEach(item => {
            // console.log(item);
            itemGrid.addChild(this.createSingleItem(item.name, item.categoryName, item.imageUrl));
        });
        return itemGrid;
    }

    createProductGridFromEndPoint(endPoint) {
        Api().getRequest(`http://localhost:8080/api/${endPoint}`, (responseCollection) => {
            // console.log(responseCollection);
            this.createItemGrid(responseCollection);
        });
    }

    renderWholePage() {
        const app = this.getAppContext();
        const grid = this.createProductGridFromEndPoint('products');
        console.log(grid);
        // app.replace(grid);
    }
}
