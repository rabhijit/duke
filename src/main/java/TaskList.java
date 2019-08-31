import java.util.*;
import java.io.*;
import java.text.*;

public class TaskList {
    protected ArrayList<Task> items;
    public TaskList(ArrayList<Task> items) {
        this.items = items;
    }

    public Task getItem(int itemNo) {
        Task thisItem = items.get(itemNo);
        return thisItem;
    }

    public String getItemToPrint(int itemNo) {
        Task thisItem = items.get(itemNo);
        return ("  " + thisItem.toString());
    }

    public ArrayList<Task> getAllItems() {
        return items;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public void deleteItem(int itemNo) {
        items.remove(itemNo);
    }

    public void addItem(Task item) {
        items.add(item);
    }

    public void markItemAsDone(int itemNo) {
        Task thisItem = items.get(itemNo);
        thisItem.markAsDone();
    }

    public ArrayList<String> searchItems(String keyword) {
        ArrayList<String> results = new ArrayList<String>();
        for (int j = 0; j < items.size(); j++) {
            Task thisTask = items.get(j);
            if (thisTask.getDescription().toLowerCase().contains(keyword)) {
                results.add((j+1) + ". " + thisTask.toString());
            }
        }
        return results;
    }

    public ArrayList<String> generateList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            Task thisTask = items.get(i);
            list.add((i+1) + ". " + thisTask.toString());
        }
        return list;
    }
}