
import java.io.*;
/**
 @author Chelsea Dorich (Email: <a href="mailto:"robotqi@gmail.com>robotqi@gmail.com</a>)
 @version 1.1 03/05/2014
 @assignment.number A190-05
 @prgm.usage Called from the operating system
 @see "Gaddis, 2013, Starting out with Java, From Control Structures, 5th Edition"
 @see "<a href='http://docs.oracle.com/javase/7/docs/technotes/guides/javadoc/index.html'>JavaDoc Documentation</a>

 */
public class a19005
{/**Main method opens FBIN file and reads information to becomputed by NWSFB class, and prints returned information to
 FBOUT
 */
    public static void main(String[] args) throws Exception
    {
        //Declare some variables
        String strFileName = "data\\FBIN.txt";
        String  strRecord = "";
        //Declare file object
        File myFile = new File(strFileName);
        //declare printwriter object to write data to file
        PrintWriter outPut = new PrintWriter("data\\FBOUT.txt");
        //check for files existance
        if(myFile.exists())
        {
            //create reader obj for file
            BufferedReader inputFile;
            inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(strFileName)));
            //throw out first 8 lines
            for (int intLnCount = 0; intLnCount <= 8; intLnCount++)
            {
                strRecord = inputFile.readLine();
            }
            //construct class referance
            NWSFB windsAloft = new NWSFB(strRecord);
            //while there are records in FBIN
            while(inputFile.ready())
            {
                //read line + hand it to windsAloft
               strRecord = inputFile.readLine();
                windsAloft.updateString(strRecord);
                //create strings for printing
                String strTwo = "\r\n\r\nStation ID: " + windsAloft.getStationId();
                String strThree =windsAloft.ftmWeatherReport(strRecord, "3000");
                String strFour = windsAloft.ftmWeatherReport(strRecord, "6000");
                String strFive = windsAloft.ftmWeatherReport(strRecord, "9000");
                String strSix = windsAloft.ftmWeatherReport(strRecord, "12000");
                String strSeven = windsAloft.ftmWeatherReport(strRecord, "18000");
                String strEight = windsAloft.ftmWeatherReport(strRecord, "24000");
                String strNine = windsAloft.ftmWeatherReport(strRecord, "30000");
                String strTen = windsAloft.ftmWeatherReport(strRecord, "34000");
                String strEleven = windsAloft.ftmWeatherReport(strRecord, "36000");
                //print strings
                outPut.print(strTwo);
                outPut.print(strThree);
                outPut.print(strFour);
                outPut.print(strFive);
                outPut.print(strSix);
                outPut.print(strSeven);
                outPut.print(strEight);
                outPut.print(strNine);
                outPut.print(strTen);
                outPut.print(strEleven);
            }
            // close file
            inputFile.close();
            outPut.close();
        }
        else
        {
            System.out.println("File does not exist");
        }
    }
}
