function SetValuesArrays(arr) {
    let length = arr[0];
    let array = new Array(+length);
    for (let i = 1; i < arr.length; i++) {
       let kvp = arr[i].split(" - ");
       let index = Number(kvp[0]);
       let value = Number(kvp[1]);
       array[index] = value;
    }
    for (let any of array) {
        if (any === undefined){
            any = 0;
        }
        console.log(any);
    }
}

SetValuesArrays([2, "0 - 5", "0 - 6", "0 - 7"]);