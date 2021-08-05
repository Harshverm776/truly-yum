function validateForm() {
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var date = document.getElementById("dateOfLaunch").value;
    var active = document.getElementById("active").checked;
    var category = document.getElementById("category").value;
    var stat = 0;


    if (title == "") {
        document.getElementById("status1").innerHTML = "Item Name is required";
        stat += 1;
    } else {
        document.getElementById("status1").innerHTML = "";
    }

    if (title.length > 200) {
        document.getElementById("status2").innerHTML = "Item Name cannot exceed 200 characters";
        stat += 1;
    } else {
        document.getElementById("status2").innerHTML = "";
    }

    if (price == "") {
        document.getElementById("status3").innerHTML = "Price is required";
        stat += 1;
    } else {
        document.getElementById("status3").innerHTML = "";
    }

    var pregex = RegExp('^[0-9]*$');
    if (pregex.test(price) == false) {
        document.getElementById("status4").innerHTML = "Price can only contain numbers"
        stat += 1;
    } else {
        document.getElementById("status4").innerHTML = "";
    }

    var dregex = RegExp('^[\\d]{2}[/][\\d]{2}[/][\\d]{4}$');
    if (dregex.test(date) == false) {
        document.getElementById("status5").innerHTML = "Incorrect date format";
        stat += 1;
    } else {
        document.getElementById("status5").innerHTML = "";
    }
    console.log(active);
    if (active == false) {
        document.getElementById("status7").innerHTML = "Select in stock status";
        stat += 1;
    } else {
        document.getElementById("status7").innerHTML = "";
    }

    if (category == '') {
        document.getElementById("status6").innerHTML = "Select at least one category";
        stat += 1;

    } else {
        document.getElementById("status6").innerHTML = "";
    }

    if (stat > 0)
        return false;
    return true;

}