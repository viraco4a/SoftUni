function DNAex(input) {
    let entries = {};
    let pattern = /([a-z\!\@\#\$\?]+)=([\d]+)--([\d]+)<<([a-z]+)/;

    for (let line of input) {
        if (line === "Stop!") {
            break;
        }

        let matches = line.match(pattern);
        
        if (matches){
            let name = matches[1].replace(/([^a-z0-9]+)/gi, '')
            if (matches[2] == name.length){
                if (!entries.hasOwnProperty(matches[4])){
                    entries[matches[4]] = +matches[3];
                } else {
                    entries[matches[4]] += +matches[3];
                }
            }
        }
    }

    let sorted = [];

    for (let e in entries) {
        sorted.push([e, entries[e]])
    }
    sorted.sort((a, b) => {
        return b[1] - a[1];
    })
    sorted.forEach(s => {
        console.log(`${s[0]} has genome size of ${s[1]}`);
    })
}

DNAex(['!@ab?si?di!a@=7--152<<human',
    'b!etu?la@=6--321<<dog',
    '!curtob@acter##ium$=14--230<<dog',
    '!some@thin@g##=9<<human',
    'Stop!']
    );