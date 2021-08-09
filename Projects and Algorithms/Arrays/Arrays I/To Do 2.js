var myArr = [8,4,7,3];
var temp = null;

/* Given a numerical array, reverse the order of values, in-place. The reversed array should 
have the same length, with existing elements moved to other indices so that order of 
elements is reversed. Working 'in-place' means that you cannot use a second 
array – move values within the array that you are given. As always, do not use built-in 
array functions such as splice(). */

function reverseArr(arr) {
    for (var i = 0; i < Math.floor(arr.length/2); i++) {
        temp = arr[i];
        arr[i] =  arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
    console.log(arr);
}

/*Implement rotateArr(arr, shiftBy) that accepts array and offset. Shift arr's values to the right by that amount. 'Wrap-around' any values that shift off array's end to the other side, so that no data is lost. Operate in-place: given ([1,2,3],1), 
change the array to [3,1,2]. Don't use built-in functions.
Second: allow negative shiftBy (shift L, not R).
Third: minimize memory usage. With no new array, handle arrays/shiftBys in the millions.
Fourth: minimize the touches of each element.*/

function rotateArr(arr, shiftBy) {
    for (var i = 0; i < shiftBy; i++) {
        temp = arr[shiftBy+i];
        arr[shiftBy+i] = arr[i];
        arr[i] = temp;
    }
    console.log(arr);
}
rotateArr(myArr, 1);