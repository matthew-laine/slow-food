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
        return this.classList.add(classToAdd);   
    }

    render() {
        return this.element;
    }

    canBeCalled(){
        return true;
    }
  }