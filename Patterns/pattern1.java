package Patterns;

import java.util.Scanner;

public class pattern1{

    public static void main(String[] args) {
        System.out.print("Enter the number :");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        //printstartpattern(num);
        //diamond(num);
        // diamondbox(num);
        // Hollowtranglepattern(num);
        //reverseNumTranglePattern(num);
        //squarehollowpattern(num);
        palindrometrangular(num);
       
    }

    public static void printstartpattern(int num){

        int star = num;
        int space = 0;
        
        //print no of line
        for(int i=0 ; i<num; i++){


            //print space
            for(int k=0; k<space ; k++){
                System.out.print("  ");
            }

            //print star
            for(int j=0; j<star ; j++){
                 System.out.print("* ");   
            }

            //prepare for next line
            star --;
            space ++;
            System.out.println("");


        }

       


    }

    public static void diamond(int num){
        int mid = num;
        int space = num;
        int star = 1;
        int line = num + num;

        while (line >= 0) {
            
            //space
            for(int i=0; i <space ; i++){
                System.out.print("  ");
            }

            //star
            for(int j=0; j<star ; j++){
                System.out.print("* ");
            }

            //prepare fornext line
            System.out.println("");
            line --;
            if(line >= mid){
                space --;
                star = star +2;
            }else{
                space ++;
                star = star -2;
            }
        }
    }

    public static void diamondbox(int num){
        int mid = num;
        int space = num;
        int star = 1;
        int line = num + num;

        while (line >= 0) {
            
            //space
            for(int i=0; i <space ; i++){
                System.out.print("  ");
            }

            //star
            for(int j=1; j<=star ; j++){
                if(j==star){
                    System.out.print("* ");
                }
                else if(j== 1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            //prepare fornext line
            System.out.println("");
            line --;
            if(line >= mid){
                space --;
                star = star +2;
            }else{
                space ++;
                star = star -2;
            }
        }
    }

    public static void Hollowtranglepattern(int num){

        int totalnoofline = num;
        int star = 1;
        int space = num-1;

        while (num > 0) {
                //space
                for(int i=0; i<space ; i++){
                    System.out.print(" ");
                }
                
                //star
                for(int j=0; j<star; j++){
                    if(num != 1){
                        if(j==0 || j==star-1){
                            System.out.print("* ");
                        }else{
                            System.out.print(" ");
                        }
                    }
                }
                

                
                if(num == 1){
                    for(int k=0; k<totalnoofline; k++){
                        System.out.print("* ");
                    }
                }

                //prepare next line
                star = star+2;
                space --;
                System.out.println("");
                num --;
        }

       
        

    }

    public static void reverseNumTranglePattern(int num){

        int star = num;
        int space = 0;
        int count =1;
       

        while (num > 0) {
            

            int starprint = count;

            //space
            for(int j=0; j<space; j++){
                System.out.print(" ");
            }

            // star
            for(int i=0; i<star; i++){
                System.out.print(" "+starprint+" ");
                starprint++;
            }

            //prepare next line
            star --;
            space ++;
            num --;
            count ++;
            System.out.println("");


        }

    }

    public static void squarehollowpattern(int num){

       for(int i=0; i<num;i++){

        for(int j=0; j<num;j++){

            if(i==0 || i== num-1 || j==0 || j== num-1){
                System.out.print("* ");
            }else{
                System.out.print("  ");
            }

            // System.out.print("* ");
        }
        System.out.println("");

       }

    }

    public static void palindrometrangular(int num){

        int star = 1;
        int space = num-1;
        int count = 1;


        while (num > 0) {

            int printnum = count;
             boolean flag = true;
            
            //space
            for(int i=0; i<space ; i++){
                System.out.print("  ");
            }

            //star
            for(int j=0; j<star; j++){
                System.out.print(printnum+" ");

                if(printnum > 1 && flag){
                    printnum--;
                    if(printnum==1){
                        flag=false;
                    }
                }else{
                    printnum ++;
                    if(printnum==1){
                        flag=false;
                    }
                    
                }
            }

            //prepare next line
            System.out.println("");
            space --;
            star= star +2;
            num--;
            count ++;

        }

    }

}