function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
}

function memberadd() {
	console.log("qiehuan方法执行了")
	$(".page-content").load('/add');
}
