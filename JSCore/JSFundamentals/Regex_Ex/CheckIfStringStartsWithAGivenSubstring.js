function checkStringStartSubstr(text, word){
    if (text.slice(0, word.length) === word){
        console.log(true);
    } else {
        console.log(false);        
    }
}

checkStringStartSubstr('How have you been?', 'how');

checkStringStartSubstr('The quick brown fox…', 
'The quick brown fox…'
);

checkStringStartSubstr('Marketing Fundamentals, starting 19/10/2016', 
'Marketing Fundamentals, sta'
);