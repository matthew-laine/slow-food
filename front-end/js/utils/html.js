export default function () {
    return new Html();
  }

  class Html{
    create(elementType){
        if(!elementType){
            throw new Error('Must Pass Valid Html Element');
        }
        const newElement = document.createElement(elementType);
        return newElement;
      }
  }