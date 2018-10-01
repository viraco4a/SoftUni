function modifyAverage(number) {
    let numberStr = number + '';

    let avr = (numberStr) => {
        let avrVal = 0;
        for (let val of numberStr) {
            avrVal += +val;
        }
        return avrVal / numberStr.length;
    }

    while (avr(numberStr) <= 5) {
        numberStr += '9';
    }

    return numberStr;
}

console.log(modifyAverage(101));
console.log(modifyAverage(5835));