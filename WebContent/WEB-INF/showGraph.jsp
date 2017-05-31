<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=0.75, minimum-scale=0.3, maximum-scale=2.0, user-scalable=yes"/>
<title>香山文化知识图谱-图谱展示 </title>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="css/showGraph_1366.css" type="text/css">
<link rel="stylesheet" href="css/d3_menu.css" type="text/css"/>
<link rel="stylesheet" href="css/alert_box.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/nav_slider.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="js/d3.js"></script>
<script type="text/javascript" src="js/d3Events.js"></script>
<script type="text/javascript" src="js/events.js"></script>
<script>
	var args = {"date":new Date()};
	var setting = {	
			async: {
				enable: true,
				url:"CatalogProcess.do",
				autoParam:["name"]
			},
			callback: {
				onClick: listInstances
			}
		};
	var zNodes =[{ "name":"知识分类","iconOpen":"icon/foldericon_alter.gif","iconClose":"icon/unfoldericon_alter.gif","icon":"icon/unfoldericon_alter.gif","isParent":"true"}];
	
	$(document).ready(function(){
		$.fn.zTree.init($("#classes"), setting, zNodes);
	});
</script>

</head>
<body>

<div id="header">
<img id="smalllogo" src="img/SmallLogo.png" />

<div id="nav">
	<ul>
		<li><a href="index.jsp">首页</a></li>
		<li class="cur"><a href="./RedirectProcess.do?pageName=showGraph">图谱展示</a></li>
		<li><a href="./RedirectProcess.do?pageName=knowledgeSearch">知识检索</a></li>
		<li><a href="./RedirectProcess.do?pageName=relationSearch">关系检索</a></li>
		<li><a href="./RedirectProcess.do?pageName=timeSpaceSearch">时空检索</a></li>
	</ul>
	<div class="curBg"></div>
    <div class="cls"></div>
</div>

</div>

<div id="main">

<div id="Tree">
	<div id="TreeTitle">
		<span id="TreeTitleContent">知识目录</span>
	</div>
	<div id="TreeContent">
		<ul id="classes" class="ztree"></ul>
	</div>
</div>

<div id="Instance">
	<div id="InstanceTitle">
		<span id="InstanceTitleContent">知识实例<span id="instanceNumber"></span></span>
	</div>
	<div id="InstanceContent">
		<font id="warning" color="red" size="4"></font>
		<ul id="classInstances" class="ztree"></ul>
	</div>
</div>

<div id="D3">
	<div id="D3title">
		<span id="D3titleContent">知识图谱</span>
		<button class="D3Button" onclick="fixAll()">固定<br>所有节点</button>
		<button class="D3Button" onclick="cancleAllFix()" style="margin-left:150px;">取消<br>所有固定</button>
		<button class="D3Button" onclick="emptyElements()" style="margin-left:300px;">清空<br>所有节点</button>
	</div>
	<div class="d3_area" id="D3Content">
	</div>
</div>

<div id="Footer">
	北京师范大学珠海分校管理学院 @2016-2018 http://som.bnuz.edu.cn 版权所有
</div>

</div>

</body>
</html>