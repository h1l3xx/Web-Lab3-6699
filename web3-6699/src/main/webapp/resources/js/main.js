
class FormValues {
    x = 0
    y = 0
    r = 0
    click = false;

    setX(x){
        this.x = Number(x)
        console.log(this.x)
    }
    setY(){
        if (!form.click){
            form.click = false;
            const cur = document.getElementById("choose-form:y-select").value
            console.log(cur)
            this.y = Number(cur)
        }
    }
    setR(){
        const cur = document.getElementById("choose-form:r-select_input").value.replace(",", ".")
        console.log(cur)
        canvas.drawGraph(Number(cur))
        this.r = Number(cur)
    }

    getValues(){
        console.log(this.x, this.y, this.r);
    }
}

const form = new FormValues();



const canvas = new Canvas();

canvas.drawGraph(3);

function draw(){
    if (form.click){
        const x = form.x;
        const y = form.y;
        const r = form.r
        console.log(x, y, r, validate(x, y, r))

        canvas.drawDot(x, y, r, validate(x, y, r));
    }
}

const click_canvas = document.getElementById("graph")
click_canvas.addEventListener("click", ev => {
    const xOffset = ev.offsetX;
    const yOffset = ev.offsetY;
    const r = document.getElementById("choose-form:r-select_input").value.replace(",", ".")

    const x = (xOffset - 250)/(50)
    const y = (yOffset - 250)*(-1)/(50)

    form.click = true
    form.x = x;
    form.y = y;
    form.r = r

    document.getElementById("choose-form:input-hidden-x").value = x;
    document.getElementById("choose-form:input-hidden-y").value = y;
    document.getElementById("choose-form:input-hidden-r").value = r;

    document.getElementById("choose-form:submit-button").click();
})









function validate(x, y, r){
    if (x>=0 && y>=0){
        return x * x + y * y <= r * r;
    }else if (x<=0 && y<=0){
        return Math.abs(x) <= r && Math.abs(y) <= r
    }else if (x>=0 && y<=0){
        return x - r - y <= 0;
    }else{
        return false;
    }
}



