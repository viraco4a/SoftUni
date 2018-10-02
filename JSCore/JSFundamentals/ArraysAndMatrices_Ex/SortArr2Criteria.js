function sortByTwo(arr) {
    let array = arr
            .map(s => s)
            .sort()
            .sort((a, b) => a.length - b.length);

    for (let item of array) {
        console.log(item);        
    }
}

sortByTwo(['alpha', 
'beta', 
'gamma']
);

sortByTwo(['Isacc', 
'Theodor', 
'Jack', 
'Harrison', 
'George'] 
);

sortByTwo(['test', 
'Deny', 
'omen', 
'Default']
);

