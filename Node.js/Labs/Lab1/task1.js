/*
 * Node.js Lab 1 - Task 1
 * Author: Mahmoud Mohamed Kamal
 * Date: 06-04-2022
 * File: task1.js
 */

function add(num1, num2) {
    if (isNaN(num1) && isNaN(num2))
        console.log(`ERROR || ${num1} & ${num2} are not numbers`);
    else if (isNaN(num1))
        console.log(`ERROR || ${num1} is not a number`);
    else if (isNaN(num2))
        console.log(`ERROR || ${num2} is not a number`);
    else
        console.log(num1 + num2);
}

function sub(num1, num2) {
    if (isNaN(num1) && isNaN(num2))
        console.log(`ERROR || ${num1} & ${num2} are not numbers`);
    else if (isNaN(num1))
        console.log(`ERROR || ${num1} is not a number`);
    else if (isNaN(num2))
        console.log(`ERROR || ${num2} is not a number`);
    else
        console.log(num1 - num2);
}

function multi(num1, num2) {
    if (isNaN(num1) && isNaN(num2))
        console.log(`ERROR || ${num1} & ${num2} are not numbers`);
    else if (isNaN(num1))
        console.log(`ERROR || ${num1} is not a number`);
    else if (isNaN(num2))
        console.log(`ERROR || ${num2} is not a number`);
    else
        console.log(num1 * num2);
}

module.exports = {
    add: add,
    sub: sub,
    multi: multi
}