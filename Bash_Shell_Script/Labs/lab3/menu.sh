#!/bin/bash
#### Author: Mahmoud Mohamed Kamal
#### Date: 15-04-2022
#### Exit Code:
##		0: Done
##		1: Wrong option	

source dataop.sh

function menu {
    echo -ne "
MAIN MENU
1- Insert Invoices
2- Delete Invoices
3- Display Invoices
4- Exit
Choose an option:  "
    read -r ans
    case $ans in
    1)
        insertDataInToDB
        menu
        ;;
    2)
        deleteDataFromDB
        menu
        ;;
    3)
        displayInvoices
        menu
        ;;
    4)
        echo "Bye bye."
        exit 0
        ;;
    *)
        echo "Wrong option."
        exit 1
        ;;
    esac
}

#menu(){
#    select op in Insert Delete Display Exit
#    do
#    case $op in
#        "Insert")
#             insert;;
#
#        "Delete")
#             read -r delete_id
#             delete $delete_id;;
#
#        "Display")
#             read -r id
#             display $id;;
#
#        "Exit")
#             exit 0;;
#        *)
#        echo "Error";;
#    esac
#    done
#}



