var loadFile = function(event) {
    var output = document.getElementById('demoImage');
    output.style.height="100px";
    output.style.width="100px";
    output.src = URL.createObjectURL(event.target.files[0]);

    console.log(event.target.files[0].type);
  };