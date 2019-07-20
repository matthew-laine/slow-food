export default function () {
    return new Html();
  }

  class Html{
      create(){
        const newDiv = document.createElement('div');
        return newDiv;
      }
  }