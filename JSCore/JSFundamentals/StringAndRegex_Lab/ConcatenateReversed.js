function concatenateReversed(arr){
    let text = arr.join('');
    let reversedText = text
        .split('')
        .reverse()
        .join('');
    console.log(reversedText);
}

concatenateReversed(['I', 'am', 'student'])

concatenateReversed(['race', 'car'])