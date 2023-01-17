var count = 1;
$(".btn1").click(function () {
    count++;
    $(".count").val(count);
});

$(".btn2").click(function () {
    count--;
    $(".count").val(count);
});


$(function() {
			$("li").click(function(e) {
			  e.preventDefault();
			  $("li").removeClass("active");
			  $(this).addClass("active");
			});
		});