import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        int first = -1;
        
        while(choice != 0 && first!=0){
            System.out.print("Type the numbers you would like to order in the format '3,5,6,7,8': ");

            String[] parts = (sc.next()).split(",");
            int[] numeros = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                numeros[i] = Integer.parseInt(parts[i]);
            }

            System.out.print("Select the method to sort the array : [1] BubbleSort, [2] QuickSort, [3] MergeSort and [4] InsertionSort. Type 0 to log out: ");
            choice = sc.nextInt();

            if(choice == 1){
                bubbleSort(numeros);
            }
            else if(choice == 2){
                quickSort(numeros, 0, numeros.length-1);
            }
            else if(choice == 3){
                mergeSort(numeros);
            }
            else if(choice == 4){
                insertionSort(numeros);
            }
            else if(choice == 0){
                return;
            }
            else{
                System.out.println("Invalid. Try again");
            }

            String printOpt = "Null";
            System.out.print("Would you like to print the sorted array ? Type 'YES' or 'NO': ");
            printOpt = sc.next();

            if(printOpt.equals("YES") || printOpt.equals("yes")){
                printArray(numeros);
            }
            else if(printOpt.equals("NO") || printOpt.equals("no")){
                return;
            }
            else{
                System.out.println("Invalid");
                return;
            }
        }
        sc.close();
    }

    public static void bubbleSort(int[] x){
        boolean troca = true;
        while(troca){
            troca = false;

            int tam = x.length;
            for(int i = 0; i < tam-1; i++){
                if(x[i] > x[i+1]){
                    troca = true;
                    int aux = 0;
                    aux = x[i];
                    x[i] = x[i+1];
                    x[i+1] = aux;
                }
            }
        }
    }
    
    public static void mergeSort(int[] x){
        int xTam = x.length;

        if(x.length <2){
            return;
        }
        int meio = xTam/2;
        int[] left = new int[meio];
        int[] right = new int[xTam - meio];

        for (int i = 0; i < meio; i++) {
            left[i] = x[i];
        }

        for (int i = meio; i<xTam; i++) {
            right[i-meio] = x[i];
        }
        
        mergeSort(left);
        mergeSort(right);

        merge(x, left, right);

    }

    public static void merge(int[] x, int[] left, int[] right ){
        int leftTam = left.length;
        int rightTam = right.length;

        int i=0, j=0, k=0;

        while(i<leftTam && j<rightTam){

            if (left[i]<= right[j]) {
                x[k] = left[i];
                i++;
            }
            else{
                x[k] = right[i];
                j++;
            }
        k++;
        }
        
        while(i<leftTam){
            x[k] = left[i];
            i++;
            k++;
        }

        while(j<rightTam){
            x[k] = right[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] x, int low, int high){
        if (low >= high) {
            return;
        }
        
        int pivot = x[high];

        int esqPoint = low;
        int dirPoint = high;

        while(esqPoint < dirPoint){
            while (x[esqPoint] <= pivot && esqPoint < dirPoint) {
                esqPoint++;
            }

            while (x[dirPoint] >= pivot && esqPoint < dirPoint) {
                dirPoint--;
            }
        swap(x, esqPoint, dirPoint);
        }
        swap(x, esqPoint, high);

        quickSort(x, low, esqPoint-1);
        quickSort(x, dirPoint+1, high);

    }

    public static void swap(int[] x, int index1, int index2){
        int temp = x[index1];
        x[index1] = x[index2];
        x[index2] = temp;
    }

    public static void insertionSort(int[] x){
        for (int i = 0; i < x.length; i++) {
            int atual = x[i];

            int j = i-1;
            while(j >= 0 && x[j] > atual){
                x[j+1] = x[j];
                j--;
            }
            x[j+1] = atual;
        }
    }

    public static void printArray(int[] numeros){
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

}
