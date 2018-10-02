function addAndRemoveEls(arr) {
    let array = [];
    for (let i = 1; i <= arr.length; i++) {
        if (arr[i - 1] === 'add'){
            array.push(i);
        } else {
            array.pop();
        }
    }
    if (array.length == 0){
        console.log("Empty");        
    } else {
        array.forEach(s => {
            console.log(s);
        })
    }
}

addAndRemoveEls(['add', 
'add', 
'add', 
'add']
);

addAndRemoveEls(['add', 
'add', 
'remove', 
'add', 
'add']
);

addAndRemoveEls(['1', 
'2',
'3', 
'4', 
'5', 
'6']
);