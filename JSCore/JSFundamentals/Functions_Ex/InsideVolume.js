function insideVolume(arr){
    function inVolume(x, y, z){
        let x0 = 10;
        let x1 = 50;
        let y0 = 20;
        let y1 = 80;
        let z0 = 15;
        let z1 = 50
        if ((x0 <= x && x <= x1)
         && (y0 <= y && y <= y1) 
         && (z0 <= z && z <= z1)){
            return true;
         } else {
             return false;
         }
    }
    for (let i = 0; i < arr.length; i+=3) {
        let x = arr[i];
        let y = arr[i + 1];
        let z = arr[i + 2];
        if(inVolume(x, y, z)){
            console.log('inside');
        } else {
            console.log('outside');
        }
    }
}

insideVolume([13.1, 50, 31.5,
    50, 80, 50,
    -5, 18, 43]
    );