$("#saveBtn").click(function () {

    $.post("user/save", $("#editUserForm").serialize(), function (data) {
        window.location.reload();
    })


})