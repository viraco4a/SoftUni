function warehouseMachine(arr) {
    let map = new Map();
    for (const line of arr) {
        let splitted = line.split(/,\s/);
        let command = splitted[0];
        if (command === 'IN'){
            In(splitted);
        } else if (command === 'OUT'){
            Out(splitted);
        } else if (command === 'REPORT'){
            report();
        } else if (command === 'INSPECTION'){
            inspection();
        }        
    }

    function inspection() {
        console.log(`>>>>> INSPECTION! <<<<<`);
        let sorted = [...map.entries()]
            .sort((a, b) => a[0].localeCompare(b));
        sorted.forEach(el => {
            console.log(`Brand: ${el[0]}:`);
            [...el[1].entries()]
            .sort((a, b) => 
                b[1].quantity - a[1].quantity
            )
            .forEach(s => {
                console.log(`-> ${s[0]} -> ${s[1].expireDate} -> ${s[1].quantity}.`);                
            });
        });
    }

    function report() {
        console.log(`>>>>> REPORT! <<<<<`);
        let unsorted = [...map.entries()];
        unsorted.forEach(el => {
            console.log(`Brand: ${el[0]}:`);
            [...el[1].entries()].forEach(s => {
                console.log(`-> ${s[0]} -> ${s[1].expireDate} -> ${s[1].quantity}.`);                
            });
        });
    }

    function Out(arr) {
        let coffeeBrand = arr[1];
        let coffeeName = arr[2];
        let expireDate = arr[3];
        let quantity = +arr[4];
        if (!map.has(coffeeBrand)){
            return;
        }
        if (!map.get(coffeeBrand).has(coffeeName)){
            return;
        }
        let oldDate = map.get(coffeeBrand).get(coffeeName).expireDate;
        let curQuantity =  map.get(coffeeBrand).get(coffeeName).quantity;
        if (expireDate.localeCompare(oldDate) === -1){
            if (curQuantity >= quantity){
                map.get(coffeeBrand).get(coffeeName).quantity -= quantity;
            }
        }
    }

    function In(arr) {
        let coffeeBrand = arr[1];
        let coffeeName = arr[2];
        let expireDate = arr[3];
        let quantity = +arr[4];
        if (!map.has(coffeeBrand)){
            map.set(coffeeBrand, new Map());
            map.get(coffeeBrand).set(coffeeName,{
                'expireDate': expireDate,
                'quantity': quantity
            });
        } else if (!map.get(coffeeBrand).has(coffeeName)){
            map.get(coffeeBrand).set(coffeeName,{
                'expireDate': expireDate,
                'quantity': quantity
            });
        } else {
            let oldDate = map.get(coffeeBrand).get(coffeeName).expireDate;
            if (expireDate.localeCompare(oldDate) === 1){
                map.get(coffeeBrand).get(coffeeName).expireDate = expireDate;
                map.get(coffeeBrand).get(coffeeName).quantity = quantity;
            } else if (expireDate.localeCompare(oldDate) === 0){
                map.get(coffeeBrand).get(coffeeName).quantity += quantity;
            }
        }
    }
}

warehouseMachine([  'IN, yatdorf & Bronson, Espresso, 2025-05-25, 20',
                    'IN, Folgers, Black Silk, 2023-03-01, 14',
                    'IN, Lavazza, Crema e Gusto, 2023-05-01, 5',
                    'IN, Lavazza, Crema e Gusto, 2023-05-02, 5',
                    'IN, Folgers, Black Silk, 2022-01-01, 10',
                    'IN, Lavazza, Intenso, 2022-07-19, 20',
                    'OUT, Dallmayr, Espresso, 2022-07-19, 5',
                    'OUT, Dallmayr, Crema, 2022-07-19, 5',
                    'OUT, Lavazza, Crema e Gusto, 2020-01-28, 2',
                    'REPORT',
                    'INSPECTION' ]
);