export default function () {
    return new Html();
  }

  class Html{
    
    addChild(childToAdd){
      this.element.append(childToAdd.render());
      return this;
    }
    
    addClass(classToAdd){
      if(this.element.classList.contains(classToAdd)) {
        throw new Error("Class already exists on element.");
      }
      this.element.classList.add(classToAdd);
      return this;
    }
    
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
    
    replace(replacementChild){
      this.element.innerHTML = '';
      this.addChild(replacementChild);
      
      return this;
    }
    
    render() {
      return this.element;
    }

    rmChildrenByClass(className){

      let childrenWithClassName = this.element.getElementsByClassName(className);
      while(childrenWithClassName.length>0){
        this.element.removeChild(childrenWithClassName[0]);
        childrenWithClassName = this.element.getElementsByClassName(className);
      }
      return this;
    }

    addAttribute(attributeType, attributeName){
      if (!this.element.getAttribute(attributeType)) {
        this.element.setAttribute(attributeType, attributeName);
      }
      return this;
    }
  }