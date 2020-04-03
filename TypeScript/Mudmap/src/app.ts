class Display {
    element: HTMLElement;
    span: HTMLElement;

    constructor(element: HTMLElement) {
        this.element = element;
        this.element.innerHTML += "I have created new HTML object: ";
        this.element.innerHTML += "<br /> ";
        this.span = document.createElement('span');
        this.span.setAttribute("id", "dialog");
        this.element.appendChild(this.span);
        this.span.innerText = "span";
    }

    Refresh(container: HTMLElement) {
    }

    Render()
    {
        let canvas = document.createElement("canvas");
        let ctx = canvas.getContext("2d");
        canvas.width = 512;
        canvas.height = 480;
        document.body.appendChild(canvas);
        if(ctx!=null)
        {
            ctx.fillStyle = "rgb(20, 50, 250)";
            ctx.fillRect(0, 0, 150, 75);
        }
    }

}

class MainPicture {
    element: HTMLElement;
    image: HTMLElement;

    constructor(element: HTMLElement)
    {
        this.element = element;
        this.image = document.createElement('img');
        this.image.setAttribute("src", "race3.jpg");
        this.image.setAttribute("id", "view");
        this.element.appendChild(this.image);
    }
    Render(imageName: string)
    {
        let view = document.getElementById('view');
        if(view!=null)
        {
            view.setAttribute("src",imageName);
        }
    }
}

class Keyboard {
    Push(e: KeyboardEvent, mainPicture: MainPicture)
    {
        let message = document.getElementById('dialog');

        // left = 37
        // up = 38
        // right = 39
        // down = 40

        if(message!=null)
        {
            if(e.which===38)
            {
                message.innerHTML="<h1>up pushed</h1><br />";
                mainPicture.Render("race2.jpg");
            }
            else if(e.which===37)
            {
                message.innerHTML="<h1>left pushed</h1><br />";
                mainPicture.Render("race.jpg");
            }
            else if(e.which===39)
            {
                message.innerHTML="<h1>right pushed</h1><br />";
                mainPicture.Render("tor.jpg");
            }
            else if(e.which===40)
            {
                message.innerHTML="<h1>down pushed</h1><br />";
                mainPicture.Render("samochod.jpg");
            }
            else
            {
                message.innerText="something else pushed";
            }
        }
       
    }

}

// Main
window.onload = () => {
    let arrayMap:number[][] = [[0,4,0],[5,3,0],[0,2,1]];
        let container = document.getElementById('mudmap');
        if(container!=null)
        {
            let display = new Display(container);
            display.Refresh(container);
            display.Render();

            let mainPicture = new MainPicture(container);

            window.onkeydown = (ev:KeyboardEvent) => {
                let keyboard = new Keyboard();
                keyboard.Push(ev, mainPicture);
              }
        }
  }

 