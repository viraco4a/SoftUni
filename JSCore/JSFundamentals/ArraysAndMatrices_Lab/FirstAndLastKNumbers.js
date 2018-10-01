function firstAndLastKnums(arr) {
    let n = arr.shift();
    let left = arr.slice(0, n);
    let right = arr.slice(arr.length - n, arr.length);

    console.log(left.join(' '));
    console.log(right.join(' '));
}

firstAndLastKnums([2,
    7, 8, 9]
   );
console.log(firstAndLastKnums([3,
    6, 7, 8, 9]
   ));