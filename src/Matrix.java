import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

class Matrix {
    double[][] matrix;
    private void setMatrix()
    {
        this.matrix = new double[0][0];
    }
    private void setMatrix(int a, int b)
    {
        this.matrix = new double[a][b];
    }
    private void setMatrix(double[][]matrix)
    {
        this.matrix = matrix;
    }
    public Matrix()
    {
        this.setMatrix();
    }
    public Matrix(int a, int b)
    {
        this.setMatrix(a, b);
    }
    public Matrix(double[][] matrix)
    {
        this.setMatrix(matrix);
    }
    void create(){
        int m,n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість рядків: ");
        n=scanner.nextInt();
        System.out.println("Введіть кількість стовпчиків: ");
        m=scanner.nextInt();
        double[][]  mat= new double[n][m];
        this.setMatrix(mat);
        for(double[] a: matrix)
            System.out.println(Arrays.toString(a));
    }
    double[][] copy(double[][] or){
        double[][] cop;
        cop=or.clone();
        for(double[] b: cop)
            System.out.println(Arrays.toString(b));
        return cop;
    }
    void fill(){
        Scanner scanner = new Scanner(System.in);
        int n;
        double m;
        System.out.println("Виберіть опцію:\n1.Заповнити випадковими числами від 0 до 100\n2.Заповнити вручну");
        n=scanner.nextInt();
        if (n==1) {
            int min=0, max=100;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=(int)(Math.random()*(max-min+1)+min);
                }
            }
        } else if (n==2) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.println("Введіть елемен " + (i + 1) + " рядок " + (j + 1) + " товпчик");
                    m=scanner.nextDouble();
                    matrix[i][j]=m;
                }
            }
        }
        for(double[] c: matrix){
            System.out.println(Arrays.toString(c));
        }
    }
    void get_numb(){
        int m,n;
        double a;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        m=scanner.nextInt();
        System.out.println("Введіть стовпчик: ");
        n=scanner.nextInt();
        a=matrix[m-1][n-1];
        System.out.println(a);
    }
    void get_line(){
        int n;
        double[] a;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        n=scanner.nextInt();
        a=matrix[n-1];
        System.out.println(Arrays.toString(a));
    }
    void get_col(){
        double[] a=new double[0];
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть стовпчик: ");
        n=scanner.nextInt();
        for(int i=0;i< matrix.length;i++){
            a=addnumb(a,matrix[i][n-1]);
        }
        System.out.println(Arrays.toString(a));
    }
    static double[] addnumb(double[] numb, double a) {
        double[] addnum = new double[numb.length + 1];

        for(int i = 0; i < numb.length; ++i) {
            addnum[i] = numb[i];
        }

        addnum[addnum.length - 1] = a;
        return addnum;
    }
    void diag_mat(){
        int n,a;
        Scanner snanner= new Scanner(System.in);
        System.out.println("Введіть кількість елементів вектора: ");
        n=snanner.nextInt();
        double[] ar= new double[0];
        double[][]  mat= new double[n][n];
        this.setMatrix(mat);
        for(int i=0;i<n;i++){
            System.out.println("Введіть "+(i+1)+" елемент вектору");
            a=snanner.nextInt();
            ar=addnumb(ar,a);
        }

        for(int i=0;i<n;i++){
            matrix[i][i]=ar[i];
        }
        for(double[] b: matrix)
          System.out.println(Arrays.toString(b));
    }
    void up_mat(){
        double[] ar=dim();
        if(ar[0]!=ar[1]){
            System.out.println("Матриця повинна бути квадратною");
        }
        else{
            for(int i=0;i< matrix.length;i++){
                for(int j=i+1;j< matrix[i].length;j++){
                    gus(j,i,(matrix[j][i]/matrix[i][i]));
                }
            }
            round();
            for(double[] b: matrix)
                System.out.println(Arrays.toString(b));
        }
    }
    void down_mat(){
        double[] ar=dim();
        if(ar[0]!=ar[1]){
            System.out.println("Матриця повинна бути квадратною");
        }
        else {
            for(int i=matrix.length-1;i>=0;i--){
                for(int j=i-1;j>=0;j--){
                    gus(j,i,(matrix[j][i]/matrix[i][i]));
                }
            }
            round();
            for(double[] b: matrix)
                System.out.println(Arrays.toString(b));
        }
    }
    void round(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                matrix[i][j]=Math.floor(matrix[i][j]*100)/100;
            }
        }
    }
    private void gus(int i, int j, double x){
        for(int a=0;a<matrix.length;a++) matrix[i][a]-=x*matrix[j][a];

    }
    double[] dim() {
        int n = 0, m = 0;
        double[] ar=new double[0];
        for (int i = 0; i < matrix.length; i++) {
            n = n + 1;}
        for (int j = 0; j < matrix[0].length; j++) {
            m = m + 1;
        }
        ar=addnumb(ar,n);
        ar=addnumb(ar,m);
        System.out.println(ar[0]+"x"+ar[1]);
        return ar;
    }

    @Override
    public boolean equals(Object obj) {
        double[][] mat=(double[][]) obj;
        return Arrays.equals(matrix,mat);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }
}
