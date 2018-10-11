function townsToJSON(arr){
    let townArr = [];
    for (const town of arr.slice(1)) {
        let [empty, townName, lat, long] = town.split(/\s*\|\s*/);
        townArr.push({Town: townName, Latitude: +lat, Longitude: +long})
    }
    console.log(JSON.stringify(townArr));    
}

townsToJSON(['| Town | Latitude | Longitude |',
'| Sofia | 42.696552 | 23.32601 |',
'| Beijing | 39.913818 | 116.363625 |']
);

// townsToJSON(['| Town | Latitude | Longitude |',
// '| Veliko Turnovo | 43.0757 | 25.6172 |',
// '| Monatevideo | 34.50 | 56.11 |']
// );