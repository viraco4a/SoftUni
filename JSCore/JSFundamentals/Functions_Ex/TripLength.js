function tripLength(arr) {
    let distance = (x1, y1, x2, y2) => {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    };

    let first = {x: arr[0], y: arr[1]};
    let second = {x: arr[2], y: arr[3]};
    let third = {x: arr[4], y: arr[5]};

    let distance12 = distance(first.x, first.y, second.x, second.y);
    let distance23 = distance(second.x, second.y, third.x, third.y);
    let distance13 = distance(first.x, first.y, third.x, third.y);
    
    let max = Math.max(distance12, distance13, distance23);

    function scenarii123(total){
        console.log(`1->2->3: ${total}`)
    }

    function scenarii132(total){
        console.log(`1->3->2: ${total}`)
    }

    function scenarii213(total){
        console.log(`2->1->3: ${total}`)
    }

    if (distance13 === max) {
        scenarii123(distance12 + distance23);
    } else if (distance12 === max) {
        scenarii132(distance13 + distance23);
    } else {
        scenarii213(distance12 + distance13)
    }
}

tripLength([0, 0, 2, 0, 4, 0]);
tripLength([5, 1, 1, 1, 5, 4]);
tripLength([-1, -2, 3.5, 0, 0, 2]);