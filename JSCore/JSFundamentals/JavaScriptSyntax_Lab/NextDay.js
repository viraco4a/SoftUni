function calcNextDay(year, month, day) {
    let date = new Date(year, month-1, day);    
    let oneDay = 24 * 60 * 60 * 1000; // milliseconds in 1 day    
    let nextDate = new Date(date.getTime() + oneDay);    
    let final = nextDate.getFullYear() + "-" +    
    (nextDate.getMonth() + 1) + '-' +    
    nextDate.getDate();   
    console.log(final);
    }

    calcNextDay(2016, 9, 29);