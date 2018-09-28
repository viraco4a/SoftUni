function printTriangle(n){
    function printStars(count) {
        console.log("*".repeat(count));
    }

    for (let i = 0; i <= n; i++) {
        printStars(i); 
    }
    
    for (let i = n - 1; i > 0; i--) {
        printStars(i);        
    }
}

printTriangle(10);