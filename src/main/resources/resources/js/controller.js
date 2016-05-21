/**
 * Created by doppler on 2016/5/19.
 */
function hello(){
    $("#email").val(hex_md5($("#email").val().trim()));
    //$("password").val(hex_md5(hex_md5($("#password").val().trim())));
    $("#password").val(hex_md5($("#password").val().trim()));
    $("#myForm").submit();
}