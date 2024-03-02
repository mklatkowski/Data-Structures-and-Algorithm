package Main;

import Student.Student;

import java.util.Iterator;
import java.util.function.Predicate;

public class Main {

    static Student[] table = new Student[5];

    public static void ResultsEx3(){

        System.out.println(" ROZWIAZANIA DO ZADANIA NR 3: ");
        System.out.println("******************************************");

        Student student_add = new Student(9, "K", "O", 2.0);
        Student student_remove = new Student(7, "E", "J", null);

        TableIterator<Student> iterator = Add(new TableIterator<>(table),student_add);

        System.out.println("Po dodaniu studenta: " +student_add);
        System.out.println(" ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(" ");

        TableIterator<Student> iterator1 = remove(new TableIterator<>(table), student_remove);

        System.out.println("Po usunięciu studenta: " +student_remove);
        System.out.println(" ");
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }


        TableIterator<Student> iterator2 = sort(new TableIterator<>(table));


        System.out.println("Po posortowaniu: ");
        System.out.println(" ");
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

    public static TableIterator<Student> sort(TableIterator<Student> iterator){
        TableIterator<Student> iterator1 = iterator.clone();
        int size = 0;
        while(iterator1.hasNext()){
            iterator1.next();
            size++;
        } // określenie rozmiaru tablicy która korzysta z podanego iteratora
        Student [] temp = new Student[size];
        size = 0;
        while(iterator.hasNext()){
            temp[size] = iterator.next();
            size++;
        } // uzupełnienie tablicy elementami poprzez sklonowany iterator
        Student st;

        int sort_size = temp.length;
        for(int i=0; i<sort_size; i++) {
            if (temp[i].getOcena() == null) {
                st = temp[i];
                temp[i] = temp[sort_size - 1];
                temp[sort_size - 1] = st;
                sort_size--;
                i=0;
            }
        } // wykrycie rekordów których ocena jest równa "null" i ustawienie ich na końcu
        // tablicy. Te elementy nie będą sortowane w późniejszym etapie, a będą
        // na końcu tablicy. Zmienna sort_size określi do jakiego elementu
        // tablicy należy sortować, aby do sortowania nie weszły oceny null
        for(int i=0; i< sort_size-1; i++){
            for(int j=1; j< sort_size; j++){
                if(temp[j].getOcena()!= null && temp[j-1].getOcena()!=null && temp[j].getOcena()>temp[j-1].getOcena()){
                    st = temp[j - 1];
                    temp[j-1] = temp[j];
                    temp[j] = st;
                }
            }
        }// posortowanie tylko elementów których ocena jest różna od null (z racji na wcześniej
        // ustawioną budowę tablicy

        return new TableIterator<>(temp);
    }

    public static TableIterator<Student> remove(TableIterator<Student> iterator, Student student){
        TableIterator<Student> iterator1 = iterator.clone();
        TableIterator<Student> iterator2 = iterator.clone();
        int size = 0;
        int orginal_size = 0;
        while(iterator.hasNext()){
            Student s = iterator.next();
            orginal_size++;
            if(!(student.equals(s))){ // określenie rozmiaru pomocniczej tablicy (uwzględniającą usunięcie danego rekordu)
                size++;
            }
        }
        if(orginal_size==size){ // jeśli pomocnicza tablica ma taki sam rozmiar jak orginalna
            // to znaczy, że szukany rekord nie znajduje się w tablicy (wprowadzony iterator będzie aktulany)
            System.out.println("Element: " +student +" nie znajduje się w tablicy, więc nie będzie usunięty");
            return iterator2;
        }

        Student [] temp = new Student[size];
        size = 0;

        while(iterator1.hasNext()){
            Student s = iterator1.next();
            if(!(student.equals(s))){ // przepisanie tablicy, oprócz elementu który ma być wykreślony
                temp[size] = s;
                size++;
            }
        }

        return new TableIterator<>(temp);

    }

    public static TableIterator<Student> Add(TableIterator<Student> iterator, Student student){
        TableIterator<Student> iterator1 = iterator.clone();
        TableIterator<Student> iterator2 = iterator.clone();
        int size = 0;
        int orginal_size = 0;
        while(iterator1.hasNext()){
            Student s = iterator1.next();
            orginal_size++;
            if(!(student.equals(s))){
                size++;
            }
        } // określenie rozmiaru tablicy
        if(orginal_size!=size){ // taka sytuacja może zajść tylko wtedy, gdy znajduje się w tablicy przynajmniej jeden
            // taki sam student co podany, zatem nie można go dodać drugi raz
            System.out.println("Ten student: " +student +" znajduje się już na liście");
            return iterator2;
        }
        Student [] temp = new Student[size+1]; // stworzenie nowej tablicy o rozmiarze o 1 większym od poprzedniej
        size = 0;
        while(iterator.hasNext()){
            Student s = iterator.next();
            if(s.getNrIndeksu()<student.getNrIndeksu()){
                temp[size] = s;
                size++;
            } // dopóki indeks studentów jest mniejszy od podanego, to są oni przepisywani tak samo
            else{
                temp[size] = student; // jeśli znajdzie się miejsce do dodania podanego studenta
                size++;
                if(size!=temp.length){ // w pamięci może nie być już zmiennej pomocniczej studenta. Nie można wtedy
                    // dodać tego studenta (bo go oczywiście nie ma) w przeciwnym wypadku, trzeba obsłużyć te zmienną pomocniczą
                    temp[size] = s;
                    size++;
                }
                while(iterator.hasNext()){ // reszta elementów orginalnej tablicy musi być przepisana
                    temp[size] = iterator.next();
                    size++;
                }
            }
            if(temp[temp.length-1]==null){ // jeśli element ma większy indeks od każdego elementu w tablicy,
                // to warunek else z poprzedniej pętli się nie wypełni
                // dlatego podany student musi zostać dodany na ostatnie miejsce tablicy
                temp[temp.length-1] = student;
            }
        }
        return new TableIterator<>(temp);
    }

    public static void Generate(){

        table[0] = new Student(1, "A", "F", 2.0);
        table[1] = new Student(2, "B", "G", null);
        table[2] = new Student(3, "C", "H", 3.0);
        table[3] = new Student(4, "D", "I", null);
        table[4] = new Student(7, "E", "J", null);

//        table[0] = new Student(1, "A", "F", 2.0);
//        table[1] = new Student(2, "B", "G", 5.5);
//        table[2] = new Student(3, "C", "H", 3.0);
//        table[3] = new Student(4, "D", "I", 4.0);
//        table[4] = new Student(7, "E", "J", 3.5);


    }

    public static void View(Iterator<Student> iterator){

        System.out.println("Początkowe elementy tablicy: ");
        System.out.println(" ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(" ");
    }

    public static void ViewIndex(Iterator<Student> iterator, int indeks, double ocena) {
        class PredicateStudent<T> implements Predicate<T> {
            public boolean test(T student) {
                return ((Student)student).getNrIndeksu() == indeks;
            }
        }

        Predicate<Student> predicate11 = new PredicateStudent<>(); // deklaracja predykatu
        Iterator<Student> iterator2 = new FiltredIterator<>(iterator, predicate11); // i iteratora filtrującego

        int n=0;

        while(iterator2.hasNext()){
            n++;
            iterator2.next().setOcena(ocena);
        }
        if(n==0){
            System.out.println(" Student o indesie: " +indeks + " nie znajduje się na liście");
        }
        else{
            System.out.println(" Student o indeksie: " +indeks + " dostał ocenę: " +ocena);
        }
        System.out.println(" ");
    }

    public static void ViewAverage(TableIterator<Student> iterator){
        double sum = 0;
        int n = 0;
        class PredicateStudent<T> implements Predicate<T> {
            public boolean test(T student) {
                return (((Student)student).getOcena()!=null) &&(((Student)student).getOcena() >=3.0);
            }
        }
        Predicate<Student> predicate = new PredicateStudent<>();

        Iterator<Student> iterator1 = new FiltredIterator<>(iterator, predicate);

        while(iterator1.hasNext()){
            sum += iterator1.next().getOcena();
            n++;
        }
        System.out.println("Srednia arytmetyczna studentów z ocenami minimum 3.0: ");
        System.out.println(sum/n);

    }

    public static void ViewFailed(TableIterator<Student> iterator){
        class PredicateStudent<T> implements Predicate<T> {
            public boolean test(T student) {
                return ((Student)student).getOcena()==null ||(((Student)student).getOcena() < 3);
            }
        }

        Predicate<Student> predicate = new PredicateStudent<>();
        Iterator<Student> iterator1 = new FiltredIterator<>(iterator, predicate);
        System.out.println("Osoby które mają ocene mniejszą od 3.0: ");
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println(" ");

    }


    public static void main(String[] args) {

        TableIterator<Student> iterator_test = new TableIterator<>(table);
        TableIterator<Student> iterator_test1 = new TableIterator<>(table);
        TableIterator<Student> iterator_test2 = new TableIterator<>(table);
        TableIterator<Student> iterator_test3 = new TableIterator<>(table);

        Generate();
        View(iterator_test);
        ViewIndex(iterator_test1, 3, 5.5);
        ViewAverage(iterator_test2);
        ViewFailed(iterator_test3);

        ResultsEx3();

    }
}
