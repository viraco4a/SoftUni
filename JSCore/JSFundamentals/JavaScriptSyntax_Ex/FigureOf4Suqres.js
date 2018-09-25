function figureOf4Squares(n){
    let rows = n;
    if (n % 2 == 0){
        rows--;
    }
    let size = n - 2;
    let cols = 3 + 2 * size;

    for (let row = 1; row <= rows; row++) {
        let line = '';
        for (let col = 1; col <= cols; col++) {
            if ((col == 1 || col == cols || col == 1 + parseInt(cols / 2))
            && (row == 1 || row == rows || row == 1 + parseInt(rows / 2))){
                line += '+';                
            } else  if (row == 1 || row == rows || row == 1 + parseInt(rows / 2)){
                line += '-';                
            } else  if (col == 1 || col == cols || col == 1 + parseInt(cols / 2)){
                line += '|';                
            } else {
                line += ' ';
            }
        }
        console.log(line);
    }
}

figureOf4Squares(4)