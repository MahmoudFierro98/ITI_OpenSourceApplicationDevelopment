/*
 * Node.js Lab 1 - Task 2
 * Author: Mahmoud Mohamed Kamal
 * Date: 06-04-2022
 * File: task2.js
 */

module.exports = function getAge(name, birthYear) {
    if ((birthYear > 1930) && (birthYear < 2020)) {
        var currentDate = new Date();
        var currentYear = currentDate.getFullYear();
        var age = currentYear - birthYear;
        console.log(`Hello, ${name} and your Age now is: ${age}`);
    }
    else {
        console.log(`ERROR || ${birthYear} >= 2020`);
    }
};
