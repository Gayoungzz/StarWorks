# 🖥️ StarWorks
> <b>전자결재, 프로젝트 관리, AI 기반 업무지원</b>을 하나의 흐름으로 연결한 통합 스마트 <b>그룹웨어</b>
<p align="center">
<img width="1891" height="910" alt="Image" src="https://github.com/user-attachments/assets/96bcc997-0fbd-485b-bce2-afdaec53b7be" />
</p>

</br>

## 01. 프로젝트 개요
* <b>개발 기간</b> : 2025.09. ~ 2025.11. (2개월) 
* <b>개발 인원</b> : 5명
* <b>핵심 목표</b> : 1. 결재 프로세스 자동화로 업무 효율성 증대 2. 프로젝트 중심의 실시간 협업 환경 구축 3. AI 어시스턴트를 활용한 스마트한 업무 환경 제공

<br />

## 02. 팀원 및 역할
* <b>임가영</b> (PL)
* <b>김주민</b> (UA)
* <b>윤서현</b> (BA)
* <b>장어진</b> (TA, DA)
* <b>홍현택</b> (AA)

<br />

## 03. 기술 스택
<table>
  <tr>
    <td>개발언어</td>
    <td>Java, JavaScript, HTML5, CSS3</td>
  </tr>
   <tr>
    <td>프레임워크</td>
    <td>Spring(Boot, Security, MVC, AI), MyBatis, React (Admin Only)</td>
  <tr>
    <td>라이브러리 및 API</td>
    <td>Spring AI (Vertex AI), OAuth2, Google OTP, WebSocket (STOMP), Apache POI, iText, D3.js, Quartz, SweetAlert2</td>
  </tr>
   <tr>
    <td>협업 툴</td>
    <td>SVN, Redmine</td>
  </tr>
   <tr>
    <td>개발 툴</td>
    <td>Eclipse, Maven, Vscode</td>
  </tr>
   <tr>
    <td>DB</td>
    <td>SQL Developer, Oracle DB, AWS S3</td>
</table>
  <br />

## 04. 시스템 구조 및 설계 전략

### 개발 전략
* 프로세스: Waterfall 모델 기반의 단계별 공정 준수 (기획 → 설계 → 구현 → 테스트)
* 협업 관리: Redmine을 통한 이슈 트래킹 및 마일스톤 관리
* 소통: 매일 15분 데일리 스크럼을 통한 이슈 공유 및 피드백

### 서비스 아키텍처
<table>
  <tr>
    <td>구분</td>
    <td>기술 스택</td>
    <td>주요 특징</td>
  </tr>
  <tr>
    <td>사용자 페이지</td>
    <td>Spring MVC (JSP)</td>
    <td>SSR 기반의 안정적인 화면 렌더링 및 보안(Security) 강화</td>
   </tr>
  <tr>
    <td>관리자 페이지</td>
    <td>React (SPA)</td>
    <td>React 학습 목적으로 별도 제작. Axios를 활용한 비동기 데이터 처리</td>
  </tr>
  <tr>
    <td>공통 백엔드</td>
    <td>Spring Boot</td>
    <td>REST API 설계 및 MyBatis를 이용한 데이터 관리</td>
  </tr>
</table>

### 데이터베이스
[🔗 ERD Cloud에서 상세보기](https://www.miricanvas.com/v2/design2/8d74d3c4-5f53-4e46-afff-a747f5ef9b19)
<p align="left">
  <img src="https://github.com/user-attachments/assets/e44c4984-2fe7-4c2f-8d07-85e69465eb83" width="600"/>
</p>


## 05. 주요 기능








