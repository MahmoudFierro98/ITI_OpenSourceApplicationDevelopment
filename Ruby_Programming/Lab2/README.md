# Ruby Programming - Lab 2

- [Requirements](https://github.com/MahmoudFierro98/ITI_OpenSourceApplicationDevelopment/blob/main/Ruby_Programming/Lab2/lab2.pdf)

- lab2.rb
```
puts "User class"
class User 
    attr_accessor :name
    @@name='User'
    def initialize(name="User")
        @name = name
    end
    def self.name()
        @@name
    end    
    def changeName(new_name)
        @name=new_name
    end
    def setName(name)
        @name = name
    end
    def getName()
        @name
    end
end
user1= User. new
user2= User. new("Mahmoud")
p user1.name
p user2.name
p user1.getName
p user2.getName
print "----------\n\n"

puts "Math class"
class Maths
    @@result=nil
    def initialize(num1,num2,op)
        if(num1.is_a? Integer and num2.is_a? Integer)
            case op
            when "+"
                @@result=num1+num2
            when "-"
                @@result=num1-num2
            when "*"
                @@result=num1*num2
            when "/"
                if(num2!=0)
                    @@result=num1/num2
                else
                    p "Error Div by 0"
                end
            else
                p "Error Invalid Operation"
            end
        end
    end
    def ret_result
        @@result
    end
end
add = Maths.new(2, 3, "+")
p add.ret_result
sub = Maths.new(10, 2, "-")
p sub.ret_result
mul = Maths.new(5, 5, "*")
p mul.ret_result
div = Maths.new(9, 3, "/")
p div.ret_result
print "----------\n\n"

puts "Module"
module MyModule
    require 'date'
    class Person
        attr_accessor :fname, :lname, :bdate, :age
        def initialize()
            @fname=""
            @lname=""
            @bdate=Date.today
            @age=0
        end
        def getData
            puts "Enter first name: "
            @fname=gets.chomp
            puts "Enter last name: "
            @lname=gets.chomp
            puts "Enter BirthDay: "
            @bdate=Date.parse(gets.chomp)
            now=Time.now.utc.to_date
            @age = now.year - @bdate.year - (now.month > @bdate.month || (now.month == @bdate.month && now.day >= @bdate.day) ? 0 : 1)
        end
        def welcome
            puts "Welcome dear #@fname #@lname"
            now = Time.now.utc.to_date
            this_year_birthday = @bdate
            this_year_birthday = Date.parse("#{now.year}-#{@bdate.month}-#{@bdate.day}")
            days = (now - this_year_birthday).to_i
            if days < 0
            days += 365
            end
            months = (days/30).to_i
            puts "Your age is: #@age years, #{months} months and #{days%30} days"
        end
    end
end
person = MyModule::Person.new()
person.getData()
puts person.age
puts person.welcome()
print "----------\n\n"
```

- Output
```
ruby .\lab2.rb
```
```
User class
"User"
"Mahmoud"
"User"
"Mahmoud"
----------

Math class
5
8
25
3
----------

Module
Enter first name: 
Mahmoud
Enter last name: 
Kamal
Enter BirthDay: 
7-3-1998
24
Welcome, Mahmoud Kamal
Your age is: 24 years, 3 months and 26 days

----------
```

# Author
* LinkedIn - [Mahmoud Mohamed Kamal](https://www.linkedin.com/in/mahmoudfierro98)

<p align="right">(<a href="#top">Top</a>)</p>
