/*
 * Node.js Lab 3
 * Author: Mahmoud Mohamed Kamal
 * Date: 11-04-2022
 * File: lab3.js
 */

let http = require('http');
let fs = require('fs');
let sh = require('./ServerHandler');

http.createServer(function(req, res) {
    res.writeHead(200, { 'Content-Type': "text/html" });
    let response = sh.init(req);
    switch (response) {
        case 'home':
            let html = fs.readFileSync('./index.html', 'utf8');
            res.write(html);
            break;
        case 'sign-up':
            if (!sh.checkEmail(req.url)) {
                if (sh.signUp(req.url)) {
                    res.write('Add new user');
                } else {
                    res.write("Error - Can't add new user (Wrong Email or You didn't Enter Email and Password or You entered extra parameter)");
                }
            } else {
                res.write('Error - Email already exists');
            }
            break;
        case 'login':
            let loginResponse = sh.login(req.url)
            switch (loginResponse) {
                case "ok":
                    let user = req.url.split('/')[2];
                    let html = fs.readFileSync('./user.html', 'utf8');
                    html = html.replace('{user}', user);
                    res.write(html);
                    break;
                case "wrong-password":
                    res.writeHead(400, { 'Content-Type': "text/html" });
                    res.write("You entered wrong password ");
                    break;
                case "email-doesn't-exist":
                    res.writeHead(400, { 'Content-Type': "text/html" });
                    res.write("You entered email doesn't exist please signup");
                    break;
                case "wrong-email":
                    res.writeHead(400, { 'Content-Type': "text/html" });
                    res.write("You entered wrong email ");
                    break;
            }
            break;
        case 'error':
            res.writeHead(404, { 'Content-Type': "text/html" });
            res.write('404 NOT FOUND');
            break;
    }
    res.end()
}).listen(3000)