/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jenso
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] x;
        x = new int[]{0,2,-5,4,6,-2,8};
        int[] w;
        w = new int[x.length];
        
       for(int i=1; i < x.length; i++){
           if(i % 2 != 0 ){
              w[i] = x[i];
               System.out.println(w[i]);
           }
       }
        
    }

}
