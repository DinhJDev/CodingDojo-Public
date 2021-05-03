function printOneReturn(arr) {
    for (i=0; i<arr.length; i++) {
        if (arr[i]%2 !== 0) {
            console.log(arr[i])
            break
        }
    }

    return arr[arr.length-2]
}