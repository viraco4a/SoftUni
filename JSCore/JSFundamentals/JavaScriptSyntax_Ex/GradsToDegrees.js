function solve(grad){
    let deg = grad / 400 * 360
    deg = deg % 360;

    if (deg < 0){
        deg += 360;
    } 
    console.log(deg)
}

solve(-50);