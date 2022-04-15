/*
 * Node.js Lab 5 - Task 1 CRUD
 * Author: Mahmoud Mohamed Kamal
 * Date: 15-04-2022
 * File: database/connectDB.js
 */

const mongoose = require("mongoose");

const connectDB = (uri) => {
    return mongoose.connect(uri, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
    });
};

module.exports = connectDB;