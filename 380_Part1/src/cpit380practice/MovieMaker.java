package cpit380practice;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Class to create frames for a movie
 *
 * @author Barb Ericson
 */
public class MovieMaker {

    ///////////////// fields ///////////////////////////////
    private Random randNumGen = new Random();

    /**
     * Method to make a movie that has a rectangle moving around
     *
     * @param directory the directory to put the movie frames
     */
    public void makeRectangleMovie(String directory) {
        int framesPerSec = 25;
        Picture p = null;

        Graphics g = null;
        FrameSequencer frameSequencer = new FrameSequencer(directory);
        frameSequencer.setShown(true);

        String kidF = "C:\\Users\\SoHaIb\\Desktop\\CPIT380\\picGirl.png";
        Picture kidP = null;
//        String wallF = FileChooser.pickAFile();
        Picture wallP = new Picture("C:\\Users\\SoHaIb\\Desktop\\CPIT380\\girlOld.png");
//        String beachF = FileChooser.pickAFile();
        Picture beachP = new Picture("C:\\Users\\SoHaIb\\Desktop\\CPIT380\\girlNew.png");
        for (int i = 0; i < framesPerSec; i++) {
            kidP = new Picture(kidF);
            kidP.swapBackground(wallP, beachP, i);
            frameSequencer.addFrame(kidP);
            Graphics gr = kidP.getGraphics();
            gr.setColor(Color.white);
            gr.fillRect(100, 155, 100, 50);

            gr.setColor(Color.BLACK);
            gr.drawString("Sohaib Albakri", 105, 165);
            gr.drawString("1742285", 105, 180);
        }
        // loop through the first second
        for (int i = 0; i < framesPerSec / 2; i++) {

            // draw a filled rectangle
            p = new Picture(kidP);
            g = p.getGraphics();

            //Ova
            g.setColor(Color.RED);
            g.fillOval(126, 0 + i * 9, 50, 50);

            g.setColor(Color.BLUE);
            g.fillOval(126, (p.getHeight() - 50) - i * 9, 50, 50);
            //------
            //Ova
            g.setColor(Color.GREEN);
            g.fillOval(0 + i * 14, 100, 50, 50);

            g.setColor(Color.PINK);
            g.fillOval(p.getWidth() - 50 - i * 14, 100, 50, 50);
            //-----
            frameSequencer.addFrame(p);
        }
        for (int i = 0; i < framesPerSec / 2; i++) {
            p = new Picture(kidP);
            g = p.getGraphics();
            //Ova
            g.setColor(Color.RED);
            g.fillOval(126 - i * 10, 106 - i * 10, 50, 50);

            g.setColor(Color.BLUE);
            g.fillOval(126 + i * 10, 106 + i * 10, 50, 50);
            //------
            //Ova
            g.setColor(Color.GREEN);
            g.fillOval(126 + i * 10, 106 - i * 10, 50, 50);

            g.setColor(Color.PINK);
            g.fillOval(126 - i * 10, 106 + i * 10, 50, 50);
            //-----
            frameSequencer.addFrame(p);

        }
        // play the movie
        frameSequencer.play(framesPerSec);

    }

    //-----------------------------------------------------------------------------------
    public void makeRectMovieTopRightToBotLeft(String directory, int time) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer = new FrameSequencer(directory);
        frameSequencer.setShown(true);

        // loop through the first second
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < framesPerSec; j++) {
                // draw a filled rectangle
                p = new Picture(400, 400);
                g = p.getGraphics();
                g.setColor(Color.RED);
                g.fillRect(350 - j * 12, 0 + j * 12, 50, 50);

                // add frame to sequencer
                frameSequencer.addFrame(p);
            }
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    public void makeDropBallMovie(String directory, int time) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer = new FrameSequencer(directory);

        frameSequencer.setShown(true);
        int distance = 100;
        int height = 480;
        int start = (height - 50) - distance;
        for (int i = 0; i < framesPerSec * time; i++) {
            p = new Picture(640, height);
            g = p.getGraphics();
            int y = (int) (Math.sin(30 + (i)) * distance) + start;
            if (y > (height - 50 - 10)) {
                distance = distance / 2;
                start = (height - 50) - distance;
            }
            y = (int) (Math.sin(30 + (i)) * distance) + start;
            g.setColor(Color.RED);
            g.fillOval(i * 20, y, 50, 50);
            // add frame to sequencer
            frameSequencer.addFrame(p);
        }
        // play the movie
        frameSequencer.play(framesPerSec);
    }


    //-----------------------------------------------------------------------------------
    /**
     * Method to make a movie that has a oval moving from bottom left to top
     * right
     *
     * @param directory the directory to put the movie frames
     */
    public void makedrobpall(String directory) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        frameSequencer.setShown(true);

        // loop through the first second
        for (int i = 0; i < framesPerSec * 3; i++) {
            // draw a filled oval
            p = new Picture(640, 480);
            g = p.getGraphics();
            g.setColor(Color.RED);
            if (i <= framesPerSec) {
                g.fillOval(i * 3, i * 15, 50, 50);
            }
            if (i > framesPerSec && i <= framesPerSec * 2) {
                g.fillOval(i * 3, 480 - ((i - framesPerSec) * 3), 50, 50);
            }
            if (i > framesPerSec * 2 && i <= framesPerSec * 3) {
                g.fillOval(i * 3, i * 6, 50, 50);
            }
            // add frame to sequencer
            frameSequencer.addFrame(p);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a tickertape movie that moves from bottom to top
     *
     * @param directory the directory to write to
     * @param message the string to display
     */
    public void makeTickerTapeMovieBotTop(String directory,
            String message) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        Font font = new Font("Arial", Font.BOLD, 24);

        // loop for 2 seconds of animation
        for (int i = 0; i < framesPerSec * 2; i++) {
            // draw the string
            p = new Picture(300, 200);
            g = p.getGraphics();
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(message, 10, 190 - (i * 2));

            // add frame to sequencer
            frameSequencer.addFrame(p);
        }
        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a tickertape movie that moves from top left to bottom
     * right
     *
     * @param directory the directory to write to
     * @param message the string to display
     */
    public void makeTickerTapeMovieTopBot(String directory,
            String message) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        Font font = new Font("Arial", Font.BOLD, 24);

        // loop for 2 seconds of animation
        for (int i = 0; i < framesPerSec * 2; i++) {
            // draw the string
            p = new Picture(300, 200);
            g = p.getGraphics();
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(message, 10 + (i * 2), 10 + (i * 2));

            // add frame to sequencer
            frameSequencer.addFrame(p);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to make a movie that has a two rectangles moving around
     *
     * @param directory the directory to put the movie frames
     */
    public void makeTwoRectangleMovie(String directory) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);

        // loop through the first second
        for (int i = 0; i < framesPerSec * 20; i++) {
            // draw a filled rectangle
            p = new Picture(640, 480);
            g = p.getGraphics();
//      g.setColor(Color.RED);
//      g.fillRect(i * 10, i * 5, 50,50);
            g.setColor(Color.BLUE);
            g.fillRect(i, 100 + (int) (50 * Math.sin(i * (2 * 3.14 / 180.0))), 50, 50);

            // add frame to sequencer
            frameSequencer.addFrame(p);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to return a random amount added to i < 5 but checking not to
     * exceed the given max @param i the current value @param max
     *
     * t
     * he max for this direction (x or y) @return i + some random amount < 5
     */
    private int getRandomExtra(int i, int max) {
        int value = i + randNumGen.nextInt(5);
        if (value > max) {
            value = max - 5;
        }
        return value;
    }

    /**
     * Method to make a movie that has a two rectangles moving around by adding
     * a random amount less than 5 pixels
     *
     * @param directory the directory to put the movie frames
     */
    public void makeTwoRectangleRandMovie(String directory) {
        int framesPerSec = 30;
        Picture p = null;
        Graphics g = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);

        // loop through the first second
        for (int i = 0; i < framesPerSec; i++) {
            // draw a filled rectangle
            p = new Picture(640, 480);
            g = p.getGraphics();
            g.setColor(Color.RED);

            g.fillRect(getRandomExtra(i, 639),
                    getRandomExtra(i, 479),
                    50, 50);
            g.setColor(Color.BLUE);
            g.fillRect(getRandomExtra(i + 100, 639),
                    getRandomExtra(i, 479),
                    50, 50);

            // add frame to sequencer
            frameSequencer.addFrame(p);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    public void moveMarksHead(String directory, int time, Picture pic) {

        // declare other variables
        Picture target = null;
        FrameSequencer frameSequencer = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec * time; i++) {
            target = new Picture(640, 480);
            int randomX = (int) (Math.random() * 539);
            int randomY = (int) (Math.random() * 343);
            target.copy(pic, 0, 0, pic.getWidth() - 1, pic.getHeight() - 1, randomX, randomY);
            frameSequencer.addFrame(target);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to slowly create a sunset
     *
     * @param directory the directory to write to
     */
    public void makeSunsetMovie(String directory, double value, int time) {
        // load the picture of the beach
        String fName = FileChooser.pickAFile();
        Picture beachP = new Picture(fName);

        // declare other variables
        Picture target = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        frameSequencer.setShown(true);

        // loop creating the frames
        for (int i = 0; i < framesPerSec * time; i++) {
            beachP.makeSunset(100 - i * value);
            frameSequencer.addFrame(beachP);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to slowly create a sunset and after a certain amount of reduction
     * make the picture fade to black
     *
     * @param directory the directory to write to
     */
    public void makeSunsetMovie2(String directory, double threshold) {
        // load the picture of the beach
        String fName = FileChooser.pickAFile();
        Picture beachP = new Picture(fName);
        double amountReduction = 1;
        Picture blackP = new Picture(beachP.getWidth(), beachP.getHeight(),
                Color.BLACK);
        // declare other variables
        Picture temp = null;
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            temp = new Picture(beachP);
            amountReduction = amountReduction * 0.95;
            if (amountReduction < threshold) {
                temp.modifyTowards(blackP, i, framesPerSec);
            } else {
                temp.makeSunset(amountReduction);
            }
            frameSequencer.addFrame(temp);

        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a movie that fades out the person from one background to
     * another.
     *
     * @param directory the directory to write to
     */
    public void makeFadeOutMovie(String directory, int time) {
        // load the pictures
        String foreground = FileChooser.pickAFile();
        Picture foregroundPic = null;

        String oldBG = FileChooser.pickAFile();
        Picture oldBGPic = new Picture(oldBG);

        String newBG = FileChooser.pickAFile();
        Picture newBGPic = new Picture(newBG);

        // declare other variables
        FrameSequencer frameSequencer = new FrameSequencer(directory);
        int framesPerSec = 30;
        frameSequencer.setShown(true);
        // loop creating the frames
        for (int i = 0; i < framesPerSec * time; i++) {
            foregroundPic = new Picture(foreground);
            foregroundPic.swapBackground(oldBGPic, newBGPic, i);
            frameSequencer.addFrame(foregroundPic);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a movie that fades out the person
     *
     * @param directory the directory to write to
     */
    public void makeFadeOutMovie2(String directory) {
        // load the pictures
        String kidF = FileChooser.getMediaPath("kid-in-frame.jpg");
        Picture kidP = null;
        String wallF = FileChooser.getMediaPath("bgframe.jpg");
        Picture wallP = new Picture(wallF);
        String bgF = FileChooser.getMediaPath("bgframe.jpg");
        Picture bgP = new Picture(bgF);

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec * 2; i++) {
            kidP = new Picture(kidF);
            kidP.swapBackground(wallP, bgP, i);
            frameSequencer.addFrame(kidP);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to make a movie of barb's head moving and katie dancing
     *
     * @param dir the directory to read from and write to
     */
    public void makeMommyWatchingMovie(String dir) {
        String barbF = FileChooser.getMediaPath("barbaraS.jpg");
        String katieDir
                = FileChooser.getMediaPath("kid-in-bg-seq/");
        Picture barbP = new Picture(barbF);
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File(katieDir);
        String[] fileArray = dirObj.list();

        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].indexOf(".jpg") >= 0) {
                currP = new Picture(katieDir + fileArray[i]);
                currP.copy(barbP, 22, 9, 93, 97, i * 3, i * 3);
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(30);
    }

    /**
     * Method to make a movie a turtle moving across the movie of the blowhole
     *
     * @param dir the directory to read from and write to
     */
    public void makeTurtleBlowholeMovie(String dir) {
        String turtleF = FileChooser.getMediaPath("turtle.jpg");
        String blowholeDir
                = FileChooser.getMediaPath("blowhole/");
        Picture turtleP = new Picture(turtleF);
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File(blowholeDir);
        String[] fileArray = dirObj.list();

        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].indexOf(".jpg") >= 0) {
                currP = new Picture(blowholeDir + fileArray[i]);
                currP.copy(turtleP, i, 150);
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(30);
    }

    /**
     * Method to make a movie of the kids crawling on the moon
     *
     * @param dir the directory to write the frames to
     */
    public void makeKidsOnMoonMovie(String dir) {
        Picture moonP = new Picture("C:\\Users\\SoHaIb\\Desktop\\abc.jpg");
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File("C:\\Users\\SoHaIb\\Desktop\\Test");
        String[] fileArray = dirObj.list();
        frameSequencer.setShown(true);
        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].contains(".jpg")) {
                currP = new Picture("C:\\Users\\SoHaIb\\Desktop\\Test\\" + fileArray[i]);
                currP.chromakey(moonP, Color.GREEN, 160.0);
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(30);
    }

    public void parkingDetaction(String dir) {
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File("frames");
        String[] fileArray = dirObj.list();
        frameSequencer.setShown(true);
        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].contains(".png")) {
                currP = new Picture("frames\\" + fileArray[i]);
                int numOfYellow = countYellow(currP);
                if (numOfYellow > 8184 * 0.3) {
                    Graphics g = currP.getGraphics();
                    g.setColor(Color.GREEN);//draw green rec
                    g.fillRect(currP.getWidth() - 150, currP.getHeight() - 40, 100, 20);
                } else {//70% is coverd
                    Graphics g = currP.getGraphics();
                    g.setColor(Color.RED);//draw red rec
                    g.fillRect(currP.getWidth() - 150, currP.getHeight() - 40, 100, 20);
                }
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(17);
    }

    public int countYellow(Picture pic) {
        Pixel[] pixels = pic.getPixels();
        int count = 0;
        Color c = new Color(255, 255, 128);
        for (Pixel pixel : pixels) {
            if (pixel.colorDistance(c) < 30) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method to make a movie of the kids crawling on the beach
     *
     * @param dir the directory to write the frames to
     */
    public void makeKidsOnBeachMovie(String dir) {
        String kidsDir = FileChooser.getMediaPath("kids-blue/");
        String beachF = FileChooser.getMediaPath("beach.jpg");
        Picture beachP = new Picture(beachF);
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File(kidsDir);
        String[] fileArray = dirObj.list();

        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].indexOf(".png") >= 0) {
                currP = new Picture(kidsDir + fileArray[i]);
                currP.chromakey(beachP, Color.black, 100.0);
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(30);
    }

    /**
     * Method to lighten the pixels that are near black in a movie
     *
     * @param dir the directory to write the frames to
     */
    public void makeLighterMovie(String dir) {
        String movieDir = FileChooser.getMediaPath("dark-fish2/");
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File(movieDir);
        String[] fileArray = dirObj.list();

        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].indexOf(".jpg") >= 0) {
                currP = new Picture(movieDir + fileArray[i]);
                currP.lighten(Color.BLACK, 8, 5);
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(30);
    }

    /**
     * Method to change the red and green values in the frames
     *
     * @param dir the directory to write the frames to
     */
    public void makeFishMovie(String dir) {
        String movieDir = FileChooser.getMediaPath("fish/");
        FrameSequencer frameSequencer = new FrameSequencer(dir);
        Picture currP = null;

        // get the array of files in the directory
        File dirObj = new File(movieDir);
        String[] fileArray = dirObj.list();

        // loop through the array of files
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].indexOf(".jpg") >= 0) {
                currP = new Picture(movieDir + fileArray[i]);
                currP.changeRedAndGreen(2.0, 1.5);
                frameSequencer.addFrame(currP);
            }
        }

        // play the movie
        frameSequencer.play(16);
    }

    /**
     * Method to create a sepia-toned movie
     *
     * @param p the picture to use in the movie
     * @param directory the directory to store the frames in
     */
    public void makeSepiaMovie(Picture p, String directory) {
        // make a copy of the picture
        Picture copyPict = null;
        Picture origPict = new Picture(p);

        // make a sepia-toned picture
        p.sepiaTint();

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(origPict);
            copyPict.modifyTowards(p, i, framesPerSec);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a movie where the picture changes to the negative image
     *
     * @param p the picture to use in the movie
     * @param directory the directory to store the frames in
     */
    public void makeNegativeMovie(Picture p, String directory) {
        // make a copy of the picture
        Picture copyPict = null;
        Picture origPict = new Picture(p);

        // make a negative picture
        p.negate();

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(origPict);
            copyPict.modifyTowards(p, i, framesPerSec);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a posterized movie
     *
     * @param p the picture to use in the movie
     * @param directory the directory to store the frames in
     */
    public void makePosterizedMovie(Picture p, String directory) {
        // make a copy of the picture
        Picture copyPict = null;

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(p);
            copyPict.posterize(30 - i);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a posterized movie
     *
     * @param p the picture to use in the movie
     * @param directory the directory to store the frames in
     */
    public void makeEdgeDetectMovie(Picture p, String directory) {
        // make a copy of the picture
        Picture copyPict = null;

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(p);
            copyPict.edgeDetection(31 - i);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a movie where one picture blends into the other
     *
     * @param directory the directory to store the frames in
     */
    public void makeBlendedMovie(String directory) {
        // get the pictures to blend
        Picture pict1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
        Picture pict2 = new Picture(FileChooser.getMediaPath("blueShrub.jpg"));
        Picture copyPict = null;

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(pict1);
            copyPict
                    = copyPict.blendPictures(pict2, ((double) i) / framesPerSec);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a movie where a turtle crawls across the beach
     *
     * @param directory the directory to store the frames in
     */
    public void makeTurtleMovie(String directory) {
        // get the pictures to use
        Picture pict1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
        Picture pict2 = new Picture(FileChooser.getMediaPath("turtle.jpg"));
        Picture copyPict = null;

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(pict1);
            copyPict.copy(pict2, i + 7, 300);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a movie where a robot crawls across the moon
     *
     * @param directory the directory to store the frames in
     */
    public void makeRobotMovie(String directory) {
        // get the pictures to use
        Picture pict1 = new Picture(FileChooser.getMediaPath("moon-surface.jpg"));
        Picture pict2 = new Picture(FileChooser.getMediaPath("robot.jpg"));
        Picture copyPict = null;

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            copyPict = new Picture(pict1);
            copyPict.copy(pict2, i + 7, 300);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    /**
     * Method to create a rotating image movie
     *
     * @param p the picture to rotate
     * @param directory the directory to store the frames in
     */
    public void makeRotatingMovie(Picture p, String directory) {
        // make a copy of the picture
        Picture tempPict = null;
        int max = Math.max(p.getWidth(), p.getHeight());
        Picture copyPict = null;

        // declare other variables
        FrameSequencer frameSequencer
                = new FrameSequencer(directory);
        int framesPerSec = 30;

        // loop creating the frames
        for (int i = 0; i < framesPerSec; i++) {
            tempPict = new Picture(p);
            tempPict = tempPict.rotate(i * 5);
            copyPict = new Picture(max, max);
            copyPict.copy(tempPict, 0, 0);
            frameSequencer.addFrame(copyPict);
        }

        // play the movie
        frameSequencer.play(framesPerSec);
    }

    public static void main(String[] args) {
        MovieMaker movieMaker = new MovieMaker();
        //String dir = "c:/intro-prog-java/movies/rectangle/";
        //movieMaker.makeRectangleMovie(dir);
        //String dir = "c:/intro-prog-java/movies/tickertape/";
        //movieMaker.makeTickerTapeMovie(dir,"Buy more widgets");
        //String dir = "c:/intro-prog-java/movies/rectangle2/";
        //movieMaker.makeTwoRectangleMovie(dir);
        //String dir = "c:/intro-prog-java/movies/mark/";
        //movieMaker.moveMarksHead(dir);
//    String dir = "C:\\intro-prog-java\\movies\\sunset";
//     movieMaker.makeSunsetMovie(dir);
//    String dir = "C:\\intro-prog-java\\movies\\backgroun";
//    movieMaker.makeFadeOutMovie(dir);
        //String dir = "c:/intro-prog-java/movies/mommy/";
        //movieMaker.makeMommyWatchingMovie(dir);
        //String dir = "c:/intro-prog-java/movies/moon/";
        //movieMaker.chromaKey(dir);
        //String dir = "c:/intro-prog-java/movies/lighter/";
        //movieMaker.makeLighterMovie(dir);
        //String dir = "c:/intro-prog-java/movies/fish/";
        //movieMaker.makeFishMovie(dir);

//    String dir = "c:/intro-prog-java/movies/sepia/";
//    Picture p = new Picture(FileChooser.getMediaPath("gorge.jpg"));
//    movieMaker.makeSepiaMovie(p,dir);
//    String dir = "c:/intro-prog-java/movies/poster/";
//    Picture p = new Picture(FileChooser.getMediaPath("tammy.jpg"));
//    movieMaker.makePosterizedMovie(p,dir);
//    String dir = "c:/intro-prog-java/movies/negate/";
//    Picture p = new Picture(FileChooser.getMediaPath("caterpillar.jpg"));
//    movieMaker.makeNegativeMovie(p,dir);
//    String dir = "c:/intro-prog-java/movies/rotate/";
//    Picture p = new Picture(FileChooser.getMediaPath("flower1.jpg"));
//    movieMaker.makeRotatingMovie(p,dir);
//    String dir = "c:/intro-prog-java/movies/beach/";
//    movieMaker.makeKidsOnBeachMovie(dir);
//   String dir = "C:\\intro-prog-java\\movies\\backgroun";
//    movieMaker.makeFadeOutMovie2(dir);
//    String dir = "c:/intro-prog-java/movies/blend/";
//    movieMaker.makeBlendedMovie(dir);
//    String dir = "c:/intro-prog-java/movies/turtle/";
//    movieMaker.makeTurtleMovie(dir);
//    String dir = "c:/intro-prog-java/movies/robot/";
//    movieMaker.makeRobotMovie(dir);
//    String dir = "c:/intro-prog-java/movies/oval/";
//    movieMaker.makeOvalMovie(dir);
//    String dir = "c:/intro-prog-java/movies/rectTopRBotL/";
//    movieMaker.makeRectMovieTopRightToBotLeft(dir);
//    String dir = "c:/intro-prog-java/movies/tickerTapeBotTop/";
//    movieMaker.makeTickerTapeMovieBotTop(dir, "Talk like a pirate day!");
//    String dir = "c:/intro-prog-java/movies/tickerTapeTopLBotR/";
//    movieMaker.makeTickerTapeMovieTopBot(dir, "Talk like a pirate day!");
//    String dir = "c:/intro-prog-java/movies/turtleBlowhole/";
//    movieMaker.makeTurtleBlowholeMovie(dir);
//    String dir = "c:/intro-prog-java/movies/randRects/";
//    movieMaker.makeTwoRectangleRandMovie(dir);
//        String dir = "C:\\intro-prog-java\\movies\\edge";
//        movieMaker.makedrobpall(dir);
//    
//    String dir = "C:\\intro-prog-java\\movies\\edge";
//    Picture p = new Picture(FileChooser.pickAFile());
//    movieMaker.makeEdgeDetectMovie(p,dir);
    }

}
