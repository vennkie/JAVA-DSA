public class method {
    public static void main(String[] args){
        System.out.println("the area is: "+area(4.0));
    }
    public static int area(int height, int width){
        return height*width;
    }
    public static int area(int side){
        return side*side;
    }
    public static double area(double side){
        return side*side;
    }
}
