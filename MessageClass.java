package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class MessageClass {
    static String receiver;
    static String message;

    static String messageHash;
    static int Messages = 0;
    static String totalMessages = " ";
    static long randomMessageID;
    static int messagesNumber;
    static int messagesChoice;

    static List<String> sentMessages = new ArrayList<>();
    static List<String> messageIDsArray = new ArrayList<>();
    static List<String> messageHashesArray = new ArrayList<>();
    static List<String> ArrayRecipients = new ArrayList<>();
    static List<String> ArrayDisregardedMessages = new ArrayList<>();


    public void main(String[] args) {

    }

    public static void Message(Scanner myScanner) {
        // Code Attribution
        // This method was taken from W3 Schools
        // https://www.w3schools.com/java/java_for_loop.asp
        // N/A
        // N/A

        System.out.println("How many messages do you want to send? ");
        int messagesCount = myScanner.nextInt();
        myScanner.nextLine();

        for (int i = 0; i < messagesCount; i++) {
             messagesNumber = i + 1;
            System.out.println("Sending message " + (i + 1));
            createID(myScanner);

        }
        printMessages();
        System.out.println("Total messages sent: " + returnTotalMessages());

    }

    public static void createID(Scanner myScanner) {
        // Code Attribution
        // This method was taken from GeeksForGeeks
        // https://www.geeksforgeeks.org/generating-random-numbers-in-java/
        // N/A
        // N/A

        Random random1 = new Random();
        randomMessageID = 1000000000L + random1.nextInt(900000000);
        checkMessageID(randomMessageID);
        Receiver(myScanner);
    }

        // Recipient input
    public static void Receiver (Scanner myScanner) {
        // Code attribution
        // This method was taken from W3 Schools
        // https://www.w3schools.com/java/java_user_input.asp#gsc.tab=0
        // N/A
        // N/A
            System.out.println("Enter recipient cell phone number ( with the country code and no longer then 12 digits):");
            receiver = myScanner.nextLine();
            checkRecipientCell(receiver);
            if (receiver.length() != 12) {
                Message(myScanner);
            }

            inputMessage(myScanner);
        }

            // Message input
    public static String inputMessage(Scanner myScanner){
        // Code attribution
        // This method was taken from W3 Schools
        // https://www.w3schools.com/java/java_user_input.asp#gsc.tab=0
        // N/A
        // N/A
            System.out.println("Enter message(250 characters max):");
            message = myScanner.nextLine();

            if (message.length() > 250) {
                System.out.println("Please enter a message less than 250 characters");

                return "Please enter a message less than 250 characters";

            }

            createMessageHash();
            SentMessage(myScanner);

        return message;
    }


        // User Choice
        public static void SentMessage (Scanner myScanner){
            // Code attribution
            // This method was taken from W3 Schools
            // https://www.w3schools.com/java/java_user_input.asp#gsc.tab=0
            // N/A
            // N/A
            System.out.println("Choose what you want to do with the message :");
            System.out.println("1. Send Message");
            System.out.println("2. Disregard Message");
            System.out.println("3. Store Message to send later");
            int messageChoice = myScanner.nextInt();
            myScanner.nextLine();

            if (messageChoice == 1) {
                System.out.println("Message sent to " + receiver);
                sentMessages.add(message);
                messageIDsArray.add(String.valueOf(randomMessageID));
                messageHashesArray.add(messageHash.toUpperCase());
                ArrayRecipients.add(receiver);

                String newEntry = "Sent to " + receiver + " Message:" + message + " Hash: " + messageHash.toUpperCase() + "\n";
                totalMessages += newEntry;
                Messages++;
            } else if (messageChoice == 2) {
                System.out.println("Disregarded ");
                ArrayDisregardedMessages.add(message);
            } else if (messageChoice == 3) {
                storeMessage(receiver, message, messageHash);
                System.out.println("Message stored to send later");
            } else {
                System.out.println("Invalid choice");
            }


        }
        // Creating the message hash
        public static String createMessageHash (){
            // Code Attribution
            // This method was taken from GeeksForGeeks
            // https://www.geeksforgeeks.org/java-string-manipulation-best-practices-for-clean-code/
            // N/A
            // N/A

            String iD = String.valueOf(randomMessageID);
            String firstTwo = (iD.length() >= 2) ? iD.substring(0, 2) : iD;

            String[] words = message.trim().split("\\s+");
            String firstWord = words[0];
            String finalWord = words[words.length - 1];

            // The Hash
            messageHash = firstTwo + ":" + messagesNumber + ":" + firstWord + finalWord;

            System.out.println("Message hash:" + messageHash.toUpperCase());

            return messageHash.toUpperCase();


        }
        public static boolean checkMessageID ( long randomMessageID){
            // Code attribution
            //This method was taken from W3 Schools
            // https://www.w3schools.com/java/java_conditions.asp
            // N/A
            // N/A

            // Code Attribution
            // This method was taken from GeeksForGeeks
            // https://www.geeksforgeeks.org/java-string-manipulation-best-practices-for-clean-code/
            // N/A
            // N/A

            String messageid = String.valueOf(randomMessageID);

            if (messageid.length() == 10) {
                System.out.println(" Message ID successfully created " + randomMessageID);
                return true;
            } else {
                System.out.println("Message ID not created ");
            }
            return false;

        }
        public static int checkRecipientCell (String receiver) {
            // Code attribution
            //This method was taken from W3 Schools
            // https://www.w3schools.com/java/java_conditions.asp
            // N/A
            // N/A
            if (receiver.length() == 12 && receiver.startsWith("+27")) {
                System.out.println(" Cell phone number is captured");
            } else {
                System.out.println(" Wrong length or does not contain the country code");
            }
            return receiver.length();
        }
        public static String printMessages () {
            // Code attribution
            //This method was taken from W3 Schools
            // https://www.w3schools.com/java/java_conditions.asp
            // N/A
            // N/A
            if (Messages == 0) {
                System.out.println(" No Messages sent");

            } else {
                System.out.println(" Messages sent:" + totalMessages);
            }
            return totalMessages;

        }
        public static int returnTotalMessages () {
            return Messages;
        }
        public static void storeMessage (String receiver, String message, String messageHash){

            Gson gson = new Gson();
            Message msg = new Message(receiver,  message,  messageHash, randomMessageID);
            sentMessages.add(msg.message);
            ArrayRecipients.add(msg.receiver);
            messageHashesArray.add(msg.messageHash);
            messageIDsArray.add(String.valueOf(msg.randomMessageID));
            Messages++;

            List<Message> allMessages = new ArrayList<>();
            for (int i = 0; i < sentMessages.size(); i++) {
                allMessages.add(new Message(
                        ArrayRecipients.get(i),
                        sentMessages.get(i),
                        messageHashesArray.get(i),
                        Long.parseLong(messageIDsArray.get(i))));
            }
            try (FileWriter fileWriter = new FileWriter("messages.json", true)) {
                gson.toJson(msg, fileWriter);
                fileWriter.write("\n");
                System.out.println("Message saved ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    static class Message {
        // Code Attribution
        // This method was taken from W3 Schools
        // https://www.w3schools.com/java/java_inheritance.asp
        // N/A
        // N/A

        String receiver;
        String message;
        String messageHash;
        long randomMessageID;

        Message(String receiver, String message, String messageHash, long randomMessageID) {
            this.receiver = receiver;
            this.message = message;
            this.messageHash = messageHash;
            this.randomMessageID = randomMessageID;


        }
    }
    // Code Attribution

        public static void displayRecipients(){
            System.out.println("\nAll the recipients of the sent messages:");
            if(ArrayRecipients.isEmpty()){
                System.out.println("No recipients found");
                return;

            }
            for (int i = 0; i < ArrayRecipients.size(); i++) {
                System.out.println("Message " + (i + 1) + " sent to: " + ArrayRecipients.get(i));
            }
        }
        public static void displayLongestMessage(){
        if (sentMessages.isEmpty()) {
            System.out.println("No messages sent:");
            return;
        }
            // Code Attribution
            //
             //
        int longestMessage = 0;
        int longestMessageLength = sentMessages.get(0).length();
        for (int i = 1; i < sentMessages.size(); i++) {
            if(sentMessages.get(i).length() > longestMessageLength){
                longestMessageLength = sentMessages.get(i).length();
                longestMessage = i;
            }
        }
        System.out.println("\nLongest message: ");
        System.out.println("Recipient: " + ArrayRecipients.get(longestMessage));
        System.out.println("Message: " + sentMessages.get(longestMessage));
        System.out.println("MessageHash: " + messageHashesArray.get(longestMessage).toUpperCase());
        System.out.println("MessageID: " + messageIDsArray.get(longestMessage));
        }
    public static void searchMessages(Scanner myScanner) {
        if (messageIDsArray.isEmpty()) {
            System.out.println("No messages found");
            return;
        }
        System.out.println("Enter the message ID:");
        long inputMessageID = myScanner.nextLong();
        myScanner.nextLine();
        boolean found = false;

        for (int i = 0; i < messageIDsArray.size(); i++) {
            String storedID = messageIDsArray.get(i).trim();
            if (storedID.equals(inputMessageID)) {
                System.out.println("\nMessage Found:");
                System.out.println("Recipient: " + ArrayRecipients.get(i));
                System.out.println("Message: " + sentMessages.get(i));
                System.out.println("MessageHash: " + messageHashesArray.get(i));
                System.out.println("MessageID: " + storedID);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Message not found with that ID.");
        }
    }
    // Code Attribution
    //

    public static void searchMessagesWithRecipient(Scanner myScanner){
        if (ArrayRecipients.isEmpty()) {
            System.out.println("No messages found");
            return;
        }

        System.out.println("Enter the recipient cellphone number:");
        String inputRecipient = myScanner.nextLine().trim();
        myScanner.nextLine();

        boolean found = false;

        for (int i = 0; i < ArrayRecipients.size(); i++) {
            String storedRecipient = ArrayRecipients.get(i).trim();
            if (storedRecipient.equals(inputRecipient)) {
                System.out.println("\nMessage Found:");
                System.out.println("Recipient: " + storedRecipient);
                System.out.println("Message: " + sentMessages.get(i));
                System.out.println("MessageHash: " + messageHashesArray.get(i));
                System.out.println("MessageID: " + messageIDsArray.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Message not found with that recipient.");
        }
        }
    public static void deleteMessageWithHash(Scanner myScanner){
        if (messageHashesArray.isEmpty()) {
            System.out.println("No messages found to delete");
            return;
        }

        System.out.println("Enter the message Hash to delete:");
        String inputHash = myScanner.nextLine().trim();
        myScanner.nextLine();

        boolean found = false;

        for (int i = 0; i < messageHashesArray.size(); i++) {
            String storedHash = messageHashesArray.get(i).trim();
            if (storedHash.equalsIgnoreCase(inputHash)) {
                System.out.println("Deleting message:");
                System.out.println("Recipient: " + ArrayRecipients.get(i));
                System.out.println("Message: " + sentMessages.get(i));
                System.out.println("MessageID: " + messageIDsArray.get(i));

                sentMessages.remove(i);
                ArrayRecipients.remove(i);
                messageHashesArray.remove(i);
                messageIDsArray.remove(i);
                Messages--;

                System.out.println("Message deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Message not found with that Hash.");
        }
    }
        public static void readJsonMessages(){
            sentMessages.clear();
            ArrayRecipients.clear();
            messageHashesArray.clear();
            messageIDsArray.clear();
            Messages = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader("messages.json"))) {
                Gson gson = new Gson();
            String storedLines;                                                                                             // (OpenAI,2025)

            while((storedLines = reader.readLine()) != null){
                Message Msg = gson.fromJson(storedLines, Message.class);
                sentMessages.add(Msg.message);
                ArrayRecipients.add(Msg.receiver);
                messageHashesArray.add(Msg.messageHash);
                messageIDsArray.add(String.valueOf(Msg.randomMessageID));
                Messages++;

            }
        }catch (IOException e){
                System.out.println("Error reading file");
            }
        }
        public static void displayMessageReport(){
        if (sentMessages.isEmpty()) {
            System.out.println("No messages found");
            return;
        }
        System.out.println("<< Messages Report >> ");
        for (int i = 0; i < sentMessages.size(); i++) {
            System.out.println("Message " + (i + 1) + ": ");
            System.out.println("Recipient: " + ArrayRecipients.get(i));
            System.out.println("Message: " + sentMessages.get(i));
            System.out.println("MessageHash: " + messageHashesArray.get(i).toUpperCase());
            System.out.println("MessageID: " + messageIDsArray.get(i));
            System.out.println("__________________________");
        }
        System.out.println("Total number of messages: " + sentMessages.size());
        }
        }








