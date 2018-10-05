function simpleEmailValidation(input){
    let pattern = /^[a-zA-Z0-9]+@[a-z]+\.[a-z]+$/gm;
    if (pattern.test(input)) {
        console.log('Valid');        
    } else {
        console.log('Invalid');        
    }
}

simpleEmailValidation('valid@email.bg');

simpleEmailValidation('invalid@emai1.bg');