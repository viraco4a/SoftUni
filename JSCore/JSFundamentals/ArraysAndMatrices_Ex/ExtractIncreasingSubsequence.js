function increasingSubsequence(arr) {
    let result = arr.filter((x, i) => x >= Math.max(...arr.slice(0, i + 1)));
    result.forEach(s => {
        console.log(s);        
    })
}

increasingSubsequence([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]    
);

increasingSubsequence([1, 
    2, 
    3,
    4]    
);

increasingSubsequence([20, 
    3, 
    2, 
    15,
    6, 
    1]
);

