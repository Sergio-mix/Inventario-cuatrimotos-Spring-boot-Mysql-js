$.get("/user", function (data) {
    $("#user").html(data.name);
    $(".unauthenticated").hide()
    $(".authenticated").show()

    localStorage.setItem('session', data.name);

    if (data.name !== null) {
        doOpen("../../index.html");
    } else {
        doOpen("../../html/login/login.html");
    }
});