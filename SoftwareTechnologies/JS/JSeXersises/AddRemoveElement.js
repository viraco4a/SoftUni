function AddRemoveElement(arr) {
    let array = [];
    for (let i = 0; i < arr.length; i++) {
        let kvp = arr[i].split(' ');
        let command = kvp[0];
        if (command === "add") {
            array.push(Number(kvp[1]));
        }
        else {
            let index = Number(kvp[1]);
            if (index >= 0 || index < array.length){
                array.splice(index, 1);
            }
        }
    }
    for (let arrayElement of array) {
        console.log(arrayElement);
    }
}

AddRemoveElement(["add 3",
    "add 5",
    "remove 2",
    "remove 0",
    "add 7",
]);
