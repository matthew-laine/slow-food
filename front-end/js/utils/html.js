export default function () {
    return new Html();
  }

  class Html{
    create(elementType){
        if(!elementType){
          throw new Error('Must Pass Valid Html Element');
        }
        const newElement = document.createElement(elementType);
        if(newElement instanceof HTMLUnknownElement) {
          throw new Error('Must Pass Valid Html Element');
        }
        this.element = newElement;
        return this;
    }

    addClass(classToAdd){
        this.element.classList.add(classToAdd);
        return this;
    }

    render() {
        return this.element;
    }
  }