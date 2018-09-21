function solve(arr){
    let V1 = arr[0];
    let V2 = arr[1];
    let time = arr[2] / 3600;
    let S = Math.abs(V1 - V2) * time * 1000;
    console.log(S);
}

solve([0, 60, 3600])