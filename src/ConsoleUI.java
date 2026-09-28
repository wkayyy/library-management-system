import java.util.ArrayList;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Indtast valg: ");

            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }

    private void borrowBook() {
        int memberId = readInt("Indtast medlemsnummer: ");
        int bookId = readInt("Indtast bog id: ");

        if (library.loanBook(bookId, memberId)) {
            IO.println("Lån registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    private void returnBook() {
        int bookId = readInt("Indtast bog id: ");

        if (library.returnBook(bookId)) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    private void showLoans() {
        int memberId = readInt("Indtast medlemsnummer: ");
        ArrayList<Loan> loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()) {
            IO.println("Ingen udlån");
        } else {
            for (Loan loan : loans) {
                IO.println(loan);
            }
        }
    }


    private int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(IO.readln(prompt).trim());
            } catch (NumberFormatException e) {
                IO.println("Indtast venligst et tal.");
            }
        }
    }
}
