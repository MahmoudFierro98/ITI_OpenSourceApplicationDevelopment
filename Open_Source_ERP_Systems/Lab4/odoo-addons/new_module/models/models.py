from odoo import models, fields, api


class CallLogInheritance(models.Model):
    _name = 'my_module.call.log'
    _inherit = 'my_module.call.log'
    _description = 'new call log'

    description = fields.Text()
