/*
 * Node.js Lab 5 - Task 1 CRUD
 * Author: Mahmoud Mohamed Kamal
 * Date: 15-04-2022
 * File: index.js
 */

const app = require("./app.js");

const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Running Server on port ${port}`)
});