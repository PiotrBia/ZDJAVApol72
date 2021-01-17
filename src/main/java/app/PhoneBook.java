package app;

import list.StringArrayList;

import java.util.Scanner;

public class PhoneBook {
    static StringArrayList phoneBook = new StringArrayList(1000);
    static Scanner SCANNER = new Scanner(System.in);

    static public int menu() {
        System.out.println("1. Wyświetl wszystkie");
        System.out.println("2. Wyszukaj");
        System.out.println("3. Dodaj numer");
        System.out.println("4. Usuń");
        System.out.println("0. Koniec");
        if (SCANNER.hasNextInt()) {
            int select = SCANNER.nextInt();
            SCANNER.nextLine(); //czyszczenie bufora skanera
            return select;
        } else {
            SCANNER.nextLine(); //czyszczenie bufora skanera
            return -1;
        }
    }

    public static void displayPhoneBook() {
        for (int i = 0; i < phoneBook.size(); i++) {
            System.out.println(phoneBook.get(i));
        }
    }

    public static void init() {
        phoneBook.add("608-166-063");
        phoneBook.add("512-138-479");
        phoneBook.add("652-126-155");
    }

    public static void findPhoneNumber() {
        System.out.println("Podaj numer, którego szukasz");
        String item = SCANNER.nextLine();
        boolean found = false;
        int count = 0;
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(1).equals(item)) {
                System.out.println("Jest taki . Indeks: " + i);
                count++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nie ma takiego numeru.");
        } else {
            System.out.println("Numer występuje " + count + " razy");
        }
    }

    public static void addPhoneNumber() {
        System.out.println("Wpisz nowy numer:");
        String item = SCANNER.nextLine();
        phoneBook.add(item);
    }

    public static void main(String[] args) {
        init();
        while (true)
            //TODO zadeklarować zmienną boolean zamiast true, albo coś innego
            switch (menu()) {
                case 1: {
                    System.out.println("Lista");
                    displayPhoneBook();
                    break;
                }
                case 2: {
                    System.out.println("Szukanie");
                    findPhoneNumber();
                    break;
                }
                case 3: {
                    System.out.println("Dodanie");
                    addPhoneNumber();
                    break;
                }
                case 4: {
                    System.out.println("Usuwanie");
                    break;
                }
                case 0: {
                    System.out.println("Koniec");
                    System.exit(0);
                    return;
                }
                default: {
                    System.out.println("Brak takiej opcji");
                    break;
                }


            }

    }
}
