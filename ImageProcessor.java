import java.util.Scanner;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.PrintWriter;
import java.util.Random;
/**
 * Write a description of class ImageProcessor here.
 * 
 * @author Grant Goldenberg 
 * @version October 2014
 */
public class ImageProcessor
{
    public void runProcessor () throws java.io.IOException {
        Scanner input = new Scanner(System.in);
        clearScreen();
        displayWelcome();
        String whatToDo = getInputName(input);
        if(whatToDo.equals("1")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic =  openOutfile(fileName);
            flattenRedFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("2")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic =  openOutfile(fileName);
            flattenGreenFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("3")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic =  openOutfile(fileName);
            flattenBlueFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("4")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            negateRedFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("5")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            negateGreenFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("6")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            negateBlueFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("7")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            invert(imageScanner, outpic);
        }
        else if(whatToDo.equals("8")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            grayScaleFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("9")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            int num = 1;
            motionBlurFilter(imageScanner, outpic, num);
        }
        else if(whatToDo.equals("10")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            flipHorTransform(imageScanner, outpic);
        }
        else if(whatToDo.equals("11")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            embossFilter(imageScanner, outpic);
        }
        else if(whatToDo.equals("12")) {
            String fileName = getFileName(input);
            Scanner imageScanner = null;
            imageScanner = initInFile(fileName);
            PrintWriter outpic = openOutfile(fileName);
            collage(imageScanner, outpic);
        }

        displayFarewell();

    }

    public void clearScreen() {
        System.out.println("\f");
    }

    public void displayWelcome() {
        System.out.println("/ / / / / / / / / / / / / / / / /");
        System.out.println("/  Welcome to Impractical PPM!  /");
        System.out.println("/  Written by Grant Goldenberg  /");
        System.out.println("/ / / / / / / / / / / / / / / / /");
        System.out.println("");
        System.out.println(" __________________________________");
        System.out.println("|/%%%%%%%%%%%%% /  /  /  /  /  /  /|");
        System.out.println("| /  %%%%%%%%%%%%   /  /  /  /  /  |");
        System.out.println("|  /  / %%%%%%%%%%%  /  /  /  /  / |");
        System.out.println("|/  /  /  /%%%%%%%%%% /  /  /  /  /|");
        System.out.println("| /  /  /  /  %%%%%%%%%/  /  /  /  |");    
        System.out.println("|  /  /  /  /  / %%%%%%%%  /  /  / |");
        System.out.println("|/  /  /  /  /  /  /%%%%%%% /  /  /|");
        System.out.println("| /  /  /  /  /  /%%%%%%% /  /  /  |");
        System.out.println("|  /  /  /  /  /%%%%%%% /  /  /  / |");
        System.out.println("|/  /  /  /  /  /  %%%%%%/  /  /  /|");
        System.out.println("| /  /  /  /  /  /  / %%%%%  /  /  |");
        System.out.println("|  /  /  /  /  /  /  /  /%%%% /  / |");
        System.out.println("|/  /  /  /  /  /  /  /  /  %%%/  /|");
        System.out.println("| /  /  /  /  /  /  /  /  /  / %%  |");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("/ What do you want to do: /");
        System.out.println("");
        System.out.println("/ 1. Flatten Red /");
        System.out.println("/ 2. Flatten Green /");
        System.out.println("/ 3. Flatten Blue /");
        System.out.println("/ 4. Negate Red /");
        System.out.println("/ 5. Negate Green /");
        System.out.println("/ 6. Negate Blue /");
        System.out.println("/ 7. Invert /");
        System.out.println("/ 8. Grey Scale /");
        System.out.println("/ 9. Motion Blur /");
        System.out.println("/ 10. Flip Horizontally /");
        System.out.println("/ 11. Emboss /");
        System.out.println("/ 12. Collage /");
    }

    public String getFileName(Scanner input) {
        System.out.println("/ Give me your file name: /");
        return input.nextLine();
    }

    public String getInputName(Scanner input) {
        System.out.println("/ Give me your choice: /");
        return input.nextLine();
    }

    public PrintWriter openOutfile(String filename) throws java.io.IOException {
        return new PrintWriter(System.getProperty("user.dir") + "/" + filename + "out.ppm");
    }

    public Scanner initInFile (String filename) throws java.io.IOException {
        java.io.File imageFile = new java.io.File (System.getProperty("user.dir") + "/" + filename + ".ppm");
        return new Scanner(imageFile);
    }

    public String contentsOfFile(Scanner fileScanner) {
        String contents = "";
        while(fileScanner.hasNextLine()) {
            contents += fileScanner.nextLine() + "\n";
        }
        return contents;
    }

    public void echoToScreen (Scanner fileScanner) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        System.out.println(p3Part);
        System.out.println(cols + " " + rows);
        System.out.println(maxVal);
        // thats the header
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
            }
        }
    }

    public void flattenRedFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                outpic.print(0 + " " + green + " " + blue + " ");
            }
            outpic.println();
        }
    }

    public void flattenGreenFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                outpic.print(red + " " + 0 + " " + blue + " ");
            }
            outpic.println();
        }
    }

    public void flattenBlueFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                outpic.print(red + " " + green + " " + 0 + " ");
            }
            outpic.println();
        }

        outpic.flush();
    }

    public void negateRedFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                int red = maxVal - fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                outpic.print(red + " " + green + " " + blue + " ");
            }
            outpic.println();
        }

        outpic.flush();
    }

    public void negateGreenFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = maxVal - fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                outpic.print(red + " " + green + " " + blue + " ");
            }
            outpic.println();
        }

        outpic.flush();
    }

    public void negateBlueFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = maxVal - fileScanner.nextInt();
                outpic.print(red + " " + green + " " + blue + " ");
            }
            outpic.println();
        }

        outpic.flush();
    }

    public void invert (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                int red = maxVal - fileScanner.nextInt();
                int green = maxVal - fileScanner.nextInt();
                int blue = maxVal - fileScanner.nextInt();
                outpic.print(red + " " + green + " " + blue + " ");
            }
            outpic.println();
        }

        outpic.flush();
    }

    public void grayScaleFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                int avg = (red + green + blue)/3;
                int redOut = avg;
                int greenOut = avg;
                int blueOut = avg;
                outpic.print(redOut + " " + greenOut + " " + blueOut + " ");
            }
            outpic.println();
        }

        outpic.flush();
    }

    public void motionBlurFilter (Scanner fileScanner, PrintWriter outpic, int num) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < cols; b++) {
                int avgRed, avgGreen, avgBlue;
                avgRed = avgGreen = avgBlue = 0;
                int tmp = num;
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();

                if (b + num > cols) {
                    tmp = num -(b + num - cols);

                }
                for (int k = 0; k <= tmp - 1; k++) {
                    avgRed += red + k;
                    avgGreen += green + k;
                    avgBlue += blue + k;

                }
                if (tmp != 0) {
                    red = avgRed/tmp;
                    green = avgGreen/tmp;
                    blue = avgBlue/tmp;

                }
                else {
                    red = avgRed;
                    green = avgGreen;
                    blue = avgBlue;

                } 
                outpic.print(red + " " + green + " " + blue + " ");
            }
            outpic.println();
        }
        outpic.flush();
    }

    public void flipHorTransform (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for (int a = 0; a < rows; a++) {
            String pixelRow = "";
            for (int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                String row = red + " " + green + " " + blue + " ";
                pixelRow = row + pixelRow;
            }
            outpic.println(pixelRow);
        }
        outpic.flush();
    }

    public void embossFilter (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();

        outpic.println(p3Part);
        outpic.println(cols + " " + rows);
        outpic.println(maxVal);
        // thats the header
        for (int a = rows - 1; a >= 0; a--) {
            for (int b = cols - 1; b >= 0; b--) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                if (b == 0 || a == 0) {
                    red = maxVal / 2 + 1;
                    green = maxVal/ 2 + 1;
                    blue = maxVal/ 2 + 1;
                }
                else {
                    int redDiff = (red - red - 1);
                    int greenDiff = (green - green - 1);
                    int blueDiff = (blue - blue - 1);
                    int maxDiff = redDiff;
                    if (Math.abs(greenDiff) > Math.abs(maxDiff)) {
                        maxDiff = greenDiff;
                    }
                    if (Math.abs(blueDiff) > Math.abs(maxDiff)) {
                        maxDiff = blueDiff;
                    }
                    int v = 128 + maxDiff;
                    if (v < 0) {
                        v = 0;
                    }
                    else if (v > maxVal) {
                        v = maxVal;
                    }
                    red = v;
                    green = v;
                    blue = v;

                }
                outpic.print(red + " " + green + " " + blue + " ");
            }
            outpic.println();
        }
        outpic.flush();
    }

    public void collage (Scanner fileScanner, PrintWriter outpic) throws java.io.IOException {
        String p3Part = fileScanner.nextLine();
        int cols = fileScanner.nextInt();
        int rows = fileScanner.nextInt();
        int maxVal = fileScanner.nextInt();
        fileScanner.nextLine();

        outpic.println(p3Part);
        outpic.println(cols * 2 + " " + rows * 1);
        outpic.println(maxVal);
        for (int a = 0; a < rows; a++) {
            String pixelRow = " ";
            String pixelRowFilter = " ";
            for (int b = 0; b < cols; b++) {
                int red = fileScanner.nextInt();
                int green = fileScanner.nextInt();
                int blue = fileScanner.nextInt();
                int redInvert = maxVal - red;
                int greenInvert = maxVal - green;
                int blueInvert = maxVal - blue;
                String row = red + " " + green + " " + blue + " ";
                String rowFilter = redInvert + " " + greenInvert + " " + blueInvert + " ";
                pixelRow = row + pixelRow;
                pixelRowFilter = rowFilter + pixelRowFilter;

            }
            outpic.println(pixelRowFilter + pixelRow);
        }
        outpic.flush();
    }

    public void displayFarewell() {
        System.out.println("\n");
        System.out.println("/ / / / / / / / / / / / / / / / / / / / /");
        System.out.println("/  Thanks for choosing Impractical PPM. /");
        System.out.println("/ / / / / / / / / / / / / / / / / / / / /");
    }
}
