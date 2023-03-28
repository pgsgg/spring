/**
 * 약관 동의 여부
 */
function go_next() {
    if (document.formm.okon1[0].checked == true) {
        document.formm.action = "join_form"; //요청url
        document.formm.submit(); //Controller로 요청
    } else if (document.formm.okon1[1].checked == true) {
        alert("약관에 동의하셔야 합니다.");
    }
}

/*
* 사용자 ID 중복체크 화면 표시
*/

function idcheck() {
    if (document.getElementById('id').value == "") {
        alert("아이디를 입력해주세요.");
        document.getElementById('id').focus();
        return false;
    }

    //id 중복확인 화면 요청
    //url - Controller에 요청 url
    //_blank_ - 새로운 창을 띄우기
    var url = "id_check_form?id=" + document.getElementById('id').value;
    window.open(url, "_blank_", "toolbar=no", "menubar=no", "scrollbar=yes",
        "resizable=no", "width=100", "height=50");
}

function post_zip() {
    var url = "find_zip_num";
    window.open(url, "_blank_", "toolbar=no", "menubar=no", "scrollbar=yes",
        "resizable=yse");
    window.resizeTo(350,450);
}

function go_save() {
    if (document.getElementById('id').value == "") {
        alert("사용자 아이디를 입력해 주세요");
        document.getElementById('id').focus();
        return false;
    } else if (document.getElementById('reid').value == "") {
        alert("아이디 중복체크를 해 주세요");
        document.getElementById('reid').focus();
        return false;
    } else if (document.getElementById('pwd').value == "") {
        alert("비밀번호를 입력해 주세요");
        document.getElementById('pwd').focus();
        return false;
    } else if (document.getElementById('pwd').value != document.getElementById('pwdCheck').value) {
        alert("서로 다른 비밀번호 입니다.");
        document.getElementById('pwd').focus();
        return false;
    } else if (document.getElementById('name').value == "") {
        alert("이름을 입력해 주세요");
        document.getElementById('name').focus();
        return false;
    } else if (document.getElementById('email').value == "") {
        alert("이메일을 입력해 주세요");
        document.getElementById('email').focus();
        return false;
    } else {
        document.getElementById('join').action = "join";
        document.getElementById('join').submit();
    }


}

/*
* 아이디 비밀번호찾기
*/
function find_id_form() {
    var url = "find_id_form";
    window.open(url, "_blank_", "toolbar=no", "menubar=no", "scrollbar=yes",
        "resizable=yes");
    window.resizeTo(970,780);
}

function findMemberId() {
    if (document.getElementById('name').value == "") {
        alert("이름을 입력해주세요");
        document.getElementById('name').focus();
        return false;
    } else if (document.getElementById('email').value == "") {
        alert("이메일을 입력해주세요");
        document.getElementById('email').focus();
        return false;
    } else {
        var form = document.getElementById('findId');
        form.action = "find_id";
        form.submit();
    }
}

function findPassword() {
    if (document.getElementById('id2').value == "") {
        alert("아이디를 입력해주세요");
        document.getElementById('id2').focus();
        return false;
    } else if (document.getElementById('name2').value == "") {
        alert("이름을 입력해주세요");
        document.getElementById('name2').focus();
        return false;
    } else if (document.getElementById('email2').value == "") {
        alert("이메일을 입력해주세요");
        document.getElementById('email2').focus();
        return false;
    } else {
        var form = document.getElementById('findPW');
        form.action = "find_pwd";
        form.submit();
    }
}

function changePassword(){
    if(document.getElementById('pwd').value == ""){
        alert("비밀번호를 입력해주세요");
        document.getElementById('pwd').focus();
        return false;
    } else if(document.getElementById('pwd').value != document.getElementById('pwdcheck').value){
        alert("비밀번호가 서로 다릅니다");
        document.getElementById('pwdcheck').focus();
        return false;
    } else {
        var form = document.getElementById('pwd_form');
        form.action = "change_pwd";
        form.submit();
    }
}