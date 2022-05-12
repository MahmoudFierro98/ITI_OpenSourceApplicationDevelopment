# Angular - Lab 5
[iti-Angular-labs/Lab5](https://github.com/MahmoudFierro98/iti-Angular-labs/tree/main/Lab5)

![screen-gif](./Screenshots/Lab5.gif)

## Create new project "Lab5"
```
$ ng new Lab5
```
![alt text](./Screenshots/Lab5.PNG)

## Add bootstrap
```
$ npm i bootstrap
```

## Create Department and Student Models
```
$ ng g class _models/department --skip-tests
```
```
$ ng g class _models/student --skip-tests
```

## Create Department and Student Modules
```
$ ng g m department 
```
```
$ ng g m student 
```

## Create Department Components
```
$ ng g c department/departmentAdd --skip-tests
```
```
$ ng g c department/departmentList --skip-tests
```
```
$ ng g c department/departmentDetails --skip-tests
```
```
$ ng g c department/departmentEdit --skip-tests
```

## Create Student Components
```
$ ng g c student/studentAdd --skip-tests
```
```
$ ng g c student/studentList --skip-tests
```
```
$ ng g c student/studentDetails --skip-tests
```
```
$ ng g c student/studentEdit --skip-tests
```

## Create Department and Student Services
```
$ ng g s department --skip-tests 
```
```
$ ng g s student --skip-tests
```

## Create core Module and navbar Component in core
```
$ ng g m core 
``` 
```
$ ng g c core/navbar --skip-tests 
``` 

## Create about, contactus, home, login and register Components
```
$ ng g c about --skip-tests 
``` 
```
$ ng g c contactus --skip-tests 
``` 
```
$ ng g c home --skip-tests 
``` 
```
$ ng g c login --skip-tests 
``` 
```
$ ng g c register --skip-tests 
```

## Create authorized Guard
```
$ ng g g authorized --skip-tests 
``` 

## Run Server 
```
$ ng serve --o
``` 

## To fix this error in VSC terminal
![alt text](./Screenshots/Lab5_error.PNG)
[Stack Overflow](https://stackoverflow.com/questions/54776324/powershell-bug-execution-of-scripts-is-disabled-on-this-system)
```
$ Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope LocalMachine
```
```
$ Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
```
```
$ Get-ExecutionPolicy -List
```

## Authors
* LinkedIn - [Mahmoud Mohamed Kamal](https://www.linkedin.com/in/mahmoudfierro98)

<p align="right">(<a href="#top">Top</a>)</p>
