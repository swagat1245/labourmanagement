console.log("this is script file")

const toggleSidebar = () =>{
    if($(".sidebar").is(":visible")){
//band karana hai
$(".sidebar").css("display", "none")
$(".content").css("margin-left","0%")
    }else{ 
//show karana hai
$(".sidebar").css("display", "block")
$(".content").css("margin-left","20%")
    }
}