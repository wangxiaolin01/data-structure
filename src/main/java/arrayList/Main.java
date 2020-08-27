package arrayList;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan",10);
        Person p2 = new Person("lisi",20);

      ArrayList arrayList = new ArrayList<Object>(5);

        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(null);
        arrayList.add(10);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(7);
//
//        arrayList.remove(2);
//        arrayList.clear();
//
////        System.out.println(arrayList.get(2));
//
        arrayList.remove(2);
        System.out.println(arrayList.indexOf(null));
        System.out.println(arrayList);
    }
}
