function coffeeMachine(arr) {
    const coffeeCaffeine = 0.8;
    const coffeeDecaf = 0.9;
    const tea = 0.8;
    let totalMoney = 0;

    for (const line of arr) {
        let splitted = line.split(', ');
        let coinsInsered = +splitted[0];
        let currentPrice = 0;
        let typeOfDrink = splitted[1];
        if (typeOfDrink === 'coffee'){
            let coffeeType = splitted[2]
            if (coffeeType === 'caffeine'){
                currentPrice = coffeeCaffeine;
            } else if (coffeeType === 'decaf'){
                currentPrice = coffeeDecaf;
            }
            if (splitted[3] === 'milk'){
                currentPrice = +(currentPrice * 1.1).toFixed(1);
                if (+splitted[4] !== 0){
                    currentPrice = currentPrice + 0.1;
                }
            } else {
                if (+splitted[3] !== 0){
                    currentPrice = currentPrice + 0.1;
                }
            }
        } else {
            currentPrice = tea;
            if (splitted[2] === 'milk'){
                currentPrice = +(currentPrice * 1.1).toFixed(1);
                if (+splitted[3] !== 0){
                    currentPrice = currentPrice + 0.1;
                }            
            } else {
                if (+splitted[2] !== 0){
                    currentPrice = currentPrice + 0.1;
                }
            }
        }

        if (coinsInsered >= currentPrice){
            console.log(`You ordered ${typeOfDrink}. Price: ${currentPrice.toFixed(2)}$ Change: ${(coinsInsered - currentPrice).toFixed(2)}$`);
            totalMoney += currentPrice;
        } else {
            console.log(`Not enough money for ${typeOfDrink}. Need ${(-coinsInsered + currentPrice).toFixed(2)}$ more.`);
        }
    }
    console.log(`Income Report: ${totalMoney.toFixed(2)}$`);    
}

coffeeMachine([ '1.00, coffee, caffeine, milk, 4',
                '0.40, tea, milk, 2',
                '1.00, coffee, decaf, 0' ])