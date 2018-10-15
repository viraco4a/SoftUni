function ticketsScan(text, second) {
    const passangerNameReg = / ([A-Z][A-Za-z]*)-([A-Za-z]*)(\.-)?([A-Za-z]*)? /g;
    const airportReg = / [A-Z]{3}\/[A-Z]{3} /g;
    const flightReg = / [A-Z]{1,3}[\d]{1,5} /g;
    const companyReg = /- [A-Z][A-Za-z]*\*[A-Z][A-Za-z]* /g;

    let name = '';
    let airport = [];
    let flight = '';
    let company = '';

    let matchPassanger = text.match(passangerNameReg);
    let matchAirport = text.match(airportReg);
    let matchFlight = text.match(flightReg);
    let matchCompany = text.match(companyReg);

    if (matchPassanger){
        name = matchPassanger[0].replace(' ', '');
        name = name.replace(' ', '');
        name = name.replace('-', ' ');
        name = name.replace('-', ' ');        
    }
    if (matchFlight){
        flight = matchFlight[0].replace(' ', '');
        flight = flight.replace(' ', '');
    }
    if (matchCompany){
        company = matchCompany[0].replace('- ', '');
        company = company.replace(' ', '');
        company = company.replace('*', ' ');
    }
    if (matchAirport){
        let tmp = matchAirport[0].replace(' ', '');
        tmp = tmp.replace(' ', '');
        airport = tmp.split('/');
    }
    
    if (second === 'name'){
        console.log(`Mr/Ms, ${name}, have a nice flight!`);
    } else if (second === 'flight'){
        console.log(`Your flight number ${flight} is from ${airport[0]} to ${airport[1]}.`);
    } else if (second === 'company'){
        console.log(`Have a nice flight with ${company}.`);        
    } else if (second === 'all'){
        console.log(`Mr/Ms, ${name}, your flight number ${flight} is from ${airport[0]} to ${airport[1]}. Have a nice flight with ${company}.`);
        
    }
}

//ticketsScan('ahah Second-Testov )*))&&ba SOF/VAR ela** FB973 - Bulgaria*Air -opFB900 pa-SOF/VAr//_- T12G12 STD08:45  STA09:35 ', 'all');

ticketsScan(' TEST-T.-TESTOV   SOF/VIE OS806 - Austrian*Airlines T24G55 STD11:15 STA11:50 ', 'name')
