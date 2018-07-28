function Largest3Numbers(arr) {
    let sorted = arr.sort((a, b) => a - b);

    let length = sorted.length > 2 ? 3 : sorted.length;

    for (let i = 0; i < length; i++){
        console.log(sorted.pop());
    }
}

Largest3Numbers([10, 30])