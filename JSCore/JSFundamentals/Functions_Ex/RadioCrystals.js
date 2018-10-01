function radioCrystals(arr) {

    let cut = (chunk) => {return chunk / 4};
    let lap = (chunk) => {return chunk * 0.8};
    let grind = (chunk) => {return chunk - 20};
    let etch = (chunk) => {return chunk - 2};
    let xRay = (chunk) => {
        console.log(`X-ray x1`);
        return chunk + 1;
    };
    let wash = (chunk) => {
        console.log('Transporting and washing');        
        return Math.floor(chunk, 0);
    };

    let target = arr[0];
    for (let i = 1; i < arr.length; i++) {
        let chunk = arr[i];
        console.log(`Processing chunk ${chunk} microns`);
        process(target, chunk);
        console.log(`Finished crystal ${target} microns`);        
    }

    function process(target, chunk) {
        let cutting = 0;
        let lapping = 0;
        let grinding = 0;
        let etching = 0;

        while (chunk !== target) {
            cutted = cut(chunk);
            lapped = lap(chunk);
            grinded = grind(chunk);
            etched = etch(chunk);

            let min = Math.min(cutted, lapped, grinded, etched);

            if (cutted === min && cutted >= target){
                chunk = cutted;
                cutting++;
                if (chunk === target){
                    console.log(`Cut x${cutting}`);
                    chunk = wash(chunk);
                }
                continue;
            } else if (cutted < target) {
                min = Math.min(lapped, grinded, etched);
                if (cutting > 0){
                    console.log(`Cut x${cutting}`);
                    chunk = wash(chunk);
                    cutting = 0;
                    continue;
                }                
            }

            if (lapped === min && lapped >= target){
                chunk = lapped;
                lapping++;
                if (chunk === target){
                    console.log(`Lap x${lapping}`);
                    chunk = wash(chunk);
                }
                continue;
            } else if (lapped < target) {
                min = Math.min(grinded, etched);
                if (lapping > 0){
                    console.log(`Lap x${lapping}`);
                    chunk = wash(chunk);                
                    lapping = 0;
                    continue;
                }
            }

            if (grinded === min && grinded >= target){
                chunk = grinded;
                grinding++;
                if (chunk === target){
                    console.log(`Grind x${grinding}`);
                    chunk = wash(chunk);
                }
                continue;
            } else if (grinded < target) {
                if (grinding > 0){
                    console.log(`Grind x${grinding}`);
                    chunk = wash(chunk);
                    grinding = 0;
                    continue;
                }

            }

            if (etched >= target - 1){
                chunk = etched;
                etching++;
                if (chunk === target){
                    console.log(`Etch x${etching}`);
                    chunk = wash(chunk);
                }
                continue;
            } else if (etched <= target - 1) {
                if (etching > 0){
                    console.log(`Etch x${etching}`);
                    chunk = wash(chunk);
                    etching = 0;
                }
                if (chunk === target - 1){
                    chunk = xRay(chunk);
                }
            }
        }
    }
}

radioCrystals([1000, 4000, 8100]);