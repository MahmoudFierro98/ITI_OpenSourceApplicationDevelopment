#!/bin/bash
## Lab 1
## Author: Mahmoud Mohamed Kamal
## Date: 09-04-2022
##Exit codes
##		0: Success
##		1: Error - Didn't connect
##		2: Error - Missing parameter 
[ ${#} -ne 2 ] && exit 2
FILE1=${1}
FILE2=${2}
USER="fierro"
PASS="pasword1234@"
DB="bash1"
TABLE1="invoice"
 
QUERY1=$(awk 'BEGIN{
FS=":"
}{print "INSERT INTO bash1.invoice VALUES(" $1 ", \"" $2 "\", \"" $3 "\", " $4 "); "}' ${FILE1} )
QUERY2=$(awk 'BEGIN{
FS=":"
}{print "INSERT INTO bash1.Invoices_details VALUES(" $1 ", " $2 ", \"" $3 "\", " $4 ", " $5 "); "}' ${FILE2} )

mysql -u${USER} -p${PASS} -e "$QUERY1"
mysql -u${USER} -p${PASS} -e "$QUERY2"
exit 0

# mysql -u ${USR} -p${PASSWORD}  -e "CREATE TABLE IF NOT EXISTS ${DB}.${TABLE1}(invID int PRIMARY KEY,custname varchar(100), invdate date, invtotal float )";
# mysql -u ${USR} -p${PASSWORD}  -e "CREATE TABLE IF NOT EXISTS ${DB}.${TABLE2}(seq int PRIMARY KEY AUTO_INCREMENT,invID int REFERENCES ${DBNAME}.${T1}(invID), itemname varchar(50), unitprice int, quantity int)";

