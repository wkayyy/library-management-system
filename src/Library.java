import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public Book getBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberNumber() == memberId) {
                return member;
            }
        }
        return null;
    }

    private Loan findLoanByBookId(int bookId) {
        for (Loan loan : loans) {
            if (loan.getBook().getId() == bookId) {
                return loan;
            }
        }
        return null;
    }

    public boolean loanBook(int bookId, int memberId) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);

        if (member == null || book == null) {
            return false;
        }
        if (findLoanByBookId(bookId) != null) {
            return false;
        }

        loans.add(new Loan(book, member, LocalDate.now()));
        return true;
    }

    public boolean returnBook(int bookId) {
        Loan loan = findLoanByBookId(bookId);
        if (loan == null) {
            return false;
        }
        loans.remove(loan);
        return true;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> result = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMember().getMemberNumber() == memberId) {
                result.add(loan);
            }
        }
        return result;
    }

    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }
}
