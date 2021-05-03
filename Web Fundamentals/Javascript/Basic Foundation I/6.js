function findAvg(arr) {
    var avg = 0;
    
    for (i=0;i<arr.length;i++){
        avg += arr[i];
    }
    avg = avg/arr.length
    
    return avg; 
}