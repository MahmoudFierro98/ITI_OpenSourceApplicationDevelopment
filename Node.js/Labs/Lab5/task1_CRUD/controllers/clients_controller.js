/*
 * Node.js Lab 5 - Task 1 CRUD
 * Author: Mahmoud Mohamed Kamal
 * Date: 15-04-2022
 * File: controllrs/clients_controller.js
 */

const Client = require('../models/client')

module.exports = {
    getAllClients(req, res, next) {
        const limit = parseInt(req.query.limit) || ''
        Client.find({}).limit(limit)
            .then(clients => res.status(200).send(clients))
            .catch(next)
    },
    createNewClient(req, res, next) {
        const clientProps = req.body;
        Client.create(clientProps)
            .then(client => res.status(201).send(client))
            .catch(next)
    },
    editClient(req, res, next) {
        const clientId = req.params.id;
        const clientProps = req.body;
        Client.findByIdAndUpdate({ _id: clientId }, clientProps)
            .then(() => Client.findById({ _id: clientId }))
            .then(client => res.status(200).send(client))
            .catch(next)
    },
    deleteClient(req, res, next) {
        const clientId = req.params.id;
        Client.findByIdAndRemove({ _id: clientId })
            .then(client => res.status(204).send(client))
            .catch(next)
    },
    getClient(req, res, next) {
        const clientId = req.params.id;
        Client.findById({ _id: clientId })
            .then(client => res.status(200).send(client))
            .catch(next)
    }
}