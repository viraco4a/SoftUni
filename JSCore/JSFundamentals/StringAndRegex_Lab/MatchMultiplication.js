function matchMultiplication(text){
    let pattern = /(-?\d*)\s*\*\s*(-?\d+(\.\d+)?)/gm;
    text = text.replace(pattern, (match, num1, num2) => +num1 * +num2)
    console.log(text);    
}

matchMultiplication('My bill: 2*2.50 (beer); 2* 1.20 (kepab); -2  * 0.5 (deposit).'
);

matchMultiplication('My bill is: 4 * 2.50 (beer); 12* 1.50 (kepab); 1  *4.50 (salad); 2  * -0.5 (deposit).');