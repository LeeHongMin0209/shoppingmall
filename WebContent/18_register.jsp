<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/shoppingmall/css/style.css"/>
<script src="/shoppingmall/js/jquery-1.11.0.min.js"></script>
<script src="/shoppingmall/18_register.js"></script>

<div id="regForm" class="box">
   <ul>
      <li><label for="id">아이디</label>
          <input id="id" name="id" type="email" size="20" 
           maxlength="50" placeholder="example@kings.com" autofocus>
          <button id="checkId">ID중복확인</button>
      <li><label for="passwd">비밀번호</label>
          <input id="passwd" name="passwd" type="password" 
           size="20" placeholder="6~16자 숫자/문자" maxlength="16">
      <li><label for="repass">비밀번호 재입력</label>
          <input id="repass" name="repass" type="password" 
           size="20" placeholder="비밀번호재입력" maxlength="16">
      <li><label for="name">이름</label>
          <input id="name" name="name" type="text" 
           size="20" placeholder="홍길동" maxlength="10">
      <li><label for="address">주소</label>
          <input id="address" name="address" type="text" 
           size="30" placeholder="주소 입력" maxlength="50">
      <li><label for="tel">전화번호</label>
          <input id="tel" name="tel" type="tel" 
           size="20" placeholder="전화번호 입력" maxlength="20">
      <li class="label2"><button id="process">가입하기</button>
          <button id="cancle">취소</button>
   </ul>
</div>