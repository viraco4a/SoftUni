let http = require('http');

http.createServer((req, res) => {
	res.end("<h1>Hello<h1>")
	
}).listen(3000, () => console.log("Listening on port 3000"));