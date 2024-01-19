const $arrows = $('.arrow');
const $naviTitle = $('.navi-title');
const $boardList = $('.board-list li');
const $inquiriesList = $('.inquiries-list li');

$boardList.hide();
$arrows.eq(1).css('transform', 'rotate(180deg)');

$naviTitle.eq(0).on('click', function() {
	const deg = $arrows[0].style.transform;
    $arrows.eq(0).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $boardList.slideToggle(300);
})

$naviTitle.eq(1).on('click', function() {
    const deg = $arrows[1].style.transform;
    $arrows.eq(1).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $inquiriesList.slideToggle(300);
})

$arrows.eq(0).on('click', function() {
    const deg = this.style.transform;
    $(this).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $boardList.slideToggle(300);
})

$arrows.eq(1).on('click', function() {
    const deg = this.style.transform;
    $(this).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $inquiriesList.slideToggle(300);
})