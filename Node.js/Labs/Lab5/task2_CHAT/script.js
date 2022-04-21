/*
 * Node.js Lab 5 - Task 2 CHAT
 * Author: Mahmoud Mohamed Kamal
 * Date: 21-04-2022
 * File: script.js
 */

var chat_container = document.getElementsByClassName("chat_container")[0];
var joinDiv = `
        <div class="join">
          "{{username}}" has joined
        </div>`;
var leftDiv = `
      <div class="left">
        "{{username}}" has left
        </div>`;
var chatMessageDiv = `
        <div class="chat_message_div">
          <div class="user_name">{{username}} :</div>
          <div class="message_text">{{message}}</div>
        </div> `;

var socket = io.connect("localhost:3000");
socket.on("connected", (data) => {
    username = prompt("Username: ");
    socket.emit("join", username);
});

socket.on("identified", (newUser) => {
    let newJoinDiv = joinDiv.replace("{{username}}", newUser);
    chat_container.insertAdjacentHTML("beforeEnd", newJoinDiv);
});

const sendMessage = () => {
    let message = document.getElementsByClassName("message_field")[0].value;
    socket.emit("handleMessage", message);
    document.getElementsByClassName("message_field")[0].value = "";
};

socket.on("broadcastMessage", (username, message) => {
    let newchatMessageDiv = chatMessageDiv
        .replace("{{username}}", username)
        .replace("{{message}}", message);
    chat_container.insertAdjacentHTML("beforeEnd", newchatMessageDiv);
});

socket.on("userLeft", (username) => {
    let newLeftDiv = leftDiv.replace("{{username}}", username);
    chat_container.insertAdjacentHTML("beforeEnd", newLeftDiv);
});

document
    .getElementsByClassName("message_field")[0]
    .addEventListener("keypress", (e) => {
        if (event.keyCode == 13) {
            sendMessage();
        }
    });