public class Seat {
    //예매한 사람의 이름을 담고있음
    private String name;

    //이름을 리턴
    public String getName() {
        return name;
    }

    //예약자 이름 설정
    public void reserve(String name) {
        this.name = name;
    }

    //예약취소
    public void cancel() {
        name = null;
    }

    //이미 예약된 자리인지 확인. 예약가능 = true, 이미 예약된자리 = false
    public boolean isOccupied() {
        return name != null;
    }

    //예약자 이름 체크
    public boolean match(String checkName) {
        return name.equals(checkName);
    }
}