/*
 * Node.js Lab 5 - Task 2 CHAT
 * Author: Mahmoud Mohamed Kamal
 * Date: 21-04-2022
 * File: app.js
 */

const PORT = 3000;

var express = require("express");
var app = new express();

var http = require("http").createServer(app);
var io = require("socket.io")(http);

http.listen(PORT);

app.get("/", (req, res) => {
    res.sendFile(__dirname + "/index.html");
});

var userId = 0;

io.on("connect", (client) => {
    client.emit("connected");
    var newUser = "";

    client.on("join", (username) => {
        userId += 1;
        newUser = username ? username : `User${userId}`;
        client.broadcast.emit("identified", newUser);
        client.emit("welcome", newUser);
    });

    client.on("handleMessage", (message) => {
        client.broadcast.emit("broadcastMessage", newUser, message);
        client.emit("broadcastMessage", "You", message);
    });

    client.on("disconnect", () => {
        io.emit("userLeft", newUser);
    });
});