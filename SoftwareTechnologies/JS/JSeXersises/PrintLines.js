function PrintLines(str) {
    for (let i = 0; i < str.length; i++) {
        if (str[i] === "Stop"){
            return;
        }
        console.log(str[i]);
    }
}

PrintLine(["Line1", "Line2", "Line3", "Stop"])