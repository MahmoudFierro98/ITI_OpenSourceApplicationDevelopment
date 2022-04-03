/*
 * JavaScript Libraries jQuery Lab
 * Author: Mahmoud Mohamed Kamal
 * Date: 03-04-2022
 * File: js/script.js
 */

let cart = []
let flag = []

function addImage(event) {
    return `<img src='${event.target.src}' class='item-image'/>`;
}

function start() {
    $(() => {
        for (let item of items) {
            const newItem = $(".item.hidden").clone()
            newItem.removeClass('hidden').appendTo(".menu").children(".item-name").html(`${item.name}`)
            newItem.children(".item-price").html(`${item.price}`)
            newItem.children(".item-image").attr("src", item.imagsrc)

            $("body").children(".container").children(".menu").children(".item").children(".item-image").draggable({
                stop: function(event, ui) {
                    console.log(ui.position.left)
                    if (ui.position.left > 650) {
                        addToCart($(this).siblings(".selectBtn"))
                        calculateBill();
                    }
                },
                helper: addImage,
                containment: ".container"
            });
        }
    })
}

$(() => {
    $("body").on("click", ".selectBtn", function() {
        addToCart($(this))
        calculateBill();
    })
    $("body").on("click", "#plus", function() {
        increaseAmount($(this))
    })
    $("body").on("click", "#minus", function() {
        decreaseAmount($(this))
    })
    $("body").on("click", ".removeBtn", function() {
        removeFromCart($(this))
    })
})

function addToCart(e) {
    $(() => {
        let cartNewItem = $(".cart-add-item.hidden-cart").clone();
        cartNewItem.removeClass('hidden-cart');
        let purshedItem = e.parents(".item").clone();
        purshedItem.children(".selectBtn").remove();
        let itemName = purshedItem.children(".item-name").html();
        let itemPrice = purshedItem.children(".item-price").html();
        let itemAmount = 1
        let item = {
            name: itemName,
            price: itemPrice,
            amount: itemAmount
        }
        if (!flag.includes(itemName)) {
            $(cartNewItem).appendTo(purshedItem)
            purshedItem.appendTo(".cart")
            $("body").children(".container").children(".cart").children(".item").children(".item-image").draggable({
                stop: function(event, ui) {
                    console.log(ui.position.left)
                    if (ui.position.left < 650) {
                        removeFromCart($(this).siblings(".cart-add-item").children(".removeBtn"))
                        calculateBill();
                    }
                },
                helper: addImage,
                containment: ".container"
            });
            cart.push(item);
            flag.push(itemName);
            calculateBill();
        }
    })

}

function increaseAmount(e) {
    $(() => {
        let name = e.parent("div").siblings(".item-name").html();
        let amount = Number(e.siblings(".quantatiy.value").html());
        for (let i = 0; i < cart.length; i++) {
            if (cart[i].name == name && cart[i].amount == amount) {
                cart[i].amount++;
                break;
            }
        }
        amount++;
        e.siblings(".quantatiy.value").html(amount);
    })
    calculateBill();
}

function decreaseAmount(e) {
    $(() => {
        let name = e.parent("div").siblings(".item-name").html()
        let amount = Number(e.siblings(".quantatiy.value").html())
        if (amount > 1) {

            for (let i = 0; i < cart.length; i++) {
                if (cart[i].name == name && cart[i].amount == amount) {
                    cart[i].amount--
                        break
                }
            }
            amount--
            e.siblings(".quantatiy.value").html(amount)
        }
    })
    calculateBill()
}

function removeFromCart(e) {
    $(() => {
        let name = e.parent("div").siblings(".item-name").html()
        let amount = Number(e.siblings(".quantatiy.value").html())
        e.parent("div").parent(".item").remove()
        for (let i = 0; i < cart.length; i++) {
            if (cart[i].name == name && cart[i].amount == amount) {
                if (i > -1) {
                    cart.splice(i, 1);
                }
                break
            }
        }
        console.log(name);
        const id = flag.indexOf(name);
        flag.splice(id, 1);
    })
    calculateBill()
}

function calculateBill() {
    $(() => {
        let total = 0
        cart.forEach(item => {
            total += (item.price * item.amount)
        });
        delivery = total ? 15 : 0;
        $(".bill").children("#total").html(total + " LE")
        $(".bill").children("#delivery").html(delivery + " LE")
        $(".bill").children("#VAT").html(total * (14 / 100) + " LE")
        $(".bill").children("#order-total").html(((total * 1.14) + delivery) + " LE")
    })
}

start()