function roadRadar(arr){
    let speed = arr[0];
    let area = arr[1];
    let limit = function getLimitZone(area){
        switch (area) {
            case 'residential':
                return 20;
            case 'city':
                return 50;
            case 'interstate':
                return 90;
            case 'motorway':
                return 130;
        }
    }
    let diff = speed - limit(area);
    if (diff > 40){
        return 'reckless driving';
    } else if (diff > 20) {
        return 'excessive speeding';
    } else if (diff > 0){
        return 'speeding';
    } else {
        return '';
    }
}

console.log(roadRadar([21, 'residential']));
console.log(roadRadar([40, 'city']));
console.log(roadRadar([120, 'interstate']));
console.log(roadRadar([200, 'motorway']));