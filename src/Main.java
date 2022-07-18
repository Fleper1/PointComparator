import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("a)");//Заполнить коллекцию случайными данными (обеспечить наличие одинаковых элементов).
        System.out.println("ArrayList:");
        Scanner in = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < 10; i++)
        {
            double x = (int)(Math.random() * 5);
            double y = (int)(Math.random() * 5);
            points.add(new Point(x, y));
        }
        print(points);

        System.out.println("TreeSet without comparator:");
        TreeSet<Point> points1 = new TreeSet<Point>(points);
        print(points1);

        System.out.println("TreeSet with comparator:");

        TreeSet<Point> points2 = new TreeSet<Point>(new PointComparator());
        points2.addAll(points);
        print(points2);

        System.out.println("c)");//Обойти коллекцию с помощью итератора и при обходе удалить все заданные элементы

        ArrayList<Point> pointsToDel = new ArrayList<Point>(); // сравнение наоборот
        System.out.println("Enter points to remove ");
        String end = "";
        while(!end.equals("0"))
        {
            System.out.println("Enter x ");
            double x = in.nextDouble();
            System.out.println("Enter y");
            double y = in.nextDouble();
            pointsToDel.add(new Point(x, y));
            System.out.println("One more? 0 - exit");
            end = in.next();
        }

        Iterator<Point> pointIterator = points.iterator();
        while (pointIterator.hasNext())
        {
            Point p = pointIterator.next();
            if(pointsToDel.contains(p))
            {
                pointIterator.remove();
            }
        }
        print(points);
        System.out.println();
        System.out.println("d)"); //Протестировать методы коллекции

        print(points.subList(3, 5)); //используется для возврата представления части этого списка между указанными fromIndex, включительно, и toIndex, исключительно

        points.sort(new PointComparator());
//        Collections.sort(points, new PointComparator());
        print(points);

        System.out.println("TreeSet before remove");
        print(points1);
        Iterator<Point> pointTreeIterator = points1.iterator();
        while (pointTreeIterator.hasNext())
        {
            Point p = pointTreeIterator.next();
            if(pointsToDel.contains(p))
            {
                pointTreeIterator.remove();
            }
        }
        System.out.println("TreeSet after remove");
        System.out.println(points1);
    }


    //b)
    static public <E> void print(Collection<E> col)
    {
        System.out.println();
        for(E elem : col)
        {
            System.out.println(elem);
        }
    }
}