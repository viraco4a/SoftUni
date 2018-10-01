function templateFormat(arr){
    console.log(`<?xml version="1.0" encoding="UTF-8"?>
    <quiz>`)
    for (let i = 0; i < arr.length; i+=2) {
        let question = arr[i];
        let answer = arr[i + 1];   
        console.log(`       <question>
            ${question}
        </question>
        <answer>
            ${answer}
        </answer>`)
    }
    console.log(`   </quiz>`)
}

console.log(templateFormat(
    ["Who was the forty-second president of the U.S.A.?",
"William Jefferson Clinton"]
))