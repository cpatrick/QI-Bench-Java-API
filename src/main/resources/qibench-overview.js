//
(function() {
    var delayInterval;

    function qibenchDelay() {
        // check to see if our element exists
        // if it does start the new processes and stop looking at intervals
        if (document.getElementById('qibench-api-overview') != null) {
            window.clearInterval(delayInterval);
            qibenchAddText();
        }
    }

    function qibenchAddText() {
        var a = document.getElementById('qibench-api-overview');
        var txtNode;
        txtNode = document.createTextNode("General Information shown with disclosure triangles will go here");
        a.setAttribute(
            'style',
            'position:relative;' +
                'top:1px;' +
                'left:1px;' +
                'margin:10px 0px 0px 10px;' +
                'background-color: beige;' +
                'max-width:500px;' +
                'padding: 2px 10px 2px 10px;' +
                'border: 1px solid #C0C0C0;' +
                'font: normal 10px/12px verdana;' +
                'color: #000;' +
                'text-align:left;' +
                'display: block;'
        );
        a.appendChild(txtNode);
        
    }

    delayInterval = window.setInterval(qibenchDelay, 500);

}).call(this);
