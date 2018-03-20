/**
 * CONSTANTS
 */
const ALL_BOOKS_URL = "https://api.coinmarketcap.com/v1/ticker/?limit=24";

/**
 * ------------------
 * --- MAIN METHOD
 * ------------------
 */
$(document).ready(function () {
    showCrypto();
    searchForIsbn();
});

/**
 * ------------------
 * --- METHODS
 * ------------------
 */
function searchForIsbn() {
    $("#isbn-search-button").click(function () {
        alert("You want to search for a book with ISBN: " + $("#isbn-search-input").val());
    });
}

function showCrypto() {
    console.log("Calling backend!");
    $.getJSON(ALL_BOOKS_URL, function (data) {
        console.log("--> Great success!");
        console.log(data);
        data.forEach(function (item) {
            $("#injectable").append(VIEW.renderSingleItem(item), null);
        });
    })
        .done(function () {
            console.log("--> I'm done (successfully)");
        })
        .fail(function () {
            console.log("--> error!");
        })
        .always(function () {
            console.log("--> finalized...");
        });
}

/**
 * ------------------
 * --- VIEW
 * ------------------
 */
const VIEW = {
    renderSingleItem: (function (item) {
        return `<div class="col-lg-3">
                    <div class="card">
                      <div class="card-body">
                        <h4 class="card-title">${item.name}</h4>
                        <p class="card-text">Price in USD: ${item.price_usd}</p>
                      </div>
                    </div>
                </div>
            `
    })
};