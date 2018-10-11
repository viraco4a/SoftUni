function kompot(arr) {
    let peackKg = 0;
    let plumKg = 0;
    let cherryKg = 0;
    let fruitsForRakia = 0;
    for (const line of arr) {
        let [fruit, kg] = line.split(/\s+/g);
        switch (fruit) {
            case "peach": peackKg += +kg;
                break;
            case "plum": plumKg += +kg;
                break;
            case "cherry": cherryKg += +kg;
                break;
            default: fruitsForRakia += +kg;
                break;
        }
    }

    let cherryKompots = Math.floor(((cherryKg * 1000) / 9) / 25);
    let plumKompots = Math.floor(((plumKg * 1000) / 20) / 10);
    let peachKompots = Math.floor(((peackKg * 1000) / 140) / 2.5);
    let rakia = fruitsForRakia * 0.2;

    console.log(`Cherry kompots: ${cherryKompots}`);
    console.log(`Peach kompots: ${peachKompots}`);
    console.log(`Plum kompots: ${plumKompots}`);
    console.log(`Rakiya liters: ${rakia.toFixed(2)}`);    
}

kompot(['cherry 1.2',
        'peach 2.2', 
        'plum 5.2',
        'peach 0.1', 
        'cherry 0.2', 
        'cherry 5.0', 
        'plum 10',
        'cherry 20.0' ,
        'papaya 20' ]
)