<h1>FakeTheater란?</h1>

<h2>영화 예매 서비스를 Java로 구현</h2>

<h3>사용 예시</h3>
<p>Java Main에서 명령어 Theater t = new Theater(5, 9)를 입력하면 행과 열이 5, 9 로 이루어진 영화관 좌석표가 만들어집니다.</p>
<p>t.reserve(이름(String), 행(char), 열(int), 연속된 자리(int))로 예매하면 좌석에 O로 체크가 됩니다.</p>
<p>t.cancel(행(char), 열(int), 연속된 자리(int))로 예매를 취소할 수 있습니다.<p>
<p>t.getNumberOfReservedSeat() 로 몇개의 좌석이 예약되었는지 확인할 수 있습니다.</p>
