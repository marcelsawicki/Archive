window.addEventListener('load', startClock);
window.addEventListener('load', modyfikacja);

function startClock() {
    updateClock();
    setInterval("updateClock()", 1000);
}

function updateClock() {
    node = document.getElementById("clock");
    now = new Date();
    node.innerHTML = now.toLocaleString();
}
function modyfikacja() {
    node = document.getElementById("modyf");
    node.innerHTML = document.lastModified.toLocaleString();
}
//s.10 handler zdarzenia tam gdzie jest prze WPISAc
$('input#prze').click(function () {
    location.reload(true);
});