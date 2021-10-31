$.get("/user", function (data) {
    $("#user").html(data.name);
    $(".unauthenticated").hide()
    $(".authenticated").show()

    localStorage.setItem('session', data.name);

    if (data.name !== null) {
        doOpen("../../index.html");
    } else {
        location.reload();
    }
});


function doOpen(url) {
    document.location.target = "_blank";
    document.location.href = url;
}