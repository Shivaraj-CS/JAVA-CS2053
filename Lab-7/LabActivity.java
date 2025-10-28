package programs;

import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylist {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Music Playlist Menu ====");
            System.out.println("1. Add Song at Beginning");
            System.out.println("2. Add Song at End");
            System.out.println("3. Remove First Song");
            System.out.println("4. Remove Last Song");
            System.out.println("5. Replace Song at Index");
            System.out.println("6. Display Playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add at beginning: ");
                    String songAtStart = sc.nextLine();
                    playlist.addFirst(songAtStart);
                    System.out.println("Song added at the beginning!");
                    displayPlaylist(playlist);
                    break;

                case 2:
                    System.out.print("Enter song name to add at end: ");
                    String songAtEnd = sc.nextLine();
                    playlist.addLast(songAtEnd);
                    System.out.println("Song added at the end!");
                    displayPlaylist(playlist);
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeFirst());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    displayPlaylist(playlist);
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeLast());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    displayPlaylist(playlist);
                    break;

                case 5:
                    if (!playlist.isEmpty()) {
                        System.out.print("Enter index to replace: ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        if (index >= 0 && index < playlist.size()) {
                            System.out.print("Enter new song name: ");
                            String newSong = sc.nextLine();
                            playlist.set(index, newSong);
                            System.out.println("Song replaced successfully!");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    displayPlaylist(playlist);
                    break;

                case 6:
                    displayPlaylist(playlist);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
