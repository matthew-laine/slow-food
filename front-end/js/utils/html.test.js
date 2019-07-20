import Html from './html.js';

describe("create", () => {

    describe("should return new html object", () => {

        test("Html should be an object", () => {
            const newHtmlDivObject = Html().create('div');
            expect(typeof newHtmlDivObject).toBe('object');
        });

        test("Html containing p element should be an object", () =>{
            const newHtmlPObject = Html().create('p');
            expect(typeof newHtmlPObject).toBe('object');
        });
    });

    describe("render", () =>{
    
        test('rendering created div type should be div', () =>{
            const newDiv = Html().create('div')
            expect(newDiv.render()).toBeInstanceOf(HTMLDivElement);
        });
    
        test('rendering created p type should be p', () =>{
            const newDiv = Html().create('p')
            expect(newDiv.render()).toBeInstanceOf(HTMLParagraphElement);
        });
    });

    describe("should return appropriate errors", () => {

        test("Passing null element should throw error", () => {
            expect(() => {
                Html().create();
            }).toThrow('Must Pass Valid Html Element');
    
        });
        
        test("Passing lolnotreal element shoudl throw error", () => {
            expect(() => {
                Html().create('lolnotreal');
            }).toThrow('Must Pass Valid Html Element');
        });
    }); 
});



describe("addClass", () => {

    describe("should add class to element", () => {

        test("should add class test to element", () => {
            const underTest = Html().create('div');
            underTest.addClass('test');
            expect(underTest.render().classList.contains('test')).toBeTruthy();
        });
        
        test("should throw an error when adding an existing class to div element", ()=>{
            const underTest = Html().create('div');
            underTest.addClass('test');
            expect(() => {
                underTest.addClass('test');
            }).toThrow("Class already exists on element.");
        });
    });
});

describe("addChild", () => {

    test("should add child to element", () => {
        const underTest = Html().create('div');
        const childToAdd = Html().create('a');
        underTest.addChild(childToAdd);
        expect(underTest.render().querySelector('a')).toEqual(childToAdd.render());
    });

    test('should throw error when adding a unknown element');
        const underTest = Html().create('div');
        const childToAdd = document.create('applesauce')
        expect(() => {
            underTest.addChild(childToAdd)
        }).toThrow("Cannot append invalid HTML Element to parent")
});