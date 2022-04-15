/*
 * Node.js Lab 5 - Task 1 CRUD
 * Author: Mahmoud Mohamed Kamal
 * Date: 15-04-2022
 * File: routes/index_routese.js
 */

module.exports = (app) => {
    app.get('/', (req, res) => {
        res.send('Welcome')
    })
}