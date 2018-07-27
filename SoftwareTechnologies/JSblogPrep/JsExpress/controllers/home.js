function homeController(req, res) {
    res.end("<a href='/register' style='float: right'>Register</a>" +
        "<h1 style='text-align: center'>Welcome to our site</h1>" +
        "<div style='text-align: center'>" +
        "<p style='color: red'>Articles:</p>" +
        "<p style='color: blue'>First Article</p>" +
        "<p style='color: blue'>Second Article</p>" +
        "</div>");
};

module.exports = homeController;