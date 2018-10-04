function extractText(text){
    let result = [];
    let startIndex = text.indexOf('(');
    let endIndex = text.indexOf(')', startIndex);
    while (startIndex > -1 && endIndex > -1) {
        let snippet = text.substring(startIndex + 1, endIndex);
        result.push(snippet);
        startIndex = text.indexOf('(', endIndex);
        endIndex = text.indexOf(')', startIndex);
    }
    console.log(result.join(', '));
}

extractText('Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)');

// extractText('ariea lo a do keep the animal healthy and happy.');
