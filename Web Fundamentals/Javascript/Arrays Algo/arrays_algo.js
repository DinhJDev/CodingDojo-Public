var testArr = [6,3,5,1,2,4]

var sum = 0;

for (i=0; i<testArr.length; i++) {
    sum+=testArr[i];
    console.log("Num " + testArr[i] + ", Sum " + sum);
}

var newArr = [];

for (i=0; i<testArr.length; i++) {
    newArr.push(testArr[i] * i);
}

console.log(newArr);