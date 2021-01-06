import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;
import java.util.Scanner;


//Singleton example

class Logger {



        private File myFile; //File Object
        private int verbosity; // gotten by contructor method
        private int counter = 0;//counts number of writes

        //Everything needed to make this a singleton goes here
        private Logger() {}; //Private constructor
        private static Logger instance = new Logger(); //Create a new logger class object within the class
        public static Logger get_instance(int verb, String FileName) {

                instance.createFile(FileName);
                instance.verbosity = verb;

                return instance;
                                        //Fix this code two calls to the object could reset the verbosity without changing
                                        //the file causing issues down the line
        }


        //Creates the file
        private void createFile(String fileName) {

            try {
              myFile = new File(fileName);
              if (myFile.createNewFile()) {
                System.out.println("File: " + myFile.getName());
              } else {
                System.out.println("File exists.");
              }
            } catch (IOException error) {
              System.out.println("error");
              error.printStackTrace();
            }

        }
        //Logs to the file created 
        public boolean log(String toAppend) {

                if(counter > verbosity)
                        return false;
                try{
                FileWriter writer = new FileWriter(myFile,true);
                writer.write(toAppend + "\n");
                writer.close();
                } catch(IOException error) {
                        System.err.println("failure");
                }

                counter++;//incrament counter

                return true;    //return
        }







/*      public void printFile() {
                
                try {
                        Scanner toPrint = new Scanner(myFile);

                        while (toPrint.hasNextLine())
                        {
                           System.out.println(toPrint.nextLine());
                        }
                } catch(FileNotFoundException error) {
                        System.error.Println("File not found");
                }

        }       

*/

        
        
        
  
