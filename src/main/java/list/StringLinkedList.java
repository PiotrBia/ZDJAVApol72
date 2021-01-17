package list;

public class StringLinkedList {
    StringNode head;
    StringNode tail;

    public boolean add(String item){
        StringNode node = new StringNode(item, null);
        if(isEmpty()){
            head = node;
            tail = node;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    public boolean add(String item, int index){
        StringNode node = new StringNode(item, null);
        //indeksy ujemne, niemożliwe dodanie
        if(index < 0){
            return false;
        }
        StringNode previous = getAt(index - 1);
        //brak węzła poprzedniego, gdy nie wstawiamy na początek, niemożliwe dodanie
        if(previous == null && index > 0){
            return false;
        }
        //jeśli poprzedni to ogon to ogonem jest teraz nowy węzeł
        if (previous == tail){
            tail = node;
        }
        //jeęli wstawiamy na początek to nową głowa jest teraz nowy węzeł
        if (index == 0){
            node.next = head;
            head = node;
            return true;
        }
        //wstawienie nowego węzła za węzłem o indeksie index - 1
        StringNode temp = previous.next;
        previous.next = node;
        node.next = temp;
        return true;
    }

    public boolean remove(int index){
        //jeśli indeks ujemny lub lista pusta to usunięcie niemożliwe
        if(index < 0 || isEmpty()){
            return false;
        }
        //jeśli usunięcie głowy
        if (index == 0){
            //jeśli lista jednoelementowa to zmień też ogon
            if (head == tail){
                tail = null;
            }
            //głowa to obecnie element następny za głową
            head = head.next;
            return true;
        }
        //pobieramy poprzednik
        StringNode previous = getAt(index - 1);
        //nie ma poprzednika, usunięcie niemozliwe
        if (previous == null){
            return false;
        }
        //pobieramy usuwany element
        StringNode removed = previous.next;
        //jesli nie ma to usunięcie niemożliwe
        if(removed == null){
            return false;
        }
        //jeśli usuwamy ogon to, ogonem jest teraz jego poprzednik
        if(removed == tail){
            tail = previous;
        }
        //łączymy listę pomijając usuwany element
        previous.next = removed.next;
        return true;
    }

    public String get(int index){
        StringNode node = getAt(index);
        if(node == null){
            return null;
        }
        return node.value; //w przyszłości nie będziemy zwracać null'i
    }

    public int size(){
        int count = 0;
        StringNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    StringNode getAt(int index){
        int count = 0;
        StringNode current = head;
        while(current != null){
            if(index == count){
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public boolean isEmpty(){
        return head == null;
    }
}