function ParseJSONobj(string) {
    for (let i = 0; i < string.length; i++) {
        let parsedObject = JSON.parse(string[i]);
        console.log(`Name: ${parsedObject.name}`);
        console.log(`Age: ${parsedObject.age}`);
        console.log(`Date: ${parsedObject.date}`);
    }
}

ParseJSONobj(`{"name":"Gosho","age":10,"date":"19/06/2005"}`,
    '{"name":"Tosho","age":11,"date":"04/04/2005"}',
);