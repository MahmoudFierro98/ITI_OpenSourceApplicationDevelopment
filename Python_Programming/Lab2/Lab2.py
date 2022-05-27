'''
    Python Lab 2
    Author: Mahmoud Mohamed Kamal
    Date:   2022-05-25
'''

from datetime import datetime
import re
from stat import FILE_ATTRIBUTE_READONLY
import mysql.connector

class Person:
    def __init__(self, full_name, money, sleepMood, healthRate):
        self.full_name = full_name
        self.money = money
        self.sleepMood = sleepMood
        if healthRate in range(0, 100):
            self.healthRate = healthRate
        else:
            self.healthRate = 100

    def sleep(self, hours):
        if (hours == 7):
            self.sleepMood = "Happy"
        elif (hours < 7):
            self.sleepMood = "Tired"
        else:
            self.sleepMood = "Lazy"

    def eat(self, meals):
        if (meals == 3):
            self.healthRate = 100
        elif (meals == 2):
            self.healthRate = 75
        elif (meals == 1):
            self.healthRate = 50

    def buy(self, items):
        self.money -= (10*items)


class Employee(Person):
    __email_regex = re.compile(r'([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+')

    def __init__(self, id, full_name, money, sleepMood, healthRate, email, workMood, salary, is_manager):
        Person.__init__(self, full_name, money, sleepMood, healthRate)
        self.id = id
        if re.fullmatch(self.__email_regex, email):
            # print("Valid email")
            self.email = email
        else:
            self.email = "email@email.com"
            print("Invalid email you take this email: "+self.email)
        self.workMood = workMood
        if salary >= 1000:
            self.salary = salary
        else:
            self.salary = 1000
        self.is_manager = is_manager

    def sendEmail(self, sender, to, subject, body):
        now = datetime.now()
        dt_string = now.strftime("%d-%m-%Y_%H-%M-%S")
        file = open(dt_string, "w")
        file.write("From: " + sender + "\n")
        file.write("To: " + to + "\n")
        file.write("Subject: " + subject + "\n")
        file.write("Body: " + body + "\n")
        file.close

    def work(self, hours):
        if (hours == 8):
            self.workMood = "Happy"
        elif (hours > 8):
            self.workMood = "Tired"
        else:
            self.workMood = "Lazy"


class Office:
    def __init__(self, name, employees):
        try:
            self.__mydb = mysql.connector.connect(
                host="localhost",
                user=name,
                password="",
                database=employees
            )
            print("Connected")
            self.__cur = self.__mydb.cursor()
            self.__cur.execute('''CREATE TABLE IF NOT EXISTS Employees (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        full_name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        salary INT NOT NULL,
                        money INT NOT NULL,
                        sleepMood CHAR(20) NOT NULL,
                        workMood CHAR(20) NOT NULL,
                        healthRate CHAR(20) NOT NULL,
                        is_manager BOOLEAN NOT NULL DEFAULT FALSE
                        );''')
            self.__mydb.commit()
            self.connect = True
        except:
            print("Failed to Connect")
            self.connect = False

    def get_all_employees(self):
        self.__cur.execute('select * from Employees')
        rows = self.__cur.fetchall()
        for row in rows:
            if not(row[8]):
                print("#:", row[0],"| Name:", row[1], "| Email:", row[2], "| Salary:", row[3], "| Money:", row[4], "| Sleep Mood:", row[5], "| Work Mood:", row[6], "| Health Rate:", row[7], "| Manger:", row[8])
            else:
                print("#:", row[0],"| Name:", row[1], "| Email:", row[2], "| Money:", row[4], "| Sleep Mood:", row[5], "| Work Mood:", row[6], "| Health Rate:", row[7], "| Manger:", row[8])

    def get_employee(self, empId):
        self.__cur.execute(f'select * from Employees where id = {empId}')
        rows = self.__cur.fetchall()
        if rows:
            for row in rows:
                if not(row[8]):
                    print("#:", row[0],"| Name:", row[1], "| Email:", row[2], "| Salary:", row[3], "| Money:", row[4], "| Sleep Mood:", row[5], "| Work Mood:", row[6], "| Health Rate:", row[7], "| Manger:", row[8])
                else:
                    print("#:", row[0],"| Name:", row[1], "| Email:", row[2], "| Money:", row[4], "| Sleep Mood:", row[5],"| Work Mood:", row[6],  "| Health Rate:", row[7], "| Manger:", row[8])
                return row
        else:
            print("Error | Wrong ID")
            return "Error"

    def hire(self, Employee): 
        self.__cur.execute(f'''Insert into Employees(full_name, email, salary, money, sleepMood, workMood, healthRate, is_manager)
            values("{Employee.full_name}", "{Employee.email}", {Employee.salary}, {Employee.money}, "{Employee.sleepMood}", "{Employee.workMood}", {Employee.healthRate}, {Employee.is_manager})
            ''')
        self.__mydb.commit()
        print("Done")

    def fire(self, empId): 
        self.__cur.execute(f'delete from Employees where id = {empId}')
        self.__mydb.commit()
        print("Done")

    def edit(self, employee): 
        self.__cur.execute(f'''Update Employees set full_name = "{employee.full_name}", email = "{employee.email}", salary = {employee.salary}, money = {employee.money}, sleepMood = "{employee.sleepMood}", workMood = "{employee.workMood}", healthRate = {employee.healthRate}, is_manager = {employee.is_manager} where id = {employee.id}''')
        self.__mydb.commit()
        print("Done")

    def __del__(self):
        if self.connect:
            self.__mydb.close() 

def addEmployee():
    email_regex = re.compile(r'([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+')
    full_name = input("\n\nEnter Full Name: ")
    email = input("Enter Email: ")
    while not(email_regex.fullmatch(email)):
        print("Invalid Email")
        email = input("Enter Email: ")
    print("Valid Email")
    salary = int(input("Enter Salary: "))
    while salary < 1000:
        print("Invalid Salary | Must be greater than 1000")
        salary = int(input("Enter Salary: "))
    money = int(input("Enter Money: "))
    sleepMood = input("Enter Sleep Mood (Happy/Tired/Lazy): ")
    while sleepMood != "Happy" and sleepMood != "Tired" and sleepMood != "Lazy":
        print("Invalid Sleep Mood")
        sleepMood = input("Enter Sleep Mood (Happy/Tired/Lazy): ")
    healthRate = int(input("Enter Health Rate (0->100): "))
    while healthRate < 0 or healthRate > 100:
        print("Invalid Health Rate")
        healthRate = int(input("Enter Health Rate (0->100): "))
    workMood = input("Enter Work Mood (Happy/Tired/Lazy): ")
    while workMood != "Happy" and workMood != "Tired" and workMood != "Lazy":
        print("Invalid Work Mood")
        workMood = input("Enter Work Mood (Happy/Tired/Lazy): ")
    is_manager = input("Is Manager (True/False): ")
    while is_manager != "True" and is_manager != "False":
        print("Invalid Manager")
        is_manager = input("Is Manager (True/False): ")
    return Employee(0, full_name, money, sleepMood, healthRate, email, workMood, salary, is_manager)

def addAction(employee):
    emp = Employee(employee[0], employee[1], employee[4], employee[5], employee[7], employee[2], employee[6], employee[3], employee[8])
    print(''' Actions Menu:   
        1. Sleep
        2. Work
        3. Eat
        4. Buy
        5. Send Email
        6. Back
    ''')
    ip = input("Enter Action: ")
    if ip == "1":
        hours = int(input("Enter Hours: "))
        emp.sleep(hours)
    elif ip == "2":
        hours = int(input("Enter Hours: "))
        emp.work(hours)
    elif ip == "3":
        males = int(input("Enter Males: "))
        while males < 0 or males > 3:
            print("Males between 1 to 3")
            males = int(input("Enter Males: "))
        emp.eat(males)
    elif ip == "4":
        if emp.money < 10:
            print("You don't have enough money to buy anything")
        else:
            items = int(input("Enter no. of Items: "))
            emp.buy(items)
    elif ip == "5":
        to = input("To: ")
        subject = input("subject: ")
        body = input("body: ")
        emp.sendEmail(emp.email, to, subject, body)
    return emp

def start():
    office = Office('root', 'lab-python')
    if office.connect:
        while True:
            print(''' Main Menu:   
                1. Hire Employee
                2. Fire Employee
                3. Get All Employees
                4. Get Employee
                5. Exit
            ''')
            ip = int(input("Please enter your choice: "))
            if ip == 1:
                office.hire(addEmployee())
            elif ip == 2:
                empId = int(input("Enter Employee ID: "))
                office.fire(empId)
            elif ip == 3:
                office.get_all_employees()
            elif ip == 4:
                empId = int(input("Enter Employee ID: "))
                employee = office.get_employee(empId)
                if employee != "Error":
                    while True:
                        print('''
                        1. Actions Menu
                        2. Back
                        ''')
                        ip = int(input("Please enter your choice: "))
                        if ip == 1:
                            employee = addAction(employee)
                            office.edit(employee)
                            employee = office.get_employee(empId)
                        elif ip == 2:
                            break
            elif ip == 5:
                print("BYE, SEE YOU LATER")
                break

start()

#py -m pip install --user virtualenv