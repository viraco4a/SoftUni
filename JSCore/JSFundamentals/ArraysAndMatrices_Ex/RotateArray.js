function rotateArray(arr) {
    let count = arr.pop() % arr.length;
    
    for (let i = 0; i < count; i++) {
        let tmp = arr.pop();
        arr.unshift(tmp);
    }
    console.log(arr.join(' '));
}

rotateArray(['1', 
'2', 
'3', 
'4', 
'2']
);

rotateArray(['Banana', 
'Orange', 
'Coconut', 
'Apple', 
'15']
);

