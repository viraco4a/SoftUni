function SymmetricalNumbers(str) {
    let n = Number(str);
    let result = [];
    for (let i = 1; i <= n; i++){
        if(isPalindrome(i)){
            console.log(i);
        }
    }
    function isPalindrome(num){
        let str = Array.from(num.toString());
        for (let i = 0; i < str.length; i++){
            if (str[i] !== str[str.length - 1 - i]) {
                return false;
                break;
            }
        }
        return true;
    }
}



SymmetricalNumbers("100");