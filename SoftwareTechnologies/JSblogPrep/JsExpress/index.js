const express = require("express");
const controllers = require("./controllers/index")

const app = express();

app.get('/', controllers.homeController);
app.get('/register', controllers.userController.registerGet);
app.get('/users/:id', controllers.userController.getUserById)

app.listen(3000, () => {
    console.log('Listening on http://localhost:3000')
})