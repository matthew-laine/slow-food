import Html from "../html";
import api from "../../api/Api";
import Components from "../../../../../album-collection/front-end/js/utils/Components/Components";

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
        return Html().create('div')
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
                    .text(name)
            )
            .addChild(
                Html().create('span')
                    .addClass('item-info-span')
                    .text(info)
            )
    }

    createItemGrid(itemCollection) {
        
    }

}
