# -- coding: utf-8 --

from odoo import models, fields, api
from odoo.exceptions import ValidationError


class Package(models.Model):
    _name = 'my_module.package'
    _description = 'call log class'
    name = fields.Char()
    price = fields.Float()
    type = fields.Selection(selection=[('unit','Unit'),('flex','Flex')],default='unit')

class CallLog(models.Model):
    _name = 'my_module.call.log'
    _description = 'call log class'
    _rec_name= 'timestamp'
    customer  = fields.Many2one(comodel_name='res.partner',required=True)
    timestamp = fields.Datetime()
    from_number = fields.Char(string='From')
    to_number = fields.Char(string='To')
    duration =fields.Integer()
    price = fields.Float(compute='_compute_cost',store=True)
    usd_price=fields.Float(string='USD Price')
    notes = fields.Text()
    package_id = fields.Many2one(comodel_name='my_module.package')


    @api.depends("duration","package_id.price")
    def _compute_cost(self):
        for rec in self:
            rec.price = (rec.duration/60)*rec.package_id.price
    @api.constrains('duration' , 'package_id')
    def check_package_id(self):
        for rec in self:
            if not rec.package_id:
                raise ValidationError("please add package!")

    def compute_usd(self):
        for rec in self:
            rec.usd_price=rec.price*(1 / 18.5)

    @api.onchange("duration")
    def _onchange_duration(self):
        self.price = (self.duration / 60) * self.package_id.price
        print(self.price)


# class my_module(models.Model):
#     _name = 'my_module.my_module'
#     _description = 'my_module.my_module'

#     name = fields.Char()

#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100
