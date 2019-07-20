export default function () {
    return new Html();
  }

  class Html{
      create(elementType){
        const newElement = document.createElement(elementType);
        return newElement;
      }
  }