function composeTag(arr){
    let fileLocation = arr[0];
    let text = arr[1];
    console.log(`<img src="${fileLocation}" alt="${text}">`)
}

composeTag(['smiley.gif', 'Smiley Face'])