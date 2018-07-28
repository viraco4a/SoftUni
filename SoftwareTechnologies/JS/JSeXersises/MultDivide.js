function MultDiv(arr) {
    let first = Number(arr[0]);
    let second = Number(arr[1]);
    if (second >= first) {
        return first * second;
    }
    else {
        return first / second;
    }
}

MultDiv(["2", "3"])