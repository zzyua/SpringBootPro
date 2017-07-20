$(function(){

	/**
	 * 原来使用 custom.js中的格式
	 */
	
	$('#carousel-example').carousel({
        interval:3000 // THIS TIME IS IN MILLI SECONDS
    });
	
	  $('#dataTables-example').dataTable();
	  
	  
	//  statisticsAmounts();
	  
});

/**
 * 统计总数量
 * @returns
 */
function statisticsAmounts(result , counts){
	
	
	$("#total_amount").html(result);
	$("#total_counts").html(counts);
	
}
