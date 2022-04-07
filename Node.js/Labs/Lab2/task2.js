/*
 * Node.js Lab 2 - Task 2
 * Author: Mahmoud Mohamed Kamal
 * Date: 07-04-2022
 * File: task2.js
 */

const fs = require('fs');

/* How to read a file line by line using node.js?
HINT: Redline Module in Node.js allows the reading of input streamline by line. 
The given node.js code opens the file 'txtfile.txt' and returns the content line by line. */
const readline = require('readline');
const file = readline.createInterface({
    input: fs.createReadStream('txtfile.txt'),
    output: process.stdout,
    terminal: false
});
file.on('line', (line) => {
    console.log(line);
});
console.log("----------------------------");

/* Rename file from test.txt to info.txt */
function ls() {
    console.log("Files:");
    fs.readdirSync(__dirname).forEach(file => {
        console.log(file);
    });
}
ls();
fs.rename('test.txt', 'info.txt', () => {
    console.log("\nDone (Renamed)\n");
    ls();
});
console.log("----------------------------");

/* Remove file */
try {
    fs.unlinkSync("./txt.txt")
    console.log('file \nDone (Removed)\n');
} catch (err) {
    console.error(err)
}
console.log("----------------------------");

/* Read data from data.json file as sync */
let fileData = fs.readFileSync('./data.json', 'utf8');
console.log(JSON.parse(fileData));
console.log("\nDone (Synchronous)\n");
console.log("----------------------------");

/* Read data from data.json file as async */
var readfile = fs.createReadStream('./data.json', { encoding: 'utf8', highWaterMark: 32 * 1024 })
readfile.on('data', function(chunk) {
    console.log(JSON.parse(chunk))
})
console.log("\nDone (Asynchronous)\n");
console.log("----------------------------");

/* Write file inside file info.txt “hello iti” */
fs.writeFileSync('./info.txt', "Hello iti");
console.log("\nDone (Write)\n");
console.log("----------------------------");

/* Create directory */
fs.access('./DIR', (error) => {
    if (error) {
        fs.mkdir('./DIR', (error) => {
            if (error) {
                throw error;
            }
            console.log("\nDone (Directory is created)\n");
        });
    } else {
        console.log("\nERROR (Directory is already exist)\n");
    }
});
console.log("----------------------------");