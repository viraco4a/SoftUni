function WorkingWithKVP(arr) {
    let masterKey = arr[arr.length - 1];
    // let dict = new Map();
    let dict = {};
    for (let i = 0; i < arr.length - 1; i++) {
        let kvp = arr[i].split(' ');
        let key = kvp[0];
        let value = kvp[1];
        // dict.set(key, value);
        dict[key] = value;
    }
    if (masterKey in dict) {
        console.log(dict[masterKey]);
    } else {
        console.log("None")
    }
}

WorkingWithKVP(["key value",
    "key eulav",
    "test tset",
    "test",
]);