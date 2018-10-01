function validityChecker(arr) {
    let x1 = +arr[0];
    let y1 = +arr[1];
    let x2 = +arr[2];
    let y2 = +arr[3];

    function isValid(distance) {
        let intDistance = Math.round(distance, 0);
        return intDistance === distance;
    }

    let distance = (x1, y1, x2, y2) => {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    };

    let print = (x1, y1, x2, y2) => {
        if (isValid(distance(x1, y1, x2, y2))){
            return `{${x1}, ${y1}} to {${x2}, ${y2}} is valid`
        } else {
            return `{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`
        }
    }
    console.log(print(x1, y1, 0, 0));
    console.log(print(x2, y2, 0, 0));
    console.log(print(x1, y1, x2, y2));
}

console.log(validityChecker([3, 0, 0, 4]));
console.log(validityChecker([2, 1, 1, 1]));