function CapitalCaseWords(input) {
    let pattern = /(^|(?<=\s)|(?<=[^A-Za-z]))([A-Z]+)($|(?=[^a-z]))/g;
    let match = pattern.exec(input);
    let result = [];
    while (match !== null) {
        result.push(match[2]);
        match = pattern.exec(input);
    }
    console.log(result.join(", "));
}

CapitalCaseWords("We start by HTML, CSS, JavaScript, JSON and REST.\n" +
    "Later we touch some PHP, MySQL and SQL.\n" +
    "Later we play with C#, EF, SQL Server and ASP.NET MVC.\n" +
    "Finally, we touch some Java, Hibernate and Spring.MVC.\n");