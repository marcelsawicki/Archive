"use strict";
var Display = /** @class */ (function () {
    function Display(element) {
        this.element = element;
        this.element.innerHTML += "I have created new HTML object: ";
        this.element.innerHTML += "<br /> ";
        this.span = document.createElement('span');
        this.span.setAttribute("id", "dialog");
        this.element.appendChild(this.span);
        this.span.innerText = "span";
    }
    Display.prototype.Refresh = function (container) {
    };
    Display.prototype.Render = function () {
        var canvas = document.createElement("canvas");
        var ctx = canvas.getContext("2d");
        canvas.width = 512;
        canvas.height = 480;
        document.body.appendChild(canvas);
        if (ctx != null) {
            ctx.fillStyle = "rgb(20, 50, 250)";
            ctx.fillRect(0, 0, 150, 75);
        }
    };
    return Display;
}());
var MainPicture = /** @class */ (function () {
    function MainPicture(element) {
        this.element = element;
        this.image = document.createElement('img');
        this.image.setAttribute("src", "race3.jpg");
        this.image.setAttribute("id", "view");
        this.element.appendChild(this.image);
    }
    MainPicture.prototype.Render = function (imageName) {
        var view = document.getElementById('view');
        if (view != null) {
            view.setAttribute("src", imageName);
        }
    };
    return MainPicture;
}());
var Keyboard = /** @class */ (function () {
    function Keyboard() {
    }
    Keyboard.prototype.Push = function (e, mainPicture) {
        var message = document.getElementById('dialog');
        // left = 37
        // up = 38
        // right = 39
        // down = 40
        if (message != null) {
            if (e.which === 38) {
                message.innerHTML = "<h1>up pushed</h1><br />";
                mainPicture.Render("race2.jpg");
            }
            else if (e.which === 37) {
                message.innerHTML = "<h1>left pushed</h1><br />";
                mainPicture.Render("race.jpg");
            }
            else if (e.which === 39) {
                message.innerHTML = "<h1>right pushed</h1><br />";
                mainPicture.Render("tor.jpg");
            }
            else if (e.which === 40) {
                message.innerHTML = "<h1>down pushed</h1><br />";
                mainPicture.Render("samochod.jpg");
            }
            else {
                message.innerText = "something else pushed";
            }
        }
    };
    return Keyboard;
}());
// Main
window.onload = function () {
    var arrayMap = [[0, 4, 0], [5, 3, 0], [0, 2, 1]];
    var container = document.getElementById('mudmap');
    if (container != null) {
        var display = new Display(container);
        display.Refresh(container);
        display.Render();
        var mainPicture_1 = new MainPicture(container);
        window.onkeydown = function (ev) {
            var keyboard = new Keyboard();
            keyboard.Push(ev, mainPicture_1);
        };
    }
};
