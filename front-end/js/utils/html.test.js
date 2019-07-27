import Html from "./html.js";
const jsdom = require("jsdom");
const { JSDOM } = jsdom;

describe("create", () => {
  describe("should return new html object", () => {
    test("Html should be an object", () => {
      const newHtmlDivObject = Html().create("div");
      expect(typeof newHtmlDivObject).toBe("object");
    });

    test("Html containing p element should be an object", () => {
      const newHtmlPObject = Html().create("p");
      expect(typeof newHtmlPObject).toBe("object");
    });
  });

  describe("render", () => {
    test("rendering created div type should be div", () => {
      const newDiv = Html().create("div");
      expect(newDiv.render()).toBeInstanceOf(HTMLDivElement);
    });

    test("rendering created p type should be p", () => {
      const newDiv = Html().create("p");
      expect(newDiv.render()).toBeInstanceOf(HTMLParagraphElement);
    });
  });

  describe("should return appropriate errors", () => {
    test("Passing null element should throw error", () => {
      expect(() => {
        Html().create();
      }).toThrow("Must Pass Valid Html Element");
    });

    test("Passing lolnotreal element shoudl throw error", () => {
      expect(() => {
        Html().create("lolnotreal");
      }).toThrow("Must Pass Valid Html Element");
    });
  });
});

describe("addClass", () => {
  describe("should add class to element", () => {
    test("should add class test to element", () => {
      const underTest = Html().create("div");
      underTest.addClass("test");
      expect(underTest.render().classList.contains("test")).toBeTruthy();
    });

    test("should throw an error when adding an existing class to div element", () => {
      const underTest = Html().create("div");
      underTest.addClass("test");
      expect(() => {
        underTest.addClass("test");
      }).toThrow("Class already exists on element.");
    });
  });
});

describe("addChild", () => {
  test("should add child to element", () => {
    const underTest = Html().create("div");
    const childToAdd = Html().create("a");
    underTest.addChild(childToAdd);
    expect(underTest.render().querySelector("a")).toEqual(childToAdd.render());
  });
});

describe("replace", () => {
  test("should replace inner html element", () => {
      const underTest = Html().create("div");
      const firstChildToAdd = Html().create("div");
      const childToReplace = Html().create("p");
      underTest.addChild(firstChildToAdd);
      underTest.replace(childToReplace);
      expect(underTest.render().querySelector("p")).toEqual(childToReplace.render());
      expect(underTest.render().querySelectorAll('div').length).toEqual(0);
  });
});

describe("rmChildrenByClass", () =>{
    test("should remove only child elements with classlist containing remove", () =>{
        const underTest = Html().create("div");
        const firstChildToAdd = Html().create("div").addClass("remove");
        const secondChildToAdd = Html().create("div").addClass("keep");
        const thirdChildToAdd = Html().create("div").addClass("remove");
        underTest.addChild(firstChildToAdd);
        underTest.addChild(secondChildToAdd);
        underTest.addChild(thirdChildToAdd);
        underTest.rmChildrenByClass('remove')
        console.log(underTest.render().querySelector("div"))
        expect(underTest.render().querySelector("div")).toEqual(secondChildToAdd.render());
    });
});

describe("addAttribute", () => {
  test("should add an href attribute to an a element", () => {
    const underTest = Html().create("a");
    underTest.addAttribute("href", "http://www.google.com");
    expect(underTest.element.getAttribute("href")).toBe("http://www.google.com");
  });

  test("should not add multiple href to an element", () =>{
    const underTest = Html().create("a");
    underTest.addAttribute("href", "http://www.google.com");
    underTest.addAttribute("href", "http://www.notgoogle.com");
    expect(underTest.element.getAttribute("href")).toBe("http://www.google.com");
  });
});

describe("rmClass", () => {
  test("should remove class foo", () => {
    const underTest = Html().create("a");
    underTest.addClass("foo");
    underTest.rmClass("foo");
    expect(underTest.render().classList.contains("foo")).toBeFalsy();
  });

  test("should do nothing when removing bar which isn't in the classlist", ()=>{
    const underTest = Html().create("a").addClass("foo");
    const underTestWithoutBar = underTest.rmClass("bar");
    expect(underTestWithoutBar).toEqual(underTest);
  });
});

describe("text", () => {
  test("Should return text", () => {
      const text = Html().create("p");
      text.render().textContent = "This is text";
      expect(text.text()).toBe("This is text");
  });
  test("Should add text to element", () => {
      const text = "add me to the element";
      const element = Html().create('p');
      element.text(text);
      expect(element.text()).toBe(text);
  });
});

describe("select", () => {
  test("should select h1 element", () => {

      const dom = new JSDOM(`<div>
        <h1>JSDOM mocking</h1>
      </div>`);

      const select = jest.fn(Html().select('h1').text());
      select.mockReturnValue('JSDOM mocking');
      expect(select()).toBe(dom.window.document.querySelector('h1').textContent);

  });
});

// describe("html", () => {
//   const html = Html().create("div");
//   html.html('div')
// });