/**
 * Created by doppler on 2016/5/19.
 */
function deletePost(postId,title){
    if(confirm("Are you sure to delete   " + title + "?")) {
        $.ajax({
            type : "delete",
            url  : "/admin/posts/" + postId,
            success : function(){
                window.location.href="/admin/posts";
            }
        });
    }
}
function deleteTag(hashtagId,tagName){
    if(confirm("Are you sure to delete tag : " + tagName + "?")) {
        $.ajax({
            type : "delete",
            url  : "/admin/hashtags/" + hashtagId,
            success : function(){
                window.location.href="/admin/hashtags";
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