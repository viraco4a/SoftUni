function cookingNumbers(arr) {
    let number = +arr[0];
    let chop = (num) => {return num / 2;}
    let dice = (num) => {return Math.sqrt(num);}
    let spice = (num) => {return num + 1;}
    let bake = (num) => {return num * 3;}
    let fillet = (num) => {return num * 0.8;}

    for (let i = 1; i < arr.length; i++) {
        let operation = arr[i];
        switch (operation) {
            case 'chop':
                number = chop(number);
                break;
            case 'dice':
                number = dice(number);
                break;
            case 'spice':
                number = spice(number);
                break;
            case 'bake':
                number = bake(number);
                break;
            case 'fillet':
                number = fillet(number);
                break;
        }
        console.log(number);
    }
}

cookingNumbers(
    ['32', 'chop', 'chop', 'chop', 'chop', 'chop']);

cookingNumbers(
    ['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);