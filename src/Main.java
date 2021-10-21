import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // define the number of City
        System.out.println("Veuillez Entrer le nombre de ville:");
        int nbrVille = sc.nextInt();

        double[][] city = City.RandomArrayCity(nbrVille) ;

        //set list E <---{V1.....Vn}
        ArrayList copieCity = new ArrayList();
        for (int i = 1 ; i <= city.length; i++) copieCity.add("V"+i);
        ArrayList  Ensemble = new ArrayList<>();
        Ensemble.addAll(copieCity);

        //The user enters the initial city in the form V1 or V2 ..... Vn
        System.out.println("Veuillez Entrer la ville initiale sous la forme V1 ou V2.....Vn:");
        sc.nextLine();
        String initialCity = sc.nextLine();
        String element = initialCity;
        //1System.out.println(Arrays.deepToString(city));//return to the initial City

        ArrayList  permutation = new ArrayList();//Arraylist of path to find

        double poids = 0;//weight of the path find
        String ville = "";

        LocalTime time;
        if(!Ensemble.contains(element)) {
            System.out.println("City enter is not in a list of city");
        }
        else{
            time = LocalTime.now();
            permutation.add(element) ;
            Ensemble.remove(element);
            while(permutation.size() < nbrVille){

                double min =  Double.MAX_VALUE;

                for (Object e : Ensemble) {

                    if(city[copieCity.indexOf(element)][copieCity.indexOf(e.toString())] < min){
                        min = city[copieCity.indexOf(element)][copieCity.indexOf(e.toString())];
                        ville = e.toString();
                    }
                }
                poids = poids + min;
                permutation.add(ville);
                Ensemble.remove(ville);
                element = ville;
                //System.out.println(permutation + "  " + Ensemble +" "+element);
            }

            poids = poids + city[copieCity.indexOf(initialCity)][copieCity.indexOf(element)];
            permutation.add(initialCity);
            //System.out.println(permutation);//return to the initial City
            System.out.println(permutation.toString().replace("[","").
                    replace(","," --> ").
                    replace("]", ""));
            System.out.println("poids du chemin: "+poids);
            System.out.println("Execution Time:");
            System.out.println(LocalTime.now()+"  "+time+" "+ ChronoUnit.MILLIS.between(time, LocalTime.now()));

        }
    }
}