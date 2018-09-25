function imperialUnits(input){
    let foot = parseInt(+input / 12);
    let inch = +input % 12;
    console.log(`${foot}'-${inch}"`)
}

imperialUnits(55)