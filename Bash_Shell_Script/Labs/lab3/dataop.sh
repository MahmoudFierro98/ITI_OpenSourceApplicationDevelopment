#!/bin/bash
#### Author: Mahmoud Mohamed Kamal
#### Date: 15-04-2022
#### Exit Code:
##		0: Done
	
source checker.sh
function insertDataInToDB {
  local query_inv_master="INSERT INTO bash1.inv_master (inv_date, cust_name, inv_total) VALUES (\"$1\", \"$2\", $3);"
  mysql -u $USER -p$PASSWORD -e "$query_inv_master"
  #local id=$(mysql -u $USER -p$PASSWORD -BNe 'SELECT label FROM bash1.inv_master WHERE cust_name=\"$2\"')
  #local query_inv_detail="INSERT INTO bash1.inv_detail (inv_date, cust_name, inv_total) VALUES (\"$1\", \"$2\", $3);"
  #mysql -u $USER -p$PASSWORD -e "$query_inv_detail"
  checkConnect
}

function insertData {
  echo "Customer name : "
  read customer
  echo "Date : "
  read date
  echo "Total : "
  read total
  insertDataInToDB $date $customer $total
}

function deleteDataFromDB {
  local query_inv_detail="DELETE FROM bash1.inv_detail WHERE inv_id=$1;"
  local query_inv_master="DELETE FROM bash1.inv_master WHERE inv_id=$1;"
  mysql -u $USER -p$PASS -e "$sqlStatment_invoice_detail"
  mysql -u $USER -p$PASS -e "$sqlStatment_invoice_master"
  checkConnect
}

function deleteData {
  echo "ID: "
  read id
  deleteDataFromDB $id
}

function displayInvoices {
  local sqlStatment_invoice_detail="select * from DB_Bash.invoice_detail;"
  local sqlStatment_invoice_master="select * from DB_Bash.invoice_master;"
  mysql -u $USER -p$PASS -e "$sqlStatment_invoice_detail"
  mysql -u $USER -p$PASS -e "$sqlStatment_invoice_master"
  existCodeChecker
}


#insert() {
#  INV=$(awk '{print "insert into invoices.invoices values(" $1 ", \"" $2 "\", \"" $3 "\", " $4 ");"}' invoices.txt)
#  INVD=$(awk '{print "insert into invoices.invoice_details (invoice_id, item, price, quantity) values(" $1 ", \"" $2 "\", " $3 ", " $4 ");"}' invoice_details.txt)
#  mysql -u fierro -ppassword1234@ -e "$INV"
#  mysql -u fierro -ppassword1234@ -e "$INVD"
#  echo "Inserted"
#}

#delete() {
#  mysql -u fierro -ppassword1234@ -e "delete from invoices.invoice_details where invoice_id = $1"
#  mysql -u fierro -ppassword1234@ -e "delete from invoices.invoices where id = $1"
#  echo "Deleted"
#}

#display() {
#  mysql -u fierro -ppassword1234@ -e "select * from invoices.invoices, invoices.invoice_details where id = $1"
#}



####################################### INSERT DATA ##############################################

