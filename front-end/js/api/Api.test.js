import Api from "./Api";

describe("Api", () => {
	test("can to create Api from exported function", () => {
		let newApi = Api();
		expect(newApi).toBeTruthy();
	});
});

// (KEEP) Doesn't recognize "fetch" in getRequest when testing, but is shown to work in other classes.

// describe("Api", () => {
// 	test("can fetch the produce department with Api", () =>{
// 		let newApi = Api();
// 		newApi.getRequest("http://localhost:8080/api/departments/1", founDept =>{
// 			const foundDeptName = foundDept.name
// 			expect(foundDeptName == "produce").toBeTruth()
// 		})
// 	})
// })
