function diagonalSums(matrix) {
    let first = 0;
    let second = 0;
    matrix
    .forEach((item, index) => {
        first += +item
        .filter((innerItem, innerIndex) => {
            return innerIndex === index;
        })[0]
    });

    matrix.forEach((item, index) => {
        second += +item
        .filter((innerItem, innerIndex) => {
            return innerIndex === item.length - index - 1;
        })
    })

    return first + ' ' + second;
}
console.log(diagonalSums([[20, 40],
    [10, 60]]
   ));

console.log(diagonalSums([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
   ));