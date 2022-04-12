/*
 * Node.js Lab 3
 * Author: Mahmoud Mohamed Kamal
 * Date: 11-04-2022
 * File: ServerHandler.js
 */

let fs = require('fs');

function init(req) {
    console.log(req.method);
    if (req.url == '/' && req.method == 'GET') {
        response = 'home';
    } else {
        let request = req.url.split('/');
        if (request[1] == "sign-up" && req.method == 'POST') {
            response = "sign-up";
        } else if (request[1] == "login" && req.method == 'POST') {
            response = 'login';
        } else {
            response = "error";
        }
    }
    console.log(response);
    return response;
}

function signUp(req) {
    let request = req.split('/');
    let response = true;
    if ((request[2] != null) && (request[3] != null) && (request[4] == null) && (validateEmail(req))) {
        fs.appendFile('users.txt', `${request[2]}:${request[3]}\n`, (error) => {
            if (error) {
                throw error;
            }
            console.log("Add new user");
        });
    } else {
        console.log("Can't add new user (Wrong Email or You didn't Enter Email and Password or You entered extra parameter)");
        response = false;
    }
    return response;
}

function checkEmail(req) {
    let response = false;
    let emails = [];
    let request = req.split('/');
    const users = fs.readFileSync('users.txt', 'UTF-8');
    const data = users.split('\n');
    data.forEach((user) => {
        if (user.split(':')[0]) {
            emails.push(user.split(':')[0]);
        }
    });
    for (let i = 0; i < emails.length; i++) {
        if (emails[i] == request[2]) {
            console.log("Email exists");
            response = true;
            break;
        }
    }
    if (!response) {
        console.log("Email doesn't exist");
    }
    return response;
}

const validateEmail = (req) => {
    let request = req.split('/');
    let email = request[2];
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
};

function checkPassword(req) {
    let response = false;
    let passwords = [];
    let request = req.split('/');
    const users = fs.readFileSync('users.txt', 'UTF-8');
    const data = users.split('\n');
    data.forEach((user) => {
        if (user.split(':')[0]) {
            passwords.push(user.split(':')[1]);
        }
    });
    for (let i = 0; i < passwords.length; i++) {
        if (passwords[i] == `${request[3]}`) {
            console.log('Password exists');
            response = true;
            break;
        }
    }
    if (!response) {
        console.log('Wrong Password');
    }
    return response;
}

function login(req) {
    let request = req.split('/');
    if ((request[2] != null) && (request[3] != null) && (request[4] == null) && (validateEmail(req))) {
        if (checkEmail(req)) {
            if (checkPassword(req)) {
                return "ok";
            } else {
                return "wrong-password";
            }
        } else {
            return "email-doesn't-exist";
        }
    } else {
        console.log("Wrong Email or You didn't enter an Email or You entered extra parameter");
        return "wrong-email";
    }
}

module.exports = {
    init: init,
    signUp: signUp,
    checkEmail: checkEmail,
    checkPassword: checkPassword,
    login: login
}