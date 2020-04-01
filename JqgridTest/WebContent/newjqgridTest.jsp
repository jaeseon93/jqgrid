<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="css/ui.multiselect.css" />

<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="js/i18n/grid.locale-kr.js"></script>

<script type="text/javascript">
  function goSearch(){
     var jsonObj = {};
   
     
     $("#jqGrid").setGridParam({
       datatype : "json",
       postData : {"param":JSON.stringify(jsonObj)},
       loadComplete : function(data){
         $.each(data, function(i, item){
           if(i=="rows"){
             if(item<1){
               alert("데이터가 없습니다.");
             }
           }
         });
       },
       gridComplete : function(){
           
       }
     }).trigger("reloadGrid");
  }
</script>
<script type="text/javascript">
  $(document).ready(function(){
     var cnames = ['아이디', '이름', '전화번호', '주소', '기타', '성별코드'];
     
     $("#jqGrid").jqGrid({
        url: "jqgridStartMain.do",
        datatype: "local",
        colNames: cnames,
        colModel: [
           {name:'seq', index:'seq', width:55, key:true, align:"center"},
           {name:'name', index:'name', width:100, align:"center"},
           {name:'phone', index:'phone', width:100},
           {name:'address', index:'address', width:100},
           {name:'etcc', index:'etcc', width:100},
           {name:'gender', index:'gender', width:100}
           ],
        height: 480,
        rowNum: 10,
        rowList: [10,20,30],
        pager: '#jqGridPager',
        rownumbers: true,
        ondbClickRow: function(rowId, iRow, iCol, e){
           if(iCol == 1){
              alert(rowId + "째 줄입니다.");
           }
          },
        viewrecords: true,
        caption: "실습용 테이블"
     });
  });
</script>  

</head>
<body>
<div class="row">
  <div>
    <select id = "selectId">
      <option value=""> 전체 </option>
      <option value="A"> A </option>
      <option value="B"> B </option>
      <option value="C"> C </option>
      <option value="D"> D </option>
    </select>
      <span><a href="#" onclick="javascript:goSearch()">조회</a></span>
  </div>
  <div>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
  </div>
</div>
</body>
</html>