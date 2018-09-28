function squareOfStars(n = 5){
    function printStars(count){
        console.log('*' + ' *'.repeat(count - 1));
    }
    
    for (let i = 1; i <= n; i++) {
        printStars(n);
    }
}

squareOfStars();