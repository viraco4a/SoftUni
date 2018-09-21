function solve(arr){
    let principalSum = arr[0];
    let interestRate = arr[1] * 0.01;
    let compoundingFreq = 12 / arr[2];
    let totalTimespan = arr[3];
    let compoundInterest = principalSum * Math.pow(1 + (interestRate / compoundingFreq),
    compoundingFreq * totalTimespan);
    console.log(compoundInterest.toFixed(2));
}

solve([1500, 4.3, 3, 6]);