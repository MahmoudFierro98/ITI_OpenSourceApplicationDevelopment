#!/bin/bash
#### Author: Mahmoud Mohamed Kamal
#### Date: 12-04-2022
#### Exit Code:
##		0: Done

PASSWORD="07031998"
sshpass -p "$PASSWORD" ssh-copy-id -i ~/.ssh/id_rsa.pub fierro98@192.168.187.134
echo $PASSWORD | ssh -t fierro98@192.168.187.134 "sudo -S apt install apache2 -y"
exit 0
