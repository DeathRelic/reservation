$(function(){
	$path = getNavPath();
	switch ($path){
		case "index.action":
			$status="nav1";
			break;
		case "news_list.action":
			$status="nav2";
			break;
		case "reserve.action":
			$status="nav3";
			break;
		case "loginUrl.action":
			$status="nav4";
			break;
		}
	if ($("li[class='active']")!=null)
		if ($("li[class='active']").attr("id") != $status){
			$("li[class='active']").attr("class","") ;
			$("li[id="+$status+"]").attr("class","active");
		}
	else{
		$("li[id=$status]").attr("class","active");
	}
})