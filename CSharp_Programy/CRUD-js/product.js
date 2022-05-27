var URL = "https://localhost:44330/api/product"

function getProduct(productId) {
    let req = new XMLHttpRequest();
    req.onreadystatechange = function() {
        if(this.readyState === XMLHttpRequest.DONE && this.status===200) {
            setInput(JSON.parse(this.response));
            displayDetail();
        }
    }
    req.open("GET", URL + "/" + productId);
    req.send();
}

function displayDetail() {
    console.log("Not implemented!");
}

function setInput(response) {
    console.log(response);
}