function findMax(arr) {
    var max = -1000000;
    for (i=0;i<arr.length;i++){
        if (arr[i] > max){
            max = arr[i];
        }
    }
    return max; 
}