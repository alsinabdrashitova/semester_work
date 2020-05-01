function validation() {
    let email = $("#login").val();
    let pass = $("#password").val();
    let pass2 = $("#passwordRepeat").val();

    console.log(pass);

    if (validEmail(email)) {
        if (validPassword(pass, 8, 20)) {
            if (validPassword2(pass, pass2)) {
                    return true;

            }
        }
    }
    return false;
}
function validEmail(email) {
    let m = /.+@.+\..+/;
    if (!email.value.match(m)) {
        document.getElementById('checkLogin').style.color = 'red';
        document.getElementById('checkLogin').innerHTML = 'Пожалуйста, введите корректный адрес почты';
        return false;
    }
    return true;
}

function validPassword(pass, min, max) {
    let len = pass.value.length;
    if (len > max) {
        document.getElementById('checkPassword').style.color = 'red';
        document.getElementById('checkPassword').innerHTML = 'Количество символов в строке не должно превышать ' + max;
        return false;
    } else if (len < min) {
        document.getElementById('checkPassword').style.color = 'red';
        document.getElementById('checkPassword').innerHTML = 'Количество символов должно превышать ' + min;
        return false;
    }
    return true;
}
function validPassword2(pass, pass2) {
    if (pass.value != pass2.value){
        document.getElementById('checkPasswordRepeat').style.color = 'red';
        document.getElementById('checkPasswordRepeat').innerHTML = 'Пароли не совпадают';
        return false;
    }
    return true;
}

function validSex(inlineRadioOptions) {
    for (let i = 0; i < inlineRadioOptions.length; i++) {
        if (inlineRadioOptions[i].type == "radio" && inlineRadioOptions[i].checked) {
            return true;
        }
    }
    document.getElementById('checkSex').style.color = 'red';
    document.getElementById('checkSex').innerHTML = 'Пожалуйста, выберите ваш пол';
    return false;
}

