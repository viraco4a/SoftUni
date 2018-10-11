function f1Race(arr) {
    let pilots = arr.shift().split(/\s+/);
    arr.forEach(e => {
        let event = e.split(/\s+/)[0];
        let pilot = e.split(/\s+/)[1];
        switch (event) {
            case "Join": 
                if (!pilots.includes(pilot)){
                    pilots.push(pilot);
                }
                break;
            case "Crash": 
                if (pilots.includes(pilot)){
                    let index = pilots.indexOf(pilot);
                    pilots.splice(index, 1);                    
                }
                break;
            case "Pit": 
                if (pilots.includes(pilot)){
                    let index = pilots.indexOf(pilot);
                    if (index != pilots.length - 1){
                        pilots[index] = pilots[index + 1];
                        pilots[index + 1] = pilot;
                    }
                }         
                break;
            case "Overtake": 
                if (pilots.includes(pilot)){
                    let index = pilots.indexOf(pilot);
                    if (index != 0){
                        // pilots[index] = pilots[index - 1];
                        // pilots[index - 1] = pilot;
                        pilots.splice(index, 1)
                        pilots.splice(index - 1, 0, pilot);
                    }
                }
                break;
        }
    })
    console.log(pilots.join(" ~ "))
}

f1Race(["Vetel Hamilton Slavi",
        "Pit Hamilton",
        "Overtake Vetel",
        "Crash Slavi"]
);
f1Race(["Vetel Hamilton Raikonnen Botas Slavi",
        "Pit Hamilton",
        "Overtake LeClerc",
        "Join Ricardo",
        "Crash Botas",
        "Overtake Ricardo",
        "Overtake Ricardo",
        "Overtake Ricardo",
        "Crash Slavi"]
);