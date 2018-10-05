function expressionSplit(input){
    let pattern = /[\s.();,]+/gm;
    let elements = input.split(pattern);
    console.log(elements.join('\n'));    
}

expressionSplit('let sum = 4 * 4,b = "wow";');

expressionSplit('let sum = 1 + 2;if(sum > 2){\tconsole.log(sum);}');