var currentSelection = -1;
var proposalLength = 0;
var scrollCount = -1;
		
$(function(){
	
	d3.selectAll(".proposals")
		.append("div")
		.attr("class","proposal-box")
		.attr("id",function(){
			return $(this).parent().attr("id")+"_box";
		})
		.style("display","none");

	var ul = d3.selectAll(".proposal-box")
				.append("ul")
				.attr("class","proposal-list");
	
	d3.select("body").on("click",function(){
		d3.selectAll(".proposal-box").style("display","none");
		currentSelection = -1;
		proposalLength = 0;
		scrollCount = -1;
		$("#d3_menu").hide();
	})
	
	$(".queryInput").each(function(){
		$(this).keydown(function(e) {
		switch(e.which) {
			case 38: // Up arrow
			e.preventDefault();
			$('.proposal-list li,#objectProposal_box li').removeClass('selected');
			if((currentSelection - 1) >= 0){
				currentSelection--;
				$( ".proposal-list li:eq(" + currentSelection + "),#objectProposal_box li:eq(" + currentSelection + ")" )
					.addClass('selected');
				var scrollTop = 0;
				$(".proposal-box").each(function(){
					if($(this).scrollTop()>0){
						scrollTop = $(this).scrollTop();
					}
				});
				if(currentSelection-6*scrollCount==5){
					scrollCount--;
					$(".proposal-box").animate({'scrollTop':scrollTop-210},100);
				}
			} else {
				currentSelection = -1;
			}
			break;
			case 40: // Down arrow
			e.preventDefault();
			if((currentSelection + 1) < proposalLength){
				$('.proposal-list li,#objectProposal_box li').removeClass('selected');
				currentSelection++;
				$( ".proposal-list li:eq(" + currentSelection + "),#objectProposal_box li:eq(" + currentSelection + ")" )
					.addClass('selected');
				
				var scrollTop = 0;
				$(".proposal-box").each(function(){
					if($(this).scrollTop()>0){
						scrollTop = $(this).scrollTop();
					}
				});
				if(currentSelection!=0&&currentSelection%6==0&&scrollTop>=0){
					scrollCount++;
					$(".proposal-box").animate({'scrollTop':scrollTop+210},100);
				}
			}
			break;
			case 13: // Enter
				if(currentSelection > -1){
					var text = $( ".proposal-list li:eq(" + currentSelection + ")" ).html();
					currentSelection = -1;
					$(".proposal-list").empty();
					if($("#keywordProposal_box").css("display")=='block'){
						$("#SearchContent").val(text);
						knowledgeSearch(text);
					}else if($("#timeSpaceProposal_box").css("display")=='block'){
						$("#SearchContent").val(text);
						timeSpaceSearch(text);
					}else if($("#predicateProposal_box").css("display")=='block'){
						$("#PredicateSearchContent").val(text);
						predicateSearch(text);
					}else if($("#subjectProposal_box").css("display")=='block'){
						$("#subject").val(text);
					}else if($("#objectProposal_box").css("display")=='block'){
						$("#object").val(text);
					}
				}
				break;
			case 27,9: // Tab,Esc button
				currentSelection = -1;
				$(".proposal-list").empty();
				break;
		}
	});
	})
	
});


function appendLi(args,url){
	
	$(".proposal-list").empty();
	$(".proposal-box").hide();

	$.ajax({
		async:false,
		type:"post",
		url:url,
		data:args,
		dataType:"json",
		success:function(datas){	
			proposalLength = datas.length;
			for(var i=0;i<datas.length;i++){
				d3.selectAll(".proposal-list")
					.append("li")
					.attr('class', 'proposal')
					.text(datas[i])
					.on("mouseover",function(){
							$(this).addClass('selected');
						})
					.on("mouseout",function(){
						$(this).removeClass('selected');
					})
					.on("click",function(){
						if($("#keywordProposal_box").css("display")=='block'){
							$("#SearchContent").val($(this).html());
							knowledgeSearch($(this).html());
						}else if($("#timeSpaceProposal_box").css("display")=='block'){
							$("#SearchContent").val($(this).html());
							timeSpaceSearch($(this).html());
						}else if($("#predicateProposal_box").css("display")=='block'){
							$("#PredicateSearchContent").val($(this).html());
							predicateSearch($(this).html());
						}else if($("#subjectProposal_box").css("display")=='block'){
							$("#subject").val($(this).html());
						}else if($("#objectProposal_box").css("display")=='block'){
							$("#object").val($(this).html());
						}
				});
				
			}
		}
	})

}


function knowledgeIndistinctSearch(){
	
	$(".proposal-list").empty();
	
	var keyword = $("#SearchContent").val();
	var scope = $("#scope option:selected").val();
	var args = {"date":new Date(),"keyword":keyword,"scope":scope};
	var url = "./KeywordIndistinctQueryProcess.do";
	
	appendLi(args,url);
	
	$("#keywordProposal_box").show();
}

function predicateIndistinctSearch(){
	
	$(".proposal-list").empty();
	
	var keyword = $("#PredicateSearchContent").val();
	var scope = "所有类";
	var args = {"date":new Date(),"keyword":keyword,"scope":scope};
	var url = "./PredicateIndistinctQueryProcess.do";
	
	appendLi(args,url);
	
	$("#predicateProposal_box").show();
}

function timeSpaceIndistinctSearch(){
	
	$(".proposal-list").empty();
	
	var keyword = $("#SearchContent").val();
	var scope = $("#timeScope option:selected").val();
	var args = {"date":new Date(),"keyword":keyword,"scope":scope};
	var url = "./TimeSpaceIndistinctQueryProcess.do";
	
	appendLi(args,url);
	
	$("#timeSpaceProposal_box").show();
}

function subjectIndistinctSearch(){
	
	var keyword = $("#subject").val();
	var scope = "所有类";
	var args = {"date":new Date(),"keyword":keyword,"scope":scope};
	var url = "./KeywordIndistinctQueryProcess.do";
	
	appendLi(args,url);
	
	$("#subjectProposal_box").show();
}

function objectIndistinctSearch(){
	
	var keyword = $("#object").val();
	var scope = "所有类";
	var args = {"date":new Date(),"keyword":keyword,"scope":scope};
	var url = "./KeywordIndistinctQueryProcess.do";
	
	appendLi(args,url);
	
	$("#objectProposal_box").show();
}
