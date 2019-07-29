export default function () {
  return new Html();
}

class Html{

  addAttribute(attributeToSet, attributeValue) {
    this.element.setAttribute(attributeToSet, attributeValue);

    return this;
  }
    
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
    
  replace(replacementChild){
    this.element.innerHTML = '';
    this.addChild(replacementChild);
      
    return this;
  }
    
   click(callback) {
    this.element.addEventListener("click", callback);

    return this;
  }

  create(elementType) {
    if (!elementType) {
      throw new Error("Must Pass Valid Html Element");
    }
    const newElement = document.createElement(elementType);
    if (newElement instanceof HTMLUnknownElement) {
      throw new Error("Must Pass Valid Html Element");
    }
    this.element = newElement;
    return this;
  }

  html(contentToAdd) {
    if (contentToAdd === undefined) {
      return this.element.innerHTML;
    }
    this.element.innerHTML = contentToAdd;

    return this;
  }
  
  render() {
    return this.element;
  }
  
  replace(replacementChild) {
    this.element.innerHTML = "";
    if(!replacementChild) {
      return this;
    }
    this.addChild(replacementChild);

    return this;
  }

  rmChildrenByClass(className) {
    let childrenWithClassName = this.element.getElementsByClassName(className);
    while (childrenWithClassName.length > 0) {
      this.element.removeChild(childrenWithClassName[0]);
      childrenWithClassName = this.element.getElementsByClassName(className);
    }
    return this;
  }

  rmClass(className) {
    this.element.classList.remove(className);
    return this;
  }

  select(query) {
    const selection = document.querySelectorAll(query);

    if (selection.length === 1) {
      this.element = selection[0];
    } else {
      this.element = selection;
    }
    return this;
  }

  text(textToAdd) {
    if (textToAdd === undefined) {
      return this.element.textContent;
    }
    this.element.textContent = textToAdd;
    return this;
  }

  toggleClass(classToToggle) {
    if(this.element.classList.contains(classToToggle)) {
      this.rmClass(classToToggle);
    } else {
      this.addClass(classToToggle);
    }
  }
}