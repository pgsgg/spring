/**
 * 
 */
/*
장바구니 넣기 
*/
function go_cart() {
    var qty = document.getElementById('quantity').value;

    if (qty == "") {
        alert("수량을 입력해 주세요.");
        document.getElementById('quantity').focus();
        return false;
    } else if (qty > 30) {
        alert("수량이 너무 큽니다.");
        document.getElementById('quantity').focus();
        return false;
    } else {
        var form = document.getElementById('theform');
        form.action = "cart_insert";
        form.submit();
    }
}

function go_cart_delete() {
    const query = 'input[name="cseq"]:checked';
    var len = document.querySelectorAll(query).length;
    console.log("len = " + len);

    if (len == 0) {
        alert("삭제할 항목을 선택해 주세요")
    } else {
        var form = document.getElementById('theform');
        form.action = "cart_delete";
        form.submit();
    }
}

function go_order_insert(){
    var form = document.getElementById('theform');
    form.action = "order_insert";
    form.submit();
}   