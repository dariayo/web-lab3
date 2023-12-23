const Y = document.getElementById("point_coordinates:y");
const btn_clear = document.getElementById("point_coordinates:clear_button")
const btn_submit = document.getElementById("point_coordinates:submit_button");
const xSpan = document.getElementById('point_coordinates:XValue');
btn_submit.addEventListener('click', evt => {
    let x = xSpan.textContent.trim()
    let y = Y.value;
    if (checkY() && checkX() && checkR()) {
        createPoint(scaleR * x + Ox, (scaleR * y - Oy) * (-1), RValue);
    }

});
btn_clear.addEventListener('click', evt => {
    clearPoints();
})


function checkR() {
    return (RValue >= 2);
}

function checkX() {
    return (xSpan.textContent.trim() >= -5 && xSpan.textContent.trim() <= 5);
}

function checkY() {
    return (Y.value >= -5 && Y.value <= 5);
}



