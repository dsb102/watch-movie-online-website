// -----------------------------------------------------

// Xử lý chuyển động slide
let sliderImagess = document.querySelectorAll('.slide-item');
let arrowLeft = document.querySelector('.slide-item-btn-left');
let arrowRight = document.querySelector('.slide-item-btn-right');
let currentSlide = 0;

function reset() {
    for (let i = 0; i < sliderImagess.length; i++) {
        sliderImagess[i].style.display = 'none';
    }
}

function startSlide() {
    reset();
    sliderImagess[0].style.display = 'block';
}

// đặt slide 1 ban đầu
startSlide();

function slideLeft() {
    reset();
    sliderImagess[currentSlide - 1].style.display = 'block';
    currentSlide--;
}

function slideRight() {
    reset();
    sliderImagess[currentSlide + 1].style.display = 'block';
    currentSlide++;
}

arrowLeft.addEventListener('click', () => {
    if (currentSlide === 0) {
        currentSlide = sliderImagess.length;
    }
    slideLeft();

})

arrowRight.addEventListener('click', () => {
    if (currentSlide === sliderImagess.length - 1) {
        currentSlide = -1;
    }
    slideRight();
})

setInterval(() => {
    if (currentSlide === sliderImagess.length - 1) {
        currentSlide = -1;
    }
    slideRight();
}, 4000)

//--------------------------------------------------------


// -----------------------------------
// Xử lý chuyển động menu list

let listMenu = document.querySelectorAll('ul.root-menu > li > a');

function removeActive() {
    listMenu.forEach((e) => {
        e.classList.remove('menu-active');
    })
}

// removeActive();

function setActive() {
    listMenu.forEach( (e) => {
        e.addEventListener('click', () => {
            removeActive();
            e.classList.add('menu-active');
        })
    } )
}

setActive();

// -----------------------------------






// -------------------------------start
// Xử lý click next phim

const arrowRightFilms = document.querySelectorAll(".arrow-right");
// const arrowLeftFilms = document.querySelectorAll(".arrow-left");

const movieLists = document.querySelectorAll(".movie-list");


arrowRightFilms.forEach( (arrowRight, i) => {

    const itemNumber = movieLists[i].querySelectorAll(".movie-list-item-img").length
    let clickCounter = 0;
    arrowRight.addEventListener("click", () => {
        const numberFilmsOnPage = Math.floor(window.innerWidth/235);
        clickCounter++;

        if (itemNumber - (5 + clickCounter) + (5-numberFilmsOnPage)>=0) {
            //backtick js
            movieLists[i].style.transform = `translateX(${movieLists[i].computedStyleMap().get("transform")[0].x.value - 235}px)`;
        } else {
            movieLists[i].style.transform = "translateX(0)";
            clickCounter = 0;
        }

    })

    // console.log(movieLists[i].computedStyleMap().get("transform")[0].x.value);
    // console.log(movieLists[i].querySelectorAll(".movie-list-item-img").length);
    // console.log(Math.floor(window.innerWidth/235));
})

//----------------------------------end