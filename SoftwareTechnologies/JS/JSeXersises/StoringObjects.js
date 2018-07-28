function StoringObjects(args) {
    let dict = new Array();
    for (let string of args) {
        let splitted = string.split("->");
        let name = splitted[0].trim();
        let age = splitted[1].trim();
        let grade = splitted[2].trim();
        dict.push({
            Name: name,
            Age: age,
            Grade: grade
        });
    }
    for (let student of dict) {
        for (let key of Object.keys(student)) {
            console.log(`${key}: ${student[key]}`)
        }
    }
}

StoringObjects("Pesho -> 13 -> 6.00",
"Ivan -> 12 -> 5.57",
"Toni -> 13 -> 4.90",
);