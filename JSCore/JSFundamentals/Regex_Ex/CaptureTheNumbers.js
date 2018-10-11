function captureTheNumbers(arr) {
    let regex = /[0-9]+/gm
    let nums = []
    let str = "";
    for (let text of arr) {
        str += text;
    } 
    let match = regex.exec(str);
    while (match) {
        nums.push(match[0]);
        match = regex.exec(str);
    }
    console.log(nums.join(" "));    
}

captureTheNumbers(['The300', 
'What is that?', 
'I think it’s the 3rd movie.', 
'Lets watch it at 22:45']
);

captureTheNumbers(['123a456', 
'789b987', 
'654c321', 
'0']
);

captureTheNumbers(['Let’s go11!!!11!',
'Okey!1!']
);