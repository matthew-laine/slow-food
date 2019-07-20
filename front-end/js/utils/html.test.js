import Html from './html.js';

describe("create", () => {

    describe("should return new html object", () => {

        test("Html should be an object", () => {
            expect(Html().create('div')).toBeInstanceOf(HTMLDivElement);
        });

        test("Html containing p element should be an object", () =>{
            const newPElement = Html().create('p')
            console.log(newPElement)
            expect(newPElement).toBeInstanceOf(HTMLParagraphElement);
        });

    });

});