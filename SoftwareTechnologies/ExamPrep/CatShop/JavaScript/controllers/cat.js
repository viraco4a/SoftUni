const Cat = require('../models').Cat;

module.exports = {
    index: (req, res) => {
		Cat.findAll().then(cats => {
		    res.render("cat/index", {cats: cats})
        });
    },

    createGet: (req, res) => {
	    res.render("cat/create");
    },

    createPost: (req, res) => {
        let body = req.body.cat;

        let obj = {
            name: body.name,
            nickname: body.nickname,
            price: body.price
        };

        Cat.create(obj).then(() => {
            res.redirect("/");
        })
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Cat.findById(id).then(cat => {
            res.render("cat/edit", {cat: cat})
        })
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let body = req.body.cat;

        Cat.findById(id).then(cat => {
            cat.name = body.name;
            cat.nickname = body.nickname;
            cat.price = body.price;

            cat.save().then(() => {
                res.redirect("/");
            })
        })
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Cat.findById(id).then(cat => {
            res.render("cat/delete", {cat: cat})
        })
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Cat.findById(id).then(cat => {
            cat.destroy().then(() => {
                res.redirect("/");
            })
        })
    }
};
