#!/bin/bash
#### Author: Mahmoud Mohamed Kamal
#### Date: 15-04-2022
#### Exit Code:
##		0: Done
##		10: can not connect to database	

USER=fierro
PASS=pasword1234@
DB=bash1
TABLE1=inv_master
TABLE2=inv_detail

function checkDB {
  local query="create database if not exists ${DB};"
  mysql -u $USER -p$PASSWORD -e "$query"
  checkConnect
}

function createTables {
  local createTablesQuery="create table if not exists bash1.inv_master
                     (
                         inv_id int primary key auto_increment,
                         inv_date date,
                         cust_name varchar(100) unique,
                         inv_total float
                     );
                     create table if not exists bash1.inv_detail
                     (
                         Seq int primary key auto_increment,
                         inv_id int,
                         item_name varchar(50),
                         quantity int,
                         unit_price int,
                         FOREIGN KEY (inv_id) REFERENCES inv_master (inv_id)
                     );"
  mysql -u $USER -p$PASS -e "$createTablesQuery"
  checkConnect
}

function checkConnect {
  if [ $? -ne 0 ]; then
    return 10
  fi
  return 0
}


#checkDB() {
#  RESULT=`mysql -u fierro -ppassword1234@ --skip-column-names -e "show databases like '${DB}'"`
#  if [ $RESULT == '${DB}' ]; then
#    echo "Database exists"
#  else
#    echo "Database doesn't exist"
#  fi
#}

#checkTables() {
#  TABLE1=`mysql -u fierro -ppassword1234@ --skip-column-names -e "use invoices; show tables like 'invoices'"`
#  TABLE2=`mysql -u fierro -ppassword1234@ --skip-column-names -e "use invoices; show tables like 'invoice_details'"`
#  if [ $TABLE1 == 'invoices' ] && [ $TABLE2 == 'invoice_details' ]; then
#    echo "Tables exist"
#  else
#    echo "Tables don't exist"
#  fi
#}

#checkInvoice() {
#  RESULT=`mysql -u fierro -ppassword1234@ --skip-column-names -e "select * from invoices.invoices where id = $1"`
#  if [ -z "$RESULT" ]; then
#    echo "Not found"
#  else
#    echo $RESULT
#  fi
#}
