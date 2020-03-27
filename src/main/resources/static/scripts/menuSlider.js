	
	var openMenuBtn = document.getElementById('main_menu_button');
	var closeMenuBtn = document.getElementById('close_menu_button');
	var body = document.getElementById('main-body');
	var header = document.getElementById('nav-bar');
	var sideMenu = document.getElementById('side_menu');

function openSideMenu(){
		closeMenuBtn.style.transform='rotate(0deg)';
		openMenuBtn.style.transform='rotate(360deg)';
		sideMenu.style.width='300px';
		body.style.marginLeft='320px';	
		header.style.marginLeft='245px';
		header.style.width='85%';
	}
	
	
function closeSideMenu(){
		sideMenu.style.width='0%';
		closeMenuBtn.style.transform='rotate(360deg)';
		openMenuBtn.style.transform='rotate(0deg)';
		body.style.marginLeft='10px';
		header.style.marginLeft='0px';
		header.style.width='100%';
	}
	