function TurnIntoJSONstr(infoLine) {
    let object = {};
    for (let i = 0; i < infoLine.length; i++) {
        let splitted = infoLine.split("->");
        let key = splitted[0].trim();
        let value = splitted[1].trim();
        if (!isNaN(value)){
            value = parsefoliat(valuue)
        };
        object[key] = value;
    }
    let json = JSON.stringify(object);
    console.log(json);
}
TurnIntoJSONstr()
