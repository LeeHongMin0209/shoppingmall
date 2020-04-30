<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/shoppingmall/css/style.css"/>



<div id="header">
  <div id="logo" class="box">
   
   	
   
    <img class="noborder" id="logo" src="/shoppingmall/images/logo.png"/>
   
  </div>
  <div id="auth" class="box">
    <c:if test="${type == 0}">
      <jsp:include page="02_managerLogin.jsp"/>
    </c:if>
    <c:if test="${type == 1}">
     <jsp:include page="12_login.jsp"/>
    </c:if>
  </div>
</div>
<div id="content" class="box2">
  <jsp:include page="${cont}"/>
</div>


<%--
==================== 시작주소 ===================
localhost:8080/shoppingmall/managerMain.do
localhost:8080/shoppingmall/index.do
===============================================

# server.xml 파일에 커넥션 풀 설정
			
		<Resource auth="Container"
			driverClassName="com.mysql.cj.jdbc.Driver" loginTimeout="10"
			maxWait="5000" name="jdbc/pool" password="1234"
			type="javax.sql.DataSource"
			url="jdbc:mysql://localhost:3306/shoppingmall?serverTimezone=UTC"
			username="root" />

-----------------------------------------------------------------------

-------------------------------------------------------
# 데이터베이스 생성하기 
CREATE DATABASE shoppingmall;

# 데이터베이스 사용하기
USE shoppingmall;
-------------------------------------------------------
# manager 테이블 생성하기
CREATE TABLE manager(
	managerId VARCHAR(50),
    managerPw VARCHAR(16)
);
DESC manager;
INSERT INTO manager (managerId, managerPw)
VALUES('admin@shop.com', '1111');
SELECT * FROM manager;
-------------------------------------------------------
# book 테이블 생성하기
CREATE TABLE book(
	book_id INT,
    book_kind VARCHAR(3),
    book_title VARCHAR(100),
    book_price INT,
    book_count INT,
    author VARCHAR(40),
    publishing_com VARCHAR(30),
    publishing_date VARCHAR(15),
    book_image VARCHAR(16),			-- default 'nothing.jpg'
    book_content VARCHAR(500),
    discount_rate INT,				-- default 10
    reg_date VARCHAR(50)
);
DESC book;
INSERT INTO book VALUES(1, '100', '나미야 잡화점의 기적', 15000, 100, '히가시노 게이고', '현대문학', '2019-01-11', 'nothing.jpg', '일본을 대표하는 소설가 히가시노 게이고의 신작', 10, now());
INSERT INTO book VALUES(2, '100', '연필로 쓰기', 18000, 80, '김훈', '문학동네', '2018-02-14', 'nothing.jpg', '70대의 김훈이 연필로 꾹꾹 눌러쓴 산문의 진경', 5, now());
INSERT INTO book VALUES(3, '100', '인간 실격', 20000, 50, '다자이 오사무', '민음사', '2016-11-20', 'nothing.jpg', '2019 상반기 종합 베스트셀러', 15, now());
INSERT INTO book VALUES(4, '100', '기묘한 신혼여행', 12000, 30, '정태원', '문학의 문학', '2017-04-20', 'nothing.jpg', '13편의 추리문학 걸작선', 20, now());

INSERT INTO book VALUES(5, '200', '외국어 공부의 감각', 15000, 100, '아키야마 요헤이', '월북', '2011-03-11', 'nothing.jpg', '나는 어떻게 10개 국어를 말하게 되었나?', 25, now());
INSERT INTO book VALUES(6, '200', 'EBS 수능완성 고등 제2외국어', 28000, 200, 'EBS 편집부', 'EBS교육방송', '2014-08-14', 'nothing.jpg', '2014 학년도 수능 연계교재', 10, now());
INSERT INTO book VALUES(7, '200', '외국어 전파담', 23000, 70, '로버트 파우저', '혜화', '2012-10-03', 'nothing.jpg', '외국어는 어디에서 어디로', 10, now());
INSERT INTO book VALUES(8, '200', '아무튼,외국어', 22000, 50, '조지영', '위고', '2019-04-20', 'nothing.jpg', '모든 나라에는 철수와 영희가 있다', 10, now());

INSERT INTO book VALUES(9, '300', '컴퓨터 비전과 딥러닝', 35000, 700, '라쟈링가파 샨무갸마니', '에이콘', '2018-02-18', 'nothing.jpg', '텐서플로와 케라스를 사용한 전문 가이드', 5, now());
INSERT INTO book VALUES(10, '300', '쉽게 배우는 데이터 통신', 19000, 100, '박기현', '한빛아카데미', '2015-03-10', 'nothing.jpg', '데이터 통신과 컴퓨터 네트워크', 10, now());
INSERT INTO book VALUES(11, '300', '컴퓨터활용능력', 38000, 200, '이주희', '배움', '2012-09-24', 'nothing.jpg', '컴퓨터 자격증', 20, now());
INSERT INTO book VALUES(12, '300', '초등학생이 알아야할 숫자', 22000, 0, '엘리스 제임스', '어스본코리아', '2013-06-12', 'nothing.jpg', '컴퓨터와 코디 100가지', 10, now());
SELECT * FROM book;
-------------------------------------------------------
# bank 테이블 생성하기
CREATE TABLE bank(
	account VARCHAR(30),
    bank VARCHAR(10),
    name VARCHAR(10)
);
DESC bank;
INSERT INTO bank (account, bank, name)
VALUES('11111-111-11111', '우리은행', '(주)코리아');
INSERT INTO bank (account, bank, name)
VALUES('22222-222-22222', '신한은행', '(주)코리아');
SELECT * FROM bank;
-------------------------------------------------------
# cart 테이블 생성하기
CREATE TABLE cart(
	cart_id int not null auto_increment primary key,
    buyer VARCHAR(50),
    book_id INT,
    book_title VARCHAR(100),
    buy_price INT,
    buy_count INT,
    book_image VARCHAR(16)			-- default 'nothing.jpg'
);
DESC cart;
-------------------------------------------------------
# buy 테이블 생성하기
CREATE TABLE buy(
	buy_id bigint ,
    buyer VARCHAR(50),
    book_id VARCHAR(12),
    book_title VARCHAR(100),
    buy_price INT,
    buy_count INT,
    book_image VARCHAR(16),			-- default 'nothing.jpg'
    buy_date VARCHAR(50),
    account VARCHAR(50),
    deliveryName VARCHAR(10),
    deliveryTel varchar(20),
    deliveryAdress VARCHAR(10),
    sanction VARCHAR(10)			-- default '상품준비중'
);
DESC buy;
-------------------------------------------------------

# member 테이블 생성하기
CREATE TABLE member1(
	id VARCHAR(20),
    passwd VARCHAR(16),
    name VARCHAR(20),
    reg_date VARCHAR(30),
    address VARCHAR(100),
    tel VARCHAR(20)
);
DESC member1;
INSERT INTO member1
VALUES('qwer@shop.com', '1111', '홍길동', now(), '경기도 구리시 교문동 아차산로', '010-3034-2291');
SELECT * FROM member1;
---------------------

create table qna(
	qna_id int not null auto_increment primary key,
    book_id int,
    book_title varchar(40),
    qna_writer varchar(20),
    qna_content varchar(500),
    group_id int,
    qora int,
    reply int,
    reg_date datetime
);

 --%>

