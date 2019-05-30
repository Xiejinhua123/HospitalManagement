/**
 * 用于在上传之前图片预览
 * 
 * @param docId
 * 		需要获取的图片的文本框的id
 * @param ddId
 * 		需要显示的div的id
 * @param width
 * 		显示的图片的宽度
 * @param height
 * 		显示的图片的高度
 * @returns {Boolean}
 * 		是否成功的显示
 */
function setImagePreviews(docId, ddId, width, height) {

        var docObj = document.getElementById(docId);

        var dd = document.getElementById(ddId);

        var html = "";
        
        $(dd).html(html);

        var fileList = docObj.files;

            html += "<div style='float:left' > <img id='img" + docId + "' alt='没有显示？检查一下您的文件是否是图片格式的'  /> </div>";
            
            $(dd).html(html);
            
            var imgObjPreview = document.getElementById("img"+docId); 

            if (docObj.files && docObj.files[0]) {

                //火狐下，直接设img属性

                imgObjPreview.style.display = 'block';

                imgObjPreview.style.width = width;

                imgObjPreview.style.height = height;
                
                
                
                //imgObjPreview.src = docObj.files[0].getAsDataURL();

                //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式

                imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);

            }

            else {

                //IE下，使用滤镜

                docObj.select();

                var imgSrc = document.selection.createRange().text;

                var localImagId = document.getElementById("img" + docId);

                //必须设置初始大小

                localImagId.style.width = width;

                localImagId.style.height = height;

                //图片异常的捕捉，防止用户修改后缀来伪造图片

                try {

                    localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";

                    localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;

                }

                catch (e) {

                    return false;

                }

                imgObjPreview.style.display = 'none';

                document.selection.empty();
            }
        return true;
}