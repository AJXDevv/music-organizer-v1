import java.util.ArrayList;
import java.util.Random;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.0
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * Check whether an index is valid for the collection.
     * Print an error message if it is not valid.
     * @param index The index to check.
     */
    //question 1
    public void checkIndex(int index)
    {
        if(index < 0 || index >= files.size()) {
            System.out.println("Error: Invalid index " + index + ". Valid range is 0 to " + (files.size() - 1) + ".");
        }
    }
    
    /**
     * Determine whether an index is valid.
     * @param index The index to check.
     * @return true if the index is valid, false otherwise.
     */
    //question 2
    public boolean validIndex(int index)
    {
        return index >= 0 && index < files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    //question 3
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    //question 3
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * List all the files in the collection.
     */
    //question 6
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }

    /**
     * List all the files in the collection along with their index.
     */
    //question 7
    public void listWithIndex()
    {
        int position = 0;
        for(String filename : files) {
            System.out.println(position + ": " + filename);
            position++;
        }
    }

    /**
     * List the names of files matching the given search string.
     * If no files match, print a warning message.
     * @param searchString The string to match.
     */
    //question 8
    //question 9
    public void listMatching(String searchString)
    {
        boolean matchFound = false;
        for(String filename : files) {
            if(filename.contains(searchString)) {
                System.out.println(filename);
                matchFound = true;
            }
        }
        if(!matchFound) {
            System.out.println("No files matched the search term: " + searchString);
        }
    }
    // Question 1 - Practice 5 Part IV
    public void playRandom()
    {
        if (files.isEmpty()) {
            System.out.println("No songs");
            return;
        }
        Random random = new Random();
        int index = random.nextInt(files.size());
        System.out.println(files.get(index));
    }

    // Question 3 - Practice 5 Part IV
    public void playAllRandom()
    {
        ArrayList<String> remaining = new ArrayList<>(files);
        Random random = new Random();
        while (!remaining.isEmpty()) {
            int index = random.nextInt(remaining.size());
            System.out.println(remaining.get(index));
            remaining.remove(index);
        }
    }
}
//question 4
// Header: public void listAllFiles()
// Return type: void
// Parameters: It does not need any parameters.

//question 5
// You would need an infinite number of statements. Without a loop, you cannot handle a list whose size changes.

// Question 2 - Practice 5 Part IV
// I would play every song once before repeating any. A play count could help track plays.
