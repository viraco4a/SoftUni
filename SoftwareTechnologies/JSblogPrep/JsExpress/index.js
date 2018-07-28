const express = require("express");
const controllers = require("./controllers/index");
const bodyParser = require("body-parser")

const app = express();

app.set(bodyParser.json());

app.use(bodyParser.urlencoded({
    extended: true
}));

app.get('/', controllers.homeController);
app.get('/register', controllers.userController.registerGet);
app.post('/register', controllers.userController.registerPost);
app.get('/users/:id', controllers.userController.getUserById);
app.get('/about', controllers.aboutController.about);

app.listen(3000, () => {
    console.log('Listening on http://localhost:3000')
});