function splitStringWithDelimiter(text, delimiter){
    text.split(delimiter)
        .forEach(e => {
            console.log(e);            
        });
}

splitStringWithDelimiter('One-Two-Three-Four-Five', '-');

splitStringWithDelimiter('http://platform.softuni.bg', '.');