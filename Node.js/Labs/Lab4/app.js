/*
 * Node.js Lab 4 (express)
 * Author: Mahmoud Mohamed Kamal
 * Date: 14-04-2022
 * File: app.js
 */

var express = require('express');
var fs = require('fs');
let sh = require('./ServerHandler');
var app = express();

app.set('view engine', 'ejs');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.get("/", (req, res) => {
    res.status(200).render('index')
});

app.post('/sign-up', (req, res) => {
    if (req.query.email && req.query.password && req.query.username && (Object.keys(req.query).length == 3)) {
        let email = req.query.email;
        let password = req.query.password;
        let username = req.query.username;
        if (!sh.checkEmail(email)) {
            if (sh.signUp(email, password, username)) {
                res.status(200).send(`Add new user ${username}`);
            } else {
                res.status(403).send("Error - Can 't add new user (Wrong Email)");
            }
        } else {
            res.status(400).send("Error - Email already exists");
        }
    } else {
        console.log("Wrong way to enter the Email and Password")
        res.status(500).send("Error - Wrong way to enter the Email and Password");
    }
});

app.post('/login', (req, res) => {
    if (req.query.email && req.query.password && (Object.keys(req.query).length == 2)) {
        let email = req.query.email;
        let password = req.query.password;
        let loginResponse = sh.login(email, password)
        switch (loginResponse) {
            case "ok":
                const users = JSON.parse(fs.readFileSync("users.json"));
                let username = users[email].username;
                res.status(200).render('user', { user: username });
                break;
            case "wrong-password":
                res.status(403).send("You entered wrong password");
                break;
            case "email-doesn't-exist":
                res.status(403).send("You entered email doesn't exist please signup");
                break;
            case "wrong-email":
                res.status(403).send("You entered wrong email");
                break;
        }
    } else {
        console.log("Wrong way to enter the Email and Password")
        res.status(500).send("Error - Wrong way to enter the Email and Password");
    }
});

app.listen(3000);