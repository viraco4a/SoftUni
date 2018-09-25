function assingProp(arr){
    let data = {
        [arr[0]] : arr[1],
        [arr[2]] : arr[3],
        [arr[4]] : arr[5]
    }
    console.log(data);
}

assingProp(['name', 'Pesho', 'age', '23', 'gender', 'male'])