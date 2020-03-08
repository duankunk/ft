<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script src="js/wangEditor.min.js" type="text/javascript"></script>
<script type="text/javascript">
var a;
function up() {
	$('#file1').click();
	
}
function u() {
	 a =$('#file1').val();
	$('#attachment').val(a);
	
}
function na() {
	var s=a.substr(a.lastIndexOf('\\')+1);
	$('#attachmentname').val(s);
	
}
$(document).ready(function () {
    var time = new Date();
    var day = ("0" + time.getDate()).slice(-2);
    var month = ("0" + (time.getMonth() + 1)).slice(-2);
    var today = time.getFullYear() + "-" + (month) + "-" + (day);
    $('#releasetime').val(today);
})

setInterval("u()","1000");


</script>
</head>
<body>
<div id="controller">
		<table>
			<tr>
				<td colspan="4"  align=“center”><h1>产品管理</h1></td>
			</tr>
			<tr>
				<td colspan="2"><h4>管理导航：产品类别添加   产品信息管理</h4></td>
				<td colspan="2"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="添加产品内容"></td>
				<td colspan="3">产品类别 ：<select name="category"><option>请选择产品类别</option></select>关键字搜素<input type="text"><input type="subimt" value="搜索"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="中文产品列表"></td>
			</tr>
			<tr>
			    <td>选择语言：</td>
				<td colspan="3"><input type="radio" checked="checked">中文</td>
			</tr>
			<tr>
			    <td>产品分类：</td>
				<td>
					<select name="category" id="category">
						<option>YSL水费分析仪</option>
					</select></td>
				<td>发布日期：</td>
				<td><input type="date"  name="releasetime" id="releasetime"></td>
			</tr>
			<tr>
			    <td>产品名称：</td>
				<td><input type="text" name="name" id="name"></td>
				<td>附件名称：</td>
				<td><input type="text" name="attachmentname"id="attachmentname"  ></td>
			</tr>
			<tr>
			    <td>添加附件：</td>
				<td><input type="text" name="attachment" id="attachment" onclick="up()"></td>
				<td>&nbsp;</td>
				<td><input type="submit" value="删除"><input type="submit" value="复原" disabled="disabled"><input type="button" value="查看ssss" onclick="na();"></td>
			</tr>
			<tr>
			    <td>简要介绍：<p><p><font color="red">(不少于800个字)</font></td>
				<td><textarea rows="“50“" cols="”30“" name="productintroduce"id="productintroduce" style="margin: 0px; height: 250px; width: 502px;"></textarea></td>
				<td>添加图片：</td>
				<td><p><input type="submit" value="删除"><input type="submit" value="复原"></td>
			</tr>
			<tr>
			    <td colspan="4"><input type="file" id="file1" name="file" style="display: none;" ></td>
			</tr>
		</table>
		<div id="editor" >
		</div>
		<input type="submit" value="提交" onclick="ui()">
		<script type="text/javascript">
			// 创建wangEditor的对象
			var E = window.wangEditor;
			// 创建编辑的富文本编辑器对象
			var editor = new E("#editor");
			// 获得多行文本框
			var text = $("#text");
			// 让富文本框与多行文本框绑定在一起
			editor.customConfig.onchange=function(html){
				text.val(html);
			}
			editor.create();
			
			function ui() {
				var file1 = $('#file1')[0].files[0];
				var category = $.trim($('#category').val());
			    var name = $.trim($('#name').val());
			    var attachment = $('#attachment').val();
			    var releasetime = $('#releasetime').val();
			    var attachmentname = $('#attachmentname').val();
			    var productintroduce = $('#productintroduce').val();
			    var context = editor.txt.html();
			    
			    var formData = new FormData();
			
			    formData.append("category",category);
			    formData.append("name", name);
			    formData.append("attachment", attachment);
			    formData.append("releasetime", releasetime);
			    formData.append("attachmentname", attachmentname);
			    formData.append("productintroduce", productintroduce);
			    formData.append("context", context);
			    formData.append("file1", file1);
			    $.ajax({
			        url:'/upload',
			        type:'POST',
			        async: false,
			        data: formData,
			        processData : false, // 使数据不做处理
			        contentType : false, // 不要设置Content-Type请求头
			        success: function(data){
			            console.log(data);
			            if (data.status == 'ok') {
			                alert('上传成功！');
			            }
		
			        },
			        error:function(response){
			            console.log(response);
			        }
			    });
		}
		</script>
	</div>
</body>
</html>