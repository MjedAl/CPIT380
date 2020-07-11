package cpit380practice;

import java.io.*;
import java.awt.*;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 * Class that represents a sound. This class is used by the students to extend the capabilities of SimpleSound.
 *
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound {

    /////////////// consructors ////////////////////////////////////
    /**
     * Constructor that takes a file name
     *
     * @param fileName the name of the file to read the sound from
     */
    public Sound(String fileName) {
        // let the parent class handle setting the file name
        super(fileName);
    }

    /**
     * Constructor that takes the number of samples that this sound will have
     *
     * @param numSamples the number of samples desired
     */
    public Sound(int numSamples) {
        // let the parent class handle this
        super(numSamples);
    }

    /**
     * Constructor that takes a sound to copy
     */
    public Sound(Sound copySound) {
        // let the parent class handle this
        super(copySound);
    }

    ////////////////// methods ////////////////////////////////////
    /**
     * Method to return the string representation of this sound
     *
     * @return a string with information about this sound
     */
    public String toString() {
        String output = "Sound";
        String fileName = getFileName();

        // if there is a file name then add that to the output
        if (fileName != null) {
            output = output + " file: " + fileName;
        }

        // add the length in frames
        output = output + " number of samples: " + getLengthInFrames();

        return output;
    }

    /**
     * Method to pick a sound file, create the sound object, play the sound object, and return the sound object
     *
     * @return the created sound object
     */
    public static Sound pickAndPlay() {
        String aFileName = FileChooser.pickAFile();
        Sound aSound = new Sound(aFileName);
        aSound.play();
        return aSound;
    }

    /**
     * Method to play a specific sound. The sound to play is specified in the method. To change the sound that this method plays change the file name in the method and recompile
     *
     * @return the created sound object
     */
    public static Sound playSpecificSound() {
        String myFile
                = "C:/intro-prog-java/mediasources/thisisatest.wav";
        Sound mySound = new Sound(myFile);
        mySound.play();
        return mySound;
    }

    /**
     * Method to create a sound object from the given file name and play the sound. It also returns the created sound object
     *
     * @return the created sound object
     */
    public static Sound playNamed(String fileName) {
        Sound mySound = new Sound(fileName);
        mySound.play();
        return mySound;
    }

    /**
     * Method that just shows how to get each sample value and set it again
     */
    public void doNothing() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int index = 0;
        int value = 0;

        // loop through all the samples in the array
        while (index < sampleArray.length) {
            sample = sampleArray[index];
            value = sample.getValue();
            sample.setValue(value);
            index++;
        }
    }

    /**
     * Method to go through each sound sample and set the sample value to the original value. This is simply a template for processing sounds using an array of SoundSample objects
     */
//  public void doNothing15()
//  {
//    SoundSample[] sampleArray = this.getSamples();
//    
//    for (SoundSample sample : sampleArray) {
//      sample.setValue(sample.getValue());
//    }
//      
//  }
    /**
     * Method to double the volume (amplitude) of the sound, using a for each loop
     */
    public void increaseVolumeForEach() {
        SoundSample[] sampleArray = this.getSamples();
        int value = 0;

        // loop through all the samples in the array
        for (SoundSample sample : sampleArray) {
            value = sample.getValue();
            sample.setValue(value * 2);
        }
    }

    /**
     * Method to halve the volumne for positive and double the volume for negative sound values
     */
    public void halvePosDoubleNeg() {
        SoundSample[] sampleArray = this.getSamples();
        int value = 0;

        // loop through all the samples in the array
        for (SoundSample sample : sampleArray) {
            value = sample.getValue();
            if (value >= 0) {
                sample.setValue(value / 2);
            } else {
                sample.setValue(value * 2);
            }
        }
    }

    /**
     * Method to find the smallest value in a sound and print it, it will also return it
     */
    public int findSmallest() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int smallest = sampleArray[0].getValue();
        int value = 0;

        // loop through all the samples in the array
        for (int i = 1; i < sampleArray.length; i++) {
            sample = sampleArray[i];
            value = sample.getValue();
            if (value < smallest) {
                smallest = value;
            }
        }
        System.out.println("The smallest value is " + smallest);
        return smallest;
    }

    /**
     * Method to add an amount to each sound value
     *
     * @param amount the amount to add
     */
    public void addAmount(int amount) {
        SoundSample[] sampleArray = this.getSamples();

        // loop through the sample array
        for (SoundSample sample : sampleArray) {
            sample.setValue(sample.getValue() + amount);
        }
    }

    /**
     * Method to change 200 values in the middle of a sound to the passed amount
     *
     * @param amount the amount to set the values to
     */
    public void set200ValuesToAmount(int amount) {
        SoundSample[] sampleArray = this.getSamples();
        int start = sampleArray.length / 2 - 100;
        int end = start + 200;
        SoundSample sample = null;

        // loop through some samples
        for (int i = start; i < end; i++) {
            sample = sampleArray[i];
            sample.setValue(amount);
        }
    }

    /**
     * Method to double the volume (amplitude) of the sound using a while loop
     */
    public void increaseVolume() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int value = 0;
        int index = 0;

        // loop through all the samples in the array
        while (index < sampleArray.length) {
            sample = sampleArray[index];
            value = sample.getValue();
            sample.setValue(value * 2);
            index++;
        }
    }

    /**
     * Method to increase the volume (double it) using a for loop
     */
    public void increaseVolumeFor() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int value = 0;
        int index = 0;

        // loop through all the samples in the array
        for (int i = 0; i < sampleArray.length; i++) {
            sample = sampleArray[i];
            value = sample.getValue();
            sample.setValue(value * 2);
        }

    }

    /**
     * Method to modify the volume by the passed factor in the passed range
     *
     * @param factor the amount to multiply the value by
     * @param start the index to use as the start (inclusive)
     * @param end the index to end at (exclusive)
     */
    public void changeVolume(double factor,
            int start,
            int end) {
        int value = 0;
        for (int i = start;
                i < this.getLength() && i < end;
                i++) {
            value = this.getSampleValueAt(i);
            this.setSampleValueAt(i, (int) (value * factor));
        }
    }

    /**
     * Method to halve the volume (amplitude) of the sound.
     */
    public void decreaseVolume() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int value = 0;
        int index = 0;

        // loop through all the samples in the array
        while (index < sampleArray.length) {
            sample = sampleArray[index];
            value = sample.getValue();
            sample.setValue((int) (value * 0.5));
            index++;
        }
    }

    /**
     * Method to halve the volume (amplitude) of the sound.
     */
    public void decreaseVolume2() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int value = 0;
        // int index = 0;

        // loop through all the samples in the array
        // while (index < sampleArray.length)
        for (int index = 0; index < sampleArray.length; index++) {
            sample = sampleArray[index];
            value = sample.getValue();
            sample.setValue((int) (value * 0.5));
            // index++;
        }
    }

    /**
     * Method to change the volume (amplitude) of the sound by multiplying the current values in the sound by the passed factor.
     *
     * @param factor the factor to multiply by
     */
    public void changeVolume(double factor) {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;
        int value = 0;

        // loop through all the samples in the array
        for (int i = 0; i < sampleArray.length; i++) {
            sample = sampleArray[i];
            value = sample.getValue();
            sample.setValue((int) (value * factor));
        }
    }

    /**
     * Method to noramlize a sound in a range
     *
     * @param start the index of the starting value (inclusive)
     * @param end the index of the ending value (not inclusive)
     */
    public void normalize(int start, int end) {
        int max = start;
        int value = 0;

        // loop from start to end looking for the max
        for (int i = start; i < end; i++) {
            value = this.getSampleValueAt(i);
            if (Math.abs(value) > Math.abs(max)) {
                max = value;
            }
        }

        // determine the multiplier
        double multiplier = 32767.0 / max;
        System.out.println("multi is " + multiplier);

        // change the volume by the multiplier
        this.changeVolume(multiplier, start, end);
    }

    /**
     * Method to normalize the first second of the sound and then decrease the volume by 1/5 for each additional second
     */
    public void normSecThenDecrease() {
        int numInSec = (int) this.getSamplingRate();
        double reduction = 1.0 / 5.0;
        double totalReduction = reduction;
        int numSecs = this.getLength() / numInSec;
        if (numSecs > 5) {
            numSecs = 5;
        }

        // normalize the first second
        this.normalize(0, numInSec);

        // loop changing the volume
        for (int i = 1; i < numSecs; i++) {
            this.changeVolume(1.0 - totalReduction,
                    i * numInSec,
                    (i + 1) * numInSec);
            totalReduction = totalReduction + reduction;
        }
    }

    /**
     * Method to have a linear increase in volume to halfway and then a linear decrease in volume
     *
     * @param maxChange the change at halfway will be maxChange
     */
    public void linearIncreaseDecrease(double maxChange) {
        int length = this.getLength();
        int half = length / 2;
        double change = maxChange / half;
        double totalChange = change;
        int value = 0;

        // loop increasing each time to half
        for (int i = 0; i < half; i++) {
            value = this.getSampleValueAt(i);
            value = (int) (value * totalChange);
            totalChange = totalChange + change;
            this.setSampleValueAt(i, value);
        }

        // loop decreasing each time to end
        for (int i = half; i < this.getLength(); i++) {
            value = this.getSampleValueAt(i);
            totalChange = totalChange - change;
            value = (int) (value * totalChange);
            this.setSampleValueAt(i, value);
        }
    }

    /**
     * Method to create a piano sound from a sine wave
     *
     * @param freq the frequency of the sound wave
     * @param maxAmplitude the maximum amplitude (volume) of the wave
     */
    public static Sound createPianoSoundSineWave(int freq, int maxAmplitude) {
        Sound sineWave = Sound.createSineWave(freq, maxAmplitude);
        int len = sineWave.getLength();
        sineWave.decreaseVolBeforeIndex((int) (len * 0.2), 10);
        sineWave.decreaseVolAfterIndex((int) (len * 0.8), 10);
        return sineWave;
    }

    /**
     * Method to create a flute sound from a sine wave
     *
     * @param freq the frequency of the sound wave
     * @param maxAmplitude the maximum amplitude (volume) of the wave
     */
    public static Sound createFluteSoundSineWave(int freq, int maxAmplitude) {
        Sound sineWave = Sound.createSineWave(freq, maxAmplitude);
        int len = sineWave.getLength();
        sineWave.decreaseVolBeforeIndex((int) (len * 0.5), 10);
        return sineWave;
    }

    /**
     * Method to modify a sound to start at lower vol and increase the volume linearly in num steps to the volume at the passed index
     *
     * @param index the index to stop the change at
     * @param numSteps the number of steps to increase
     */
    public void decreaseVolBeforeIndex(int index, int numSteps) {
        int lengthInterval = index / numSteps;
        int currIndex = 0;
        double increment = 1.0 / numSteps;
        double factor = increment;
        int value;

        for (int j = 0; j < numSteps; j++) {
            for (int i = 0; i < lengthInterval; i++) {
                currIndex = j * lengthInterval + i;
                value = this.getSampleValueAt(currIndex);
                this.setSampleValueAt(currIndex, (int) (value * factor));
            }
            factor = factor + increment;
        }
    }

    /**
     * Method to modify a sound to end at lower vol and increase the volume linearly in num steps back to the volume at the passed index
     *
     * @param index the index to stop the change at
     * @param numSteps the number of steps to increase
     */
    public void decreaseVolAfterIndex(int index, int numSteps) {
        int lengthInterval = (this.getLength() - index) / numSteps;
        int currIndex = 0;
        double increment = 1.0 / numSteps;
        double factor = 1.0 - increment;
        int value;

        for (int j = 0; j < numSteps; j++) {
            for (int i = 0; i < lengthInterval; i++) {
                currIndex = index + (j * lengthInterval + i);
                value = this.getSampleValueAt(currIndex);
                this.setSampleValueAt(currIndex, (int) (value * factor));
            }
            factor = factor - increment;
        }
    }

    /**
     * Method to change the frequency of a sound to the passed frequency
     *
     * @param freq the desired frequency
     */
    public void shiftFreq(int freq) {
        double factor = this.getLength() * (freq / this.getSamplingRate());
        this.changeFreq2(factor);
    }

    /**
     * Method to normalize (make as loud as possible) a sound.
     */
    public void normalize() {
        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = sampleArray[0];
        int value = sample.getValue();
        int max = 0;
        int maxIndex = 0;

        // loop comparing the absolute value of the current value 
        // to the current largest
        for (int i = 1; i < sampleArray.length; i++) {
            sample = sampleArray[i];
            value = sample.getValue();
            if (Math.abs(value) > Math.abs(max)) {
                max = value;
                maxIndex = i;
            }
        }

        // now calculate the multiplier to multiply by
        double multiplier = 32767.0 / max;

        // print out the largest value and the multiplier
        System.out.println("The largest value was " + max
                + " at index " + maxIndex);
        System.out.println("The multiplier is " + multiplier);

        /* loop through all the samples and multiply by the 
     * multiplier
         */
        for (int i = 0; i < sampleArray.length; i++) {
            sample = sampleArray[i];
            sample.setValue((int) (sample.getValue() * multiplier));
        }
    }

    /**
     * Method to set all the sample values to the maximum positive value if they were positive (including 0) and the minimum negative value if they were negative.
     */
    public void forceToExtremes() {

        SoundSample[] sampleArray = this.getSamples();
        SoundSample sample = null;

        // loop through the sample values
        for (int i = 0; i < sampleArray.length; i++) {
            // get the current sample
            sample = sampleArray[i];

            /* if the value was positive or 0 set to the maximum 
       * positive value
             */
            if (sample.getValue() >= 0) {
                sample.setValue(32767);
            } /* else (must be less than 0) so set it to the minimum 
       * negative value
             */ else {
                sample.setValue(-32768);
            }
        }
    }

    /**
     * Method to increase the first half of the sound (double it) and then decrease the second half (half it).
     */
    public void increaseHalfDecreaseHalf() {
        int half = this.getLength() / 2;
        int value = 0;

        // loop through the first half of the sound
        for (int i = 0; i < half; i++) {

            // get the current value
            value = this.getSampleValueAt(i);

            // set the value to 2x the original
            this.setSampleValueAt(i, value * 2);
        }

        // loop through the second half of the sound
        for (int i = half; i < this.getLength(); i++) {
            // get the current value
            value = this.getSampleValueAt(i);

            // set the value to half the original
            this.setSampleValueAt(i, (int) (value * 0.5));
        }

    }

    /**
     * Method to increase the first half of the sound (double it) and then decrease the second half (half it).
     *
     * @param percentage as a double (10% = 0.1)
     */
    public void increaseAndDecrease(double percentage) {
        int changePoint
                = (int) (this.getLength() * percentage);
        int value = 0;

        // loop through the first part of the sound
        for (int i = 0; i < changePoint; i++) {

            // get the current value
            value = this.getSampleValueAt(i);

            // set the value to 2x the original
            this.setSampleValueAt(i, value * 2);
        }

        // loop through the second part of the sound
        for (int i = changePoint; i < this.getLength(); i++) {
            // get the current value
            value = this.getSampleValueAt(i);

            // set the value to half the original
            this.setSampleValueAt(i, (int) (value * 0.5));
        }

    }

    /**
     * Method to create a new sound by copying just part of the current sound to a new sound
     *
     * @param start the index to start the copy at (inclusive)
     * @param end the index to stop the copy at (inclusive)
     * @return a new sound with just the samples from start to end in it
     */
    public Sound clip(int start, int end) {
        // calculate the number of samples in the clip
        int lengthInSamples = end - start + 1;
        Sound target = new Sound(lengthInSamples); // hold clip
        int value = 0;        // holds the current sample value
        int targetIndex = 0;  // index in target sound

        // copy from start to end from source into target
        for (int i = start; i <= end; i++, targetIndex++) {
            value = this.getSampleValueAt(i);
            target.setSampleValueAt(targetIndex, value);
        }

        return target;
    }

    /**
     * Method to splice two sounds together with some silence between them into the current sound
     *
     * @return the resulting sound
     */
    public static Sound spliceS() {
        Sound sound1
                = new Sound(FileChooser.getMediaPath("guzdial.wav"));
        Sound sound2
                = new Sound(FileChooser.getMediaPath("is.wav"));
        Sound target
                = new Sound(FileChooser.getMediaPath("sec3silence.wav"));
        int targetIndex = 0; // the starting place on the target
        int value = 0;

        // copy all of sound 1 into the target
        for (int i = 0; i < sound1.getLength(); i++, targetIndex++) {
            value = sound1.getSampleValueAt(i);
            target.setSampleValueAt(targetIndex, value);
        }

        // create silence between words by setting values to 0
        for (int i = 0; i < (int) (target.getSamplingRate() * 0.1);
                i++, targetIndex++) {
            target.setSampleValueAt(targetIndex, 0);
        }

        // copy all of sound 2 into the target
        for (int i = 0; i < sound2.getLength(); i++, targetIndex++) {
            value = sound2.getSampleValueAt(i);
            target.setSampleValueAt(targetIndex, value);
        }

        // play the resulting sound
        target.play();

        return target;
    }

    /**
     * Method to splice two sounds together with some silence between them into the current sound
     */
    public void splice() {
        Sound sound1
                = new Sound(FileChooser.pickAFile());
        Sound sound2
                = new Sound(FileChooser.pickAFile());
        int targetIndex = 0; // the starting place on the target
        int value = 0;

        // copy all of sound 1 into the current sound (target)
        for (int i = 0;
                i < sound1.getLength();
                i++, targetIndex++) {
            value = sound1.getSampleValueAt(i);
            this.setSampleValueAt(targetIndex, value);
        }

        // create silence between words by setting values to 0
        for (int i = 0;
                i < (int) (this.getSamplingRate() * 0.1);
                i++, targetIndex++) {
            this.setSampleValueAt(targetIndex, 0);
        }

        // copy all of sound 2 into the current sound (target)
        for (int i = 0;
                i < sound2.getLength();
                i++, targetIndex++) {
            value = sound2.getSampleValueAt(i);
            this.setSampleValueAt(targetIndex, value);
        }
    }

    /**
     * Method to splice "We the " then "United" then "people of the United States" into the current sound
     */
    public void splicePreamble() {
        String file = FileChooser.getMediaPath("preamble10.wav");
        Sound source = new Sound(file);
        int targetIndex = 0; // start copying to first sample value
        int value = 0;

        // loop copying the "We the " into the current sound
        for (int sourceIndex = 0;
                sourceIndex < 17407;
                sourceIndex++, targetIndex++) {
            value = source.getSampleValueAt(sourceIndex);
            this.setSampleValueAt(targetIndex, value);
        }

        // print the value of the target index
        System.out.println("Target index is " + targetIndex);

        // loop copying the "united" into the current sound
        for (int sourceIndex = 33414;
                sourceIndex < 40052;
                sourceIndex++, targetIndex++) {
            value = source.getSampleValueAt(sourceIndex);
            this.setSampleValueAt(targetIndex, value);
        }

        // print the value of the target index
        System.out.println("Target index is " + targetIndex);

        // copy the "people of the United States"
        for (int sourceIndex = 17408;
                sourceIndex < 55510;
                sourceIndex++, targetIndex++) {
            value = source.getSampleValueAt(sourceIndex);
            this.setSampleValueAt(targetIndex, value);
        }

        // print the value of the target index
        System.out.println("Target index is " + targetIndex);
    }

    /**
     * Method to splice "We the " then "United" normalized (as loud as possible) then "people of the United States" into the current sound
     */
    public void splicePreambleLoudUnited() {
        String file = FileChooser.getMediaPath("preamble10.wav");
        Sound source = new Sound(file);
        int targetIndex = 0; // start copying to first sample value
        int value = 0;

        // loop copying the "We the " into the current sound
        for (int sourceIndex = 0;
                sourceIndex < 17407;
                sourceIndex++, targetIndex++) {
            value = source.getSampleValueAt(sourceIndex);
            this.setSampleValueAt(targetIndex, value);
        }

        // print the value of the target index
        System.out.println("Target index is " + targetIndex);

        // loop copying the "united" into the current sound
        int startTarget = targetIndex;
        for (int sourceIndex = 33414;
                sourceIndex < 40052;
                sourceIndex++, targetIndex++) {
            value = source.getSampleValueAt(sourceIndex);
            this.setSampleValueAt(targetIndex, value);
        }
        this.normalize(startTarget, targetIndex);

        // print the value of the target index
        System.out.println("Target index is " + targetIndex);

        // copy the "people of the United States"
        for (int sourceIndex = 17408;
                sourceIndex < 55510;
                sourceIndex++, targetIndex++) {
            value = source.getSampleValueAt(sourceIndex);
            this.setSampleValueAt(targetIndex, value);
        }

        // print the value of the target index
        System.out.println("Target index is " + targetIndex);
    }

    /**
     * Method to splice "United" into "We the people of the United States" by adding it after the "the"
     *
     * @return the changed sound
     */
    public static Sound splicePreambleS() {
        String file = FileChooser.getMediaPath("preamble10.wav");
        Sound source = new Sound(file);
        Sound target = new Sound(file);
        int targetIndex = 17408;  // declare here since need to keep it 

        // loop copying the "united" after "the"
        for (int sourceIndex = 33414; sourceIndex < 40052;
                sourceIndex++, targetIndex++) {
            target.setSampleValueAt(targetIndex,
                    source.getSampleValueAt(sourceIndex));
        }

        // copy after "united" the rest of the original
        for (int sourceIndex = 17408;
                sourceIndex < source.getLength()
                && targetIndex < target.getLength();
                sourceIndex++, targetIndex++) {
            target.setSampleValueAt(targetIndex,
                    source.getSampleValueAt(sourceIndex));
        }

        // play the resulting sound
        target.play();

        // return the resulting sound
        return target;
    }

    /**
     * Method to copy part of the passed sound into this sound at the given start index
     *
     * @param source the source sound to copy from
     * @param sourceStart the starting index to copy from in the source
     * @param sourceStop the ending index (the copy won't include this)
     * @param targetStart the index to start copying into
     */
    public void splice(Sound source, int sourceStart, int sourceStop,
            int targetStart) {
        // loop copying from source to target
        for (int sourceIndex = sourceStart, targetIndex = targetStart;
                sourceIndex < sourceStop && targetIndex < this.getLength();
                sourceIndex++, targetIndex++) {
            this.setSampleValueAt(targetIndex,
                    source.getSampleValueAt(sourceIndex));
        }
    }

    /**
     * Method to splice the preamble into the current sound so that it says We the United people of the United States
     */
    public void splicePreamble2() {
        Sound preamble
                = new Sound(FileChooser.getMediaPath("preamble10.wav"));

        // first splice the "we the" into the current sound
        this.splice(preamble, 0, 17407, 0);

        // now splice the "united" into the current sound
        this.splice(preamble, 33414, 40052, 17407);

        /* now splice the "people of the United States" into
     * the current sound
         */
        this.splice(preamble, 17408, 55510, 24045);
    }

    /**
     * Method to reverse the sound with the passed file name
     *
     * @param file the name of the file
     * @return the sound reversed
     */
    public static Sound reverseS(String file) {
        Sound source = new Sound(file);
        Sound target = new Sound(file);
        int length = source.getLength();

        // loop through the samples
        for (int targetIndex = 0, sourceIndex = length - 1;
                targetIndex < length;
                targetIndex++, sourceIndex--) {
            target.setSampleValueAt(targetIndex,
                    source.getSampleValueAt(sourceIndex));
        }

        return target;
    }

    /**
     * Method to reverse the current sound.
     */
    public void reverse() {
        Sound orig = new Sound(this.getFileName());
        int length = this.getLength();

        // loop through the samples
        for (int targetIndex = 0, sourceIndex = length - 1;
                targetIndex < length && sourceIndex > 0;
                targetIndex++, sourceIndex--) {
            this.setSampleValueAt(targetIndex,
                    orig.getSampleValueAt(sourceIndex));
        }
    }

    /**
     * Method to create an audio collage
     */
    public static Sound createCollage() {
        int samplesPerSec = 22050;
        Sound s0 = new Sound(samplesPerSec * 6);
        Sound s1
                = new Sound(FileChooser.getMediaPath("guzdial.wav"));
        Sound s2
                = new Sound(FileChooser.getMediaPath("guzdial.wav"));
        int total = 0;
        int pauseLength = samplesPerSec / 10;

        // copy s1 into the current sound
        s0.splice(s1, 0, s1.getLength(), 0);
        total = s1.getLength();

        // put 1/10 sec of silence
        for (int i = 0; i < pauseLength; i++) {
            s0.setSampleValueAt(total + i, 0);
        }
        total = total + pauseLength;

        // increase the volume
        s1.increaseVolume();

        // copy s1 into the current sound
        s0.splice(s1, 0, s1.getLength(), total);
        total = total + s1.getLength();

        // put 1/10 sec of silence
        for (int i = 0; i < pauseLength; i++) {
            s0.setSampleValueAt(total + i, 0);
        }
        total = total + pauseLength;

        // change the frequency of the sound
        s1.doubleFreq();

        // copy s1 into the current sound
        s0.splice(s1, 0, s1.getLength(), total);
        total = total + s1.getLength();

        // put 1/10 sec of silence
        for (int i = 0; i < pauseLength; i++) {
            s0.setSampleValueAt(total + i, 0);
        }
        total = total + pauseLength;

        // lower the sound
        s2.halveFreq();

        // copy s2 into the current sound
        s0.splice(s2, 0, s2.getLength(), total);
        total = total + s2.getLength();

        // put 1/10 sec of silence
        for (int i = 0; i < pauseLength; i++) {
            s0.setSampleValueAt(total + i, 0);
        }
        total = total + pauseLength;

        // reverse s1 and add it
        s1.reverse();
        s0.splice(s1, 0, s1.getLength(), total);
        total = total + s1.getLength();

        return s0;
    }

    /**
     * Method to create an audio sentence
     */
    public void audioSentence() {
        int numInSec = (int) this.getSamplingRate();
        int pauseLength = numInSec / 10;
        Sound s1 = new Sound(FileChooser.getMediaPath("guzdial.wav"));
        Sound s2 = new Sound(FileChooser.getMediaPath("is.wav"));
        Sound s3 = new Sound(FileChooser.getMediaPath("great.wav"));
        int total = 0;

        // copy s1 into the current sound
        this.splice(s1, 0, s1.getLength(), 0);
        total = s1.getLength();

        // put 1/10 sec of silence
        for (int i = 0; i < pauseLength; i++) {
            this.setSampleValueAt(total + i, 0);
        }

        // copy s2 into the current sound
        total = s1.getLength() + pauseLength;
        this.splice(s2, 0, s2.getLength(), total);

        // put 1/10 sec of silence
        total = total + s2.getLength();
        for (int i = 0; i < pauseLength; i++) {
            this.setSampleValueAt(total + i, 0);
        }

        // copy s3 into the current sound
        total = total + pauseLength;
        this.splice(s3, 0, s3.getLength(), total);
    }

    /**
     * Method to reverse the last half of the current sound.
     */
    public void reverseLastHalf() {
        Sound orig = new Sound(this.getFileName());
        int length = this.getLength();
        int half = length / 2;

        // loop through the samples
        for (int targetIndex = half, sourceIndex = length - 1;
                targetIndex < length && sourceIndex > 0;
                targetIndex++, sourceIndex--) {
            this.setSampleValueAt(targetIndex,
                    orig.getSampleValueAt(sourceIndex));
        }
    }

    /**
     * Method to erase part of a sound
     *
     * @param start the index to start at (inclusive)
     * @param end the index to end at (exclusive)
     */
    public void erasePart(int start, int end) {
        for (int i = start; i < end; i++) {
            this.setSampleValueAt(i, 0);
        }
    }

    /**
     * Method to create a sound from this is a test and erase the 2nd second of it, play it, and then return the resulting sound
     */
    public static Sound erase2ndSecThisIsATest() {
        Sound s = new Sound(FileChooser.getMediaPath("thisisatest.wav"));
        int numInSec = (int) s.getSamplingRate();
        s.erasePart(numInSec, 2 * numInSec);
        s.play();
        return s;
    }

    /**
     * Method to mirror a sound front to back
     */
    public void mirrorFrontToBack() {
        int length = this.getLength(); // save the length
        int mirrorPoint = length / 2; // mirror around this
        int value = 0; // hold the current value

        // loop from 0 to mirrorPoint
        for (int i = 0; i < mirrorPoint; i++) {
            value = this.getSampleValueAt(i);
            this.setSampleValueAt(length - 1 - i, value);
        }
    }

    /**
     * Method to mirror a sound front to back
     */
    public void mirrorBackToFront() {
        int length = this.getLength(); // save the length
        int mirrorPoint = length / 2; // mirror around this
        int value = 0; // hold the current value

        // loop from 0 to mirrorPoint
        for (int i = 0; i < mirrorPoint; i++) {
            value = this.getSampleValueAt(length - 1 - i);
            this.setSampleValueAt(i, value);
        }
    }

    /**
     * Method to overlap or blend two sounds. Start by copying the first 20,000 samples from sound1 into the target sound then copy the sum of half of sound1 and half of sound2 for the next 20,000 samples and end with the next 20,000 samples from sound2.
     */
    public static Sound blendSoundsS() {
        Sound sound1
                = new Sound(FileChooser.getMediaPath("aah.wav"));
        Sound sound2
                = new Sound(FileChooser.getMediaPath("bassoon-c4.wav"));
        Sound target
                = new Sound(FileChooser.getMediaPath("sec3silence.wav"));
        int value = 0;

        // copy the first 20,000 samples from sound1 into target
        for (int index = 0; index < 20000; index++) {
            target.setSampleValueAt(index, sound1.getSampleValueAt(index));
        }

        // copy the next 20,000 samples from sound1 and blend that
        // with the first 20,000 samples from sound2
        for (int index = 0; index < 20000; index++) {
            value = (int) ((sound1.getSampleValueAt(index + 20000) * 0.5)
                    + (sound2.getSampleValueAt(index) * 0.5));
            target.setSampleValueAt(index + 20000, value);
        }

        // copy the next 20,000 samples from sound2 into the target
        for (int index = 20000; index < 40000; index++) {
            target.setSampleValueAt(index + 20000,
                    sound2.getSampleValueAt(index));
        }

        target.play();

        return target;
    }

    /**
     * Method to overlap or blend two sounds. Start by copying the first 20,000 samples from sound1 into the current sound then copy the sum of half of sound1 and half of sound2 for the next 20,000 samples and end with the next 20,000 samples from sound2.
     */
    public void blendSounds() {
        Sound sound1
                = new Sound(FileChooser.getMediaPath("aah.wav"));
        Sound sound2
                = new Sound(FileChooser.getMediaPath("bassoon-c4.wav"));
        int value = 0;

        // copy the first 20,000 samples from sound1 into target
        for (int index = 0; index < 20000; index++) {
            this.setSampleValueAt(index,
                    sound1.getSampleValueAt(index));
        }

        // copy the next 20,000 samples from sound1 and blend that
        // with the first 20,000 samples from sound2
        for (int index = 0; index < 20000; index++) {
            value = (int) ((sound1.getSampleValueAt(index + 20000)
                    * 0.5)
                    + (sound2.getSampleValueAt(index) * 0.5));
            this.setSampleValueAt(index + 20000, value);
        }

        // copy the next 20,000 samples from sound2 into the target
        for (int index = 20000; index < 40000; index++) {
            this.setSampleValueAt(index + 20000,
                    sound2.getSampleValueAt(index));
        }
    }

    /**
     * Method to overlap or blend 3 sounds. Start by copying the first 20,000 samples from sound1 into the end sound then copy the sum of half of the sound1 value and half of the sound2 value for 20,000 samples. Then copy the sum of half of the sound2 value and half of the sound3 value for the next 20,000 samples end with the next 20,000 samples from sound3.
     */
    public static Sound blend3Sounds() {
        Sound endSound = new Sound(80000);
        Sound sound1
                = new Sound(FileChooser.getMediaPath("aah.wav"));
        Sound sound2
                = new Sound(FileChooser.getMediaPath("bassoon-c4.wav"));
        Sound sound3
                = new Sound(FileChooser.getMediaPath("g4.wav"));
        int value = 0;

        // copy the first 20,000 samples from sound1 into target
        for (int index = 0; index < 20000; index++) {
            endSound.setSampleValueAt(index,
                    sound1.getSampleValueAt(index));
        }

        // copy the next 20,000 samples from sound1 and blend that
        // with the first 20,000 samples from sound2
        for (int index = 0; index < 20000; index++) {
            value = (int) ((sound1.getSampleValueAt(index + 20000)
                    * 0.5)
                    + (sound2.getSampleValueAt(index) * 0.5));
            endSound.setSampleValueAt(index + 20000, value);
        }

        // copy the next 20,000 samples from sound2 and blend that
        // with the first 20,000 samples from sound3
        for (int index = 0; index < 20000; index++) {
            value = (int) ((sound2.getSampleValueAt(index + 20000)
                    * 0.5)
                    + (sound3.getSampleValueAt(index) * 0.5));
            endSound.setSampleValueAt(index + 40000, value);
        }

        // copy the next 20,000 samples from sound3 into the target
        for (int index = 20000; index < 40000; index++) {
            endSound.setSampleValueAt(index + 40000,
                    sound3.getSampleValueAt(index));
        }
        return endSound;
    }

    /**
     * Method to overlap or blend two sounds at the halfway point in sound1. Start by copying the first half of the samples from sound1 into the current sound then copy the sum of half of sound1 and sound2 for the rest of sound1 and end with the rest of sound2
     */
    public void blendSoundsAtHalf() {
        Sound sound1
                = new Sound(FileChooser.pickAFile());
        Sound sound2
                = new Sound(FileChooser.pickAFile());
        int value = 0;
        int halfPoint = sound1.getLength() / 2;

        // copy the first half of sound1 into target
        for (int index = 0; index < halfPoint; index++) {
            this.setSampleValueAt(index,
                    sound1.getSampleValueAt(index));
        }

        // copy the rest of sound1 and blend that
        // with the first part of sound2
        int sound2Index = 0;
        for (int index = halfPoint;
                index < sound1.getLength();
                index++, sound2Index++) {
            value = (int) ((sound1.getSampleValueAt(index)
                    * 0.5)
                    + (sound2.getSampleValueAt(sound2Index) * 0.5));
            this.setSampleValueAt(index, value);
        }

        // copy the rest of sound2 into the target
        for (int i = sound1.getLength();
                i < this.getLength()
                && sound2Index < sound2.getLength();
                i++, sound2Index++) {
            this.setSampleValueAt(i,
                    sound2.getSampleValueAt(sound2Index));
        }
    }

    /**
     * Method to add an echo to a sound
     *
     * @param delay the number of samples before the echo starts
     */
    public void echo(int delay) {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());
        int value = 0;

        // loop from delay to end of sound
        for (int i = delay; i < this.getLength(); i++) {

            /* get the value back by delay samples from the 
       * copy of the sound and make it fainter
             */
            value = (int) (s.getSampleValueAt(i - delay)
                    * 0.6);

            /* set the value at the current index to the sum
       * of the current value and the echo
             */
            this.setSampleValueAt(i,
                    this.getSampleValueAt(i)
                    + value);
        }
    }

    /**
     * Method to add two echoes to a sound
     *
     * @param delay the number of samples before the echo starts
     */
    public void echo2(int delay) {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());
        int value = 0;

        // loop from delay to end of sound
        for (int i = 2 * delay; i < this.getLength(); i++) {

            /* get the value back by delay samples from the 
       * copy of the sound and make it fainter
             */
            value = (int) (s.getSampleValueAt(i - delay)
                    * 0.4)
                    + (int) (s.getSampleValueAt(i - (2 * delay)) * 0.2);

            /* set the value at the current index to the sum
       * of the current value and the echo
             */
            this.setSampleValueAt(i,
                    s.getSampleValueAt(i)
                    + value);

        }
    }

    /**
     * Method to create multiple echoes of the current sound
     *
     * @param delay the number of samples before the echo starts
     * @param numEchoes the number of echoes desired
     * @return a new sound with the echoes in it
     */
    public Sound echo(int delay, int numEchoes) {
        int soundLength = this.getLength();
        Sound echoSound = new Sound(numEchoes * delay + soundLength);
        int value = 0;
        int echoIndex = 0;
        int echoValue = 0;
        double echoAmplitude = 1; // to start

        // copy the original sound
        echoSound.splice(this, 0, soundLength, 0);

        /* loop starting with 1 to create the first echo at the 
     * right place and end then when = the number of echoes
         */
        for (int echoCount = 1; echoCount <= numEchoes; echoCount++) {
            // decrease the volume (amplitude) of the echo
            echoAmplitude = echoAmplitude * 0.6;

            // echo the whole sound
            for (int i = 0; i < soundLength; i++) {
                echoIndex = i + (delay * echoCount);
                echoValue = (int) (this.getSampleValueAt(i)
                        * echoAmplitude);
                echoSound.setSampleValueAt(echoIndex, echoValue
                        + echoSound.getSampleValueAt(echoIndex));
            }
        }
        return echoSound;
    }

    /**
     * Method to double the frequency of a sound by taking every second sample. The result will be a higher sound.
     */
    public void doubleFreq() {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());

        /* loop through the sound and increment target index
     * by one but source index by 2 and set target value
     * to the copy of the original sound
         */
        for (int sourceIndex = 0, targetIndex = 0;
                sourceIndex < this.getLength();
                sourceIndex = sourceIndex + 2, targetIndex++) {
            this.setSampleValueAt(targetIndex,
                    s.getSampleValueAt(sourceIndex));
        }

        // clear out the rest of this sound
        for (int i = this.getLength() / 2;
                i < this.getLength();
                i++) {
            this.setSampleValueAt(i, 0);
        }

    }

    /**
     * Method to double the frequency of a sound by taking every second sample. The result will be a higher sound.
     */
    public Sound doubleFreqReturnSound() {
        Sound result = new Sound(this.getLength() / 2 + 1);

        /* loop through the sound and increment target index
     * by one but source index by 2 and set target value
     * to the copy of the original sound
         */
        for (int sourceIndex = 0, targetIndex = 0;
                sourceIndex < this.getLength();
                sourceIndex = sourceIndex + 2, targetIndex++) {
            result.setSampleValueAt(targetIndex,
                    this.getSampleValueAt(sourceIndex));
        }

        return result;
    }

    /**
     * Try to make this sound like a hip-jop dj playing a sound forward and backwards quickly
     */
    public void playHipHop() {
        Sound temp = this;
        Sound copied = new Sound(this);
        Sound reversed = new Sound(this);
        reversed.reverse();

        // play this sound normal one time
        temp.blockingPlay();

        // loop 2 times
        for (int i = 0; i < 2; i++) {

            // play the reversed sound faster
            temp = reversed.changeFreq2ReturnSound(5);
            temp.blockingPlay();

            // play the sound forward faster
            temp = copied.changeFreq2ReturnSound(5);
            temp.blockingPlay();
        }
    }

    /**
     * Method to triple the frequency of a sound by taking every third sample. The result will be a higher sound.
     */
    public void tripleFreq() {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());

        /* loop through the sound and increment target index
     * by one but source index by 3 and set target value
     * to the copy of the original sound
         */
        int targetIndex = 0;
        for (int sourceIndex = 0;
                sourceIndex < this.getLength();
                sourceIndex = sourceIndex + 3, targetIndex++) {
            this.setSampleValueAt(targetIndex,
                    s.getSampleValueAt(sourceIndex));
        }

        // clear out the rest of this sound
        for (int i = targetIndex;
                i < this.getLength();
                i++) {
            this.setSampleValueAt(i, 0);
        }

    }

    /**
     * Method to quadruple the frequency of a sound by taking every fourth sample. The result will be a higher sound.
     */
    public void quadFreq() {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());

        /* loop through the sound and increment target index
     * by one but source index by 4 and set target value
     * to the copy of the original sound
         */
        int targetIndex = 0;
        for (int sourceIndex = 0;
                sourceIndex < this.getLength();
                sourceIndex = sourceIndex + 4, targetIndex++) {
            this.setSampleValueAt(targetIndex,
                    s.getSampleValueAt(sourceIndex));
        }

        // clear out the rest of this sound
        for (int i = targetIndex;
                i < this.getLength();
                i++) {
            this.setSampleValueAt(i, 0);
        }

    }

    /**
     * Method to halve the frequency of a sound by taking each sample twice. The result will be a lower sound.
     */
    public void halveFreq() {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());

        /* loop through the sound and increment target index
     * by one but source index by 0.5 and set target value
     * to the copy of the original sound
         */
        for (double sourceIndex = 0, targetIndex = 0;
                targetIndex < this.getLength();
                sourceIndex = sourceIndex + 0.5, targetIndex++) {
            this.setSampleValueAt((int) targetIndex,
                    s.getSampleValueAt((int) sourceIndex));
        }

    }

    /**
     * Method to change the frequency of a sound by the passed factor
     *
     * @param factor the amount to increment the source index by. A number greater than 1 will increase the frequency and make the sound higher while a number less than one will decrease the frequency and make the sound lower.
     */
    public void changeFreq(double factor) {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());

        /* loop through the sound and increment the target index
     * by one but increment the source index by the factor
         */
        for (double sourceIndex = 0, targetIndex = 0;
                targetIndex < this.getLength();
                sourceIndex = sourceIndex + factor, targetIndex++) {
            this.setSampleValueAt((int) targetIndex,
                    s.getSampleValueAt((int) sourceIndex));
        }

    }

    /**
     * Method to change the frequency of a sound by the passed factor
     *
     * @param factor the amount to increment the source index by. A number greater than 1 will increase the frequency and make the sound higher while a number less than one will decrease the frequency and make the sound lower.
     */
    public void changeFreq2(double factor) {
        // make a copy of the original sound
        Sound s = new Sound(this.getFileName());

        /* loop through the sound and increment the target index
     * by one but increment the source index by the factor
         */
        for (double sourceIndex = 0, targetIndex = 0;
                targetIndex < this.getLength();
                sourceIndex = sourceIndex + factor, targetIndex++) {
            if (sourceIndex >= s.getLength()) {
                sourceIndex = 0;
            }
            this.setSampleValueAt((int) targetIndex,
                    s.getSampleValueAt((int) sourceIndex));
        }

    }

    /**
     * Method to change the frequency of a sound by the passed factor and return the resulting sound
     *
     * @param factor the amount to increment the source index by. A number greater than 1 will increase the frequency and make the sound higher while a number less than one will decrease the frequency and make the sound lower.
     * @return the resulting sound
     */
    public Sound changeFreq2ReturnSound(double factor) {
        // make a new sound of the right length
        Sound s = new Sound((int) Math.ceil(this.getLength() * (1 / factor)));

        /* loop through the sound and increment the target index
     * by one but increment the source index by the factor
         */
        for (double sourceIndex = 0, targetIndex = 0;
                targetIndex < s.getLength()
                && sourceIndex < this.getLength();
                sourceIndex = sourceIndex + factor, targetIndex++) {

            s.setSampleValueAt((int) targetIndex,
                    this.getSampleValueAt((int) sourceIndex));
        }
        return s;
    }

    /**
     * Method to change the frequency of a sound by the passed factor and return the resulting sound
     *
     * @param factor the amount to increment the source index by. A number greater than 1 will increase the frequency and make the sound higher while a number less than one will decrease the frequency and make the sound lower.
     * @param numSamples the length of the new sound as a number of samples (should be <= length * (1/factor)) @return the resul ting sound
     */
    public Sound changeFreq2ReturnSound(double factor, int numSamples) {
        // make a new sound of the right length
        Sound s = new Sound((int) Math.ceil(this.getLength() * (1 / factor)));

        /* loop through the sound and increment the target index
     * by one but increment the source index by the factor
         */
        for (double sourceIndex = 0, targetIndex = 0;
                targetIndex < s.getLength()
                && sourceIndex < this.getLength();
                sourceIndex = sourceIndex + factor, targetIndex++) {

            s.setSampleValueAt((int) targetIndex,
                    this.getSampleValueAt((int) sourceIndex));
        }
        return s.clip(0, numSamples);
    }

    /**
     * Method to change the passed sound to the passed frequency
     *
     * @param the frequency to use
     * @return the new sound
     */
//  public Sound shiftFreq(int freq)
//  {
//    //double factor = 
//  }
    /**
     * Method to play a sound 5 times and each time increase the frequency. It doesn't change the original sound.
     */
    public void play5Freq() {
        Sound s = null;

        // loop 5 times but start with 1 and end at 5
        for (int i = 1; i < 6; i++) {
            // reset the sound
            s = new Sound(this.getFileName());

            // change the frequency
            s.changeFreq(i);

            // play the sound
            s.blockingPlay();
        }
    }

    /**
     * Method to play a sound 10 times and each time increase the frequency. It doesn't change the original sound.
     */
    public void play10Freq() {
        Sound s = null;

        // loop 10 times but start with 1 and end at 10
        for (int i = 1; i < 11; i++) {
            // reset the sound
            s = new Sound(this.getFileName());

            // change the frequency
            s.changeFreq2(i);

            // play the sound
            s.blockingPlay();
        }
    }

    /**
     * Method to create a one second sine wave sound with the given frequency and maximum amplitude
     *
     * @param freq the desired frequency
     * @param maxAmplitude the maximum amplitude
     * @return the new sound
     */
    public static Sound createSineWave(int freq, int maxAmplitude) {
        Sound s
                = new Sound(FileChooser.getMediaPath("sec1silence.wav"));
        double samplingRate = s.getSamplingRate();
        double rawValue = 0;
        int value = 0;
        double interval = 1.0 / freq; // length of cycle in seconds
        double samplesPerCycle = interval * samplingRate;
        double maxValue = 2 * Math.PI;

        // loop through the length of the sound
        for (int i = 0; i < s.getLength(); i++) {
            // calculate the value between -1 and 1
            rawValue = Math.sin((i / samplesPerCycle) * maxValue);

            // multiply by the desired max amplitude
            value = (int) (maxAmplitude * rawValue);

            // set the value at this index
            s.setSampleValueAt(i, value);
        }
        return s;
    }

    /**
     * Method to copy a sine wave with the given frequency and maximum amplitude to the current sound
     *
     * @param freq the desired frequency
     * @param maxAmplitude the maximum amplitude
     */
    public void copySineWave(int freq, int maxAmplitude) {
        double samplingRate = this.getSamplingRate();
        double rawValue = 0;
        int value = 0;
        double interval = 1.0 / freq; // length of cycle in seconds
        double samplesPerCycle = interval * samplingRate;
        double maxValue = 2 * Math.PI;

        // loop through the length of the current sound
        for (int i = 0; i < this.getLength(); i++) {
            // calculate the value between -1 and 1
            rawValue = Math.sin((i / samplesPerCycle) * maxValue);

            // multiply by the desired max amplitude
            value = (int) (maxAmplitude * rawValue);

            // set the value at this index
            this.setSampleValueAt(i, value);
        }
    }

    /**
     * Method to add the passed sound to this sound
     *
     * @param source the sound to combine with this one
     */
    public void add(Sound source) {
        int value = 0; // holder for new value

        // loop through all of the source
        for (int i = 0; i < source.getLength(); i++) {

            // add source sound value and this sound value
            value = this.getSampleValueAt(i)
                    + source.getSampleValueAt(i);

            // set the value in this sound to the new value
            this.setSampleValueAt(i, value);
        }
    }

    /**
     * Method to generate a 1 second sound with square waves with the passed frequency and maximum amplitude.
     *
     * @param freq the desired frequency
     * @param maxAmplitude the maximum amplitude
     * @return the created sound
     */
    public static Sound createSquareWave(int freq,
            int maxAmplitude) {
        Sound s
                = new Sound(FileChooser.getMediaPath("sec1silence.wav"));
        double samplingRate = s.getSamplingRate();
        int value = 0;
        double interval = 1.0 / freq; // length of cycle in seconds
        double samplesPerCycle = interval * samplingRate;
        double samplesPerHalfCycle = (int) (samplesPerCycle / 2);

        // loop through the length of the sound
        for (int soundIndex = 0, sampleCounter = 0;
                soundIndex < s.getLength();
                soundIndex++, sampleCounter++) {
            // check if in first half of cycle 
            if (sampleCounter < samplesPerHalfCycle) {
                value = maxAmplitude;
            } else {
                // make the value negative
                value = maxAmplitude * -1;

                /* if the sample counter is greater than the 
         * samples per cycle reset it to 0
                 */
                if (sampleCounter > samplesPerCycle) {
                    sampleCounter = 0;
                }
            }

            // set the value
            s.setSampleValueAt(soundIndex, value);
        }
        return s;
    }

    /**
     * Method to create a one second triangle wave sound with the given frequency and maximum amplitude
     *
     * @param freq the desired frequency
     * @param maxAmplitude the maximum amplitude
     * @return the new sound
     */
    public static Sound createTriangleWave(int freq,
            int maxAmplitude) {
        Sound s
                = new Sound(FileChooser.getMediaPath("sec1silence.wav"));
        double samplingRate = s.getSamplingRate();
        int value = 0;
        double interval = 1.0 / freq; // length of cycle in seconds
        double samplesPerCycle = interval * samplingRate;
        int samplesPerQuarterCycle
                = (int) (samplesPerCycle / 4);
        int increment
                = (int) (maxAmplitude / samplesPerQuarterCycle);

        // loop through the length of the sound
        for (int soundIndex = 0;
                soundIndex < s.getLength();
                soundIndex++, value = value + increment) {
            // check if the value is equal to the desired max 
            if (value >= maxAmplitude
                    || value <= maxAmplitude * -1) {
                increment = increment * -1;
                value = value + increment;
            }

            // set the sample value
            s.setSampleValueAt(soundIndex, value);

        }
        return s;
    }

    /**
     * Method to create a one second pyramid (cut off triangle) wave sound with the given frequency and maximum amplitude
     *
     * @param freq the desired frequency
     * @param maxAmplitude the maximum amplitude
     * @return the new sound
     */
    public static Sound createPyramidWave(int freq,
            int maxAmplitude) {
        Sound s
                = new Sound(FileChooser.getMediaPath("sec1silence.wav"));
        double samplingRate = s.getSamplingRate();
        int value = 0;
        double interval = 1.0 / freq; // length of cycle in seconds
        double samplesPerCycle = interval * samplingRate;
        int numSamplesInSixth = (int) (samplesPerCycle / 6);
        int increment
                = (int) (maxAmplitude / numSamplesInSixth);
        int sign = 1;

        // loop through the sound
        for (int soundIndex = 0;
                soundIndex < s.getLength();
                soundIndex++, value = value + increment) {
            // check if the value is equal to the desired max 
            if (value >= maxAmplitude
                    || value <= maxAmplitude * -1) {
                value = maxAmplitude * sign;

                // loop for a sixth of the samples in a cycle
                for (int i = 0; i < numSamplesInSixth; i++, soundIndex++) {
                    s.setSampleValueAt(soundIndex, value);
                }

                // flip the sign and increment 
                sign = sign * -1;
                increment = increment * -1;
                soundIndex--;
            } else {
                s.setSampleValueAt(soundIndex, value);
            }

        }
        return s;
    }

    /**
     * Method to write out the values in the sound to a file as text
     *
     * @param fileName the name of the file to write to
     */
    public void writeSamplesAsText(String fileName) {
        int value = 0;

        // try the following
        try {

            // try to open the buffered writer
            BufferedWriter writer
                    = new BufferedWriter(new FileWriter(fileName));

            // loop through the samples
            for (int i = 0; i < this.getLength(); i++) {
                // get the int value
                value = this.getSampleValueAt(i);

                // write it as a string (text)
                writer.write(String.valueOf(value));

                // add the new line
                writer.newLine();
            }

            // close the writer
            writer.close();
        } catch (Exception ex) {
            SimpleOutput.showError("Error during write");
            ex.printStackTrace();
        }
    }

    /**
     * Method to create a sound from a text file
     *
     * @param fileName the name of the file to read from
     * @return the created sound object
     */
    public static Sound createSoundFromTextFile(String fileName) {
        String line = null;
        int value = 0;

        // create the sound to read into
        Sound s
                = new Sound(FileChooser.getMediaPath("sec3silence.wav"));

        // try the following
        try {

            // create the buffered reader
            BufferedReader reader
                    = new BufferedReader(new FileReader(fileName));

            // loop reading the values
            int index = 0;
            while ((line = reader.readLine()) != null
                    && index < s.getLength()) {
                value = Integer.parseInt(line);
                s.setSampleValueAt(index++, value);
            }

            // close the reader
            reader.close();
        } catch (FileNotFoundException ex) {
            SimpleOutput.showError("Couln't find file " + fileName);
            fileName = FileChooser.pickAFile();
            s = createSoundFromTextFile(fileName);
        } catch (Exception ex) {
            SimpleOutput.showError("Error during read or write");
            ex.printStackTrace();
        }
        return s;
    }

    /**
     * Method to turn a sound into a picture
     *
     * @return a created picture
     */
    public Picture createPicture() {
        int value = 0;
        Pixel pixel = null;

        // create a picture to write to 
        Picture p
                = new Picture(FileChooser.getMediaPath("640x480.jpg"));

        // loop through the pixels
        Pixel[] pixelArray = p.getPixels();

        // loop through the pixels
        for (int i = 0; i < pixelArray.length
                && i < this.getLength(); i++) {

            // get this pixel
            pixel = pixelArray[i];

            // set the color based on the sample value
            value = this.getSampleValueAt(i);
            if (value > 1000) {
                pixel.setColor(Color.RED);
            } else if (value < -1000) {
                pixel.setColor(Color.BLUE);
            } else {
                pixel.setColor(Color.GREEN);
            }
        }
        return p;
    }

    public Sound blendingSounds() {
        Sound sound1 = new Sound(this);
        Sound sound2 = new Sound(FileChooser.pickAFile());
        Sound target;
        int value = 0;
        if (sound1.getLength() > sound2.getLength()) {
            target = new Sound(sound1.getLength());
        } else {
            target = new Sound(sound2.getLength());
        }

        // copy the first half of sound1 into target
        for (int index = 0; index < sound1.getLength() / 2; index++) {
            target.setSampleValueAt(index, sound1.getSampleValueAt(index));
        }

        // copy the rest of sound1 and blend that
        // with the first part of sound2
        int sound2Index = 0;
        for (int index = sound1.getLength() / 2; index < sound1.getLength() && sound2Index < sound2.getLength() / 2; index++, sound2Index++) {
            value = (int) ((sound1.getSampleValueAt(index) * 0.5) + (sound2.getSampleValueAt(sound2Index) * 0.5));
            target.setSampleValueAt(index, value);
        }

        // copy the rest of sound2 into the target
        for (int i = sound1.getLength(); i < target.getLength() && sound2Index < sound2.getLength(); i++, sound2Index++) {
            target.setSampleValueAt(i, sound2.getSampleValueAt(sound2Index));
        }
        while (true) {
            int reply = JOptionPane.showConfirmDialog(null, "Do you want to blend an another sound ?", "Attention!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                target = blendAnother(target, sound2Index);
            } else {
                break;
            }
        }
        return target;
    }

    public Sound blendAnother(Sound target, int soundIndx) {
        Sound sound1 = new Sound(target);
        Sound sound2 = new Sound(FileChooser.pickAFile());
        int value = 0;
        if (sound1.getLength() > sound2.getLength()) {
            target = new Sound(sound1.getLength());
        } else {
            target = new Sound(sound2.getLength());
        }

        // copy the first half of sound1 into target
        for (int index = 0; index < sound1.getLength() / 2; index++) {
            target.setSampleValueAt(index, sound1.getSampleValueAt(index));
        }

        // copy the rest of sound1 and blend that
        // with the first part of sound2
        int sound2Index = 0;
        for (int index = sound1.getLength() / 2; index < sound1.getLength() && sound2Index < sound2.getLength() / 2; index++, sound2Index++) {
            value = (int) ((sound1.getSampleValueAt(index) * 0.5) + (sound2.getSampleValueAt(sound2Index) * 0.5));
            target.setSampleValueAt(index, value);
        }

        // copy the rest of sound2 into the target
        for (int i = sound1.getLength(); i < target.getLength() && sound2Index < sound2.getLength(); i++, sound2Index++) {
            target.setSampleValueAt(i, sound2.getSampleValueAt(sound2Index));
        }
        return target;
    }

    // end of class Sound, put all new methods before this
    public Sound spreadThenSqueeze() {
        SoundSample[] sample = this.getSamples();

        // Spred * 2
        Sound spreaded = new Sound((int) sample.length * 2);
        for (double sourceIndex = 0, targetIndex = 0; targetIndex < spreaded.getLength(); sourceIndex += 0.5, targetIndex++) {
            spreaded.setSampleValueAt((int) targetIndex, sample[((int) sourceIndex)].getValue());
        }
        
        // Squeeze / 4
        SoundSample[] sampleSpreaded = spreaded.getSamples();
        Sound squeezed = new Sound((int) sampleSpreaded.length /4);
        for (double sourceIndex = 0, targetIndex = 0; targetIndex < squeezed.getLength(); sourceIndex += 2, targetIndex++) {
            squeezed.setSampleValueAt((int) targetIndex, sampleSpreaded[((int) sourceIndex)].getValue());
        }
        
        return squeezed;
    }

    public void simpleAverage(int windowsSize) {

        SoundSample[] sampleArray = this.getSamples();
        System.out.println(sampleArray.length);
        
        Sound newSound = new Sound(this.getSamples().length);
        
        int start = (int) Math.floor(windowsSize / 2);
        int avg = 0;
        
        // the start index where we can't apply the avg in them, put them as they are.
        for (int i = 0; i < start; i++) {
            //System.out.println("A");
            newSound.setSampleValueAt(i, sampleArray[i].getValue());
        }
        
        // the middle indexes
        for (int i = start; i < sampleArray.length - (start + 1); i++) {
            //System.out.println("B");
            avg = 0;
            
            for (int j = -start; j < start; j++) {
                avg += sampleArray[i+j].getValue();
            }
            avg /= windowsSize;
            sampleArray[i].setValue(avg);

        }
        
         // the end index where we can't apply the avg in them, put them as they are.
        for (int i = sampleArray.length - (start + 1); i < sampleArray.length; i++) {
            //System.out.println("C");
            newSound.setSampleValueAt(i, sampleArray[i].getValue());
        }
        

    }

    /*
    * @param windowsSize 
    *   type: 0= weighted window alligned left, 1=middle, 2= right
    *   first: the size of the one in the left, middle or right
     */
    public void weightedAverage(int windowsSize, short type, short first) {
        int remaining = (1 - first) / windowsSize - 1;

        int[] weighted = new int[windowsSize];
        if (type == 0) {
            weighted[1] = first;
        } else if (type == 1) {
            weighted[windowsSize / 2] = first;
        } else if (type == 2) {
            weighted[windowsSize - 2] = first;
        }
        int skipMe = 0;
        for (int i = 0; i < weighted.length; i++) {
            if (i == skipMe) {
                continue;
            } else {
                weighted[i] = (remaining);
            }
        }

        SoundSample[] sampleArray = this.getSamples();

        int start = (int) Math.floor(windowsSize / 2);
        int avg = 0;
        int ii = 0;

        for (int i = start; i < sampleArray.length - (start + 1); i++) {
            avg = 0;
            ii = 0;
            for (int j = -start; j < start; j++) {
                avg += (sampleArray[j].getValue() * weighted[ii]);
                ii++;
            }
            avg /= windowsSize;
            sampleArray[i].setValue(avg);

        }

    }

    public static Sound spliceSoundsRecursive(Sound[] sounds, int current, double zone) {
        if (current + 1 < sounds.length) {

            // take current and current+1 splice them and make current+1 is the new sound
            Sound s1 = sounds[current];
            Sound s2 = sounds[current + 1];

            int targetIndex = 0; // the starting place on the target
            Sound newSound = new Sound((s1.getLength() + s2.getLength()) + (int) ((Math.ceil(zone))));

            // copy all of sound 1 into the new sound
            for (int i = 0; i < s1.getLength(); i++) {
                newSound.setSampleValueAt(targetIndex, s1.getSampleValueAt(i));
                targetIndex++;
            }
            // silence zone
            for (int i = 0; i < (int) (zone); i++) {
                newSound.setSampleValueAt(targetIndex, 0);
                targetIndex++;
            }
            // copy all of sound 2 into the new sound
            for (int i = 0; i < s2.getLength(); i++) {
                newSound.setSampleValueAt(targetIndex, s2.getSampleValueAt(i));
                targetIndex++;
            }
            sounds[current + 1] = newSound;
            return spliceSoundsRecursive(sounds, current++, zone);
        } else {
            return sounds[current];
        }
    }

    public Sound splice(double zone) {
        Sound sound1 = new Sound(this);
        Sound sound2 = new Sound(FileChooser.pickAFile());

        int targetIndex = 0; // the starting place on the target

        Sound s = new Sound((this.getLength() + sound2.getLength()) + (int) (this.getSamplingRate() * (Math.ceil(zone))));

        // copy all of sound 1 into the current sound (target)
        for (int i = 0; i < sound1.getLength(); i++, targetIndex++) {
            s.setSampleValueAt(targetIndex, this.getSampleValueAt(i));
        }

        // create silence between words by setting values to 0
        for (int i = 0; i < (int) (this.getSamplingRate() * zone); i++, targetIndex++) {
            s.setSampleValueAt(targetIndex, 0);
        }

        // copy all of sound 2 into the current sound (target)
        for (int i = 0; i < sound2.getLength(); i++, targetIndex++) {
            s.setSampleValueAt(targetIndex, sound2.getSampleValueAt(i));
        }
        return s;
    }

}
