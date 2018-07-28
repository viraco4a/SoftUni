function PrintInRevOrder(arr) {
    for (let i = arr.length - 1; i >= 0; i--) {
        console.log(arr[i]);
    }
}

PrintInRevOrder([10, 15, 20]);