function sum_even_numbers(){
    var sum = 0;
    for (i=1; i<=1000; i++) {
        if(i%2 === 0){
            sum+=i;
        }
    }
    return sum; 
}