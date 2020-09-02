public class Theater {
    //전체 좌석을 표현하는 2차원 배열
    private Seat[][] seats;
    // 좌석의 행과 열을 담는 변수
    private int rowCount, colCount;
    //Theater 클래스 생성자.
    public  Theater(int rowCount, int colCount) {
        seats = new Seat[rowCount][colCount];

        if (rowCount > 26) {
            rowCount = 26; // 알파벳의 갯수는 26개이므로 그이상 좌석을 생성하려하면 26으로 고정됨
        }

        for (int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                seats[i][j] = new Seat();
            }
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
    }
    //좌석 예약시 (B,4) 처럼 char형과 int형을 가지고 있어서 2차원 배열 탐색에 용이하게 하기위해 char을 int형으로 바꿈
    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A'; // 대문자 Char에서 아스키코드 'A' 즉, 65를 빼줌으로서 RowIndex가 int형으로 제대로 표현됨
    }

    //예약정보 (이름, 열, 행, 예약좌석 수)를 파라미터로 받아서 예약하는 메소드
    public boolean reserve(String name, char rowChar, int col, int numSeat) {

        int row = getRowIndex(rowChar) + 1; //영화관 열과 행의 통일성을 위해 +1해준다
        //예약하려는 좌석이 범위를 벗어났을경우 false를 리턴
        if (row > rowCount || col > colCount || col + numSeat - 1 > colCount) {
            return false;
        }


        for (int i = 0; i < numSeat; i++) {
            Seat current = seats[row - 1][col - 1 + i]; //예약할 좌석을 하나씩 예약처리함
            if (current.isOccupied()) {                  //예약할 좌석이 이미 예약되어있다면 이전 예약들은 다 취소하고 false리턴
                for (int j = 0; j < i; j++) {
                    seats[row - 1][col - 1 + j].cancel();
                }
                return false;
            }
            //모든 조건이 맞다면 예약
            current.reserve(name);
        }
        return true;
    }
    //이름으로 예매취소
    public int cancel(String name) {
        int canceledCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j <colCount; j++) {
                Seat seat = seats[i][j];
                if (seat.isOccupied() && seat.match(name)){
                    seat.cancel();
                    canceledCount++;
                }
            }
        }
        return canceledCount;
    }
    //자리번호 및 연속된 자리 취소
    public int cancel(char rowChar, int col, int numSeat){
        int row = getRowIndex(rowChar) +1 ;

        if (row > rowCount || col > colCount) {
            return 0;
        }
        if (col + numSeat  - 1 > colCount) {
            numSeat = col + numSeat - 1 - colCount;
        }

        int canceledCount = 0;

        for (int i = 0; i < numSeat; i++) {
            if (seats[row - 1][col - 1 + i].isOccupied()) {
                seats[row - 1][col - 1 + i].cancel();
                canceledCount++;
            }
        }

        return canceledCount;
    }

    public int getNumberOfReservedSeat(){
        int reservedCount = 0;
        for (int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                Seat seat = seats[i][j];
                if(seat.isOccupied()){
                    reservedCount++;
                }
            }
        }
        return reservedCount;
    }


    //좌석을 표현하기 위한 print 메소드

    public void printSeatMatrix() {
        System.out.print("  "); // 길이를 맞추기 위해 처음 두칸을 띄움
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i); // 두칸씩 띄우면서 좌석번호를 입력하면 행과열 길이가 맞는다.
        }
        System.out.println(); //좌석번호를 다 매긴후 줄바꿈

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": "); //(char) ('A'+ 1) = B, (char) ('A'+ 2) = C임.
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]"); //예매한 자리면 [O]
                } else {
                    System.out.print("[ ]"); //빈자리 [ ]프린트
                }
            }
            System.out.println(); //다음 줄로 이동
        }
    }
}
