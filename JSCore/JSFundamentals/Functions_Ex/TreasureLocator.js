function treasureLocator(arr) {
    let isInside = (x, y, landX, landY, sizeX, sizeY) => {
        let res = (landX <= x && x <= landX + sizeX)
        && (landY <= y && y <= landY + sizeY);
        return res;
    }

    for (let i = 0; i < arr.length; i+=2) {
        check(+arr[i], +arr[i + 1]);
    }
    
    function check(x, y){
        if (isInside(x, y, 1, 1, 2, 2)) {
            console.log('Tuvalu');
        } else if (isInside(x, y, 8, 0, 1, 1)) {
            console.log('Tokelau');
        } else if (isInside(x, y, 5, 3, 2, 3)) {
            console.log('Samoa');
        } else if (isInside(x, y, 0, 6, 2, 2)) {
            console.log('Tonga');
        } else if (isInside(x, y, 4, 7, 5, 1)) {
            console.log('Cook');
        } else {
            console.log('On the bottom of the ocean');
        }
    }
}

treasureLocator([4, 2, 1.5, 6.5, 1, 3]);
treasureLocator([6, 4]);