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
    if (shiftBy >= 0) {
        for (var i = 0; i < shiftBy; i++) {
            temp = arr[arr.length-1]
            for (var j = arr.length-1; j > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
        console.log(arr);
    } else {
        for (var i = 0; i > shiftBy; i--) {
            temp = arr[0]
            for (var k = 1; k < arr.length; k++) {
                arr[k-1] = arr[k];
            }
            arr[arr.length-1] = temp;
        }
        console.log(arr);
    }
}

/*Alan is good at breaking secret codes. One method is to eliminate values that lie outside 
of a specific known range. Given arr and values min and max, retain only the array values between 
min and max. Work in-place: return the array you are given, with values in original order. No built-in array functions.*/

function filterRange(arr, min ,max) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < min || arr[i] > max) {
            for (var j = i+1; j < arr.length; j++) {
                arr[j-1] = arr[j];
            }
            arr.length--;
            i--;
        }
    }
    console.log(arr);
}

/*Replicate JavaScript's concat(). Create a standalone function that accepts two arrays. 
Return a new array containing the first array's elements, followed by the second array's 
elements. Do not alter the original arrays. Ex.: arrConcat( ['a','b'], [1,2] ) should 
return new array ['a','b',1,2].*/

function concat(arr1, arr2) {
    var resultArr = [0];
    if (arr1.length > 0) {
        for (i=0; i < arr1.length; i++) {
            resultArr[i] = arr1[i];
        }
    }
    if (arr2.length > 0) {
        for (j=0; j < arr2.length; j++) {
            resultArr[arr1.length + j] = arr2[j];
        }
    }
    console.log(resultArr);
}