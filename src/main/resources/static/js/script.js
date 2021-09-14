/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#sendMail").on("submit",function(event){
        event.preventDefault();
        var f = $(this).serialize();
        $.ajax({
            url: "/sendMail",
            data: f,
            method: "post",
            success: function(data){
                if(data.trim()==="done") {
                    $("#status").show();
                    $("#status").removeClass("text-danger");
                    $("#status").addClass("text-success");
                    $("#status").html("Mail send Successfully.");
                } else {
                    $("#status").show();
                    $("#status").removeClass("text-success");
                    $("#status").addClass("text-danger");
                    $("#status").html("Something went wrong!");
                }
            },
            error: function(){
                alert("Something went wrong! Please try again later.");
            }
        });
    });
});