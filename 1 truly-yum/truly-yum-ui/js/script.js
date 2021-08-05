function validate() {
    let result = true;
    let name = document.getElementsByName("name")[0].value;
    if (name.length < 2 || name.length > 65) {
        alert("Name should have alteast 2 characters and maximum 65 characters.");
        result = false;
    } else {
        let price = document.getElementsByName("price")[0].value;
        if (isNaN (price)) {
            alert("Price should be a number.");
            result = false; 
        }
    }
    return result;
}