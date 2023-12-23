function clockTimer() {
    var canvas = document.createElement('canvas');
    canvas.width = 32;
    canvas.height = 32;
    var ctx = canvas.getContext('2d');

    ctx.fillStyle = 'transparent';
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    ctx.font = '20px serif';
    ctx.fillStyle = '#000000';
    var time1 = new Date().getSeconds().toString();
    ctx.fillText(time1, 0, 20);

    var link = document.querySelector("link[rel*='icon']") || document.createElement('link');
    link.type = 'image/x-icon';
    link.rel = 'shortcut icon';
    link.href = canvas.toDataURL("image/x-icon");

    document.getElementsByTagName('head')[0].appendChild(link);
    setInterval(clockTimer, 1000);
}


