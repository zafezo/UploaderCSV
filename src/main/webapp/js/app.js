
$(document).ready(function(){


var booladduser;
    var updateid;


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

    $(".deletebutton").bind("click", (function(event) {

        var buttonIndex=$(".deletebutton").index(this);// user ids //same order to database

        var userId=$(".userid").eq(buttonIndex).text();

        // var deleterow=$(".edituser");
        //
        // $(deleterow[buttonIndex]).deleteRow();



        $.ajax({
            url:"admincontr",
            type:"GET",
            dataType:'json',
            data:{userid: userId}
        });
        $(this).closest( 'tr').remove();
}));




    
    $(".agree").bind("click", function (event) {

        var firstname=$(".inpfirs").val();
        var lastname=$(".inplast").val();
        var email=$(".inpemail").val();
        var gender=$(".gender").val();

        if(booladduser) {
            alert("fack add");
                    $.ajax({  //add new user
                url: "admincontr",
                type: "GET",
                dataType: 'json',
                data: { firstname: firstname, lastname: lastname, email: email, gender: gender}
            });
        }
        else{
            alert("fack update");
            $.ajax({ //update user
                url: "admincontr",
                type: "GET",
                dataType: 'json',
                data: {updateid: updateid, firstname: firstname, lastname: lastname, email: email, gender: gender}
            });
        }

        setTimeout(window.location.reload(), 600);


    });

    $(".adduser").bind("click", (function(event) {
        var buttonIndex = $(".editbutton").index(this);// user ids //same order to database
        booladduser=true;

        $('#modal1').openModal();

    }));

        $(".editbutton").bind("click", (function(event) {
            var buttonIndex=$(".editbutton").index(this);// user ids //same order to database
            booladduser=false;
            $('#modal1').openModal();

            var useritem=$(".useritems").eq(buttonIndex);


            var tdarray=$(useritem).find('td');

            var editusertd=$(".edituser").find('td');


            updateid=$(tdarray[0]).text();
            $(".inputid").text(updateid);


            var i;
            for(i=1; i<tdarray.length-2; i++){
                var elementTd=$(tdarray[i]);

                var text=elementTd.text();
                var temptd=$(editusertd[i]);
                var inputvalue=$(temptd).find('input');

                inputvalue.attr("placeholder", text);

            }





        }));


    $(".cancel").bind("click", function () {
        $('#modal1').closeModal();

    })






    // $(".confirmbutton").one("click", (function(event) {
    //     var buttonIndex=$(".c").index(this);// user ids //same order to database
    //
    //     var useritem=$(".useritems").eq(buttonIndex);
    //
    //
    //     var tdarray=$(useritem).find('td');
    //
    //     var userinfo=[];
    //
    //     var i;
    //     for(i=1; i<tdarray.length-2; i++){
    //         var elementTd=$(tdarray[i]);
    //         var input=elementTd.find("input");
    //         userinfo.push(input.val());
    //     }
    //
    //     alert(userinfo);
    //
    //     var exept=$(tdarray[tdarray.length-1]);
    //
    //     var firstname=$(".firstname").eq(buttonIndex);
    //
    //     var last=$(".lastname").eq(buttonIndex);
    //
    //
    //
    // }));

    
});
