/*
 * Node.js Lab 5 - Task 1 CRUD
 * Author: Mahmoud Mohamed Kamal
 * Date: 15-04-2022
 * File: models/client.js
 */

const mongoose = require('mongoose')
const Schema = mongoose.Schema;
const ClientSchema = new Schema({
    username: {
        type: String,
        required: [true, "Please enter your name"],
        minlength: 3,
        maxlength: 20,
        unique: true,
    },
    email: {
        type: String,
        required: [true, "Please enter your email"],
        match: [
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/, ,
            "Please enter a valid email",
        ],
    },
    firstname: {
        type: String,
        minlength: 3,
        maxlength: 20,
    },
    lastname: {
        type: String,
        minlength: 3,
        maxlength: 20,
    },
    phone: {
        type: String,
        maxlength: 15,
    },
});
const Client = mongoose.model('client', ClientSchema);
module.exports = Client;