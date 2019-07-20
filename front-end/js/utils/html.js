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
        if(this.element.classList.contains(classToAdd)) {
          throw new Error("Class already exists on element.");
        }
        this.element.classList.add(classToAdd);
        return this;
    }

    addChild(childToAdd){
        this.element.append(childToAdd.render());
        return this;
    }

    replace(replacementChild){
        this.innerHTML = '';
        this.addChild(replacementChild);

        return this;
    }

    render() {
        return this.element;
    }
  }