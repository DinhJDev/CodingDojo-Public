function makeItBig(arr) {
    for (i=0; i<arr.length; i++) {
        if (arr[i] > 0) {
            arr[i] = "big"
        }
    }
    return arr
}