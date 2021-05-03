function greaterY(arr, Y) {
    var count = 0;
    
    for (i=0; i < arr.length; i++){
        if (arr[i] > Y){
            count++;
        }
    }
    
    return count; 
}