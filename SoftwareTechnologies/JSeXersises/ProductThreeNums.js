function ProductThreeNums(nums) {
    let counter = 0;
    for (let num of nums) {
        if (num === 0) {
            return "Positive";
        }
        if (num < 0) {
            counter++;
        }
    }
    if (counter % 2 == 0) {
        return "Positive";
    }
    return "Negative"
}

ProductThreeNums([2, 3, -1])