function calculateFees() {
    var weight = document.getElementById("weight").value;
    var distance = parseInt(document.getElementById("distance").value);
    var price = parseFloat(document.getElementById("price").value);
    var fees = 0.0;

    if (distance < 10) {
        fees += 0.5;
    } else if (distance < 20) {
        fees += 1;
    } else {
        fees += 2;
    }

    if (weight === "H") {
        fees += 2.0;
    } else if (weight === "M") {
        fees += 1.5;
    } else if (weight === "L") {
        fees += 0.5;
    }

    if (price < 10) {
        fees += 0.5;
    } else {
        fees += 1;
    }

    var total = fees + price;

    document.getElementById("result").innerHTML = "The current order's is considered " + weight + ".<br>" +
        "The current order will take " + distance + " minutes to deliver.<br>" +
        "The current order's total paid is £" + price + ", excluding delivery fees.<br><br>" +
        "Based on this, the order's delivery fees are: " + fees + "<br>" +
        "Therefore, the courier should ask the customer for: £" + total;
}
