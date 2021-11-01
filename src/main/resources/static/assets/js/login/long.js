$.get("/user", function (data) {
    $("#user").html(data.name);
    $(".unauthenticated").hide()
    $(".authenticated").show()

    if (data.name !== null) {
        localStorage.setItem('session', data.name);
        doOpen("../../index.html");
    } else {
        doOpen("../../html/login/login.html");
    }
});