/*
 * Node.js Lab 4 (express)
 * Author: Mahmoud Mohamed Kamal
 * Date: 14-04-2022
 * File: ServerHandler.js
 */

let fs = require('fs');

function signUp(email, password, username) {
    let response = true;
    if (validateEmail(email)) {
        var users = JSON.parse(fs.readFileSync("users.json").toString());
        users[email] = { password, username };

        try {
            fs.writeFileSync("users.json", JSON.stringify(users));
            console.log("Add new user");
        } catch (error) {
            console.log(error);
        }
    } else {
        console.log("Can't add new user (Wrong Email)");
        response = false;
    }
    return response;
}

function checkEmail(email) {
    let response = false;
    if (!fs.existsSync("users.json")) {
        fs.writeFileSync("users.json", "{}");
    }
    const users = JSON.parse(fs.readFileSync("users.json"));
    if (!users[email]) {
        console.log("Email doesn't exist");
    } else {
        console.log("Email exists");
        response = true;
    }
    return response;
}

const validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
};

function checkPassword(email, password) {
    let response = false;
    const users = JSON.parse(fs.readFileSync("users.json"));
    if (users[email].password === password) {
        console.log('Password exists');
        response = true;
    } else {
        console.log('Wrong Password');
    }
    return response;
}

function login(email, password) {
    if (validateEmail(email)) {
        if (checkEmail(email)) {
            if (checkPassword(email, password)) {
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
    signUp: signUp,
    checkEmail: checkEmail,
    checkPassword: checkPassword,
    login: login
}