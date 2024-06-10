$('#editexpenseForm').on('submit', function (event) {
    event.preventDefault();
    let form = new FormData(this);
    $.ajax({
        url: "../EditExpenseServlet",
        type: 'POST',
        data: form,
        success: function (data, textStatus, jqXHR) {
            console.log(data)
            if (data.trim() === 'done') {
                swal({
                    title: "Expense Edited Successfully !",
                    icon: "success",
                }).then((value) => {
                    window.location = "viewExpense.jsp";
                });
            } else if (data.trim() === 'error') {
                swal({
                    title: "Failed To Edit !",
                    icon: "error",
                }).then((value) => {
                    window.location = "viewExpense.jsp";
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