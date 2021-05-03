function sum_odd_5000() {
    var sum = 0;
    //your code here 
    for(i=0;i<=5000;i++){
        if (i%2 !== 0){
            sum+=i;
        }
    }
    return sum; 
}