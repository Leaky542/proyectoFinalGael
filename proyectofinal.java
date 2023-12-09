import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
class proyectofinal
{
        public static void main(String [] args) throws IOException{
        String MatrizNombres[][] = new String[8][8];
        int MatrizEdad[][] = new int[8][8];
        double MatrizEstatura[][] = new double[8][8];
        //configura el archivo y el flujo
        File archivoEntrada= new File("nombres.txt");
        FileReader lectorArchivo=new FileReader(archivoEntrada);
        BufferedReader lectorBuf = new BufferedReader(lectorArchivo);
        for(int k = 0; k < 8; k++){
            for(int l = 0; l < 8; l++){ 
                String nombre = lectorBuf.readLine();
                MatrizNombres[k][l] = (nombre != null) ? nombre : "";
                String edadStr = lectorBuf.readLine();
                MatrizEdad[k][l] = (edadStr != null) ? Integer.parseInt(edadStr) : 0;
                String estaturaStr = lectorBuf.readLine();
                MatrizEstatura[k][l] = (estaturaStr != null) ? Double.parseDouble(estaturaStr) : 0.0;
            }
        }
        lectorBuf.close();
        menu(MatrizNombres, MatrizEdad, MatrizEstatura);
    }
    public static void menu(String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        System.out.println("1.Buscar por nombre");
        System.out.println("2.Todos los mayores de 18 años");
        System.out.println("3.Todos los que tengan más edad que: ");
        System.out.println("4.Todos los menores que X edad");
        System.out.println("5.Todos cuyo nombre empiecen con: ");
        System.out.println("6.Todos los que tengan estatura: ");
        System.out.println("7.Todos los que sean mas bajos que: ");
        System.out.println("8.Todos los que midan mas de 1.75");
        System.out.println("9.El más joven de todos");
        System.out.println("10.Salir ");
        opc = sc.nextInt();
        sc.nextLine();
        switch (opc) {
            case 1:
                System.out.println("Introduce el nombre a buscar: ");
                String nombre = sc.nextLine();
                porNombre(nombre, MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 2:
                System.out.println("Se mostraran las personas mayores a 18 años");
                mayores18(MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 3:
                System.out.println("Escribe la edad: ");
                int edadMayor = sc.nextInt();
                masEdad(edadMayor, MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 4:
                System.out.println("Escribe la edad: ");
                int menorEdad = sc.nextInt();
                menoresEdad(menorEdad, MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 5:
                System.out.println("Escribe la inicial: ");
                String inicial = sc.nextLine();
                nombresIniciales(inicial, MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 6:
                System.out.println("Escribe la estatura a buscar: ");
                double estatura = sc.nextDouble();
                estaturaIndicada(estatura, MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 7:
                System.out.println("Ingresa la estatura: ");
                double estaturaBajos = sc.nextDouble();
                masBajos(estaturaBajos, MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 8: 
                System.out.println("Se mostraran los usuarios con una estatura mayor a 1.75");
                mayores175(MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 9:
                System.out.println("Se mostrara al usuario mas joven: ");
                masJovenes(MatrizNombres, MatrizEdad, MatrizEstatura);
                break;
            case 10:
                break;
            default:
                break;
        }
    }
    public static void porNombre(String nombre, String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (MatrizNombres[i][j] != null && nombre != null &&
                    MatrizNombres[i][j].toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                    System.out.println();
                }
                }
            }
        }
    public static void mayores18(String[][] MatrizNombres,int[][] MatrizEdad, double[][] MatrizEstatura){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(MatrizEdad[i][j] >= 18){
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                }
            }
        }
    }
    public static void masEdad(int edadMayor,String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(MatrizEdad[i][j] >= edadMayor){
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                }
            }
        }
    }
    public static void menoresEdad(int menorEdad, String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(MatrizEdad[i][j] > 0 && MatrizEdad[i][j] <= menorEdad){
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                }
            }
        }
    }
    public static void nombresIniciales(String inicial, String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (MatrizNombres[i][j] != null && MatrizNombres[i][j].toLowerCase().startsWith(inicial.toLowerCase())) {
                    // Imprime el nombre, edad y estatura
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                    System.out.println();
                }
            }
        }
    }
    public static void estaturaIndicada(double estatura, String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(MatrizEstatura[i][j] > 0 && MatrizEstatura[i][j] == estatura){
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                }
            }
        }
    }
    public static void masBajos(double estaturaBaja, String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(MatrizEstatura[i][j] > 0 && MatrizEstatura[i][j] <= estaturaBaja){
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                }
            }
        }
    }
    public static void mayores175(String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(MatrizEstatura[i][j] > 0 && MatrizEstatura[i][j] >= 1.75){
                    System.out.println(MatrizNombres[i][j]);
                    System.out.println(MatrizEdad[i][j]);
                    System.out.println(MatrizEstatura[i][j]);
                }
            }
        }
    }
    public static void masJovenes(String[][] MatrizNombres, int[][] MatrizEdad, double[][] MatrizEstatura) {
    int edadMasJoven = Integer.MAX_VALUE;
    List<String[]> usuariosMasJovenes = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (MatrizEdad[i][j] > 0 && MatrizEdad[i][j] <= edadMasJoven) {
                edadMasJoven = MatrizEdad[i][j];
            }
        }
    }
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (MatrizEdad[i][j] == edadMasJoven) {
                String[] usuario = {MatrizNombres[i][j], String.valueOf(MatrizEdad[i][j]), String.valueOf(MatrizEstatura[i][j])};
                usuariosMasJovenes.add(usuario);
            }
        }
    }
    if (!usuariosMasJovenes.isEmpty()) {
        for (String[] usuario : usuariosMasJovenes) {
            System.out.println(usuario[0]);
            System.out.println(usuario[1]);
            System.out.println(usuario[2]);
            System.out.println();
        }
    }
    }
}