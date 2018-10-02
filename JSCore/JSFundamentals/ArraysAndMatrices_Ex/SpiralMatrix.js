function MagicMatrix(maxRows, maxCols) {
    let matrix = [];

    for (let row =  0; row < maxRows; row++) {
        matrix.push([]);
        for (let col = 0; col < maxCols; col++) {
            matrix[row].push(0);
        }
    }
    let element = 0;
    let col = -1;
    let row = 1;
    
    while (element < maxRows * maxCols) {
        row--;
        col++;
        while (col < maxCols && matrix[row][col] == 0) { // хоризонтално напред
            element++;
            matrix[row][col] = element;
            col++;
        }
        col--;
        row--;
        while (row >= 0 && matrix[row][col] == 0) {
            element++;
            matrix[row][col] = element;
            row--;
        }
        row++;
        col--;
        while (col >= 0 && matrix[row][col] == 0) {
            element++;
            matrix[row][col] = element;
            col--;
        }
        row++;
        col++;
        while (row < maxRows && matrix[row][col] == 0) {//
            element++;
            matrix[row][col] = element;
            row++;
        }
    }
    console.log(matrix.map(row => row.join(' ')).join('\n'));
}

MagicMatrix(5, 5);

MagicMatrix(3, 3);