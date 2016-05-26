
$(document).ready(function(){
    $('#fileinput').change(function (){
            //Get file
            var file = this.files[0];            
            var formData = new FormData();
            formData.append("table",file);
            
            //Send AJAX request
            var xhr = new XMLHttpRequest();
            xhr.open("POST","csv");
            xhr.send(formData,true);
            xhr.onload = function(e) {
                if (this.status === 200) {
                    var data = this.responseText;
                    var dataJson = JSON.parse(data);
                    var source = $('#answer').html();
                    var template = Handlebars.compile(source);
                    $('#content_placeholder').html(template(dataJson)).addClass("preview");
                    $("input[type='submit']").removeClass("hide");
                        
               }
            };
     });
});
