const path = require("path");

module.exports = {
    about: (req, res) => {
        res.sendFile(path.resolve('./static/about.html'));
    }
};