/**
 * Created by doppler on 2016/5/19.
 */
function hello(){
    $("#email").val(hex_md5($("#email").val().trim()));
    //$("password").val(hex_md5(hex_md5($("#password").val().trim())));
    $("#password").val(hex_md5($("#password").val().trim()));
    $("#myForm").submit();
}
function deletePost(postId){
    if(confirm("Are you sure to delete post " + postId + "?")) {
        $.ajax({
            type : "delete",
            url  : "/admin/posts/" + postId,
            success : function(){
                window.location.href="/admin/posts";
            }
        });
    }
}
//function updatePost(postId){
//    alert(postId);
//    var title = $("#title").val();
//    var content = editor.getValue();
//    var postFormat = $("#postFormat").val();
//    var postStatus = $("#postStatus").val();
//
//    $.ajax({
//        type : "put",
//        url  : "/admin/posts/" + postId,
//        data :{
//                "title": title,
//                "content": content,
//                "postFormat": postFormat,
//                "postStatus": postStatus
//        },
//        success : function(){
//            window.location.href="/posts/" + postId;
//        }
//    });
//}