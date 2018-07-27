module.exports = {
    registerGet: (req, res) => {
        res.send("<form>" +
            "<div style='text-align: center'>" +
            "<h1 style='text-align: center'>Register</h1>" +
            "<label for='num1'>Username: </label>" +
            "<input type='text' id='num1' name='user[username]'/><br /><br />" +
            "<label for='num2'>Email: </label>" +
            "<input type='email' id='num2' name='user[email]'/><br /><br />" +
            "<input type='submit' value='Submit'/>" +
            "</div>" +
            "</form>")
    },

    getUserById: (req, res) =>{
        let id = req.params.id;
        res.send(`Welcome user with id ${id}`);
    }
};