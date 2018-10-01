function sumFirstLast(arr) {
    return +arr[0] + +arr[arr.length - 1];
}

console.log(sumFirstLast(['20', '30', '40']));
console.log(sumFirstLast(['5', '10']));