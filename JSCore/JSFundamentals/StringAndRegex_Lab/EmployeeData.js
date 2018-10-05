function formFilter(username, email, phone, data){
    let userPattern = /(<![a-zA-Z]+!>)/gm;
    let emailPattern = /(<@[a-zA-Z]+@>)/gm;
    let phonePattern = /(<\+[a-zA-Z]+\+>)/gm;
    data.forEach(line => {
        line = line.replace(userPattern, username);
        line = line.replace(emailPattern, email);
        line = line.replace(phonePattern, phone);
        console.log(line);        
    });
}

formFilter('Pesho',
'pesho@softuni.bg',
'90-60-90',
['Hello, <!username!>!',
 'Welcome to your Personal profile.',
 'Here you can modify your profile freely.',
 'Your current username is: <!fdsfs!>. Would you like to change that? (Y/N)',
 'Your current email is: <@DasEmail@>. Would you like to change that? (Y/N)',
 'Your current phone number is: <+number+>. Would you like to change that? (Y/N)']
);