import java.util.*;

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        // write your code here
        if (nameToPhoneNumbersMap.containsKey(name)) {
            // add numbers to the existing list
            Collection<PhoneNumber> existingNumbers = nameToPhoneNumbersMap.get(name);
            existingNumbers.addAll(numbers);
        } else {
            // create an entry for that name
            nameToPhoneNumbersMap.put(name, numbers);
        }
    }

    public void printPhoneBook() {
        // write your code here
        for (Map.Entry entry: nameToPhoneNumbersMap.entrySet()) {
            System.out.println(entry.getKey());
            
            // first way
            Collection<PhoneNumber> numbers = (Collection<PhoneNumber>) entry.getValue();
            for (PhoneNumber n: numbers) {
                System.out.println("  " + n.getNumber());
            }

            // second way
            // for (PhoneNumber number: (List<PhoneNumber>) entry.getValue()) {
            //     System.out.println("  " + number.getNumber());
            // }
        }
    }
}