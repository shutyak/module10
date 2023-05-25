import java.io.*;

public class JsonConverter {
    public static void main(String[] args) {
        final var jsonConverter = new JsonConverter();
        jsonConverter.jsonConverter("file2.txt", "user.json");
    }

    public void jsonConverter(String inputFile, String outputFile) {
        try (final var reader = new BufferedReader(new FileReader(inputFile));
             final var writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line = reader.readLine(); // read naming
            if (line == null) {
                System.out.println("input file is empty!");
                return;
            } else if (!line.equals("name age")) {
                System.out.println("invalit input file format");
                return;
            }
            writer.write("[\n");
            line = reader.readLine(); // read first obj
            if (line !=null){
                String[] lineParts = line.split(" ");
                Person person = new Person(lineParts[0], Integer.parseInt(lineParts[1]));
                writer.write(person.toJson());
                while ((line = reader.readLine()) != null) {
                    writer.write(",\n"); //comma after previous obj
                    lineParts = line.split(" ");
                     person = new Person(lineParts[0], Integer.parseInt(lineParts[1]));
                    writer.write(person.toJson());
                }
            }
            writer.write("\n]");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toJson() {
            return "{\n\"name\": \"" + this.name + "\",\n" +
                    "\"age\": \"" + this.age +
                    "\n}";
        }
    }
}
