/* La siguiente función se utiliza para visualizar la imagen seleccionada en la
 * página html donde se desea "cargar" utilizando un llamado "ajax"*/
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

const showEye = () => {
    const closeEye = document.querySelector(".eye");
    const password = document.querySelectorAll("#contrasena")[1];
    if (closeEye.classList.contains("fa-eye-slash")) {
        closeEye.classList.replace("fa-eye-slash", "fa-eye");
        password.setAttribute("type", "text");
    } else {
        closeEye.classList.replace("fa-eye", "fa-eye-slash");
        password.setAttribute("type", "password");
    }
}



