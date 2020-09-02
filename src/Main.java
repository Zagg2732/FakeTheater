public class Main {
    public static void main(String[] args) {
        // Theater 생성
        Theater t = new Theater(5, 9);

        // 좌석 예약
        System.out.println("김신욱님 이름으로 A5부터 2개의 좌석 예약: " + (t.reserve("김신욱", 'A', 5, 2) ? "성공" : "실패"));
        System.out.println("이천수님 이름으로 C1부터 3개의 좌석 예약: " + (t.reserve("이천수", 'C', 1, 3) ? "성공" : "실패"));
        System.out.println("강태풍님 이름으로 D4부터 7개의 좌석 예약: " + (t.reserve("강태풍", 'D', 4, 7) ? "성공" : "실패"));
        System.out.println("문희준님 이름으로 C7부터 3개의 좌석 예약: " + (t.reserve("문희준", 'C', 7, 3) ? "성공" : "실패"));
        System.out.println("폰은정님 이름으로 A1부터 3개의 좌석 예약: " + (t.reserve("폰은정", 'A', 1, 3) ? "성공" : "실패"));
        System.out.println("나아가님 이름으로 E4부터 4개의 좌석 예약: " + (t.reserve("나아가", 'E', 4, 4) ? "성공" : "실패"));

        // 좌석 취소
        System.out.println("B2부터 좌석 3개 취소: 총 " + t.cancel('B', 2, 3) + "개의 좌석이 취소되었습니다.");
        System.out.println("A6부터 좌석 3개 취소: 총 " + t.cancel('A', 6, 3) + "개의 좌석이 취소되었습니다.");
        System.out.println("이천수님의 좌석 취소: 총 " + t.cancel("이천수") + "개의 좌석이 취소되었습니다.");

        //취소된 자리 예약
        System.out.println("황회장님 이름으로 C2부터 3개의 좌석 예약: " + (t.reserve("황회장", 'C', 2, 3) ? "성공" : "실패"));

        // 결과 출력
        System.out.println();
        t.printSeatMatrix();
        System.out.println("총 " + t.getNumberOfReservedSeat() + "개의 좌석이 예약되었습니다.");
    }
}