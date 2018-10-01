function equalNeighbours(matrix) {
    let neighbours = 0;
    for (let row = 0; row < matrix.length - 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] === matrix[row + 1][col]){
                neighbours++;
            }
            if (matrix[row][col] === matrix[row][col + 1]) {
                neighbours++;
            }
        }        
    }
    for (let i = 0; i < matrix.length; i++) {
        if (matrix[matrix.length - 1][i] === matrix[matrix.length - 1][i + 1]) {
            neighbours++;
        }        
    }
    return neighbours;
}

console.log(equalNeighbours([['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']]
));

console.log(equalNeighbours([['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']]
));

console.log(equalNeighbours([[2, 2, 5, 7, 4],
[4, 0, 5, 3, 4],
[2, 5, 5, 4, 2]]
));