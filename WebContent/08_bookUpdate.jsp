<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/shoppingmall/css/style.css"/>
<script src="/shoppingmall/js/jquery-1.11.0.min.js"></script>
<script src="/shoppingmall/js/jquery.form.min.js"></script>
<script src="/shoppingmall/08_bookupdate.js"></script>

<c:if test="${empty sessionScope.id}">
  <meta http-equiv="Refresh" content="0;url=/shoppingmall/mg/managerMain.do" >
</c:if>

<div id="header">
  <button id="bookMain">관리자 메인으로</button>
  <button id="bookList">목록으로</button>
</div>
<form id="upForm1" action="/shoppingmall/mg/bookUpdatePro.do" 
          method="post" enctype="multipart/form-data">
<div id="bookUpdateForm" class="box">
   <ul>
      <li><label for="book_kind">분류선택</label>
          <select id="book_kind" name="book_kind">
            <option value="100"
            <c:if test="${book_kind == 100}">selected</c:if>
            >문학</option>
            <option value="200"
            <c:if test="${book_kind == 200}">selected</c:if>
            >외국어</option>
            <option value="300"
            <c:if test="${book_kind == 300}">selected</c:if>
            >컴퓨터</option>
          </select>
      <li><label for="book_title">제목</label>
          <input id="book_title" name="book_title" type="text" 
           size="50" maxlength="50" value="${book.book_title}">
          <input type="hidden" name="book_id" value="${book_id}">
      <li><label for="book_price">가격</label>
          <input id="book_price" name="book_price" type="text" 
           size="10" maxlength="9" value="${book.book_price}">원
      <li><label for="book_count">수량</label>
          <input id="book_count" name="book_count" type="text" 
           size="10" maxlength="5" value="${book.book_count}">권
      <li><label for="author">저자</label>
          <input id="author" name="author" type="text" 
           size="20" maxlength="30" value="${book.author}">
      <li><label for="publishing_com">출판사</label>
          <input id="publishing_com" name="publishing_com" type="text" 
           size="20" maxlength="30" value="${book.publishing_com}">  
      <li><label for="publishing_date">출판일</label>
          <div id="publishing_date"> 
            <jsp:useBean id="nowTime" class="java.util.Date"></jsp:useBean>
            <fmt:formatDate var="nowTimeStr" pattern="yyyy-MM-dd" value="${nowTime}" />
            <fmt:parseNumber var="lastYear" type="NUMBER" value="${nowTimeStr.toString().substring(0,4)}"/>
            <select name="publishing_year">
              <c:forEach var="i" begin="2010" end="${lastYear}">
                <option value="${i}">${i}</option>
              </c:forEach>
           </select>년
           <select name="publishing_month">
             <c:forEach var="i" begin="1" end="12">
                <option value="${i}">${i}</option>
             </c:forEach>
           </select>월
           <select name="publishing_day">
             <c:forEach var="i" begin="1" end="31">
                <option value="${i}">${i}</option>
             </c:forEach>
           </select>일
          </div>
      <li><label for="book_image">책 이미지</label>
          <input id="book_image" name="book_image" type="file">${book.book_image}  
      <li><label for="book_content">내용</label>
          <textarea id="book_content" name="book_content" 
                rows="13" cols="50">${book.book_content}</textarea>
      <li><label for="discount_rate">할인율</label>
          <input id="discount_rate" name="discount_rate" type="text" 
           size="5" maxlength="2" value="${book.discount_rate}">  
      <li class="label2">
          <input type="submit" id="updateBook" value="책수정">
   </ul>
</div>
</form>
