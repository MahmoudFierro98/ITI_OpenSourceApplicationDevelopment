# Ruby Programming - Lab 1

- [Requirements](https://github.com/MahmoudFierro98/ITI_OpenSourceApplicationDevelopment/blob/main/Ruby_Programming/Lab1/lab_1.pdf)

- lab1.rb
```
puts "Problem1"
def problem1(n,ch)
    for i in 1..n
        puts ch*i
    end
end
problem1(5,'a')
print "----------\n\n"

puts "Problem2"
def problem2(str)
    if str.start_with?("if") 
        puts true
    else
        puts false
    end
end
problem2('if y')
problem2('y')
print "----------\n\n"

puts "Problem3"
def problem3(str)
    puts str[-1] << str[1...-1]  << str [0]
end 
problem3('Pyton')
problem3('Java')
print "----------\n\n"

puts "Problem4"
def problem4(str)
    last_ch= str.length()-1 
    print  str.split('')[last_ch] + str + str.split('')[last_ch], "\n"
end 
problem4('abc')
print "----------\n\n"

puts "Problem5"
def problem5(year)
    if((year%4)==0)
        if((year%100 !=0))
            return "#{year} is leap year"
        elsif((year%400) ==0)
            return "#{year} is leap year"
        end
    end
    return "#{year} is not leap year" 
end
puts problem5(2012) 
puts problem5(1500) 
puts problem5(1600) 
puts problem5(2020)
print "----------\n\n"

puts "Problem6"
def problem6(nums)
    return rotated = [nums[1], nums[2], nums[0]]
end
p problem6([1,2,5])
print "----------\n\n"

puts "Problem7"
def problem7(nums)
    sum = 0
    i = 0
    while i < nums.length
        if(nums[i] == 17)
            i += 1
        else
            sum += nums[i]
        end
        i += 1
    end
    return sum
end
p problem7([3, 5, 1, 17, 6])
print "----------\n\n"

puts "Problem8"
def problem8(nums, target)
    for i in 0..nums.length-2
        for j in i+1..nums.length-1
            if ((nums[i]+nums[j]) == target)
                return [i,j]
            end
        end
    end
    return -1
end
p problem8([3,2,4],7)
print "----------\n\n"

puts "Problem9"
def problem9(s)
    n=-1
    while s.length != n
        n=s.length
        s=s.sub('()','')
        s=s.sub('[]','')
        s=s.sub('{}','')
        if s.length==0
            return 'Yes'
        end
    end
    return 'NO'
end
puts problem9("{[()]}")
puts problem9("{[(])}")
puts problem9("{{[[(())]]}}")
print "----------\n\n"
```

- Output
```
ruby .\lab1.rb
```
```
Problem1
a
aa
aaa
aaaa
aaaaa
----------

Problem2
true
false
----------

Problem3
nytoP
aavJ
----------

Problem4
cabcc
----------

Problem5
2012 is leap year
1500 is not leap year
1600 is leap year
2020 is leap year
----------

Problem6
[2, 5, 1]
----------

Problem7
9
----------

Problem8
[0, 2]
----------

Problem9
Yes
NO
Yes
----------
```

# Author
* LinkedIn - [Mahmoud Mohamed Kamal](https://www.linkedin.com/in/mahmoudfierro98)

<p align="right">(<a href="#top">Top</a>)</p>
