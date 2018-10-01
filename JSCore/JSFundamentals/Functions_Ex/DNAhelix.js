function DNAhelix(n) {
    let sequence = 'ATCGTTAGGG';
    let first = (a, b) => {
        console.log(`**${a}${b}**`);
    }
    let second = (a, b) => {
        console.log(`*${a}--${b}*`);
    }
    let third = (a, b) => {
        console.log(`${a}----${b}`);
    }
    let fourth = (a, b) => {
        console.log(`*${a}--${b}*`);
    }
    for (let i = 0, j = 0; i < n; i++, j+=2) {
        if (j === sequence.length){
            j = 0;
        }

        first(sequence[j], sequence[j + 1]);
        j+=2;
        i++;
        if (j === sequence.length){
            j = 0;
        }
        if (i >= n){
            break;
        }
        second(sequence[j], sequence[j + 1]);
        j+=2;
        i++;
        if (j === sequence.length){
            j = 0;
        }
        if (i >= n){
            break;
        }
        third(sequence[j], sequence[j + 1]);
        j+=2;
        i++;
        if (j === sequence.length){
            j = 0;
        }
        if (i >= n){
            break;
        }
        fourth(sequence[j], sequence[j + 1]);  
    }
}

DNAhelix(4);
DNAhelix(10);