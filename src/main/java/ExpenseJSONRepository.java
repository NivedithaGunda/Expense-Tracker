import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

public class ExpenseJSONRepository implements ExpenseRepositoryInterface {

    private static final String FILE_NAME = "expenses.json";
    private ObjectMapper mapper = new ObjectMapper();
    private List<Expense> expenses = new ArrayList<>();

    public ExpenseJSONRepository() {
        loadFromFile();
    }

    public List<Expense> findAll() {
        return expenses;
    }
    
    public void save(Expense expense) {
        expenses.add(expense);
        writeToFile();
    }

    public List<Expense> findByCategory(Category category) {
        return expenses.stream()
                .filter(e -> e.getCategory() == category)  
                .toList();
    }

    public void delete(int index) {
        expenses.remove(index);
        writeToFile();
    }

    
    // File logic

    private void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Expense[] data = mapper.readValue(file, Expense[].class);
                expenses = new ArrayList<>(Arrays.asList(data));
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile() {
        try{
            mapper.writeValue(new File(FILE_NAME), expenses);
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    
}
