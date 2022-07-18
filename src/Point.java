
public class Point implements Comparable<Point>
{
    private double x;
    private double y;

    Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Point)) return false;
        Point p = (Point)obj;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int compareTo(Point p2)
    {
        if(this.x < p2.getX() || (this.x == p2.getX() && this.x < p2.getY()))
        {
            return -1;
        }
        else if (this.x == p2.getX() && this.x == p2.getY())
        {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString()
    {
        return "(x = " + x + ", y = " + y +")";
    }
}