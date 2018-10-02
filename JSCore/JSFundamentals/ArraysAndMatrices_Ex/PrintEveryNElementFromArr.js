function printEveryNElement(arr) {
    let step = +arr.pop();
    for (let i = 0; i < arr.length; i+=step) {
        console.log(arr[i]);
    }
}

console.log(printEveryNElement(['5', 
'20', 
'31', 
'4', 
'20', 
'2']
));

console.log(printEveryNElement(['dsa',
'asd', 
'test', 
'tset', 
'2']
));

console.log(printEveryNElement(['1', 
'2',
'3', 
'4', 
'5', 
'6']
));