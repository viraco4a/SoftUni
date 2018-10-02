function MagicMatrix(matrix) {
    let sum = 0;
    let oldSum = 0;
    let isMagical = true;

    matrix[0].forEach((col, j) => {
        oldSum += +col;
    })

    matrix.forEach((row, i) => {
        row.forEach((col, j) => {
            sum += col;
        });
        if (sum !== oldSum){
            isMagical = false
        } else {
            oldSum = sum;
            sum = 0;
        }
    });

    for (let col = 0; col < matrix[0].length; col++) {
        matrix.forEach((row, i) => {
            sum += row[col]
        });
        if (sum !== oldSum){
            isMagical = false
        } else {
            oldSum = sum;
            sum = 0;
        }
    }
    console.log(isMagical);    
}

MagicMatrix([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
);

MagicMatrix([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]   
);

MagicMatrix([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]   
);