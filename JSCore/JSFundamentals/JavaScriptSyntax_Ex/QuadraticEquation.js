function quadraticEquations(a, b, c){
    let d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0){
            let first = (-b + Math.sqrt(d)) / (2 * a);
            let second = (-b - Math.sqrt(d)) / (2 * a);
            if (first <= second){
                console.log(first);
                console.log(second);
            } else {
                console.log(second);
                console.log(first);
            }
        } else if (d == 0) {
            console.log(-b / (2 * a));
        } else {
            console.log("No");
    }
}

quadraticEquations(6, 11, -35)