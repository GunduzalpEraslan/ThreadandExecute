import java.util.ArrayList;
import java.util.Arrays;

public class Counter implements Runnable{
    private volatile int number;
    private boolean isRun = true;
    ArrayList<Integer> fullList = new ArrayList<>();
    ArrayList<Integer> first = new ArrayList<>();
    ArrayList<Integer> second = new ArrayList<>();
    ArrayList<Integer> third = new ArrayList<>();
    ArrayList<Integer> fourth = new ArrayList<>();
    ArrayList<Integer> odd = new ArrayList<>();
    ArrayList<Integer> even = new ArrayList<>();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t:" + this.getNumber() + " ");
        if (this.fullList.size() == 0) {
            addFull(this.fullList);
        } if (this.first.size() == 0) {
            addList(fullList ,first ,second ,third, fourth);
        }
        increaseNumber();
        System.out.println("Tek olan sayılar : ");
        System.out.println(this.odd);
        System.out.println("*****************");
        System.out.println("Çift olan sayılar : ");
        System.out.println(this.even);
    }
    public synchronized void  increaseNumber() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        System.out.println(Thread.currentThread().getName());
                if (Thread.currentThread().getName().equals("pool-1-thread-1")) {
                    for (int i = 1; i <= this.first.size(); i++) {
                    if (!this.even.contains(i) && !this.odd.contains(i)) {
                    if (i % 2 == 0) {
                        this.even.add(i) ;
                            System.out.println("Ciftli listeye eklenen sayi: " + i);
                            break;
                    }
                        this.odd.add(i);
                        System.out.println("Tekli listeye eklenen sayi: " + i);
                        break;
                    }
                    }
                } else if (Thread.currentThread().getName().equals("pool-1-thread-2")) {
                    for (int i = 2501; i <= this.second.get(this.second.size() - 1); i++) {
                        if (!this.even.contains(i) && !this.odd.contains(i)) {
                            if (i % 2 == 0) {
                                this.even.add(i);
                                System.out.println("Ciftli listeye eklenen sayi: " + i);
                                break;
                            }
                            this.odd.add(i);
                            System.out.println("Tekli listeye eklenen sayi: " + i);
                            break;
    }
}
                } else if (Thread.currentThread().getName().equals("pool-1-thread-3")) {
                    for (int i = 5001; i <= this.third.get(this.third.size() - 1); i++) {
                        if (!this.even.contains(i) && !this.odd.contains(i)) {
                            if (i % 2 == 0) {
                                this.even.add(i);
                                System.out.println("Ciftli listeye eklenen sayi: " + i);
                                break;
                            }
                            this.odd.add(i);
                            System.out.println("Tekli listeye eklenen sayi: " + i);
                            break;
                        }
                    }
                } else if (Thread.currentThread().getName().equals("pool-1-thread-4")) {
                    for (int i = 7501; i <= this.fourth.get(this.fourth.size() - 1); i++) {
                        if (!this.even.contains(i) && !this.odd.contains(i)) {
                            if (i % 2 == 0) {
                                this.even.add(i);
                                System.out.println("Ciftli listeye eklenen sayi: " + i);
                                break;
                            }
                            this.odd.add(i);
                            System.out.println("Tekli listeye eklenen sayi: " + i);
                            break;
                        }
                    }
                }
    }

    public void addFull(ArrayList<Integer> list) {
        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }
    }

    public void addList(ArrayList<Integer> fulllist, ArrayList<Integer> firstList, ArrayList<Integer> secondList, ArrayList<Integer> thirdList, ArrayList<Integer> fourthList) {
        for (int i = 0; i < fulllist.size(); i++) {
            if (i <= 2500) {
                firstList.add(fulllist.get(i));
            } else if (i > 2500 && i <= 5000) {
                secondList.add(fulllist.get(i));
            } else if (i > 5000 && i <= 7500) {
                thirdList.add(fulllist.get(i));
            } else {
                fourthList.add(fulllist.get(i));
            }
        }
    }

    public void stop() {
        this.isRun = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }}