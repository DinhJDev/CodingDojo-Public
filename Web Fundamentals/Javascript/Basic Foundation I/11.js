function maxMinAvg(arr) {
    var arrnew = [0,0,0]
    
    for(i=0;i<arr.length;i++){
        if (arr[i] > arrnew[0]) {
            arrnew[0]=arr[i]
        }
    }

    for(i=0;i<arr.length;i++){
        if (arr[i] < arrnew[1]) {
            arrnew[1]=arr[i]
        }
    }
    
    for(i=0;i<arr.length;i++){
        arrnew[2] += arr[i]
    }
    
    arrnew[2] = arrnew[2]/arr.length;
    
    return arrnew; 
}