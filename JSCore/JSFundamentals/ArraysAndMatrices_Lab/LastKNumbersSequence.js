function lastKnumbersSeq(n, k) {
    let seq = [1];
    let sum = (start, end) => {
        let arr = seq.slice(start, end + 1);
        let sum = 0
        arr.forEach((a) => {
            sum += +a;
        })
        return sum;
    }
    for (let i = 1; i < n; i++) {
        let start = Math.max(0, i - k);
        let end = i - 1;

        seq[i] = sum(start, end);   
    }
    console.log(seq.join(' '));    
}

lastKnumbersSeq(6, 3);
lastKnumbersSeq(8, 2);