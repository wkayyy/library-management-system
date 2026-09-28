public class Member {
    final String name;
    final int memberNumber;

    public Member(String name, int memberNumber) {
        this.name = name;
        this.memberNumber = memberNumber;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    @Override
    public String toString() {
        return name + " (Lånernummer: " + memberNumber + ")";
    }
}
