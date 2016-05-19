/**
 * Created by doppler on 2016/5/19.
 */
function Hello($scope){
}
function hello(){
    var email = $("#email").val();
    var pwd = $("#password").val();
    $.ajax({
        type : "POST",
        url : "insert",
        data: {
            "email" : email,
            "pwd" : pwd
        },
        success : function(data){
            console.log(data);
        }
    });
}