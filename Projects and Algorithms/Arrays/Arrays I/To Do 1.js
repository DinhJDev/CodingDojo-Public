var myArr = [4,7,3];
var value = 8;

// Given an array and an additional value, insert this value at the beginning of the array. Do this without using any built-in array methods.
function pushFront(arr, val) {
    for (i = arr.length; i>0; i--) {
        arr[i] = arr[i-1];
    }
    myArr[0] = val;
    console.log(arr); // 8,4,7,3
}

// Given an array, remove and return the value at the beginning of the array. Do this without using any built-in array methods except pop().

function popFront(arr) {
    for (i = 0; i<arr.length-1; i++) {
        arr[i] = arr[i+1];
    }
    arr.pop();
    console.log(arr); // 4,7,3
}

// Given an array, index, and additional value, insert the value into array at given index. Do this without using built-in array methods. 
function insertAt(arr,ind,val) {
    for (i = arr.length; i>ind; i--) {
        arr[i] = arr[i-1];
    }
    arr[ind] = val;
    console.log(arr);
}