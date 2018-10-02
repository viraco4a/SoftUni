function orbit(arr) {
    let matrix = [];
    let distance = (row, col, x, y) => {
        return Math.sqrt(Math.pow(row - x, 2) + Math.pow(col - y, 2));
    };

    for (let row = 0; row < arr[1]; row++) {
        matrix.push([])   
        for (let col = 0; col < arr[0]; col++) {
            matrix[row].push(0);         
        }   
    }

    let x = arr[2];
    let y = arr[3];

    matrix[x][y] = 1;

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 1 + Math.max(Math.abs(row - x), Math.abs(col - y));
        }
    }

    console.log(matrix.map(
        row => row.join(' ')
        ).join('\n'));
    
}

orbit([4, 4, 0, 0]);

orbit([5, 5, 2, 2]);

orbit([3, 3, 2, 2]);