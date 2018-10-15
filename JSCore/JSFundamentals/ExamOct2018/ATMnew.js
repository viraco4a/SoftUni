function atmMachine(inputArr) {    
    let atm = []
    for (const command of inputArr) {
        if (command.length > 2){
            insert(command);
        } else if (command.length === 2){
            withdraw(command[0], command[1])
        } else if (command.length === 1){
            report(command)
        }
    }

    function report(banknote) {
        let count = 0;
        for (let i = 0; i < atm.length; i++) {
            if (atm[i] === banknote[0]){
                count++;
            }
        }
        console.log(`Service Report: Banknotes from ${banknote}$: ${count}.`);
    }

    function withdraw(currBalance, moneyToWithrdraw) {
        let withdrawn = moneyToWithrdraw
        if (moneyToWithrdraw > currBalance){
            console.log(`Not enough money in your account. Account balance: ${currBalance}$.`);
        } else if (atm.length === 0){
            console.log(`ATM machine is out of order!`);  
        } else if (moneyToWithrdraw > atm.reduce((a, b) => a + b)){
            console.log(`ATM machine is out of order!`);      
        } else {
            atm.sort((a, b) => b - a);
            while (moneyToWithrdraw !==0) {
                for (const curBank of atm) {
                    if (curBank <= moneyToWithrdraw){
                        let index = atm.indexOf(curBank);
                        atm.splice(index, 1);
                        moneyToWithrdraw -= curBank;
                        break;
                    }
                }   
            }
            console.log(`You get ${withdrawn}$. Account balance: ${currBalance - withdrawn}$. Thank you!`);
        }
    }

    function insert(arr) {
        let sum = 0;
        arr.forEach(m => {
            sum += m;
            atm.push(m);
        })
        let total = atm.reduce((a, b) => a + b)        
        console.log(`Service Report: ${sum}$ inserted. Current balance: ${total}$.`);
    }
}

atmMachine([    [ 20, 5, 100, 20, 1 ],
                [ 457, 25 ],
                [ 1 ],
                [ 10, 10, 5, 20, 50, 20, 10, 5, 2, 100, 20 ],
                [ 20, 85 ],
                [ 5000, 4500 ] ]
  );