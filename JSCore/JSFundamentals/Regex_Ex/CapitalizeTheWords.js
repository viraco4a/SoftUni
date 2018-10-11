function endsWith(text) {
    let arr = text.split(' ');
    let result = []
    for (let word of arr) {
        let local = word[0].toUpperCase();
        for (let i = 1; i < word.length; i++) {
            local += word[i].toLowerCase();            
        }
        result.push(local)
    }
    console.log(result.join(' '));    
}

endsWith('Capitalize these words');

endsWith('Was that Easy? tRY thIs onE for SiZe!');