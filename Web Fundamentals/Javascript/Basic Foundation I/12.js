function swap(arr) {
    var arrnew = arr,
    first = arr[0],
    last = arr[arr.length-1]
    
    arrnew[0] = last
    arrnew[arr.length-1] = first
    
    
    return arrnew; 
}