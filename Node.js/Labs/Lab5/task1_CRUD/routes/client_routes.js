/*
 * Node.js Lab 5 - Task 1 CRUD
 * Author: Mahmoud Mohamed Kamal
 * Date: 15-04-2022
 * File: routes/client_routese.js
 */

const ClientsController = require('../controllers/clients_controller')

module.exports = (app) => {
    app.get('/api/clients', ClientsController.getAllClients)

    app.post('/api/clients', ClientsController.createNewClient)

    app.put('/api/clients/:id', ClientsController.editClient)

    app.delete('/api/clients/:id', ClientsController.deleteClient)

    app.get('/api/clients/:id', ClientsController.getClient)
}