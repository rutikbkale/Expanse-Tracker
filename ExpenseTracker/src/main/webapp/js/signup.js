$('#signupForm').on('submit', function (event) {
    event.preventDefault();
    let form = new FormData(this);
    $.ajax({
        url: "SignUpServlet",
        type: 'POST',
        data: form,
        success: function (data, textStatus, jqXHR) {
            console.log(data)
            if (data.trim() === 'done') {
                swal({
                    title: "Successfully Registered !",
                    icon: "success",
                }).then((value) => {
                    window.location = "signin.jsp";
                });
            } else if (data.trim() === 'error') {
                swal({
                    title: "Failed To Register !",
                    icon: "error",
                }).then((value) => {
                    window.location = "signup.jsp";
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            swal({
                title: "Error Occurred!",
                text: "Please try again later.",
                icon: "error"
            });
        },
        processData: false,
        contentType: false

    });
});
