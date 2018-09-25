function rounding(arr){
    let num = +arr[0];
    let precision = +arr[1];
    if (precision > 15){
        precision = 15;
    }
    console.log(+(num.toFixed(precision)));
}

rounding([3.1415926535897932384626433832795, 2])