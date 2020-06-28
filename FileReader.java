
				//The purpose of this class is to read through the files given and check for exceptions if we do come across one
import java.util.Scanner;
import java.io.*; // IO and Exceptions
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.IllegalFormatException;

// Import this class to handle errors
public class FileReader{

    public static Map loadMap(String fileName){
        try{
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);    
            int i =myReader.nextInt();
            String data=myReader.nextLine();
            while(myReader.hasNextLine()){
                String string=myReader.nextLine();
                System.out.print(string);}
            myReader.close();}
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println(e.toString());

        }return null;}
    //Reads the hero file and assigns the values and strings to the object hero with handling exceptions
    public static Hero loadHero(String heroFile){
        try{
            File myFile = new File(heroFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String data1=myReader.nextLine();
                //String data2=myReader.nextLine();
                //String data3=myReader.nextLine();
                int i=myReader.nextInt(); 
                int j=myReader.nextInt();  
                Hero H = new Hero(data,data1,i,j);
                System.out.print(H);}
            myReader.close();}
        catch(FileNotFoundException e){
            System.out.println("error file not found");
            e.printStackTrace();
        }
        catch(IllegalFormatException ae){
            System.out.println("error wrong format");
            ae.printStackTrace();    

        }
        return null;
    }

    
    

    public static void main(String[] args){
        //loadMap("//Users//mustafachaudhary//Desktop//A2 Handout Files//mapFile.txt");
        loadHero("/Users/mustafachaudhary/Desktop/A2 Handout Files/heroFile.txt");

    
    }}
			 

    
    
    
    
    

    
    
    
    
    
    
    
    
    
