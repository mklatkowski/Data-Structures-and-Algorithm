package Main;

import java.util.*;

public class Graham {

    private ArrayList<Point> list;


    public Graham(int count, int range){
        list = new ArrayList<>();
        for(int i=0; i<count; i++){
            Random r1 = new Random();
            Random r2 = new Random();

            list.add(new Point(r1.nextInt(-range, range), r2.nextInt(-range, range)));
        }
//        list.add(new Point(0, 3));
//        list.add(new Point(1, 1));
//        list.add(new Point(2, 2));
//        list.add(new Point(4, 4));
//        list.add(new Point(0, 0));
//        list.add(new Point(1, 2));
//        list.add(new Point(3, 1));
//        list.add(new Point(3, 3));

//        list.add(new Point(100, 100));
//        list.add(new Point(-100, 100));
//        list.add(new Point(100, -100));
//        list.add(new Point(-100, -100));
//        list.add(new Point(1, 1));
//        list.add(new Point(2, 2));
//        list.add(new Point(4, 4));
//        list.add(new Point(0, 0));
//        list.add(new Point(1, 2));
//        list.add(new Point(3, 1));
//        list.add(new Point(3, 3));
        for(Point p: list){
            System.out.println(p);
        }
        System.out.println();
    }
    public Graham(ArrayList<Point> list){
        this.list = list;
    }

    public Stack<Point> otoczkaResult(){
        Point temp = list.get(0);
        for(Point p: list){
            if(p.getY()<temp.getY())
                temp = p;
            else if(p.getY()==temp.getY()){
                if(p.getX()<temp.getX())
                    temp = p;
            }
        }
//        for(int i=1; i<=list.size(); i++){
//            if(!list.get(i%list.size()).equals(temp))
//                list.get(i%list.size()).setPolar(temp, list.get(i-1));
//        }
//        for(Point p: list){
//            if(!p.equals(temp))
//                p.setPolar(temp);
//        }
        sortList(temp);

        return otoczka(temp, list);
    }


    private Stack<Point> otoczka(Point start, ArrayList<Point> list){
        Stack<Point> stack = new Stack<>();

        list.add(0, start);
        stack.push(list.get(0));
        stack.push(list.get(1));
        stack.push(list.get(2));

        for(int i=3; i<list.size(); i++){
            while(stack.size()>1 && tempPolar(stack.get(stack.size()-2), stack.get(stack.size()-1), list.get(i))>0){
                stack.pop();
            }
            stack.push(list.get(i));
        }
        return stack;
    }

    private int tempPolar(Point p, Point q, Point r){
        return (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());
    }


    private void removePoint(Point p1, Point p2, Point start){
        double d1 = distance(p1, start);
        double d2 = distance(p2, start);
        if(d1>d2)
            list.remove(p2);
        else
            list.remove(p1);
    }

    private void removePoint(Point p1, Point p2, Point start, ArrayList<Point> toRemove){
        double d1 = distance(p1, start);
        double d2 = distance(p2, start);
        if(d1>d2) {
            p2.setToRemove(true);
        }
        else
        {
            p1.setToRemove(true);
        }

    }

    private double distance(Point p1, Point p2){
        return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
    }

    private void sortList(Point start){
        list.remove(start);
        ArrayList<Point> toRemove = new ArrayList<>();
        for(int i=0; i<list.size()-1; i++){
            for(int j=1; j<list.size(); j++){
                if(i!=j) {
                    if (tempPolar(start, list.get(j-1), list.get(j)) > 0)
                        swap(j-1, j);
                    else if (tempPolar(start, list.get(j-1), list.get(j)) == 0) {
                        removePoint(list.get(j-1), list.get(j), start, toRemove);
                    }
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i).isToRemove()){
                toRemove.add(list.get(i));
            }
        }
        for(Point p: toRemove){
            list.remove(p);
        }

    }
    private void swap(int i, int j){
        Point temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
