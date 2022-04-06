/*
 * Node.js Lab 1
 * Author: Mahmoud Mohamed Kamal
 * Date: 06-04-2022
 * File: app.js
 */

/* Task 1 */
var task1 = require('./task1');
/* add */
console.log("Task 1 - add");
task1.add(1, 2);
task1.add('a', 2);
task1.add(1, 'b');
task1.add('a', 'b');
console.log("-----------------------");

/* sub */
console.log("Task 1 - sub");
task1.sub(1, 2);
task1.sub('a', 2);
task1.sub(1, 'b');
task1.sub('a', 'b');
console.log("-----------------------");

/* multi */
console.log("Task 1 - multi");
task1.multi(1, 2);
task1.multi('a', 2);
task1.multi(1, 'b');
task1.multi('a', 'b');
console.log("-----------------------");

/* Task 2 */
var task2 = require('./task2');
console.log("Task 2 - Right");
task2("Mahmoud", 1998);
console.log("Task 2 - Error");
task2("Mahmoud", 2020);
console.log("-----------------------");