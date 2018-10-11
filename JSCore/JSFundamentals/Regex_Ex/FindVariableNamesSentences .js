function findVariableNamesSent(text) {
    let regex = /(?<=\s|^)_[A-Za-z\d]+\b/gm;
    let result = [];
    let match = regex.exec(text);
    while (match) {
        result.push(match[0].slice(1));
        match = regex.exec(text);
    }
    console.log(result.join(","));    
}

findVariableNamesSent('The _id and _age variables are both integers.');

findVariableNamesSent('Calculate the _area of the _perfectRectangle object.');

findVariableNamesSent(
    '__invalidVariable _evenMoreInvalidVariable_ _validVariable');