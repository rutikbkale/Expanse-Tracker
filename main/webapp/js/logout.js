function signout() {
    swal({
        title: 'Sign out?',
        text: 'Are you sure you want to sign out?',
        icon: 'warning',
        buttons: {
            cancel: {
                text: 'Cancel',
                value: null,
                visible: true,
                className: 'btn btn-danger',
                closeModal: true,
            },
            confirm: {
                text: 'Sign Out',
                value: true,
                visible: true,
                className: 'btn btn-primary',
                closeModal: true
            }
        }
    }).then((result) => {
        if (result) {
            window.location.href = '../' + 'index.jsp';
        }
    });
}
