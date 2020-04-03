"use strict";
var MyClass = /** @class */ (function () {
    function MyClass() {
    }
    MyClass.prototype.render = function (divId, text) {
        var el = document.getElementById(divId);
        el.innerText = text;
    };
    return MyClass;
}());
window.onload = function () {
    var myClass = new MyClass();
    myClass.render("content", "Witaj świecie!");
};
