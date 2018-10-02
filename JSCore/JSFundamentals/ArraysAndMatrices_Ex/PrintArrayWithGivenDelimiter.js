function printArrDelimiter(arr) {
    let delimeter = arr[arr.length - 1];
    arr.pop();
    return arr.join(delimeter, arr);
}

console.log(printArrDelimiter(['One', 
'Two', 
'Three', 
'Four', 
'Five', 
'-']
));