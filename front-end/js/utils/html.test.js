import Html from './html.js';

describe("create", () => {

    describe("should return new html object", () => {

        test("Html should be an object", () => {
            expect(typeof Html().create('div')).toBe('object');
        });

    });

});