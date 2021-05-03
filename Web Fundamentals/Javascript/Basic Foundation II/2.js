function printlowreturnhigh(arr) {
    var high = -999999999;
    var low = 999999999;
    for (i=0; i<arr.length; i++) {
        if (arr[i]>high) {
            high = arr[i]
        }
        if (arr[i]<low) {
            low = arr[i]
        }
    }
    console.log(low);
    return(high);
} 