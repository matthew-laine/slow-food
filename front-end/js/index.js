import Api from "./api/Api";

const testApi = new Api();

testApi.getRequest(`http://localhost:8080/api/departments/1`, responseDept => {
    console.log(responseDept)
})