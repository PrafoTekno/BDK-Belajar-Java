import java.util.Scanner;

public class Tes1 {

    public static void main(String[] args) {

        Member[] members = new Member[5];
        for (int i = 0; i < 5; i++) {
            members[i] = new Member();
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Poin Member");
            System.out.println("2. Tambah Poin ");
            System.out.println("3. Pakai Poin ");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                displayPoint(members);
            } else if (choice == 2) {
                addPoint(members, scanner);
            } else if (choice == 3) {
                usePoint(members, scanner);
            } else if (choice == 0) {
                System.out.println("Terima kasih !!!");
            } else {
                System.out.println("Pilihan Tidak Ada!");
            }
        } while (choice != 0);
    }

    public static void displayPoint(Member[] members) {
        System.out.println("Poin member:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Member " + (i+1) + ": " + members[i].getPoint());
        }
    }

    public static void addPoint(Member[] members, Scanner scanner) {
        System.out.print("Masukan Angka (1-5): ");
        int memberNumber = scanner.nextInt();
        if (memberNumber < 1 || memberNumber > 5) {
            System.out.println("Member Tidak Ada!");
            return;
        }

        System.out.print("Masukan Total Belanjaan: ");
        double transactionValue = scanner.nextDouble();

        members[memberNumber-1].addPoint(transactionValue);
        System.out.println("Poin Berhasil Di Tambahkan!");
    }

    public static void usePoint(Member[] members, Scanner scanner) {
        System.out.print("Masukan Angka (1-5): ");
        int memberNumber = scanner.nextInt();
        if (memberNumber < 1 || memberNumber > 5) {
            System.out.println("Member Tidak Ada!");
            return;
        }

        System.out.print("Masukan Nilai Poin : ");
        int voucherValue = scanner.nextInt();

        members[memberNumber-1].usePoint(voucherValue);
        System.out.println("Poin Berhasil Di Pakai !");
    }
}

class Member {
    private int point;

    public Member() {
        this.point = 0;
    }

    public int getPoint() {
        return point;
    }

    public void addPoint(double transactionValue) {
        if (transactionValue >= 1000000) {
            int additionalPoint = (int) (transactionValue * 0.03);
            point += additionalPoint;
        }
    }

    public void usePoint(int voucherValue) {
        int pointToUse = voucherValue;
        int maxPointToUse = point;
        if (pointToUse > maxPointToUse) {
            pointToUse = maxPointToUse;
        }
        point -= pointToUse;
    }
}