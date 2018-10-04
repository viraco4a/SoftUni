function aggregateTable(arr){
    let sum = 0;
    let list = [];
    for (const line of arr) {
        let townData=  line.split('|');
        list.push(townData[1].trim());
        sum += +townData[2].trim();
    }
    console.log(list.join(', ') + '\n' + sum);
}

aggregateTable(['| Sofia           | 300',
                '| Veliko Tarnovo  | 500',
                '| Yambol          | 275']
);