function boardCheck() {
	if (document.frm.name.value.length == 0) {
		alert("작성자를 입력하세요.");
		return false;
	}
	if (document.frm.pass.value.legth == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if (document.frm.title.value.legth == 0) {
		alert("제목을 입력하세요.");
		return false;
	}
	return true;
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}

function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를  입력하세요.");
		return false;
	}
	return true;
}

$(function() {
	$('#list').on("click", function() {
		loaction.href = "boardList.do"
	});

	$('#add').on("click", function(e) {
		e.preventDefalult;
		alert("야야야야");

		if (boardCheck() != true) {
			alert("조건에 맞지않습니다.");
		} else {
			var updateBoard = {
				name:$('#name').val(),
				pass:$('#pass').val(),
				email:$('#email').val(),
				title:$('#title').val(),
				content:$('#content').val()
			};
			
		}

		$.ajax({
			type : "post",
			url : "boardWrite.do",
			cache: false,
			data : JSON.stringify(updateBoard),
			complete : function(data) {
				alert(data.responseText);
				if (data.responseText == 1) {
					alert("수정이되었습니다.");
					window.location.href = "boardList.do";
				}
			}
		});

	});
});