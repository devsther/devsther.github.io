<!--  listOk.board -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../../static/css/mainpageSeo/main-page.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<!-- 로고 -->
<link href="../../static/image/logo/logo.png" rel="shortcut icon"
	type="image/x-icon">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/mainpageSeo/board.css">

<title>중신:주니어의 스펙업사이트</title>

<style type="text/css">
.content-container {
	padding: 10px;
	border-radius: 10px;
	background-color: #f1f1f1;
	box-sizing: border-box;
}

.content {
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>

</head>

<body>
	<c:choose>
		<c:when test='${not empty sessionScope.userId}'>
			<jsp:include page="../mainpageSeo/loginHeader.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="../mainpageSeo/header.jsp" />
		</c:otherwise>
	</c:choose>



	<div id="app-body">
		<div class="home" data-v-38e68602="">

			<!-- 배너 -->
			<section class="banner-container">
			<div class="banner">
				<div id="first-temp"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div class="image"></div>
				<div id="last-temp"></div>
			</div>
			<button class="arrow prev"></button>
			<button class="arrow next"></button>
			<div class="page-number"></div>
			</section>
			<!-- 배너 끝 -->



			</section>

			<!--주니어 커뮤니티  -->
			<section id="info-wrap">


			<div class="main-community slide-knowhow-list container"
				data-v-0b8ae29e="" data-v-2590092d="">
				<section class="header short-bottom" data-v-0b8ae29e="">
				<h2 class="title" data-v-0b8ae29e="">게시판 목록</h2>

				<a
					href="${pageContext.request.contextPath}/comulistOk.board"
					data-testid="community-home" class="go-list" data-v-1b5b0368=""
					data-v-0b8ae29e=""><span data-v-1b5b0368="">전체보기</span><img
					src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNiIgaGVpZ2h0PSIxNiIgdmlld0JveD0iMCAwIDE2IDE2Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGc+CiAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgxNlYxNkgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTEwNTMuMDAwMDAwLCAtMjAyLjAwMDAwMCkgdHJhbnNsYXRlKDQ4NS4wMDAwMDAsIDE4OC4wMDAwMDApIHRyYW5zbGF0ZSg1NjguMDAwMDAwLCAxNC4wMDAwMDApIi8+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggc3Ryb2tlPSIjMDBDN0FFIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS13aWR0aD0iMS41IiBkPSJNMTEgMTNMNiA4IDExIDMiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMDUzLjAwMDAwMCwgLTIwMi4wMDAwMDApIHRyYW5zbGF0ZSg0ODUuMDAwMDAwLCAxODguMDAwMDAwKSB0cmFuc2xhdGUoNTY4LjAwMDAwMCwgMTQuMDAwMDAwKSB0cmFuc2xhdGUoOC41MDAwMDAsIDguMDAwMDAwKSBzY2FsZSgtMSwgMSkgdHJhbnNsYXRlKC04LjUwMDAwMCwgLTguMDAwMDAwKSIvPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K"
					data-v-1b5b0368=""></a></section>
				<div data-v-292a6694="" data-v-0b8ae29e=""
					class="main-community-contents">
					<h6 class="info">전체 게시글 : ${total}개</h6>
					<div data-v-292a6694="" class="desktop-section">
						<div data-v-292a6694="" class="curation-container half-list"
							id="content-wrap">

							<!-- 게시글 들어오는곳 -->
							<section id="content-wrap">
							<ul>
							</ul>
							</section>

						</div>

						<div data-v-292a6694="" class="knowhow-container half-list">
							<a data-v-292a6694=""
								href="/community/pro-knowhow/760-%EC%A0%88%EB%8C%80---%EC%9D%B4%EA%B1%B0-%EB%AA%A8%EB%A5%B4%EA%B3%A0-%ED%94%BC%EC%95%84%EB%85%B8-%EC%B9%98%EC%A7%80-%EB%A7%88%EC%84%B8%EC%9A%94"
								class="knowhow-card-slide" data-testid="knowhow-item"><img
								data-v-292a6694="" alt="절대!! 이거 모르고 피아노 치지 마세요"
								class="thumb-image"
								data-src="https://static.cdn.soomgo.com/upload/talkboard/b639505d-06da-4b95-bb3e-7521967d8383.jpeg?h=320&amp;w=480&amp;webp=1"
								src="https://static.cdn.soomgo.com/upload/talkboard/b639505d-06da-4b95-bb3e-7521967d8383.jpeg?h=320&amp;w=480&amp;webp=1"
								lazy="loaded">
								<div data-v-292a6694="" class="card-desc">
									<p data-v-292a6694="" class="service">피아노/키보드 레슨</p>
									<div data-v-a3afae98="" data-v-292a6694="" class="collapsed">
										<div data-v-a3afae98="" class="line-clamp"
											style="line-height: 1.5; max-height: 3rem; -webkit-line-clamp: 2;">
											<p data-v-292a6694="" data-v-a3afae98="" class="title">절대!!
												이거 모르고 피아노 치지 마세요</p>
										</div>
										<!---->
									</div>
									<p data-v-292a6694="" class="author">취미 전문 레슨, 세달피아노</p>
								</div></a> <a data-v-292a6694=""
								href="/community/pro-knowhow/759-%EB%B3%B4%EB%93%9C%EB%A5%BC-%EC%9E%98-%ED%83%80%EA%B8%B0-%EC%9C%84%ED%95%9C-%EA%BF%80%ED%8C%81"
								class="knowhow-card-slide" data-testid="knowhow-item"><img
								data-v-292a6694="" alt="보드를 잘 타기 위한 꿀팁" class="thumb-image"
								data-src="https://static.cdn.soomgo.com/upload/talkboard/ca7c81f2-5199-4fd2-8fe1-d76bf7aace94.jpg?h=320&amp;w=480&amp;webp=1"
								src="https://static.cdn.soomgo.com/upload/talkboard/ca7c81f2-5199-4fd2-8fe1-d76bf7aace94.jpg?h=320&amp;w=480&amp;webp=1"
								lazy="loaded">
							<div data-v-292a6694="" class="card-desc">
									<p data-v-292a6694="" class="service">스노우보드 강습</p>
									<div data-v-a3afae98="" data-v-292a6694="" class="collapsed">
										<div data-v-a3afae98="" class="line-clamp"
											style="line-height: 1.5; max-height: 3rem; -webkit-line-clamp: 2;">
											<p data-v-292a6694="" data-v-a3afae98="" class="title">보드를
												잘 타기 위한 꿀팁</p>
										</div>
										<!---->
									</div>
									<p data-v-292a6694="" class="author">김광현</p>
								</div></a> <a data-v-292a6694=""
								href="${pageContext.request.contextPath}/templates/community-users-wmoon/community-main.jsp"
								class="knowhow-card-slide" data-testid="knowhow-item"
								><img data-v-292a6694=""
								alt="이직 면접 이거 놓치면 불합격!" class="thumb-image"
								data-src="https://static.cdn.soomgo.com/upload/talkboard/daa7675e-e26d-4a0e-ac1f-ad53dc98a46a.png?h=320&amp;w=480&amp;webp=1"
								src="https://static.cdn.soomgo.com/upload/talkboard/daa7675e-e26d-4a0e-ac1f-ad53dc98a46a.png?h=320&amp;w=480&amp;webp=1"
								lazy="loaded">
								<div data-v-292a6694="" class="card-desc">
									<p data-v-292a6694="" class="service">(광고)면접 컨설팅</p>
									<div data-v-a3afae98="" data-v-292a6694="" class="collapsed">
										<div data-v-a3afae98="" class="line-clamp"
											style="line-height: 1.5; max-height: 3rem; -webkit-line-clamp: 2;">
											<p data-v-292a6694="" data-v-a3afae98="" class="title">이직
												면접 이거 놓치면 불합격!</p>
										</div>
										<!---->
									</div>
									<p data-v-292a6694="" class="author">김주호</p>
								</div></a> <a data-v-292a6694=""
								href="${pageContext.request.contextPath}/templates/community-users-wmoon/community-main.jsp"
								class="knowhow-card-slide" data-testid="knowhow-item"><img
								data-v-292a6694="" alt="곰팡이 제거, 광고처럼 셀프로 가능할까?"
								class="thumb-image"
								data-src="https://static.cdn.soomgo.com/upload/talkboard/8a64d04d-c5c6-4cc3-96af-2f1b8875f32a.jpg?h=320&amp;w=480&amp;webp=1"
								src="https://static.cdn.soomgo.com/upload/talkboard/8a64d04d-c5c6-4cc3-96af-2f1b8875f32a.jpg?h=320&amp;w=480&amp;webp=1"
								lazy="loaded">
								<div data-v-292a6694="" class="card-desc">
									<p data-v-292a6694="" class="service">(광고)곰팡이 제거</p>
									<div data-v-a3afae98="" data-v-292a6694="" class="collapsed">
										<div data-v-a3afae98="" class="line-clamp"
											style="line-height: 1.5; max-height: 3rem; -webkit-line-clamp: 2;">
											<p data-v-292a6694="" data-v-a3afae98="" class="title">곰팡이
												제거, 광고처럼 셀프로 가능할까?</p>
										</div>
										<!---->
									</div>
									<p data-v-292a6694="" class="author">도배르만(곰팡이, 단열 전문)</p>
								</div></a>
						</div>
					</div>
				</div>
			</div>
			<!-- 이용자 게시글 닫는태그 -->



			<div class="observer-container container no-mobile-padding"
				data-v-45a9f2fc="" data-v-73846ecc="" data-v-38e68602="">
				<!---->
			</div>




			<!--이용자 커뮤니티  --> <!--
<div class="main-community slide-knowhow-list container"
	data-v-0b8ae29e="" data-v-2590092d="">
	<section class="header short-bottom" data-v-0b8ae29e="">
	<h2 class="title" data-v-0b8ae29e="">이용자 게시판 목록</h2>
	<a href="/community/soomgo-life/" data-testid="community-home"
		class="go-list" data-v-1b5b0368="" data-v-0b8ae29e=""><span
		data-v-1b5b0368="">전체보기</span><img
		src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNiIgaGVpZ2h0PSIxNiIgdmlld0JveD0iMCAwIDE2IDE2Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGc+CiAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgxNlYxNkgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTEwNTMuMDAwMDAwLCAtMjAyLjAwMDAwMCkgdHJhbnNsYXRlKDQ4NS4wMDAwMDAsIDE4OC4wMDAwMDApIHRyYW5zbGF0ZSg1NjguMDAwMDAwLCAxNC4wMDAwMDApIi8+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggc3Ryb2tlPSIjMDBDN0FFIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS13aWR0aD0iMS41IiBkPSJNMTEgMTNMNiA4IDExIDMiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMDUzLjAwMDAwMCwgLTIwMi4wMDAwMDApIHRyYW5zbGF0ZSg0ODUuMDAwMDAwLCAxODguMDAwMDAwKSB0cmFuc2xhdGUoNTY4LjAwMDAwMCwgMTQuMDAwMDAwKSB0cmFuc2xhdGUoOC41MDAwMDAsIDguMDAwMDAwKSBzY2FsZSgtMSwgMSkgdHJhbnNsYXRlKC04LjUwMDAwMCwgLTguMDAwMDAwKSIvPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K"
		data-v-1b5b0368=""></a></section>
	<div data-v-292a6694="" data-v-0b8ae29e=""
		class="main-community-contents">
		<div data-v-292a6694="" class="desktop-section">
			<div data-v-292a6694="" class="curation-container half-list">
				<ul data-v-151ddbec="" data-v-292a6694=""
					data-testid="curation-list" class="curation-list">
					
					
					<li data-v-151ddbec="" data-testid="curation-item"
						class="curation-list-item"><a data-v-151ddbec=""
						href="/community/soomgo-life/posts/643d30b9f22d78d3e3cce686-%EC%88%98%ED%95%99%EA%B3%BC%EC%99%B8-%EC%9E%98-%EA%B5%AC%ED%95%98%EB%8A%94-%ED%8C%81"
						class="curation-list-wrapper"><div data-v-151ddbec=""
								class="curation-contents has-thumbnail">
								<p data-v-151ddbec="" class="topic-name">고수소식</p>
								<p data-v-151ddbec="" class="curation-title">수학과외 잘
									구하는 팁</p>
								<p data-v-151ddbec="" class="curation-content">선생님
									경력사항과 커리큘럼의 세부사항 확인하기! 자신에게 맞는 커리큘럼을 찾는다면 과외의 시너지가
									발휘됩니다.</p>
								<div data-v-151ddbec="" class="curation-reactions">
									<span data-v-151ddbec="" class="view-count">283</span><span
										data-v-151ddbec="" class="comment-count">9</span>
								</div>
							</div>
							</div></a>
						</li>
				</ul>
			</div>
			
			
			<div data-v-292a6694="" class="knowhow-container half-list">
				<a data-v-292a6694=""
					href="/community/pro-knowhow/754-%EC%9D%B4%EC%A7%81-%EB%A9%B4%EC%A0%91-%EC%9D%B4%EA%B1%B0-%EB%86%93%EC%B9%98%EB%A9%B4-%EB%B6%88%ED%95%A9%EA%B2%A9-"
					class="knowhow-card-slide" data-testid="knowhow-item"><img
					data-v-292a6694="" alt="이직 면접 이거 놓치면 불합격!"
					class="thumb-image"
					data-src="https://static.cdn.soomgo.com/upload/talkboard/daa7675e-e26d-4a0e-ac1f-ad53dc98a46a.png?h=320&amp;w=480&amp;webp=1"
					src="https://static.cdn.soomgo.com/upload/talkboard/daa7675e-e26d-4a0e-ac1f-ad53dc98a46a.png?h=320&amp;w=480&amp;webp=1"
					lazy="loaded">
				<div data-v-292a6694="" class="card-desc">
						<p data-v-292a6694="" class="service">면접 컨설팅</p>
						<div data-v-a3afae98="" data-v-292a6694=""
							class="collapsed">
							<div data-v-a3afae98="" class="line-clamp"
								style="line-height: 1.5; max-height: 3rem; -webkit-line-clamp: 2;">
								<p data-v-292a6694="" data-v-a3afae98="" class="title">이직
									면접 이거 놓치면 불합격!</p>
							</div>
							
						</div>
						<p data-v-292a6694="" class="author">김주호</p>
					</div></a><a data-v-292a6694=""
					href="/community/pro-knowhow/753-%EA%B3%B0%ED%8C%A1%EC%9D%B4-%EC%A0%9C%EA%B1%B0--%EA%B4%91%EA%B3%A0%EC%B2%98%EB%9F%BC-%EC%85%80%ED%94%84%EB%A1%9C-%EA%B0%80%EB%8A%A5%ED%95%A0%EA%B9%8C-"
					class="knowhow-card-slide" data-testid="knowhow-item"><img
					data-v-292a6694="" alt="곰팡이 제거, 광고처럼 셀프로 가능할까?"
					class="thumb-image"
					data-src="https://static.cdn.soomgo.com/upload/talkboard/8a64d04d-c5c6-4cc3-96af-2f1b8875f32a.jpg?h=320&amp;w=480&amp;webp=1"
					src="https://static.cdn.soomgo.com/upload/talkboard/8a64d04d-c5c6-4cc3-96af-2f1b8875f32a.jpg?h=320&amp;w=480&amp;webp=1"
					lazy="loaded">
				<div data-v-292a6694="" class="card-desc">
						<p data-v-292a6694="" class="service">곰팡이 제거</p>
						<div data-v-a3afae98="" data-v-292a6694=""
							class="collapsed">
							<div data-v-a3afae98="" class="line-clamp"
								style="line-height: 1.5; max-height: 3rem; -webkit-line-clamp: 2;">
								<p data-v-292a6694="" data-v-a3afae98="" class="title">곰팡이
									제거, 광고처럼 셀프로 가능할까?</p>
							</div>
							
						</div>
						<p data-v-292a6694="" class="author">도배르만(곰팡이, 단열 전문)</p>
					</div></a>
			</div>																				
		</div>
	</div>
</div> --><!-- 이용자 게시글 닫는태그 --> <%-- <div class="observer-container container no-mobile-padding" data-v-45a9f2fc="" data-v-73846ecc="" data-v-38e68602=""><!----></div>
								
								
								
								
								
								<!-- 숨은 주니어 배너 -->
					<div class="observer-container container no-mobile-padding"
						data-v-45a9f2fc="" data-v-9e560958="" data-v-38e68602="">
						<div class="main-popular-pro" data-v-45a9f2fc=""
							data-v-9e560958="">
							<section class="header" data-v-45a9f2fc="" data-v-9e560958="">
							<h2 class="title" data-v-45a9f2fc="" data-v-9e560958="">지금
								인기 있는 주니어</h2>
							<a href="${pageContext.request.contextPath}/templates/community-users-wmoon/community-main.jsp"
							 class="go-list"
								data-v-1b5b0368="" data-v-9e560958="" data-v-45a9f2fc=""><span
								data-v-1b5b0368="">전체보기</span><img
								src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxNiIgaGVpZ2h0PSIxNiIgdmlld0JveD0iMCAwIDE2IDE2Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGc+CiAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTAgMEgxNlYxNkgweiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTEwNTMuMDAwMDAwLCAtMjAyLjAwMDAwMCkgdHJhbnNsYXRlKDQ4NS4wMDAwMDAsIDE4OC4wMDAwMDApIHRyYW5zbGF0ZSg1NjguMDAwMDAwLCAxNC4wMDAwMDApIi8+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggc3Ryb2tlPSIjMDBDN0FFIiBzdHJva2UtbGluZWNhcD0icm91bmQiIHN0cm9rZS1saW5lam9pbj0icm91bmQiIHN0cm9rZS13aWR0aD0iMS41IiBkPSJNMTEgMTNMNiA4IDExIDMiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMDUzLjAwMDAwMCwgLTIwMi4wMDAwMDApIHRyYW5zbGF0ZSg0ODUuMDAwMDAwLCAxODguMDAwMDAwKSB0cmFuc2xhdGUoNTY4LjAwMDAwMCwgMTQuMDAwMDAwKSB0cmFuc2xhdGUoOC41MDAwMDAsIDguMDAwMDAwKSBzY2FsZSgtMSwgMSkgdHJhbnNsYXRlKC04LjUwMDAwMCwgLTguMDAwMDAwKSIvPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K"
								data-v-1b5b0368=""></a></section>
								
								
							<div data-v-538b8750="" data-v-9e560958=""
								class="main-desktop-slide" data-v-45a9f2fc="">
								<div data-v-3d1a4f76="" data-v-55917fe8="" data-v-538b8750=""
									dir="ltr" class="slick-slider slick-initialized" id="content-wrap-junior">
									
									
							<!-- 주니어 들어오는곳 -->
								<section id="content-wrap-junior">
								        <ul>
								        </ul>		
											
											
									
								</div>
							</div>
						</div>
					
					</div> --%> <!--인기있는 주니어 베너 끝-->
					
					
					<!-- recommend로 해야되는데 작성된게 없슴 -->
					 <!-- 주니어 들어오는곳 --> 
					 <!-- <section id="content-wrap-js">
							<ul style="text-align: center;">
							</ul>
					</section>  -->
					
					
					<!-- 분야 -->
			<div data-v-a9f85b62="" data-v-38e68602=""
				class="main-pro-locations container no-mobile-padding">
				<div data-v-a9f85b62="" class="header">
					<h2 data-v-a9f85b62="" class="title">분야</h2>
					<div data-v-a9f85b62="" class="desc">
						믿을 수 있는 전문가를<br data-v-a9f85b62="" class="d-none d-sm-block">
						중신 단 한 곳에서 찾으세요
					</div>
				</div>
				<ul data-v-a9f85b62="" class="location-list">
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EC%84%9C%EC%9A%B8" class="">음악</a></li>
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EC%84%B8%EC%A2%85" class="">미술</a></li>
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EA%B0%95%EC%9B%90" class="">입시</a></li>

					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EB%8C%80%EA%B5%AC" class="">건강</a></li>
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EC%A0%84%EB%B6%81" class="">미용</a></li>
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EA%B2%BD%EB%82%A8" class="">알바</a></li>
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EC%9A%B8%EC%82%B0" class="">개발</a></li>
					<li data-v-a9f85b62="" class="location-item"><a
						data-v-a9f85b62="" href="/a.%EA%B4%91%EC%A3%BC" class="">기타</a></li>

				</ul>
			</div>
			<!-- 분야 --> <!-- 전문가로 활동하시나요? 주니어 가입 -->
			<div data-v-322fbd30="" data-v-38e68602=""
				class="main-pro-info container no-mobile-margin">
				<div data-v-322fbd30="" class="header">
					<p data-v-322fbd30="" class="title">
						전문가로 활동하시나요?<br data-v-322fbd30=""> 중신에서 새로운 고객을 <br
							data-v-322fbd30="" class="d-none d-sm-block">만나보세요
					</p>
					<div data-v-322fbd30="" class="pro-signup-btn">
						<a data-v-322fbd30="" href="/pro" class="btn btn-primary"
							target="_self">고수가입</a>
					</div>
				</div>
				<div data-v-3d1a4f76="" data-v-55917fe8="" data-v-322fbd30=""
					dir="ltr" class="slick-slider slick-initialized">
					<button data-v-21137603="" data-v-3d1a4f76="" type="button"
						data-role="none" class="slick-arrow slick-prev"
						style="display: block;">Previous</button>
					<div data-v-3d1a4f76="" class="slick-list">
						<div data-v-e4caeaf8="" data-v-3d1a4f76="" class="slick-track"
							style="width: 1923px; opacity: 1; transform: translate3d(-1282px, 0px, 0px);">
							<div data-v-e4caeaf8="" tabindex="-1" data-index="0"
								aria-hidden="true" class="slick-slide"
								style="outline: none; width: 641px;">
								<div data-v-e4caeaf8="">
									<div data-v-322fbd30="" data-v-e4caeaf8="" tabindex="-1"
										style="width: 100%; display: inline-block;">
										<div data-v-322fbd30="" data-v-e4caeaf8=""
											class="pro-info-slide">
											<img data-v-322fbd30="" data-v-e4caeaf8=""
												src="https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-1.png"
												srcset="https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-1.png 1x, https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-1@2x.png 2x, https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-1@3x.png 3x"
												alt="고객의 요청서를 무료로 받으세요" class="image">
											<p data-v-322fbd30="" data-v-e4caeaf8="" class="desc">고객의
												요청서를 무료로 받으세요</p>
										</div>
									</div>
								</div>
							</div>
							<div data-v-e4caeaf8="" tabindex="-1" data-index="1"
								aria-hidden="true" class="slick-slide"
								style="outline: none; width: 641px;">
								<div data-v-e4caeaf8="">
									<div data-v-322fbd30="" data-v-e4caeaf8="" tabindex="-1"
										style="width: 100%; display: inline-block;">
										<div data-v-322fbd30="" data-v-e4caeaf8=""
											class="pro-info-slide">
											<img data-v-322fbd30="" data-v-e4caeaf8=""
												src="https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-2.png"
												srcset="https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-2.png 1x, https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-2@2x.png 2x, https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-2@3x.png 3x"
												alt="조건이 맞는 고객에게 견적을 보내세요" class="image">
											<p data-v-322fbd30="" data-v-e4caeaf8="" class="desc">조건이
												맞는 고객에게 견적을 보내세요</p>
										</div>
									</div>
								</div>
							</div>
							<div data-v-e4caeaf8="" tabindex="-1" data-index="2"
								aria-hidden="false"
								class="slick-slide slick-active slick-current"
								style="outline: none; width: 641px;">
								<div data-v-e4caeaf8="">
									<div data-v-322fbd30="" data-v-e4caeaf8="" tabindex="-1"
										style="width: 100%; display: inline-block;">
										<div data-v-322fbd30="" data-v-e4caeaf8=""
											class="pro-info-slide">
											<img data-v-322fbd30="" data-v-e4caeaf8=""
												src="https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-3.png"
												srcset="https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-3.png 1x, https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-3@2x.png 2x, https://assets.cdn.soomgo.com/images/home/img-main-signup-pro-step-3@3x.png 3x"
												alt="채팅, 전화로 빠르게 상담하고 거래하세요" class="image">
											<p data-v-322fbd30="" data-v-e4caeaf8="" class="desc">채팅,
												전화로 빠르게 상담하고 거래하세요</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 전문가로 활동하시나요? 주니어 가입 끝-->
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script
	src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/mainpageSeo/board.js"></script>
<script>
	let boards = `${boards}`;
	boards = boards.replace(/\n/g, "");
	/* let boardsJunior = `${boardsJunior}`; */
	let contextPath = `${pageContext.request.contextPath}`;

	let $form = $("form[name='page-form']");
	$("a.change-page").on("click", function(e) {
		e.preventDefault();
		$form.find("input[name='page']").val($(this).attr("href"));
		$form.submit();
	});
</script>
<script
	src="${pageContext.request.contextPath}/static/js/mainpageSeo/list.js"></script>

<script src="/static/js/mainpageSeo/main-page.js"></script>
</html>