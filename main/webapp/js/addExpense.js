$('#addexpenseForm').on('submit', function (event) {
    event.preventDefault();
    let form = new FormData(this);
    $.ajax({
        url: "../AddExpenseServlet",
        type: 'POST',
        data: form,
        success: function (data, textStatus, jqXHR) {
            console.log(data)
            if (data.trim() === 'done') {
                swal({
                    title: "Expense Added Successfully !",
                    icon: "success",
                }).then((value) => {
                    window.location = "addExpense.jsp";
                });
            } else if (data.trim() === 'error') {
                swal({
                    title: "Failed To Add !",
                    icon: "error",
                }).then((value) => {
                    window.location = "addExpense.jsp";
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