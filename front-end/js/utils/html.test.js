import Html from './html.js';

describe("create", () => {

    describe("should return new html object", () => {

        test("Html should be an object", () => {
            expect(Html().create('div')).toBeInstanceOf(HTMLDivElement);
        });

        test("Html containing p element should be an object", () =>{
            const newPElement = Html().create('p');
            expect(newPElement).toBeInstanceOf(HTMLParagraphElement);
        });

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

describe("render", () =>{
    test('newDiv able to call canBeCalled in Html class', () =>{
        const newDiv = Html().create('div')
        expect(newDiv.render().canBeCalled()).toBeTruthy();
    })
})

// describe("addClass", () => {

//     describe("should add class to element", () => {

//         test("should add class test to element", () => {
//             const underTest = Html().create('div');
//             underTest.addClass('test');
//             expect(underTest.classList.contains('test')).toBeTruthy();
//         })
//     })
// })