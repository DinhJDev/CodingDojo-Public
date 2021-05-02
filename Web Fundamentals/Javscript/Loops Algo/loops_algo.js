function printodd() {
    for (var i = 1; i <= 20; i++) {
        if (i % 2 !== 0){
            console.log(i)
        }
    }
}
printodd();

function sumnum() {
    var sum = 0;

    for (var i = 1; i <= 5; i++) {
        console.log("Num: " + i)
        sum += i;
        console.log("Sum: " + sum)
    }
}
sumnum();