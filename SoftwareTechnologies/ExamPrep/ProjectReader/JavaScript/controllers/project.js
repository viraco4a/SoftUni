const Project = require('../models').Project;

module.exports = {
    index: (req, res) => {
        //gets the projects name from v iews/project/index/each KZ
        Project.findAll().then(projects => {
            res.render("project/index", {projects: projects})
        });
    },
    createGet: (req, res) => {
        res.render("project/create")
    },
    createPost: (req, res) => {
        //because in views the Title, bla bla are with UpperCase
        //if they are as they come "title" - no need for this object
        //change in index view Title->title line 15/18
        let body = req.body.project;

        let obj = {
            title: body.Title,
            description: body.Description,
            budget: body.Budget
        };

        Project.create(obj).then(() => {
            res.redirect("/");
        })
    },
    editGet: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project => {
            res.render("project/edit", {project: project})
            //if in edit 8/12/16 "project." is missing:
            //res.render("project/edit", project.dataValues)
        })

    },

    editPost: (req, res) => {
        let id = req.params.id;
        let body = req.body.project;

        Project.findById(id).then(project => {
            //OR:
            // project.updateAttributes(body).then(() => {
            //     res.render("/")
            // });
            project.title = body.title;
            project.description = body.description;
            project.budget = body.budget;

            project.save().then(() => {
                res.redirect("/");
            })
        })
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project => {
            res.render("project/delete", {project: project})
        })

    },
    deletePost: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project => {
            project.destroy().then(() => {
                res.redirect("/");
            })
        })
    }
};