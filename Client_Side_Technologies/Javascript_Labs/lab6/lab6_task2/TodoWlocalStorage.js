/*
    Lab 6 - Task 2 - Update your todo list to allow it to save the tasks to local storage
	Author: Mahmoud Mohamed Kamal
	Date:   02-02-2022
    File:   TodoWlocalStorage.js
*/
//append the close button to the list
function appendClose() {
    var myNodelist = document.getElementsByTagName("LI");
    for (var i = 0; i < myNodelist.length; i++) {
        var span = makeCloseButton();
        myNodelist[i].appendChild(span);
    }
}

//append the check button to the list
function appendCheck() {
    var myNodelist = document.getElementsByTagName("LI");
    for (var i = 0; i < myNodelist.length; i++) {
        var span = makeCheckButton();
        myNodelist[i].appendChild(span);
    }
}

function makeCloseButton() {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    return span;
}

function makeCheckButton() {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u2713");
    span.className = "check";
    span.appendChild(txt);
    return span;
}

///////////////////////////////////


var todoForm = document.getElementById("myDIV");
var todoInput = document.getElementById("myInput");
var todoItems = document.getElementById("myUL");

var todos = [];

function newElement() {
    addTodo(todoInput.value);
}

// function to add todo
function addTodo(item) {
    if (item !== "") {
        const todo = {
            id: Date.now(), //to help check and delete
            name: item,
            completed: false
        };

        todos.push(todo);
        addToLocalStorage(todos);
        todoInput.value = "";
    } else {
        alert("You must write something to add");
    }
}

function addToLocalStorage(todos) {
    localStorage.setItem('todos', JSON.stringify(todos));
    displayTodos(todos);

}

function getFromLocalStorage() {
    const reference = localStorage.getItem('todos');
    if (reference) {
        todos = JSON.parse(reference);
        displayTodos(todos);
    }
}

getFromLocalStorage();

function displayTodos(todos) {
    todoItems.innerHTML = "";

    todos.forEach(function (item) {
        const checked = item.completed ? 'checked' : null;

        var li = document.createElement('li');
        var inputValue = document.getElementById("myInput").value;
        var t = document.createTextNode(inputValue);

        li.setAttribute('data-key', item.id); //to check or delete

        if (item.completed === true) {
            li.classList.add('checked');
        }

        li.innerHTML = `${item.name}`;

        // finally add the <li> to the <ul>
        todoItems.append(li);

    });
    appendClose();
    appendCheck();
}

function deleteItem(id) {
    todos = todos.filter(function (item) {
        return item.id != id;
    });
    addToLocalStorage(todos);
}

function checkItem(id) {
    todos.forEach(function (item) {
        if (item.id == id) {
            item.completed = !item.completed;
        }
    });
    addToLocalStorage(todos);
}


todoItems.addEventListener('click', function (event) {
    // check if the event is on check button
    if (event.target.classList.contains('check')) {
        checkItem(event.target.parentElement.getAttribute('data-key'));
    }

    // check if that is a delete button
    if (event.target.classList.contains('close')) {
        deleteItem(event.target.parentElement.getAttribute('data-key'));
    }
});