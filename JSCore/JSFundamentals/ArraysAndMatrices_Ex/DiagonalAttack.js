function diagonalAttack(arr){
    let matrix = arr.map(s => s
                    .split(' ')
                    .map(s => +s));

    let first = 0;
    let second = 0;

    matrix.forEach((item, index) => {
        first += +item
        .filter((inItem, inIndex) => {
            return index === inIndex;
        });
    });

    matrix.forEach((item, i) => {
        second += +item
        .filter((inItem, j) => {
            return j === matrix.length - i - 1;
        });
    });
    
    if (first === second){
        changeMatrix(matrix, first);
    } else {
        print(matrix);
    }

    function print(matrix){
        matrix.forEach((item, i) => {
            console.log(item.join(' '));
        });
    }

    function changeMatrix(matrix, sum) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                if (row != col && col != matrix[row].length - row - 1) {
                    matrix[row][col] = sum;
                }                
            }            
        }
        print(matrix);
    }

}

diagonalAttack(['5 3 12 3 1',
                '11 4 23 2 5',
                '101 12 3 21 10',
                '1 4 5 2 2',
                '5 22 33 11 1']
);

diagonalAttack(['1 1 1',
                '1 1 1',
                '1 1 0']
);