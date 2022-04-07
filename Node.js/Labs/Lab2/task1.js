/*
 * Node.js Lab 2 - Task 1
 * Author: Mahmoud Mohamed Kamal
 * Date: 07-04-2022
 * File: task1.js
 */

// function Emitter() {
//     this.events = {}
// }

// Emitter.prototype.on = function(type, listener) {
//     this.events[type] = this.events[type] || [];
//     this.events[type].push(listener)
// }

// Emitter.prototype.emit = function(type) {
//     if (this.events[type]) {
//         this.events[type].forEach(function(listener) {
//             listener()
//         })
//     }
// }

// module.exports = Emitter;

let emitter = require('events')
let util = require('util')

function emitterCopy() {
    emitter.call(this)

    this.greet = function() {
        console.log("Hello from the Function")
        this.emit('greet')
    }
}
util.inherits(emitterCopy, emitter)

module.exports = {
    emitter: emitterCopy
}

let em = require('./task1').emitter

let event = new em()

event.on('greet', function() {
    console.log("Hello from the Event")
})

event.greet()