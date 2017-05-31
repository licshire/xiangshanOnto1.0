<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=0.75, minimum-scale=0.3, maximum-scale=2.0, user-scalable=yes"/>
<title>香山文化知识图谱-知识检索</title>
<link rel="stylesheet" href="css/knowledgeSearch_1366.css"  type="text/css"/>
<link rel="stylesheet" href="css/d3_menu.css" type="text/css"/>
<link rel="stylesheet" href="css/alert_box.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/proposals.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/nav_slider.js"></script>
<script type="text/javascript" src="js/d3.js"></script>
<script type="text/javascript" src="js/d3Events.js"></script>
<script type="text/javascript" src="js/events.js"></script>
<script type="text/javascript" src="js/proposals.js"></script>
</head>
<body>

<div id="header">
<img id="smalllogo" src="img/SmallLogo.png" />
	<div id="nav">
		<ul>
			<li><a href="index.jsp">首页</a></li>
			<li><a href="./RedirectProcess.do?pageName=showGraph">图谱展示</a></li>
			<li class="cur"><a href="./RedirectProcess.do?pageName=knowledgeSearch">知识检索</a></li>
			<li><a href="./RedirectProcess.do?pageName=relationSearch">关系检索</a></li>
			<li><a href="./RedirectProcess.do?pageName=timeSpaceSearch">时空检索</a></li>
		</ul>
		<div class="curBg"></div>
	    <div class="cls"></div>
	</div>
</div>

<div id="main">

<div id="SearchBox">
	<span id="doSearch">
		<input type="text" name="keyword" id="SearchContent" class="queryInput" placeholder="输入关键词" oninput="knowledgeIndistinctSearch()"/>  
	</span>
	<span class="proposals" id="keywordProposal" ></span>
	<input type="image" src="img/search.png" id="Searchimage" onclick='knowledgeSearch()'/>
	
	<span id="myRadio">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		知识分类：
		<select name="scope" id="scope">
		<option value ='所有类'>所有类</option>
		<c:forEach var="topClass" items="${topClasses }">
			<option value =${topClass.name }>${topClass.name }</option>
		</c:forEach>
		</select>
	</span>
</div>
<div id="D3">
	<div id="D3Title">
		<span id="D3TitleContent">检索结果图谱</span>
		<button class="D3Button" onclick="fixAll()">固定<br>所有节点</button>
		<button class="D3Button" onclick="cancleAllFix()" style="margin-left:120px;">取消<br>所有固定</button>
		<button class="D3Button" onclick="emptyElements()" style="margin-left:240px;">清空<br>所有节点</button>
	</div>
	<div class="d3_area" id="D3Content">
	
	</div>
</div>
<div id="SearchResult">

	<div id="ResultTitle">
		<span id="ResultTitleContent">检索结果</span>
	</div>
	<div id="ResultContent">

	</div>
</div>

<div id="SearchHistory">
	<div id="HistoryTitle">
		<span id="HistoryTitleContent">回溯检索</span>
		<button id="ClearHistory" onclick="emptyHistories('knowledgeSearch')">清空</button>
	</div>
	<div class="history_area" id="HistoryContent">
	<c:set var="startIndex" value="${fn:length(knowledgeSearch_Histories)-1 }"></c:set>  
	<c:forEach items="${knowledgeSearch_Histories }"  varStatus="items">
		<center><a href="#" onclick='knowledgeSearch("${knowledgeSearch_Histories[startIndex - items.index]}")'> ${knowledgeSearch_Histories[startIndex - items.index]}  </a></center><br />
	</c:forEach>
	</div>
</div>

<div id="Footer">
	北京师范大学珠海分校管理学院 @2016-2018 http://som.bnuz.edu.cn 版权所有
</div>

</div>

</body>
</html>