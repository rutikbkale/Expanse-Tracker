$('#addexpenseForm').on('submit', function (event) {
    event.preventDefault();
    let form = new FormData(this);
    $.ajax({
        url: "AddExpenseServlet",
        type: 'POST',
        data: form,
        success: function (data, textStatus, jqXHR) {
            console.log(data)
            if (data.trim() === 'done') {
                swal({
                    title: "Successfully Login !",
                    icon: "success",
                }).then((value) => {
                    window.location = "User/dashboard.jsp";
                });
            } else if (data.trim() === 'error') {
                swal({
                    title: "Failed To Login !",
                    icon: "error",
                }).then((value) => {
                    window.location = "signin.jsp";
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