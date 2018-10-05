function restaurantBill(arr){
    let items = arr.filter((x, i) => i % 2 == 0);
    let sum = arr
                .filter((x, i) => i % 2 == 1)
                .map(Number)
                .reduce((a, b) => a + b);
    console.log(`You purchased ${items.join(', ')} for a total sum of ${sum}`)
}

restaurantBill(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']
);

restaurantBill(['Cola', '1.35', 'Pancakes', '2.88']);