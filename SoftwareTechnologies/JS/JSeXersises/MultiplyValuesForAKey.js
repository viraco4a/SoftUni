function MultiValuesKeys(arr) {
    let masterKey = arr[arr.length - 1];
    let dict = {};
    for (let i = 0; i < arr.length - 1; i++) {
        let key = arr[i].split(' ')[0];
        let value = arr[i].split(' ')[1];
        if (dict[key] === undefined){
            dict[key] = [];
        }

        dict[key].push(value);
    }
    if (masterKey in dict) {
        for (let dictElement of dict[masterKey]) {
            console.log(dictElement);
        }
    } else {
        console.log("None")
    }
}

MultiValuesKeys(["key value",
    "key eulav",
    "test tset",
    "key",
]);